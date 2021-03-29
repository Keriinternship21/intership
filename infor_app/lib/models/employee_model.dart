import 'package:flutter/material.dart';
import 'package:flutter/cupertino.dart';

class EmployeeModel {
  String name;
  String adress;
  String phoneNumber;
  String taxCode;

  EmployeeModel({this.name, this.adress, this.phoneNumber, this.taxCode});

  factory EmployeeModel.fromJson(Map<String, dynamic> json) => EmployeeModel(
        name: json['name'],
        adress: json['address'],
        phoneNumber: json['phone_number'],
        taxCode: json['tax_code'],
      );
}
