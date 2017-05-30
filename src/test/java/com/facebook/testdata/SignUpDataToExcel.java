package com.facebook.testdata;

import java.util.ArrayList;
import com.facebook.utils.ExcelUtils;

public class SignUpDataToExcel {
	public static int row = 1;

	public SignUpDataToExcel() {

		ExcelUtils.openExcelFile("./src/test/resources/testdata/facebookData.xlsx", "SignUp");
		FacebookSignUpData fbdata = new FacebookSignUpData();

		ArrayList<String> data = fbdata.getSignUpInfo();
		int col = 0;
		for (int i = 0; i < data.size(); i++) {
			ExcelUtils.setCellData(data.get(i), row, i);
		}
		row++;
	}

}
