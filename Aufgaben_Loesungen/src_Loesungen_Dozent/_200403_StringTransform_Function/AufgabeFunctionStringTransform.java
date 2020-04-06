package _200403_StringTransform_Function;


public class AufgabeFunctionStringTransform {

	public static void main(String[] args) {

		 // Transformationen vordefinieren:
        StringTransformDozent t1 = new StringTransformDozent()
                .addTransformation( s -> s.toUpperCase() )
                .addTransformation( s -> s + "!" );
        
        // Transformationen durchführen:
        String s = t1.process("Hallo");
        System.out.println(s); // HALLO!
        
        // Transformationen mit einem anderen String durchführen:
        s = t1.process("Java ist toll");
        System.out.println(s); // JAVA IST TOLL!

	}

}
