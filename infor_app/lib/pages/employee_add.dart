import 'employee.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import '../providers/employee_provider.dart';

class EmployeeAdd extends StatefulWidget {
  @override
  _EmployeeAddState createState() => _EmployeeAddState();
}

class _EmployeeAddState extends State<EmployeeAdd> {
//COMMENT-3: DEFINE VARIABLE
//   final TextEditingController _name = TextEditingController();
//   final TextEditingController _salary = TextEditingController();
//   final TextEditingController _age = TextEditingController();
//   final TextEditingController _taxCode = TextEditingController();
  final TextEditingController _name = TextEditingController();
  final TextEditingController _adress = TextEditingController();
  final TextEditingController _phonenumber = TextEditingController();
  final TextEditingController _taxCode = TextEditingController();
  final snackbarKey = GlobalKey<ScaffoldState>();
  // FocusNode salaryNode = FocusNode();
  // FocusNode ageNode = FocusNode();
  FocusNode adress = FocusNode();
  FocusNode phoneNumber = FocusNode();
  FocusNode taxCode = FocusNode();
  void submit(BuildContext context) {
    Provider.of<EmployeeProvider>(context, listen: false)
        .storeEmployee(_name.text, _adress.text, _phonenumber.text, _taxCode.text)
        .then((res) {
      if (res) {
        Navigator.of(context).pushReplacement(
            MaterialPageRoute(builder: (context) => Employee()));
      } else {
      }
    });
  }
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      key: snackbarKey,
      appBar: AppBar(
        title: Text('Add Employee'),
        actions: <Widget>[
          FlatButton(
            child: Icon(
              Icons.save,
              color: Colors.white,
            ),
            onPressed: () => submit(context),
          )
        ],
      ),
      body: Container(
        margin: EdgeInsets.all(10),
        child: ListView(
          children: <Widget>[
            TextField(
              controller: _name,
              decoration: InputDecoration(
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(
                    color: Colors.pinkAccent,
                  ),
                ),
                hintText: 'Họ tên',
              ),
              onSubmitted: (_) {
                FocusScope.of(context).requestFocus(phoneNumber);
              },
            ),
            TextField(
              controller: _adress,
              focusNode: adress,
              decoration: InputDecoration(
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(
                    color: Colors.pinkAccent,
                  ),
                ),
                hintText: 'Dia chi',
              ),
              onSubmitted: (_) {
                FocusScope.of(context).requestFocus(taxCode);
              },
            ),
            TextField(
              controller: _phonenumber,
              focusNode: phoneNumber,
              decoration: InputDecoration(
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(
                    color: Colors.pinkAccent,
                  ),
                ),
                hintText: 'phonenumber',
              ),
            ),
            TextField(
              controller: _taxCode,
              focusNode: taxCode,
              decoration: InputDecoration(
                focusedBorder: UnderlineInputBorder(
                  borderSide: BorderSide(
                    color: Colors.pinkAccent,
                  ),
                ),
                hintText: 'taxCode',
              ),
            ),
          ],
        ),
      ),
    );
  }
}