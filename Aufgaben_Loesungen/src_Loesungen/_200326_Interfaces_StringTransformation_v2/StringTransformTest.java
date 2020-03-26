package _200326_Interfaces_StringTransformation_v2;

import static _200326_Interfaces_StringTransformation_v2.Transformation.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class StringTransformTest {
	String[] arr1 = {"mo", "di", "mi"};
	String[] arr2 = {"MO", "DI", "MI"};
	String[] arr3 = {"mO", "dI", "mI"};
	String[] arr4 = {"Montag", "Dienstag", "Mittwoch"};
	ArrayList<String> list;

	@Test
	void testTransformOnlyWithArray() {
		ArrayList<String> list = StringTransform.transform(arr1);
		assertEquals("[MO, DI, MI]", list.toString());
	}
	
	@Test
	void testTransformWithOptionUPPER() {
		list = StringTransform.transform(arr1, UPPER);
		assertEquals("[MO, DI, MI]", list.toString());
	}
	
	@Test
	void testTransformWithOptionLOWER() {
		list = StringTransform.transform(arr2, LOWER);
		assertEquals("[mo, di, mi]", list.toString());
	}
	
	@Test
	void testTransformWithOptionsCAPITALIZE() {
		list = StringTransform.transform(arr3, CAPITALIZE);
		assertEquals("[Mo, Di, Mi]", list.toString());
	}

	@Test
	void testTransformWithOptionsADDPOINT() {
		list = StringTransform.transform(arr1, ADDPOINT);
		assertEquals("[mo., di., mi.]", list.toString());
	}
	
	@Test
	void testTransformWithOptionsADDLENGTH() {
		list = StringTransform.transform(arr1, ADDLENGTH);
		assertEquals("[mo(2), di(2), mi(2)]", list.toString());
		
		list = StringTransform.transform(arr4, ADDLENGTH);
		assertEquals("[Montag(6), Dienstag(8), Mittwoch(8)]", list.toString());
	}
}
