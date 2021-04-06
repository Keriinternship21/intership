import 'package:flutter/cupertino.dart';
import 'package:infor_app/models/employee_model.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class EmployeeProvider extends ChangeNotifier {
  List<EmployeeModel> _data = [];

  List<EmployeeModel> get dataEmployee => _data;

  Future<List<EmployeeModel>> getEmployee() async {
    final url = 'https://script.google.com/macros/s/AKfycbw3fMlpdr_ehu3jld5QjdZKQ2DkLaLqfnJL3zXYdFxMR7zhOr3YJ3cB4ZWGC1gKbXMO/exec';
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final result = jsonDecode(response.body);
      _data = result.map<EmployeeModel>((json) => EmployeeModel.fromJson(json))
          .toList();
      notifyListeners();
      return _data;
    } else {
      throw Exception();
    }
  }
  Future<bool> storeEmployee(String name, String adress, String phoneNumber, String taxCode) async {
    final url = 'https://script.google.com/macros/s/AKfycbynCLDQ-ZuntYOmgIOL-IWGDiovwV_M94iDW4j3NxMvT8aUITuXYStC5GMIWnv9bANM/exec';
    final response = await http.post(url, body: {
      'name': name,
      'address': adress,
      'phone_number': phoneNumber,
      'tax_code': taxCode,
    });
    final result = json.decode(response.body);
    if (response.statusCode == 200 && result['status'] == 'success') {
      notifyListeners();
      return true;
    }
    return false;
  }
}