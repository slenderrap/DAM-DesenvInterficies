import 'package:flutter/cupertino.dart';
import 'view_color_list.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoApp(
      debugShowCheckedModeBanner: false,
      title: 'Color List',
      home: ViewColorList(),
    );
  }
}
