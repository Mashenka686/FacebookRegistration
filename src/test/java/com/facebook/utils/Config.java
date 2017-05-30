package com.facebook.utils;
import java.io.FileInputStream;
import java.util.Properties;

public class Config {
	static Properties configFile;
	static{
		try{
	String path="./src/test/resources/testdata/testdata.properties";
	FileInputStream input=new FileInputStream(path);
	configFile=new Properties();
	configFile.load(input);
	input.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static String getProperty(String keyName){
		return configFile.getProperty(keyName);
	}
}
