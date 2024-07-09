import 'package:flutter/cupertino.dart';
import 'color_data.dart';

class ViewColorDetail extends StatelessWidget {
  final ColorData data;

  const ViewColorDetail({required this.data, super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: CupertinoNavigationBar(
        middle: Text(data.name),
      ),
      child: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
              width: 100,
              height: 100,
              decoration: BoxDecoration(
                shape: BoxShape.circle,
                color: Color(
                  int.parse(data.color.substring(1, 7), radix: 16) + 0xFF000000,
                ),
              ),
            ),
            const SizedBox(height: 20),
            Text(
              data.name,
              style: const TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            Text(
              data.type,
              style: const TextStyle(
                  fontSize: 20, color: CupertinoColors.inactiveGray),
            ),
            Text(
              data.color,
              style: const TextStyle(
                  fontSize: 20, color: CupertinoColors.inactiveGray),
            ),
          ],
        ),
      ),
    );
  }
}
