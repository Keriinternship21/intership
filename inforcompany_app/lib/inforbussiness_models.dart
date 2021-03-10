import 'package:flutter/cupertino.dart';
import 'app_asset.dart';

class InforModel {
  String businessName;
  String businessRepresentativeName;
  String businessAddress;
  int businessTaxcode;
  int businessPhone;


  @override
  String toString() {
    return 'InforModel{businessName: $businessName, businessRepresentativeName: $businessRepresentativeName, businessAddress: $businessAddress, businessTaxcode: $businessTaxcode, businessPhone: $businessPhone}';
  }

  InforModel( this.businessName, this.businessRepresentativeName,
      this.businessAddress, this.businessTaxcode, this.businessPhone);
}
