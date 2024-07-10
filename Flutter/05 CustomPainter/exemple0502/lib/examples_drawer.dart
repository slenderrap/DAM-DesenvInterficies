import 'dart:ui' as ui;
import 'package:flutter/material.dart';

class ExamplesDrawer {
  static void drawText(Canvas canvas, String text, double x, double y) {
    final textPainter = TextPainter(
      text: TextSpan(
        text: text,
        style: const TextStyle(
          color: Colors.black,
          fontSize: 14,
          fontFamily: 'Arial',
        ),
      ),
      textDirection: TextDirection.ltr,
    );
    textPainter.layout(minWidth: 0, maxWidth: double.infinity);
    textPainter.paint(canvas, Offset(x, y));
  }

  static void lines(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.blue
      ..strokeWidth = 2
      ..strokeCap = StrokeCap.round;

    // 0
    canvas.drawLine(const Offset(50, 60), const Offset(100, 75), paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.blue;
      paint.strokeWidth = 2;
      paint.strokeCap = StrokeCap.round;
      canvas.drawLine(
        const Offset(50, 60), 
        const Offset(100, 75), paint);
    ''',
        125,
        50);

    // 1
    paint.color = Colors.green;
    canvas.drawLine(const Offset(50, 260), const Offset(100, 275), paint);
    canvas.drawLine(const Offset(100, 275), const Offset(125, 300), paint);
    canvas.drawLine(const Offset(125, 300), const Offset(75, 300), paint);
    canvas.drawLine(const Offset(75, 300), const Offset(100, 325), paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.green;
      canvas.drawLine(
        const Offset(50, 260), 
        const Offset(100, 275), paint);
      canvas.drawLine(
        const Offset(100, 275), 
        const Offset(125, 300), paint);
      canvas.drawLine(
        const Offset(125, 300), 
        const Offset(75, 300), paint);
      canvas.drawLine(
        const Offset(75, 300), 
        const Offset(100, 325), paint);
    ''',
        125,
        250);

    // 2
    paint.color = Colors.red;
    paint.strokeWidth = 10;
    paint.strokeCap = StrokeCap.square;
    canvas.drawLine(const Offset(400, 50), const Offset(430, 80), paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.red;
      paint.strokeWidth = 10;
      paint.strokeCap = StrokeCap.square;
      canvas.drawLine(
        const Offset(400, 50), 
        const Offset(430, 80), paint);
    ''',
        450,
        50);

    // 3
    paint.color = Colors.purple;
    paint.strokeCap = StrokeCap.round;
    canvas.drawLine(const Offset(400, 250), const Offset(430, 280), paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.purple;
      paint.strokeCap = StrokeCap.round;
      canvas.drawLine(
        const Offset(400, 250), 
        const Offset(430, 280), paint);
    ''',
        450,
        250);
  }

