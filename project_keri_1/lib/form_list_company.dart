import 'package:flutter/material.dart';
import 'package:grouped_list/grouped_list.dart';
import 'company.dart';

class FormListCompany extends StatefulWidget {
  @override
  _FormListCompanyState createState() => _FormListCompanyState();
}

class _FormListCompanyState extends State<FormListCompany> {
  List<Company> _companies = new List<Company>();

  @override
  void initState() {
    // TODO: implement initState
    super.initState();
    _companies = <Company>[
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
  }

  Future<void> _showMyDialog(Company company) async {
    return showDialog<void>(
      context: context,
      barrierDismissible: false, // user must tap button!
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('${company.name}'),
          content: SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                Text('${company.address}'),
                Text('${company.email}'),
                Text('${company.phoneNumber}'),
                Text('${company.taxCode}'),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: Text('Close'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  _showPopupMenu() async {
    await showMenu(
      context: context,
      position: RelativeRect.fromLTRB(100, 400, 100, 400),
      items: [
        PopupMenuItem(
          child: Text("Edit"),
        ),
        PopupMenuItem(
          child: Text("Delete"),
        ),
      ],
      elevation: 8.0,
    );
  }

  @override
  Widget build(BuildContext context) {
    String title = 'List Companies';

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
            child: ListTile(
              selected: true,
              onTap: () {
                _showMyDialog(_companies[index]);
              },
              onLongPress: () {
                print('onLongPress');
              },
              title: Text('${_companies[index].name}'),
              trailing: IconButton(
                icon: Icon(
                  Icons.more_vert,
                  size: 20.0,
                  color: Colors.brown[900],
                ),
                onPressed: () {
                  //   _onDeleteItemPressed(index)
                },
              ),
            ),
          );
        },
      ),

    );
  }
}
