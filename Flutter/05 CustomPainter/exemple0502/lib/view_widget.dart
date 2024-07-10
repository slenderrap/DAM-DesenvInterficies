import 'dart:async';
import 'dart:ui' as ui;
import 'package:flutter/cupertino.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';
import 'drawing_painter.dart';

class ViewWidget extends StatefulWidget {
  const ViewWidget({super.key});

  @override
  ViewWidgetState createState() => ViewWidgetState();
}

class ViewWidgetState extends State<ViewWidget> {
  String selectedOption = 'Linies';
  Future<ui.Image?>? imageFuture;

  @override
  void initState() {
    super.initState();
    imageFuture = _loadImage('assets/images/mario.png');
  }

  void _setSelection(String value) {
    setState(() {
      selectedOption = value;
    });
  }

  void _showActionSheet(BuildContext context) {
    final List<String> options = [
      'Linies',
      'Quadrats i cercles',
      'Poligons',
      'Poligons emplenats',
      'Gradients lineals',
      'Gradients radials',
      'Imatges',
      'Transformacions',
      'Texts posicionats 0',
      'Texts posicionats 1',
      'Texts multilínia',
    ];

    showCupertinoModalPopup(
      context: context,
      builder: (BuildContext context) => CupertinoActionSheet(
        title: const Text('Select Option'),
        actions: options.map((String option) {
          return CupertinoActionSheetAction(
            child: Text(option),
            onPressed: () {
              _setSelection(option);
              Navigator.pop(context);
            },
          );
        }).toList(),
        cancelButton: CupertinoActionSheetAction(
          child: const Text('Cancel'),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
      ),
    );
  }

  static Future<ui.Image?> _loadImage(String asset) async {
    try {
      final ByteData data = await rootBundle.load(asset);
      final Uint8List bytes = Uint8List.view(data.buffer);
      final Completer<ui.Image> completer = Completer();
      ui.decodeImageFromList(bytes, (ui.Image img) {
        completer.complete(img);
      });
      return completer.future;
    } catch (e) {
      if (kDebugMode) {
        print('Error loading image: $e');
      }
      return null;
    }
  }

  @override
  Widget build(BuildContext context) {
    final double topPadding =
        MediaQuery.of(context).padding.top + kMinInteractiveDimensionCupertino;

    return CupertinoPageScaffold(
      navigationBar: const CupertinoNavigationBar(
        middle: Text('CustomPaint examples'),
      ),
      child: Column(
        children: [
          SizedBox(height: topPadding),
          Expanded(
            child: LayoutBuilder(
              builder: (context, constraints) {
                return FutureBuilder<ui.Image?>(
                  future: imageFuture,
                  builder: (context, snapshot) {
                    if (snapshot.connectionState == ConnectionState.waiting) {
                      // Carregant ...
                      return const Center(child: CupertinoActivityIndicator());
                    } else if (snapshot.hasError) {
                      return Center(child: Text('Error: ${snapshot.error}'));
                    } else if (!snapshot.hasData || snapshot.data == null) {
                      return const Center(child: Text('Image not available'));
                    }
                    // Mostrar el CustomPaint si ja s'han carregat els arxius
                    return CustomPaint(
                      painter: DrawingPainter(selectedOption, snapshot.data!),
                      size: Size(constraints.maxWidth, constraints.maxHeight),
                    );
                  },
                );
              },
            ),
          ),
          CupertinoButton(
            child: Text('Selected: $selectedOption'),
            onPressed: () => _showActionSheet(context),
          ),
        ],
      ),
    );
  }
}
