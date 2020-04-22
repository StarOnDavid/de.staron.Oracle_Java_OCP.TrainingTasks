# Aufgabe 'Stream bilden'

###### A1.
Gegeben ist der Code:

		List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		List<Integer> list2 = Arrays.asList( 55, 77 );
		
		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for(List<Integer> e : list3) {
		    System.out.println("size = " + e.size() + ". elements = " + e);
		}
		// B

Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert.

###### A2.
Gegeben ist der Code:

	public class Test {
	    static Integer nextInt() {
	        return new Random().nextInt();
	    }
	    
	    public static void main(String[] args) {
	        for (int i = 1; i < 100; i++) {
	            System.out.println( nextInt() );
	        }
	    }
	}

Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den Stream mit der Methode `Stream.generate`.

> Tipp: Die 'intermediate' operation `limit` kann die Anzahl der Stream-Elemente begrenzen.

###### A3.
Gegeben ist der Code:

		for (int i = 100; i >= 1; i--) {
		    System.out.println( i );
		}

Bitte ersetzen Sie die for-Schleife mit einer Pipeline. Bilden Sie bitte den Stream mit der Methode `Stream.iterate`.

> Tipp: Die 'intermediate' operation `limit` kann die Anzahl der Stream-Elemente begrenzen.


###### A4.
Gegeben ist der Code:

        String[] a1 = { "a", "b" };
        String[] a2 = { "c", "d" };
        
        // A
        String[][] a3 = { a1, a2 };
        for (String[] arr : a3) {
            for (String s : arr) {
                System.out.println(s);
            }
        }
        // B

Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert. Verwenden Sie für die Lösung die Methode `Stream.concat`.

###### A5. Optional
Gegeben ist der Code:

		//A
		Collection<Path> coll = new ArrayList<>();
		coll.add(Paths.get("/a"));
		coll.add(Paths.get("/a/b"));
		coll.add(Paths.get("/a/b/c"));
		coll.add(Paths.get("/a/b/c/d"));
		for(Path p : coll) {
			System.out.println(p);
		}
		// B
		
Bitte ersetzen Sie den Code zwischen den Zeilen A und B mit einer Pipeline, die dieselben Ausgaben liefert. Wenn möglich, sollten die Elemente der Pipeline die Path-Referenzen sein.

