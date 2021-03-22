import 'package:flutter/material.dart';
import 'package:project_keri_1/form_list_company.dart';
import 'package:project_keri_1/form_list_company_admin.dart';
import 'package:project_keri_1/form_register_company.dart';
import 'package:project_keri_1/welcome.dart';

void main() {
  runApp(HomePage());
}

class HomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Project Keri 1',
      theme: ThemeData(
        primaryColor: Colors.black,
        primaryColorLight: Colors.white,
        accentColor: Color(0xFF181F32),
      ),
      home: Welcome(),
    );
  }
}
