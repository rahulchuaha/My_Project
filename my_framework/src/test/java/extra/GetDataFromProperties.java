package extra;

import java.io.IOException;

import generic_utility.FileUtility;

public class GetDataFromProperties {
	public static void main(String[] args) throws IOException {
		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropFile("url");
		String userName = fUtil.getDataFromPropFile("username");
		String password = fUtil.getDataFromPropFile("pass");
		String browser = fUtil.getDataFromPropFile("bro");
		System.out.println(URL + " " + userName + " " + password + " " + browser);
		
		String org = fUtil.getDataFromExcelFile("org", 1, 0);
		System.out.println(org);
//		String oppName = fUtil.getDataFromExcelFile("org", 1, 1);
//		System.out.println(oppName);
	}
	
	
	

}
