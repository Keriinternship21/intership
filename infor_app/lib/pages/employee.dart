import 'package:flutter/material.dart';
import 'package:infor_app/models/employee_model.dart';
import 'package:infor_app/providers/employee_provider.dart';
import 'package:provider/provider.dart';
import 'employee_add.dart';
class Employee extends StatelessWidget {
  final data = [EmployeeModel()];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Employee'),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.blue,
        child: Text('+'),
        onPressed: () {
          Navigator.of(context)
              .push(MaterialPageRoute(builder: (context) => EmployeeAdd()));
        },
      ),
      body: RefreshIndicator(
        onRefresh: () =>
            Provider.of<EmployeeProvider>(context, listen: false).getEmployee(),
        color: Colors.red,
        child: Container(
          margin: const EdgeInsets.all(10),
          child: FutureBuilder(
            future: Provider.of<EmployeeProvider>(context, listen: false)
                .getEmployee(),
            // ignore: missing_return
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.waiting) {
                return Center(
                  child: CircularProgressIndicator(),
                );
              }
              return Consumer<EmployeeProvider>(builder: (context, data, _) {
                return ListView.builder(
                    itemCount: data.dataEmployee.length,
                    itemBuilder: (context, index) {
                      return Card(
                        elevation: 7,
                        child: ListTile(
                          title: Text(
                            data.dataEmployee[index].name,
                            style: TextStyle(
                                fontSize: 18, fontWeight: FontWeight.bold),
                          ),
                          subtitle: Text(
                              'Địa chỉ: ${data.dataEmployee[index].adress}'),
                          trailing: Text(
                              "SDT: ${data.dataEmployee[index].phoneNumber}"),
                          leading: Text(
                              "MST: ${data.dataEmployee[index].taxCode}"),
                        ),
                      );
                    });
              });
            },
          ),
        ),
      ),
    );
  }
}
