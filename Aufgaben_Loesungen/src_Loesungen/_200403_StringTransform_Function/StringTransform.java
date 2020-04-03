package _200403_StringTransform_Function;


import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;


public class StringTransform {
	List<UnaryOperator<String>> functions = new ArrayList<UnaryOperator<String>>();
	
	public StringTransform addTransformation(UnaryOperator<String> stringFunction) {
		functions.add(stringFunction);
		return this;
	}

	public String process(String s) {
		for(int i = 0; i < functions.size(); i++) {
			s = functions.get(i).apply(s);
		}
		return s;
	}
}
