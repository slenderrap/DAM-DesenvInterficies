import 'package:flutter/cupertino.dart';
import 'color_data.dart';

class ColorListItem extends StatelessWidget {
  final ColorData data;

  const ColorListItem({required this.data, super.key});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(8.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                '${data.name}, ${data.color}',
                style:
                    const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              Text(
                data.type,
                style: const TextStyle(
                    fontSize: 16, color: CupertinoColors.inactiveGray),
              ),
            ],
          ),
          Column(
            children: [
              Container(
                width: 50,
                height: 50,
                decoration: BoxDecoration(
                  shape: BoxShape.circle,
                  color: Color(
                      int.parse(data.color.substring(1, 7), radix: 16) +
                          0xFF000000),
                ),
              ),
            ],
          ),
        ],
      ),
    );
  }
}
