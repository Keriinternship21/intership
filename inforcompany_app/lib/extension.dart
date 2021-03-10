import 'package:flutter/material.dart';


// color cung thong so
extension ColorExtension on int {
  Color toColor(double opacity) {
    return Color.fromRGBO(this, this, this, opacity);
  }
}
// sizebox to witdh
extension intWidthExtension on int{
  SizedBox toWidthSizeBox() {
    return SizedBox(width: this.toDouble(),
    );
  }
}
//SizedBox to height
extension intHeigthExtension on int {
  SizedBox toHeightSizedBox() {
    return SizedBox(height: this.toDouble(),
    );
  }
}
