package _200403_StringTransform_Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/*
Alternative Lösung:

public class StringTransform {
	
	private Function<String, String> op = s -> s;
	
	public StringTransform addTransformation(UnaryOperator<String> transformation) {
		op = op.andThen(transformation);
		return this;
	}

	public String process(String s) {
		return op.apply(s);
	}
}
*/

public class StringTransformDozent {
	
	private List<UnaryOperator<String>> transformations = new ArrayList<>();
	
	public StringTransformDozent addTransformation(UnaryOperator<String> transformation) {
		transformations.add(transformation);
		return this;
	}

	public String process(String s) {
		for( UnaryOperator<String> t : transformations ) {
			s = t.apply(s);
		}
		
		return s;
	}
}
