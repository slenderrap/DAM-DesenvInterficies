import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'color_data.dart';
import 'color_list_item.dart';

class ViewColorList extends StatelessWidget {
  final List<ColorData> colorDataList = [
    ColorData('Red', 'Warm', '#FF0000'),
    ColorData('Orange', 'Warm', '#FFA500'),
    ColorData('Yellow', 'Warm', '#FFFF00'),
    ColorData('Chartreuse', 'Warm', '#7FFF00'),
    ColorData('Green', 'Cool', '#008000'),
    ColorData('Spring Green', 'Cool', '#00FF7F'),
    ColorData('Cyan', 'Cool', '#00FFFF'),
    ColorData('Azure', 'Cool', '#007FFF'),
    ColorData('Blue', 'Cool', '#0000FF'),
    ColorData('Violet', 'Cool', '#8B00FF'),
    ColorData('Purple', 'Cool', '#800080'),
    ColorData('Gray', 'Neutral', '#808080'),
    ColorData('Black', 'Neutral', '#000000'),
    ColorData('Pink', 'Warm', '#FFC0CB'),
    ColorData('Brown', 'Warm', '#A52A2A'),
    ColorData('Lime', 'Cool', '#00FF00'),
    ColorData('Teal', 'Cool', '#008080'),
    ColorData('Indigo', 'Cool', '#4B0082'),
  ];

  ViewColorList({super.key});

  @override
  Widget build(BuildContext context) {
    return CupertinoPageScaffold(
      navigationBar: const CupertinoNavigationBar(
        middle: Text('Color List'),
      ),
      child: ListView.builder(
        itemCount: colorDataList.length,
        itemBuilder: (context, index) {
          return Column(
            children: [
              ColorListItem(data: colorDataList[index]),
              if (index < colorDataList.length - 1)
                const Divider(
                  height: 1,
                  thickness: 1,
                  color: CupertinoColors.separator,
                ),
            ],
          );
        },
      ),
    );
  }
}
