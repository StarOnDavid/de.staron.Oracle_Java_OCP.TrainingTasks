package _200403_StringTransform_Function;

public class StringTransform_Function_run {

	public static void main(String[] args) {

	    // Transformationen vordefinieren:
	    StringTransform t1 = new StringTransform()
	            .addTransformation( s -> s.toUpperCase() )
	            .addTransformation( s -> s + "!" );
	    
	    // Transformationen durchführen:
	    String s = t1.process("Hallo");
	    System.out.println(s); // HALLO!
	    
	    // Transformationen mit einem anderen String durchführen:
	    s = t1.process("Java ist toll");
	    System.out.println(s); // JAVA IST TOLL!
	    
	    
	    StringTransform t2 = new StringTransform()
	            .addTransformation( x -> x.substring(7) )
	            .addTransformation( x -> x.concat(" ist") )
	            .addTransformation( x -> x.concat(" mein Name.") );
	    
	    // Transformationen durchführen:
	    String s2 = t2.process("Ulrich Hase");
	    System.out.println(s2); // Hase ist mein Name.
	}
}
