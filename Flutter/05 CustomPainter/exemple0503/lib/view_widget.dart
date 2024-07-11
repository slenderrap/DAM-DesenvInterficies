import 'dart:ui';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'shape_painter.dart';

class ViewWidget extends StatefulWidget {
  const ViewWidget({super.key});

  @override
  ViewWidgetState createState() => ViewWidgetState();
}

class ViewWidgetState extends State<ViewWidget> {
  late Rect greenSquare;
  late Rect blueCircle;
  bool isGreenSquareDragged = false;
  bool isBlueCircleDragged = false;
  bool isCircleOnTop = true;
  Offset offset = const Offset(-1, -1);

  @override
  void initState() {
    super.initState();
    greenSquare = const Rect.fromLTWH(50, 50, 100, 100);
    blueCircle = const Rect.fromLTWH(250, 250, 100, 100);
  }

  void onPanUpdate(DragUpdateDetails details) {
    final RenderBox renderBox = context.findRenderObject() as RenderBox;
    final Offset localPosition =
        renderBox.globalToLocal(details.globalPosition);

    setState(() {
      if (offset.dx == -1 && offset.dy == -1) {
        if (greenSquare.contains(localPosition)) {
          isGreenSquareDragged = true;
          isCircleOnTop = false;
          offset = localPosition - greenSquare.topLeft;
        }

        if (blueCircle.contains(localPosition)) {
          isBlueCircleDragged = true;
          isCircleOnTop = true;
          offset = localPosition - blueCircle.topLeft;
        }
      } else {
        if (isGreenSquareDragged) {
          greenSquare = Rect.fromLTWH(
              localPosition.dx - offset.dx,
              localPosition.dy - offset.dy,
              greenSquare.width,
              greenSquare.height);
        } else if (isBlueCircleDragged) {
          blueCircle = Rect.fromLTWH(
              localPosition.dx - offset.dx,
              localPosition.dy - offset.dy,
              blueCircle.width,
              blueCircle.height);
        }
      }
    });
  }

  void onPanEnd(DragEndDetails details) {
    setState(() {
      isGreenSquareDragged = false;
      isBlueCircleDragged = false;
      offset = const Offset(-1, -1);
    });
  }

  void adjustShapes(double canvasWidth, double canvasHeight) {
    // Adjust green square position if out of bounds
    if (greenSquare.right > canvasWidth) {
      greenSquare = Rect.fromLTWH(canvasWidth - greenSquare.width,
          greenSquare.top, greenSquare.width, greenSquare.height);
    }
    if (greenSquare.bottom > canvasHeight) {
      greenSquare = Rect.fromLTWH(
          greenSquare.left,
          canvasHeight - greenSquare.height,
          greenSquare.width,
          greenSquare.height);
    }

    // Adjust blue circle position if out of bounds
    if (blueCircle.right > canvasWidth) {
      blueCircle = Rect.fromLTWH(canvasWidth - blueCircle.width, blueCircle.top,
          blueCircle.width, blueCircle.height);
    }
    if (blueCircle.bottom > canvasHeight) {
      blueCircle = Rect.fromLTWH(
          blueCircle.left,
          canvasHeight - blueCircle.height,
          blueCircle.width,
          blueCircle.height);
    }
  }

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(
      builder: (context, constraints) {
        WidgetsBinding.instance.addPostFrameCallback((_) {
          adjustShapes(constraints.maxWidth, constraints.maxHeight);
          setState(() {});
        });

        return CupertinoPageScaffold(
          navigationBar: const CupertinoNavigationBar(
            middle: Text('CustomPaint App'),
          ),
          child: SafeArea(
            child: GestureDetector(
              onPanUpdate: onPanUpdate,
              onPanEnd: onPanEnd,
              child: Container(
                width: constraints.maxWidth,
                height: constraints.maxHeight,
                color: CupertinoColors.lightBackgroundGray,
                child: CustomPaint(
                  painter: ShapePainter(
                    greenSquare: greenSquare,
                    blueCircle: blueCircle,
                    isCircleOnTop: isCircleOnTop,
                  ),
                  child: Container(),
                ),
              ),
            ),
          ),
        );
      },
    );
  }
}
