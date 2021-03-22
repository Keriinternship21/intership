
class Company{
  String name;
  String address;
  String phoneNumber;
  String taxCode;
  String email;
  bool isExpanded;

  Company({this.name, this.address, this.phoneNumber, this.taxCode, this.email, this.isExpanded});



  String toBody(){
    return '$address \n $email \n $phoneNumber - $taxCode';
  }

  @override
  String toString() {
    return '$name - $address - $phoneNumber - $taxCode - $email';
  }
}