import 'package:flutter/cupertino.dart';
import 'color_data.dart';

class ColorListItem extends StatelessWidget {
  final ColorData colorData;

  const ColorListItem(this.colorData, {super.key});

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
                '${colorData.name}, ${colorData.color}',
                style:
                    const TextStyle(fontSize: 18, fontWeight: FontWeight.bold),
              ),
              Text(
                colorData.type,
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
                      int.parse(colorData.color.substring(1, 7), radix: 16) +
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
