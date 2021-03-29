import 'package:flutter/cupertino.dart';
import 'package:infor_app/models/employee_model.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class EmployeeProvider extends ChangeNotifier {
  List<EmployeeModel> _data = [];

  List<EmployeeModel> get dataEmployee => _data;

  Future<List<EmployeeModel>> getEmployee() async {
    final url = 'https://script.google.com/macros/s/AKfycbxppHLSNXPjFgiKzosOUzFCFefhdMAvJBcGIHESOKb5Pj6AfcrKGMK4CXGVFI21IC5_/exec';
    final response = await http.get(url);
    if (response.statusCode == 200) {
      final result = jsonDecode(response.body);
      _data = result.map<EmployeeModel>((json) => EmployeeModel.fromJson(json))
          .toList();
      return _data;
    } else {
      throw Exception();
    }
  }
}