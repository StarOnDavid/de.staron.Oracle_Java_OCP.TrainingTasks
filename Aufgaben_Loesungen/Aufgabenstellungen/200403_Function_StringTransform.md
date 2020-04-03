# Aufgabe 'StringTransform - Function'

Erstellen Sie bitte eine Hilfsklasse `StringTransform`, die die gewünschten String-Transformationen vordefinieren lässt, um die so vorgefertigte Transformationen mit jedem beliebigen String durchzuführen. Z.B.:
   
	
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
    }


Überlegen Sie sich zwei-drei andere Transformationen und testen Sie sie mit weiteren Strings. 