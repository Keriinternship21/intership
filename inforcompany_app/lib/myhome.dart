import 'package:flutter/material.dart';

import 'regitercompany_screen.dart';
void main() {
  runApp(MyHome());
}
class MyHome extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: RegisterCompany(),
    );
  }
}
