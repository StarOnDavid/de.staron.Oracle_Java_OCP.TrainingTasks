package _200326_Interfaces_StringTransformation_v2;

import static _200326_Interfaces_StringTransformation_v2.Transformation.*;
import java.util.ArrayList;

public class StringTransform {
	
	public static ArrayList<String> transform(String[] arr){
		ArrayList<String> list = new ArrayList<String>();
		for (String s : arr) {
			list.add(s.toUpperCase());
		}
		return list;
	}
	
	public static ArrayList<String> transform(String[] arr, int t){
		ArrayList<String> list = new ArrayList<String>();
		switch (t) {
		case UPPER:
			for (String s : arr) {
				list.add(s.toUpperCase());
			}
			break;
		case LOWER:
			for (String s : arr) {
				list.add(s.toLowerCase());
			}
			break;
		case CAPITALIZE:
			for (String s : arr) {
				list.add(s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase());
			}
			break;
		case ADDPOINT:
			for (String s : arr) {
				list.add(s + ".");
			}
			break;
		case ADDLENGTH:
			for (String s : arr) {
				list.add(s + "(" + s.length() + ")");
			}
			break;
		}
		return list;
	}
}
