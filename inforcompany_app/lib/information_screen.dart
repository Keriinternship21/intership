import 'package:flutter/material.dart';
import 'package:inforcompany_app/display_screen.dart';
import 'regitercompany_screen.dart';
import 'app_asset.dart';
import 'extension.dart';
class InformationCompany extends StatefulWidget {
  @override
  _InformationCompanyState createState() => _InformationCompanyState();
}

class _InformationCompanyState extends State<InformationCompany> {
  double inforWidth;
  double inforHeight;
  @override
  Widget build(BuildContext context) {
    inforWidth = MediaQuery.of(context).size.width;
    inforHeight = MediaQuery.of(context).size.height;
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.transparent,
        shadowColor: Colors.transparent,
        leading: IconButton(
          icon: Icon(
            Icons.arrow_back,
            color: Colors.black,
          ),
          onPressed: () {
            Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => RegisterCompany()));
          },
        ),
      ),
      backgroundColor: Colors.white,
      // khi click vao man hinh ngoai test ban phim se an
      body: GestureDetector(
        onTap: () {
          FocusScope.of(context).requestFocus(FocusNode());
        },
        child: SingleChildScrollView(
          child: Container(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Text(
                  "Information",
                  style: TextStyle(
                      fontSize: 35,
                      color: AppColor.colorRed,
                      fontFamily: AppFonts.productSansItalic),
                ),
                SizedBox(
                  child: Text(
                    "Information Company",
                    style: TextStyle(
                        color: AppColor.colorMarine,
                        fontFamily: AppFonts.popinsBold,
                        fontSize: 15),
                  ),
                ),
                // Business Name
                20.toHeightSizedBox(),
                Padding(
                  padding: const EdgeInsets.only(left: 20, right: 20),
                  child: SizedBox(
                    width: inforWidth * 335 / 375,
                    height: 18,
                    child: Text(
                      "Business Name",
                      style: TextStyle(
                          fontSize: 14,
                          fontFamily: AppFonts.popinsRegular,
                          color: AppColor.colorMarine),
                    ),
                  ),
                ),
                10.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: 60.toColor(0.5),
                    ),
                    borderRadius: BorderRadius.circular(5),
                    color: AppColor.colorGrey,
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 50,
                        child: Image.asset(AppAsset.imageBusinessName,
                            width: 30, height: 30, color: AppColor.colorRedOpa),
                      ),
                      Container(
                        height: 30,
                        width: 2,
                        color: AppColor.colorRedOpa,
                      ),
                      10.toWidthSizeBox(),
                      Expanded(
                          child: Padding(
                            padding: const EdgeInsets.only(right: 20),
                            child: TextField(
                              decoration: InputDecoration(
                                  isCollapsed: true,
                                  //bỏ thanh gach duoi
                                  border: InputBorder.none,
                                  hintText: "Enter name"),
                            ),
                          )),
                    ],
                  ),
                ),
                // Business Name
                20.toHeightSizedBox(),
                SizedBox(
                  width: inforWidth * 335 / 375,
                  height: 18,
                  child: Text(
                    "Business Representative Name",
                    style: TextStyle(
                        fontSize: 14,
                        fontFamily: AppFonts.popinsRegular,
                        color: AppColor.colorMarine),
                  ),
                ),
                10.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: 60.toColor(0.5),
                    ),
                    borderRadius: BorderRadius.circular(5),
                    color: AppColor.colorGrey,
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 50,
                        child: Icon(
                          Icons.person_rounded,
                          size: 30,
                          color: AppColor.colorRedOpa,
                        ),
                      ),
                      Container(
                        height: 30,
                        width: 2,
                        color: AppColor.colorRedOpa,
                      ),
                      10.toWidthSizeBox(),
                      Expanded(
                          child: Padding(
                            padding: const EdgeInsets.only(right: 20),
                            child: TextField(
                              decoration: InputDecoration(
                                  isCollapsed: true,
                                  //bỏ thanh gach duoi
                                  border: InputBorder.none,
                                  hintText: "Enter Representative Name"),
                            ),
                          )),
                    ],
                  ),
                ),
                // Business addresss
                15.toHeightSizedBox(),
                SizedBox(
                  width: inforWidth * 335 / 375,
                  height: 18,
                  child: Text(
                    "Business Address",
                    style: TextStyle(
                        fontSize: 14,
                        fontFamily: AppFonts.popinsRegular,
                        color: AppColor.colorMarine),
                  ),
                ),
                10.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: 60.toColor(0.5),
                    ),
                    borderRadius: BorderRadius.circular(5),
                    color: AppColor.colorGrey,
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 50,
                        child: Image.asset(
                          AppAsset.imageBusinessAddress,
                          width: 30,
                          height: 30,
                          color: AppColor.colorRedOpa,
                        ),
                      ),
                      Container(
                        height: 30,
                        width: 2,
                        color: AppColor.colorRedOpa,
                      ),
                      10.toWidthSizeBox(),
                      Expanded(
                          child: Padding(
                            padding: const EdgeInsets.only(right: 20),
                            child: TextField(
                              style: TextStyle(
                                  fontFamily: AppFonts.popinsRegular,
                                  color: Colors.redAccent),
                              decoration: InputDecoration(
                                  isCollapsed: true,
                                  //bỏ thanh gach duoi
                                  border: InputBorder.none,
                                  hintText: "Enter adress"),
                            ),
                          )),
                    ],
                  ),
                ),
                // Tax Code
                15.toHeightSizedBox(),
                SizedBox(
                  width: inforWidth * 335 / 375,
                  height: 18,
                  child: Text(
                    "Tax code",
                    style: TextStyle(
                        fontSize: 14,
                        fontFamily: AppFonts.popinsRegular,
                        color: AppColor.colorMarine),
                  ),
                ),
                10.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: 60.toColor(0.5),
                    ),
                    borderRadius: BorderRadius.circular(5),
                    color: AppColor.colorGrey,
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 50,
                        child: Image.asset(
                          AppAsset.imageBusinessCode,
                          width: 30,
                          height: 30,
                          color: AppColor.colorRedOpa,
                        ),
                      ),
                      Container(
                        height: 30,
                        width: 2,
                        color: AppColor.colorRedOpa,
                      ),
                      10.toWidthSizeBox(),
                      Expanded(
                        child: Padding(
                          padding: const EdgeInsets.only(right: 20),
                          child: TextField(
                            style: TextStyle(
                                fontFamily: AppFonts.popinsRegular,
                                color: Colors.redAccent),
                            decoration: InputDecoration(
                                isCollapsed: true,
                                //bỏ thanh gach duoi
                                border: InputBorder.none,
                                hintText: "Enter tax code"),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                // Businesss Phone
                15.toHeightSizedBox(),
                SizedBox(
                  width: inforWidth * 335 / 375,
                  height: 18,
                  child: Text(
                    "Business phone number",
                    style: TextStyle(
                        fontSize: 14,
                        fontFamily: AppFonts.popinsRegular,
                        color: AppColor.colorMarine),
                  ),
                ),
                10.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  decoration: BoxDecoration(
                    border: Border.all(
                      color: 60.toColor(0.5),
                    ),
                    borderRadius: BorderRadius.circular(5),
                    color: AppColor.colorGrey,
                  ),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.start,
                    mainAxisSize: MainAxisSize.min,
                    children: [
                      Container(
                        width: 50,
                        child: Icon(
                          Icons.phone,
                          size: 30,
                          color: AppColor.colorRedOpa,
                        ),
                        //Image.asset(
                        //   AppAsset.imageBusinessCode,
                      ),
                      Container(
                        height: 30,
                        width: 2,
                        color: AppColor.colorRedOpa,
                      ),
                      10.toWidthSizeBox(),
                      Expanded(
                        child: Padding(
                          padding: const EdgeInsets.only(right: 20),
                          child: TextField(
                            keyboardType: TextInputType.number,
                            style: TextStyle(
                                fontFamily: AppFonts.popinsRegular,
                                color: Colors.redAccent),
                            decoration: InputDecoration(
                                isCollapsed: true,
                                //bỏ thanh gach duoi
                                border: InputBorder.none,
                                hintText: "Enter phone number"),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
                20.toHeightSizedBox(),
                Container(
                  width: inforWidth * 335 / 375,
                  height: 50,
                  child: MaterialButton(
                    onPressed: () {
                      Navigator.of(context).push(MaterialPageRoute(
                          builder: (context) => DisplayBusiness()));
                    },
                    color: AppColor.colorOrange,
                    shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.circular(20)),
                    child: Text(
                      'Save'.toUpperCase(),
                      style: TextStyle(
                          color: 255.toColor(1),
                          fontSize: 18,
                          fontFamily: AppFonts.popinsBold),
                    ),
                  ),
                ),
                50.toHeightSizedBox(),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