  static void squaresAndCircles(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.blue
      ..style = PaintingStyle.stroke
      ..strokeWidth = 2
      ..strokeCap = StrokeCap.round;

    // 0
    canvas.drawRect(const Rect.fromLTWH(50, 60, 40, 20), paint);

    paint.color = Colors.green;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
          const Rect.fromLTWH(50, 110, 60, 30), const Radius.circular(25)),
      paint,
    );

    drawText(
      canvas,
      '''
      final paint = Paint()
        ..color = Colors.blue
        ..style = PaintingStyle.stroke
        ..strokeWidth = 2
        ..strokeCap = StrokeCap.round;
      // 0
      canvas.drawRect(
          const Rect.fromLTWH(50, 60, 40, 20), paint);
      paint.color = Colors.green;
      canvas.drawRRect(
        RRect.fromRectAndRadius(
            const Rect.fromLTWH(50, 110, 60, 30), 
            const Radius.circular(25)), paint);
    ''',
      100,
      50,
    );

    // 1
    paint.color = Colors.orange;
    paint.style = PaintingStyle.fill;
    canvas.drawRect(const Rect.fromLTWH(50, 300, 40, 20), paint);

    paint.color = Colors.pink;
    canvas.drawRRect(
      RRect.fromRectAndRadius(
          const Rect.fromLTWH(50, 350, 30, 60), const Radius.circular(25)),
      paint,
    );

    drawText(
      canvas,
      '''
      paint.color = Colors.orange;
      paint.style = PaintingStyle.fill;
      canvas.drawRect(
          const Rect.fromLTWH(50, 300, 40, 20), paint);

      paint.color = Colors.pink;
      canvas.drawRRect(
        RRect.fromRectAndRadius(
            const Rect.fromLTWH(50, 350, 30, 60), 
            const Radius.circular(25)), paint);
    ''',
      100,
      300,
    );

    // 2
    paint.color = Colors.blue;
    paint.style = PaintingStyle.stroke;
    paint.strokeWidth = 2;
    paint.color = Colors.purple;
    canvas.drawOval(const Rect.fromLTWH(400, 60, 40, 20), paint);

    paint.style = PaintingStyle.stroke;
    canvas.drawOval(const Rect.fromLTWH(400, 60, 40, 20), paint);

    drawText(
      canvas,
      '''
      paint.color = Colors.blue;
      paint.style = PaintingStyle.stroke;
      paint.strokeWidth = 2;
      paint.color = Colors.purple;
      canvas.drawOval(
          const Rect.fromLTWH(400, 60, 40, 20), paint);

      paint.style = PaintingStyle.stroke;
      canvas.drawOval(
          const Rect.fromLTWH(400, 60, 40, 20), paint);
    ''',
      435,
      50,
    );

    // 3
    paint.color = Colors.grey;
    paint.style = PaintingStyle.stroke;
    paint.strokeWidth = 5;
    paint.color = Colors.green;

    canvas.drawArc(
      const Rect.fromLTWH(370, 300, 60, 30),
      0,
      90 * (3.141592653589793 / 180),
      true,
      paint,
    );

    drawText(
      canvas,
      '''
      paint.color = Colors.grey;
      paint.style = PaintingStyle.stroke;
      paint.strokeWidth = 5;
      paint.color = Colors.green;

      canvas.drawArc(
        const Rect.fromLTWH(370, 300, 60, 30),
        0, 90 * (3.141592653589793 / 180), true, paint);
    ''',
      435,
      300,
    );
  }

  static void polygons(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.blue
      ..strokeWidth = 2
      ..strokeCap = StrokeCap.round
      ..style = PaintingStyle.stroke
      ..strokeJoin = StrokeJoin.round;

    // 0
    final path0 = Path();
    path0.moveTo(50, 60);
    path0.lineTo(100, 75);
    path0.lineTo(50, 100);
    canvas.drawPath(path0, paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.blue;
      paint.strokeWidth = 2;
      paint.strokeCap = StrokeCap.round;
      paint.strokeJoin = StrokeJoin.round;
      final path0 = Path();
      path0.moveTo(50, 60);
      path0.lineTo(100, 75);
      path0.lineTo(50, 100);
      canvas.drawPath(path0, paint);
    ''',
        125,
        50);

    // 1
    paint.color = Colors.green;
    final path1 = Path();
    path1.moveTo(50, 260);
    path1.lineTo(100, 275);
    path1.lineTo(125, 300);
    path1.moveTo(75, 300);
    path1.lineTo(100, 325);
    canvas.drawPath(path1, paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.green;
      final path1 = Path();
      path1.moveTo(50, 260);
      path1.lineTo(100, 275);
      path1.lineTo(125, 300);
      path1.moveTo(75, 300);
      path1.lineTo(100, 325);
      canvas.drawPath(path1, paint);
    ''',
        125,
        260);

    // 2
    paint.color = Colors.red;
    paint.strokeWidth = 10;
    paint.strokeCap = StrokeCap.square;
    paint.strokeJoin = StrokeJoin.round;
    final path2 = Path();
    path2.moveTo(400, 50);
    path2.lineTo(430, 80);
    path2.lineTo(400, 110);
    canvas.drawPath(path2, paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.red;
      paint.strokeWidth = 10;
      paint.strokeCap = StrokeCap.square;
      paint.strokeJoin = StrokeJoin.round;
      final path2 = Path();
      path2.moveTo(400, 50);
      path2.lineTo(430, 80);
      path2.lineTo(400, 110);
      canvas.drawPath(path2, paint);
    ''',
        450,
        50);

    // 3
    paint.color = Colors.purple;
    paint.strokeJoin = StrokeJoin.miter;
    final path3 = Path();
    path3.moveTo(400, 250);
    path3.lineTo(430, 280);
    path3.lineTo(400, 310);
    canvas.drawPath(path3, paint);
    drawText(
        canvas,
        '''
      paint.color = Colors.purple;
      paint.strokeJoin = StrokeJoin.miter;
      final path3 = Path();
      path3.moveTo(400, 250);
      path3.lineTo(430, 280);
      path3.lineTo(400, 310);
      canvas.drawPath(path3, paint);
    ''',
        450,
        260);
  }

  static void filledPolygons(Canvas canvas, Size size) {
    // 0
    final paint0 = Paint()
      ..color = Colors.green
      ..style = PaintingStyle.fill;
    final borderPaint0 = Paint()
      ..color = Colors.orange
      ..strokeWidth = 8
      ..style = PaintingStyle.stroke
      ..strokeCap = StrokeCap.round;

    final path0 = Path()
      ..moveTo(50, 60)
      ..lineTo(100, 75)
      ..lineTo(75, 100)
      ..lineTo(50, 75)
      ..close();
    canvas.drawPath(path0, paint0);
    canvas.drawPath(path0, borderPaint0);
    drawText(
      canvas,
      '''
      final paint0 = Paint()
        ..color = Colors.green..style = PaintingStyle.fill;
      final borderPaint0 = Paint()
        ..color = Colors.orange
        ..strokeWidth = 8
        ..style = PaintingStyle.stroke
        ..strokeCap = StrokeCap.round;

      final path0 = Path()
        ..moveTo(50, 60)..lineTo(100, 75)..lineTo(75, 100)
        ..lineTo(50, 75)..close();
      canvas.drawPath(path0, paint0);
      canvas.drawPath(path0, borderPaint0);
    ''',
      100,
      50,
    );

    // 1
    final paint1 = Paint()
      ..color = Colors.orange
      ..style = PaintingStyle.fill;
    final borderPaint1 = Paint()
      ..color = Colors.green
      ..strokeWidth = 8
      ..style = PaintingStyle.stroke
      ..strokeCap = StrokeCap.round;

    final path1 = Path()
      ..moveTo(50, 260)
      ..lineTo(100, 275)
      ..lineTo(100, 300)
      ..lineTo(50, 275)
      ..close();
    canvas.drawPath(path1, paint1);
    canvas.drawPath(path1, borderPaint1);
    drawText(
      canvas,
      '''
      final paint1 = Paint()
        ..color = Colors.orange
        ..style = PaintingStyle.fill;
      final borderPaint1 = Paint()
        ..color = Colors.green
        ..strokeWidth = 8
        ..style = PaintingStyle.stroke
        ..strokeCap = StrokeCap.round;

      final path1 = Path()
        ..moveTo(50, 260)..lineTo(100, 275)
        ..lineTo(100, 300)..lineTo(50, 275)..close();
      canvas.drawPath(path1, paint1);
      canvas.drawPath(path1, borderPaint1);
    ''',
      100,
      275,
    );

    // 2
    final paint2 = Paint()
      ..color = Colors.red
      ..style = PaintingStyle.fill;

    final path2 = Path()
      ..moveTo(400, 60)
      ..lineTo(440, 70)
      ..lineTo(420, 100)
      ..lineTo(410, 90)
      ..close();
    canvas.drawPath(path2, paint2);
    drawText(
      canvas,
      '''
      final paint2 = Paint()
        ..color = Colors.red
        ..style = PaintingStyle.fill;

      final path2 = Path()
        ..moveTo(400, 60)..lineTo(440, 70)
        ..lineTo(420, 100)..lineTo(410, 90)..close();
      canvas.drawPath(path2, paint2);
    ''',
      450,
      50,
    );

    // 3
    final paint3 = Paint()
      ..color = Colors.red
      ..style = PaintingStyle.fill;
    final semiTransparentPaint = Paint()
      ..color = const Color.fromRGBO(128, 255, 128, 0.5)
      ..style = PaintingStyle.fill;

    final path3 = Path()
      ..moveTo(400, 250)
      ..lineTo(440, 290)
      ..lineTo(390, 280)
      ..close();
    canvas.drawPath(path3, paint3);

    final path4 = Path()
      ..moveTo(400, 260)
      ..lineTo(440, 300)
      ..lineTo(390, 290)
      ..close();
    canvas.drawPath(path4, semiTransparentPaint);
    drawText(
      canvas,
      '''
      final paint3 = Paint()
        ..color = Colors.red
        ..style = PaintingStyle.fill;
      final semiTransparentPaint = Paint()
        ..color = Color.fromRGBO(128, 255, 128, 0.5)
        ..style = PaintingStyle.fill;
      final path3 = Path()
        ..moveTo(400, 250)..lineTo(440, 290)
        ..lineTo(390, 280)..close();
      canvas.drawPath(path3, paint3);
      final path4 = Path()
        ..moveTo(400, 260)..lineTo(440, 300)
        ..lineTo(390, 290)..close();
      canvas.drawPath(path4, semiTransparentPaint);
    ''',
      450,
      275,
    );
  }

  static void linearGradients(Canvas canvas, Size size) {
    // 0
    const rect0 = Rect.fromLTWH(50, 40, 80, 50);
    const gradient0 = LinearGradient(
        begin: Alignment.topLeft,
        end: Alignment.topRight,
        colors: [Colors.orange, Colors.green, Colors.blue],
        stops: [0.2, 0.5, 0.8]);
    final paint0 = Paint()..shader = gradient0.createShader(rect0);
    canvas.drawRect(rect0, paint0);
    drawText(
      canvas,
      '''
      const rect0 = Rect.fromLTWH(50, 40, 80, 50);
      const gradient0 = LinearGradient(
          begin: Alignment.topLeft,
          end: Alignment.topRight,
          colors: [Colors.orange, Colors.green, Colors.blue],
          stops: [0.2, 0.5, 0.8]);
      final paint0 = Paint()..shader = gradient0.createShader(rect0);
      canvas.drawRect(rect0, paint0);
    ''',
      125,
      50,
    );

    // 1
    const rect1 = Rect.fromLTWH(50, 210, 80, 50);
    const gradient1 = LinearGradient(
        begin: Alignment.topLeft,
        end: Alignment.bottomRight,
        colors: [Colors.red, Colors.orange, Colors.purple],
        stops: [0, 0.25, 0.8]);
    final paint1 = Paint()..shader = gradient1.createShader(rect1);
    canvas.drawRect(rect1, paint1);
    drawText(
      canvas,
      '''
      final rect1 = Rect.fromLTWH(50, 210, 80, 50);
      final gradient1 = LinearGradient(
        begin: Alignment.topLeft, end: Alignment.bottomRight,
        colors: [Colors.red, Colors.orange, Colors.purple], stops: [0, 0.25, 0.8]);
      );
      final paint1 = Paint()..shader = gradient1.createShader(rect1);
      canvas.drawRect(rect1, paint1);
    ''',
      125,
      220,
    );

    // 2
    const rect2 = Rect.fromLTWH(50, 380, 80, 50);
    const gradient2 = LinearGradient(
      begin: Alignment.topLeft,
      end: Alignment.bottomCenter,
      colors: [Colors.blue, Colors.grey, Colors.purple],
      stops: [0.2, 0.7, 1],
    );
    final paint2 = Paint()..shader = gradient2.createShader(rect2);
    canvas.drawRect(rect2, paint2);
    drawText(
      canvas,
      '''
      final rect2 = Rect.fromLTWH(50, 380, 80, 50);
      final gradient2 = LinearGradient(
        begin: Alignment.topLeft, end: Alignment.bottomCenter,
        colors: [Colors.blue, Colors.grey, Colors.purple], stops: [0.2, 0.7, 1]);
      final paint2 = Paint()..shader = gradient2.createShader(rect2);
      canvas.drawRect(rect2, paint2);
    ''',
      125,
      390,
    );
  }

  static void radialGradients(Canvas canvas, Size size) {
    // 0
    const rect0 = Rect.fromLTWH(50, 40, 80, 50);
    const gradient0 = RadialGradient(
      center: Alignment(0.5, 0.5),
      radius: 0.8,
      colors: [Colors.orange, Colors.green, Colors.blue],
      stops: [0.2, 0.5, 0.8],
    );
    final paint0 = Paint()..shader = gradient0.createShader(rect0);
    canvas.drawRect(rect0, paint0);
    drawText(
      canvas,
      '''
      final rect0 = Rect.fromLTWH(50, 40, 80, 50);
      final gradient0 = RadialGradient(
        center: Alignment(0.5, 0.5), radius: 0.8,
        colors: [Colors.orange, Colors.green, Colors.blue], stops: [0.2, 0.5, 0.8]);
      final paint0 = Paint()..shader = gradient0.createShader(rect0);
      canvas.drawRect(rect0, paint0);
    ''',
      125,
      50,
    );

    // 1
    const rect1 = Rect.fromLTWH(50, 210, 80, 50);
    const gradient1 = RadialGradient(
        center: Alignment(0, 0.5),
        radius: 1,
        colors: [Colors.red, Colors.orange, Colors.purple],
        stops: [0, 0.25, 0.8]);
    final paint1 = Paint()..shader = gradient1.createShader(rect1);
    canvas.drawRect(rect1, paint1);
    drawText(
      canvas,
      '''
      final rect1 = Rect.fromLTWH(50, 210, 80, 50);
      final gradient1 = RadialGradient(
        center: Alignment(0, 0.5), radius: 1,
        colors: [Colors.red, Colors.orange, Colors.purple], stops: [0, 0.25, 0.8]);
      final paint1 = Paint()..shader = gradient1.createShader(rect1);
      canvas.drawRect(rect1, paint1);
    ''',
      125,
      220,
    );

    // 2
    const rect2 = Rect.fromLTWH(50, 380, 80, 50);
    const gradient2 = RadialGradient(
      center: Alignment(0.5, 1),
      radius: 1,
      colors: [Colors.blue, Colors.grey, Colors.purple],
      stops: [0.2, 0.7, 1],
    );
    final paint2 = Paint()..shader = gradient2.createShader(rect2);
    canvas.drawRect(rect2, paint2);
    drawText(
      canvas,
      '''
      final rect2 = Rect.fromLTWH(50, 380, 80, 50);
      final gradient2 = RadialGradient(
        center: Alignment(0.5, 1), radius: 1,
        colors: [Colors.blue, Colors.grey, Colors.purple], stops: [0.2, 0.7, 1]);
      final paint2 = Paint()..shader = gradient2.createShader(rect2);
      canvas.drawRect(rect2, paint2);
    ''',
      125,
      390,
    );
  }

  static Future<void> images(
      Canvas canvas, Size size, ui.Image imgMario) async {
    final paint = Paint();

    // 0
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      const Rect.fromLTWH(50, 50, 50, 50),
      paint,
    );

    drawText(
      canvas,
      '''
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(
          0, 0, 
          imgMario.width.toDouble(), 
          imgMario.height.toDouble()),
        const Rect.fromLTWH(50, 50, 50, 50),
        paint,
      );
      // No manté la proporció
      ''',
      100,
      50,
    );

    // 1
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      const Rect.fromLTWH(50, 300, 50, 100),
      paint,
    );

    drawText(
      canvas,
      '''
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(
          0, 0, 
          imgMario.width.toDouble(), 
          imgMario.height.toDouble()),
        Rect.fromLTWH(50, 300, 50, 100),
        paint,
      );
      // No manté la proporció
      ''',
      100,
      300,
    );

    // 2
    double alt = imgMario.height.toDouble();
    double ample = imgMario.width.toDouble();
    double prpAmple = 50;
    double prpAlt = prpAmple * (alt / ample);
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      Rect.fromLTWH(400, 50, prpAmple, prpAlt),
      paint,
    );

    drawText(
      canvas,
      '''
      double alt = imgMario.height.toDouble();
      double ample = imgMario.width.toDouble();
      double prpAmple = 50;
      double prpAlt = prpAmple * (alt / ample);
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(
          0, 0, 
          imgMario.width.toDouble(), 
          imgMario.height.toDouble()),
        Rect.fromLTWH(400, 50, prpAmple, prpAlt),
        paint,
      );
      // Manté la proporció correcta amb ample = 50
      ''',
      450,
      50,
    );

    // 3
    prpAlt = 50;
    prpAmple = prpAlt * (ample / alt);
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      Rect.fromLTWH(400, 300, prpAmple, prpAlt),
      paint,
    );

    drawText(
      canvas,
      '''
      prpAlt = 50;
      prpAmple = prpAlt * (ample / alt);
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(
          0, 0, 
          imgMario.width.toDouble(), 
          imgMario.height.toDouble()),
        Rect.fromLTWH(400, 300, prpAmple, prpAlt),
        paint,
      );
      // Manté la proporció correcta amb alt = 50
      ''',
      450,
      300,
    );
  }

  static Future<void> transformations(
      Canvas canvas, Size size, ui.Image imgMario) async {
    final paint = Paint();

    // 0
    canvas.save();
    double alt = imgMario.height.toDouble();
    double ample = imgMario.width.toDouble();
    double prpAmple = 50;
    double prpAlt = prpAmple * (alt / ample);
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      Rect.fromLTWH(50, 30, prpAmple, prpAlt),
      paint,
    );
    canvas.restore();

    drawText(
      canvas,
      '''
      canvas.save();
      double alt = imgMario.height.toDouble();
      double ample = imgMario.width.toDouble();
      double prpAmple = 50;
      double prpAlt = prpAmple * (alt / ample);
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
        Rect.fromLTWH(50, 30, prpAmple, prpAlt), paint);
      canvas.restore();
      ''',
      125,
      20,
    );

    // 1
    canvas.save();
    canvas.translate(50, 200);
    canvas.save();
    canvas.scale(1.5, 0.5);
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      Rect.fromLTWH(0, 0, prpAmple, prpAlt),
      paint,
    );
    canvas.restore();
    canvas.restore();

    drawText(
      canvas,
      '''
      canvas.save();
      canvas.translate(50, 200);
      canvas.save();
      canvas.scale(1.5, 0.5);
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
        Rect.fromLTWH(0, 0, prpAmple, prpAlt), paint);
      canvas.restore(); canvas.restore();
      ''',
      125,
      195,
    );

    // 2
    canvas.save();
    canvas.translate(50, 375);
    canvas.save();
    canvas.rotate(-45 * 3.1415927 / 180);
    canvas.drawImageRect(
      imgMario,
      Rect.fromLTWH(
          0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
      Rect.fromLTWH(0, 0, prpAmple, prpAlt),
      paint,
    );
    canvas.restore();
    canvas.restore();

    drawText(
      canvas,
      '''
      canvas.save();
      canvas.translate(50, 375);
      canvas.save();
      canvas.rotate(-45 * 3.1415927 / 180);
      canvas.drawImageRect(
        imgMario,
        Rect.fromLTWH(0, 0, imgMario.width.toDouble(), imgMario.height.toDouble()),
        Rect.fromLTWH(0, 0, prpAmple, prpAlt), paint);
      canvas.restore(); canvas.restore();
      ''',
      125,
      350,
    );
  }

  static void texts0(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.red
      ..strokeWidth = 2
      ..style = PaintingStyle.stroke;

    // 0
    canvas.drawLine(const Offset(50, 50), const Offset(100, 50), paint);
    canvas.drawLine(const Offset(50, 30), const Offset(50, 50), paint);

    final textPainter0 = TextPainter(
      text: const TextSpan(
        text: "Agc",
        style: TextStyle(
          color: Colors.blue,
          fontSize: 25,
          fontFamily: 'Arial',
        ),
      ),
      textAlign: TextAlign.left,
      textDirection: TextDirection.ltr,
    );
    textPainter0.layout(minWidth: 0, maxWidth: double.infinity);
    textPainter0.paint(canvas, const Offset(50, 50));

    drawText(
      canvas,
      '''
      canvas.drawLine(
          const Offset(50, 50), 
          const Offset(100, 50), paint);
      canvas.drawLine(
          const Offset(50, 30), 
          const Offset(50, 50), paint);

      final textPainter0 = TextPainter(
        text: const TextSpan(
          text: "Agc",
          style: TextStyle(
            color: Colors.blue,
            fontSize: 25,
            fontFamily: 'Arial',
          ),
        ),
        textAlign: TextAlign.left,
        textDirection: TextDirection.ltr,
      );
      textPainter0.layout(
          minWidth: 0, 
          maxWidth: double.infinity);
      textPainter0.paint(
          canvas, 
          const Offset(50, 50));
      ''',
      125,
      30,
    );

    // 1
    canvas.drawLine(const Offset(450, 50), const Offset(500, 50), paint);
    canvas.drawLine(const Offset(450, 50), const Offset(450, 80), paint);

    final textPainter2 = TextPainter(
      text: const TextSpan(
        text: "Àgc",
        style: TextStyle(
          color: Colors.blue,
          fontSize: 25,
          fontFamily: 'Arial',
        ),
      ),
      textAlign: TextAlign.left,
      textDirection: TextDirection.ltr,
    );
    textPainter2.layout(minWidth: 0, maxWidth: double.infinity);
    textPainter2.paint(canvas, const Offset(450, 50));

    drawText(
      canvas,
      '''
      canvas.drawLine(
          const Offset(450, 50), 
          const Offset(500, 50), paint);
      canvas.drawLine(
          const Offset(450, 50), 
          const Offset(450, 80), paint);

      final textPainter2 = TextPainter(
        text: const TextSpan(
          text: "Àgc",
          style: TextStyle(
            color: Colors.blue,
            fontSize: 25,
            fontFamily: 'Arial',
          ),
        ),
        textAlign: TextAlign.left,
        textDirection: TextDirection.ltr,
      );
      textPainter2.layout(
          minWidth: 0, 
          maxWidth: double.infinity);
      textPainter2.paint(
          canvas, 
          const Offset(450, 50));
      ''',
      520,
      30,
    );
  }

  static void texts1(Canvas canvas, Size size) {
    final paint = Paint()
      ..color = Colors.red
      ..strokeWidth = 2
      ..style = PaintingStyle.stroke;

    // 0
    canvas.drawLine(const Offset(50, 250), const Offset(100, 250), paint);
    canvas.drawLine(const Offset(100, 225), const Offset(100, 250), paint);

    final textPainter1 = TextPainter(
      text: const TextSpan(
        text: "Agc",
        style: TextStyle(
          color: Colors.blue,
          fontSize: 25,
          fontFamily: 'Verdana',
        ),
      ),
      textAlign: TextAlign.right,
      textDirection: TextDirection.ltr,
    );
    textPainter1.layout(minWidth: 0, maxWidth: double.infinity);
    textPainter1.paint(canvas, const Offset(100, 250));

    drawText(
      canvas,
      '''
      canvas.drawLine(
          const Offset(50, 250), 
          const Offset(100, 250), paint);
      canvas.drawLine(
          const Offset(100, 225), 
          const Offset(100, 250), paint);

      final textPainter1 = TextPainter(
        text: const TextSpan(
          text: "Agc",
          style: TextStyle(
            color: Colors.blue,
            fontSize: 25,
            fontFamily: 'Verdana',
          ),
        ),
        textAlign: TextAlign.right,
        textDirection: TextDirection.ltr,
      );
      textPainter1.layout(
          minWidth: 0, 
          maxWidth: double.infinity);
      textPainter1.paint(
          canvas, 
          const Offset(100, 250));
      ''',
      125,
      30,
    );

    // 1
    canvas.drawLine(const Offset(450, 250), const Offset(500, 250), paint);
    canvas.drawLine(const Offset(475, 225), const Offset(475, 275), paint);

    final textPainter3 = TextPainter(
      text: const TextSpan(
        text: "Agc",
        style: TextStyle(
          color: Colors.blue,
          fontSize: 25,
          fontFamily: 'Verdana',
        ),
      ),
      textAlign: TextAlign.center,
      textDirection: TextDirection.ltr,
    );
    textPainter3.layout(minWidth: 0, maxWidth: double.infinity);
    textPainter3.paint(canvas, const Offset(475, 250));

    drawText(
      canvas,
      '''
      canvas.drawLine(
          const Offset(450, 250), 
          const Offset(500, 250), paint);
      canvas.drawLine(
          const Offset(475, 225), 
          const Offset(475, 275), paint);

      final textPainter3 = TextPainter(
        text: const TextSpan(
          text: "Agc",
          style: TextStyle(
            color: Colors.blue,
            fontSize: 25,
            fontFamily: 'Verdana',
          ),
        ),
        textAlign: TextAlign.center,
        textDirection: TextDirection.ltr,
      );
      textPainter3.layout(
          minWidth: 0, 
          maxWidth: double.infinity);
      textPainter3.paint(
          canvas, 
          const Offset(475, 250));
      ''',
      520,
      30,
    );
  }

  static void textMultiline(Canvas canvas, Size size) async {
    String str =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

    final textStyle = TextStyle(
      fontSize: 20,
      foreground: Paint()
        ..shader = ui.Gradient.linear(
          const Offset(0, 0),
          Offset(size.width, 0),
          [
            Colors.orange,
            Colors.green,
            Colors.blue,
          ],
          [0.2, 0.5, 0.8],
        ),
    );

    final textSpan = TextSpan(
      text: str,
      style: textStyle,
    );

    final textPainter = TextPainter(
      text: textSpan,
      textAlign: TextAlign.justify,
      textDirection: TextDirection.ltr,
      maxLines: null,
    );

    textPainter.layout(maxWidth: 600);
    textPainter.paint(canvas, const Offset(50, 25));

    drawText(
      canvas,
      '''
      // Crea un TextSpan amb un ample màxim i pinta el text al canvas
      String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
      
      final textStyle = TextStyle(
        fontSize: 20,
        foreground: Paint()
          ..shader = ui.Gradient.linear(
            Offset(0, 0), 
            Offset(size.width, 0),
            [Colors.orange, Colors.green, Colors.blue,],
            [0.2, 0.5, 0.8]));

      final textSpan = TextSpan(
        text: str,
        style: textStyle,
      );

      final textPainter = TextPainter(
        text: textSpan,
        textAlign: TextAlign.justify,
        textDirection: TextDirection.ltr,
        maxLines: null,
      );

      textPainter.layout(maxWidth: 600);
      textPainter.paint(canvas, Offset(50, 25));
      ''',
      35,
      80,
    );
  }
}
