import 'package:flutter/material.dart';
import 'package:infor_app/providers/employee_provider.dart';
import 'package:provider/provider.dart';
import './pages/employee.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: [
        ChangeNotifierProvider(
          create: (_) => EmployeeProvider(),
        )
      ],
        child: MaterialApp(
          title: 'Company',
          debugShowCheckedModeBanner: false,
          home: Employee(),
        ),
    );
  }
}