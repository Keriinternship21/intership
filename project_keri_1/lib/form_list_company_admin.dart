import 'package:flutter/material.dart';
import 'package:grouped_list/grouped_list.dart';
import 'company.dart';

class FormListCompanyAdmin extends StatefulWidget {
  @override
  _FormListCompanyAdminState createState() => _FormListCompanyAdminState();
}

class _FormListCompanyAdminState extends State<FormListCompanyAdmin> {
  String title = 'List Companies';
  bool _switch = true;
  List<Company> _companies = <Company>[
    Company(
        name: "Company1",
        address: "Addresss1",
        phoneNumber: "PhoneNumber1",
        taxCode: "TaxCode1",
        email: "company1@gmail.com",
        isExpanded: false),
    Company(
        name: "Company2",
        address: "Addresss2",
        phoneNumber: "PhoneNumber2",
        taxCode: "TaxCode2",
        email: "company2@gmail.com",
        isExpanded: false),
    Company(
        name: "Company3",
        address: "Addresss3",
        phoneNumber: "PhoneNumber3",
        taxCode: "TaxCode3",
        email: "company3@gmail.com",
        isExpanded: false),
    Company(
        name: "Company4",
        address: "Addresss4",
        phoneNumber: "PhoneNumber4",
        taxCode: "TaxCode4",
        email: "company4@gmail.com",
        isExpanded: false),
    Company(
        name: "Company5",
        address: "Addresss5",
        phoneNumber: "PhoneNumber5",
        taxCode: "TaxCode5",
        email: "company5@gmail.com",
        isExpanded: false),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      backgroundColor: Colors.white,
      // Arrow back in appbar
      appBar: AppBar(
        title: Text(title),
        centerTitle: true,
        backgroundColor: Color(0xff0095FF),
        leading: IconButton(
          onPressed: () {
            Navigator.pop(context);
          },
          icon: Icon(
            Icons.arrow_back,
            size: 20,
            color: Colors.white,
          ),
        ),
      ),
      body: ListView.builder(
        itemCount: _companies.length,
        itemBuilder: (context, index) {
          return Card(
            color: Colors.white70,
            child: SwitchListTile(
                title: Text('${_companies[index].name}'),
                value: _companies[index].isExpanded,
                onChanged: (bool value) {
                  setState(() {
                    if (_companies[index].isExpanded == true) {
                      _companies[index].isExpanded = false;
                    } else {
                      _companies[index].isExpanded = true;
                    }
                    value = _companies[index].isExpanded;
                  });
                }),
          );

          // return ListTile(
          //   selected: true,
          //   onTap: (){
          //     print('OnTap');
          //   },
          //   onLongPress: (){
          //     print('onLongPress');
          //   },
          //   title: Text('${_companies[index].name}'),
          //   trailing: IconButton(
          //     icon: Icon(
          //       Icons.more_vert,
          //       size: 20.0,
          //       color: Colors.brown[900],
          //     ),
          //     onPressed: () {
          //       //   _onDeleteItemPressed(index);
          //     },
          //   ),
          // );
        },
      ),
      //
    );
  }
}
