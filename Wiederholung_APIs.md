### Object - Klasse

##### Methoden

<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=300 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>protected Object</td>
	<td>clone()</td>
	<td>Erstellt und gibt eine Kopie zurück</td>
  </tr>
  <tr>
	<td>boolean</td>
	<td>equals(Object obj)</td>
	<td>Zeigt an ob ein object diesem entspricht.</td>
  </tr>
  <tr>
	<td>protected void</td>
	<td>finalize()</td>
	<td>Wird vom GarbageCollector auf gerufen wenn ein Objekt von diesem 'gelöscht' wird.</td>
  </tr>
  <tr>
	<td>Class<?></td>
	<td>getClass()</td>
	<td>Gibt die 'runtime Klasse' des Objektes zurück.</td>
  </tr>
  <tr>
	<td>int</td>
	<td>hashCode()</td>
	<td>Gibt ein HashCode Value für das Objekt zurück.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>notify()</td>
	<td>Weckt EINEN Thread aus dem 'waiting' dieses Monitors auf.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>notifyAll()</td>
	<td>Weckt ALLE Treads aus dem 'waiting' dises Monitors auf.</td>
  </tr>
  <tr>
	<td>String</td>
	<td>toString()</td>
	<td>Gibt eine String-Repräsentation des Objekts zurück.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>wait()</td>
	<td>Versetzt den Thread aus dem sie aufgerufen wird in den Zusatand 'waiting' auf das Aufrufende Objekt als Monitor.</td>
  </tr>
   <tr>
	<td>void</td>
	<td>wait(long timeout)</td>
	<td>Wie 'wait()' nur das ein TimeOut (milliSec) gesetzt wird nach dem der Thread automatisch in den Zusatand 'runnable' zurückkehrt.</td>
  </tr>
   <tr>
	<td>void</td>
	<td>wait(long timeout, int nanos)</td>
	<td>Wie 'wait(long timeout)' nur der TimeOut durch NanoSekunden noch prezieser ist.</td>
  </tr>
</table>

### Stream Interface

##### Methoden geerbt von interface java.util.stream.BaseStream

close, isParallel, iterator, onClose, parallel, sequential, spliterator, unordered

##### Methoden

<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=300 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>

  </tr>
  <tr>
	<td>boolean</td>
	<td>allMatch(Predicate&lt;? super T&gt; predicate)</td>
	<td>
	Gibt zurück, ob alle Elemente dieses Streams mit dem angegebenen Prädikat übereinstimmen.</td>
  </tr>
  <tr>
	<td>boolean</td>
	<td>anyMatch(Predicate&lt;? super T&gt; predicate)</td>
	<td>
	Gibt zurück, ob irgend ein Elemente dieses Streams mit dem angegebenen Prädikat übereinstimmen.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Stream.Builder<T></td>
	<td>builder(</td>
	<td>
	Gibt ein Builder für ein Stream zurück.</td>
  </tr>
  <tr>
	<td>&lt;R, A&gt; R</td>
	<td>collect(Collector&lt;? super T, A, R&gt; collector)</td>
	<td>
	Führt mit Hilfe eines Collectors eine veränderbare (mutable) Reduktionsoperation an den Elementen dieses Stroms durch.</td>
  </tr>
   <tr>
	<td>&lt;R&gt; R</td>
	<td>collect(Supplier&lt;R> supplier, BiConsumer&lt;R, ? super T&gt; accumulator, BiConsumer&lt;R, R&gt; combiner)</td>
	<td>
	Führt eine veränderbare Reduktionsoperation an den Elementen des Streams durch.</td>
  </tr>
   <tr>
	<td>long</td>
	<td>count()</td>
	<td>
	Gibt zurück, die Anzahl der Elemente des Streams.</td>
  </tr>
   <tr>
	<td>Stream&lt;T&gt;</td>
	<td>distinct()</td>
	<td>
	Gibt zurück, ein Stream ohne doppelte elemente, basierend auf Object.equals(Object)</td>
  </tr>
   <tr>
	<td>static &lt;T&gt; Stream&lt;T&gt;</td>
	<td>empty()</td>
	<td>
	Gibt zurück, ob der Stream leer ist.</td>
  </tr>
   <tr>
	<td>Stream&lt;T></td>
	<td>filter(Predicate&lt;? super T&gt; predicate)</td>
	<td>
	Gibt einen Strom zurück, der aus den Elementen dieses Stroms besteht, die mit dem gegebenen Prädikat übereinstimmen.</td>
  </tr>
  <tr>
	<td>Optional&lt;T&gt;</td>
	<td>findAny()</td>
	<td>
	Gibt ein Optional zurück, mit irgendeinem Element aus dem Stream oder ein 'empty Optional' wenn der Stream leer ist.</td>
  </tr>
   <tr>
	<td>Optional&lt;T&gt;</td>
	<td>findeFirst()</td>
	<td>
	Gibt ein Optional zurück, mit dem ersten Element aus dem Stream, oder 'empty Optional wenn der Stream leer ist.</td>
  </tr>
   <tr>
	<td>&lt;R&gt; Stream&lt;R&gt;</td>
	<td>flatMap(Function&lt;? super T. ? extends Stream&lt;? extends R&gt;&gt; mapper)</td>
	<td>
	Gibt einen Strom zurück, der aus den Ergebnissen der Ersetzung jedes Elements dieses Stroms durch den Inhalt eines abgebildeten Stroms besteht, der durch Anwendung der bereitgestellten Abbildungsfunktion auf jedes Element erzeugt wurde.</td>
  </tr>
  <tr>
	<td>DoubleStream</td>
	<td>flatMapToDouble(Function&lt;? super T, ? extends DoubleStream&gt; mapper)</td>
	<td>Gibt einen DoubleStream zurück, der aus den Ergebnissen der Ersetzung jedes Elements dieses Stroms durch den Inhalt eines abgebildeten Stroms besteht, der durch Anwendung der bereitgestellten Abbildungsfunktion auf jedes Element erzeugt wurde.</td>
  </tr>
  <tr>
	<td>IntStream</td>
	<td>flatMapToInt(Function&lt;? super T, ? extends IntStream&gt; mapper)</td>
	<td>Gibt einen IntStream zurück, der aus den Ergebnissen der Ersetzung jedes Elements dieses Stroms durch den Inhalt eines abgebildeten Stroms besteht, der durch Anwendung der bereitgestellten Abbildungsfunktion auf jedes Element erzeugt wurde.</td>
  </tr>
  <tr>
	<td>LongStream</td>
	<td>flatMapToLong(Function&lt;? super T, ? extends LongStream&gt; mapper)</td>
	<td>Gibt einen LongStream zurück, der aus den Ergebnissen der Ersetzung jedes Elements dieses Stroms durch den Inhalt eines abgebildeten Stroms besteht, der durch Anwendung der bereitgestellten Abbildungsfunktion auf jedes Element erzeugt wurde.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>forEach(Consumer&lt;?super T&gt; action)</td>
	<td>Führt für jedes Element dieses Streams eine Aktion aus.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>forEachOrdered(Consumer&lt;?super T&gt; action)</td>
	<td>Führt für jedes Element dieses Streams eine Aktion aus, und zwar in der Begegnungsreihenfolge des Streams, wenn der Stream eine definierte Begegnungsreihenfolge hat.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Stream&ltT&gt;</td>
	<td>generate(Supplier&ltT&gt; s )</td>
	<td>Gibt einen unendlichen sequentiellen, ungeordneten Strom zurück, bei dem jedes Element vom bereitgestellten Lieferanten erzeugt wird.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Stream&ltT&gt;</td>
	<td>iterate(T seed, UnaryOperator&lt;T&gt; f)</td>
	<td>Gibt einen unendlich sequentiell geordneten Strom zurück, der durch iterative Anwendung einer Funktion f auf einen Anfangselement-Seed erzeugt wird, wobei ein Strom erzeugt wird, der aus seed, f(seed), f(f(seed)), usw. besteht.</td>
  </tr>
  <tr>
	<td>Stream&lt;T&gt;</td>
	<td>limit(long maxSize)</td>
	<td>Gibt einen Stream zurück, der aus den Elementen dieses Streams besteht, abgeschnitten, um nicht länger als maxSize in der Länge zu sein.</td>
  </tr>
  <tr>
	<td>&lt;R&gt; Stream&lt;R&gt;</td>
	<td>map(Function&lt;? super T, ? extends R&gt; mapper)</td>
	<td>Gibt einen Strom zurück, der aus den Ergebnissen der Anwendung der gegebenen Funktion auf die Elemente dieses Stroms besteht.</td>
  </tr>
  <tr>
	<td>DoeubleStream</td>
	<td>mapToDouble(ToDoubleFunction&lt;? super T&gt; mapper)</td>
	<td>Gibt einen DoubleStream zurück, der aus den Ergebnissen der Anwendung der gegebenen Funktion auf die Elemente dieses Streams besteht.</td>
  </tr>
  <tr>
	<td>IntStream</td>
	<td>mapToInt(ToIntFunction&lt;? super T&gt; mapper)</td>
	<td>Gibt einen IntStream zurück, der aus den Ergebnissen der Anwendung der gegebenen Funktion auf die Elemente dieses Streams besteht.</td>
  </tr>
  <tr>
	<td>LongStream</td>
	<td>mapToLong(ToLongFunction&lt;? super T&gt; mapper)</td>
	<td>Gibt einen LongStream zurück, der aus den Ergebnissen der Anwendung der gegebenen Funktion auf die Elemente dieses Streams besteht.</td>
  </tr>
  <tr>
	<td>Optional&lt;T&gt;</td>
	<td>max(Comperator&lt;? super T&gt; comperator)</td>
	<td>Gibt das größte Element dieses Streams gemäß dem angegebenen Komparator zurück.</td>
  </tr>
  <tr>
	<td>Optional&lt;T&gt;</td>
	<td>min(Comperator&lt;? super T&gt; comperator)</td>
	<td>Gibt das kleinste Element dieses Streams gemäß dem angegebenen Komparator zurück.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Stream&lt;t&gt;</td>
	<td>of(T... values)</td>
	<td>Gibt einen sequentiell geordneten Strom zurück, dessen Elemente die angegebenen Werte sind.</td>
  </tr>
   <tr>
	<td>static &lt;T&gt; Stream&lt;t&gt;</td>
	<td>of(T t)</td>
	<td>Gibt einen sequentiellen Stream zurück, der ein einzelnes Element enthält.</td>
  </tr>
  <tr>
	<td>Steam&lt;T&gt;</td>
	<td>peek(Consumer&lt;? super T&gt; action</td>
	<td>Gibt einen Strom zurück, der aus den Elementen dieses Stroms besteht, und führt zusätzlich die vorgesehene Aktion für jedes Element aus, wenn Elemente aus dem resultierenden Strom verbraucht werden.</td>
  </tr>
  <tr>
	<td>Optional&lt;T&gt;</td>
	<td>reduce(BinaryOperator&lt;T&gt; accumulator)</td>
	<td>Führt mit Hilfe einer assoziativen Akkumulationsfunktion eine Reduktion der Elemente dieses Stroms durch und gibt ein Optional zurück, das den reduzierten Wert beschreibt, falls vorhanden.</td>
  </tr>
  <tr>
	<td>T</td>
	<td>reduce(T identity, BinaryOperator&lt;T&gt; accumulator)</td>
	<td>Führt eine Reduzierung der Elemente dieses Stroms unter Verwendung des bereitgestellten Identitätswerts und einer assoziativen Akkumulationsfunktion durch und gibt den reduzierten Wert zurück.</td>
  </tr>
  <tr>
	<td>&lt;R&gt; U</td>
	<td>reduce(u identity, BiFunction&lt;U, ? super T, U&gl; accumulator, BinaryOperation&lt;U&gt; combiner)</td>
	<td>Führt eine Reduktion der Elemente dieses Stroms durch, indem er die vorgegebene Identität nutzt, Funktionen akkumuliert und kombiniert.</td>
  </tr>
  <tr>
	<td>Stream&lt;T&gt;</td>
	<td>skip(long n)</td>
	<td>Gibt einen Strom zurück, der aus den verbleibenden Elementen dieses Stroms besteht, nachdem die ersten n Elemente des Stroms verworfen wurden.</td>
  </tr>
  <tr>
	<td>Stream&lt;T&gt;</td>
	<td>sorted()</td>
	<td>Gibt einen Strom zurück, der aus den Elementen dieses Stroms besteht, sortiert nach der natürlichen Ordnung.</td>
  </tr>
  <tr>
	<td>Stream&lt;T&gt;</td>
	<td>sorted(Comperator&lt;? super T&gt; comperator)</td>
	<td>Gibt einen Strom zurück, der aus den Elementen dieses Stroms besteht, sortiert nach dem bereitgestellten Komparator.</td>
  </tr>
  <tr>
	<td>Object[]</td>
	<td>toArray()</td>
	<td>Gibt ein Array zurück, das die Elemente dieses Streams enthält.</td>
  </tr>
  <tr>
	<td>&lt;A&gt; a[]</td>
	<td>toArray(IntFunction&lt;A[]&gt; generator</td>
	<td>Gibt ein Array zurück, das die Elemente dieses Streams enthält, wobei die bereitgestellte Generatorfunktion verwendet wird, um das zurückgegebene Array sowie alle zusätzlichen Arrays, die für eine partitionierte Ausführung oder zur Größenänderung erforderlich sein könnten, zuzuweisen.</td>
  </tr>
</table>


### Functional Interfaces (Package java.util.function)

##### BiConsumer&lt;T,U&gt;
Stellt einen Vorgang dar, der zwei Eingabeargumente akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(T t, U u)</td>
	<td>Führt diese Operation mit den angegebenen Argumenten aus.</td>
  </tr>
</table>

##### BiFunktion&lt;T,U,R&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein Ergebnis erzeugt.

##### BinaryOperator&lt;T&gt;
Stellt eine Operation auf zwei Operanden desselben Typs dar, die ein Ergebnis desselben Typs wie die Operanden erzeugt.

##### BiPredicate&lt;T,U&gt;
Stellt ein Prädikat (Boolesche-Wert-Funktion) von zwei Argumenten.

##### BooleanSupplier
Repräsentiert einen Lieferanten von boolesch Werten.

##### Consumer&lt;T&gt;
Stellt einen Vorgang dar, der ein einzelnes Eingabeargument akzeptiert und kein Ergebnis zurückgibt.

##### DoubleBinaryOperator
Stellt eine Operation auf zwei double Operanden dar und erzeugt ein double Ergebnis.

##### DoubleConsumer
Stellt einen Vorgang dar, der ein einzelnes double Argument akzeptiert und kein Ergebnis zurückgibt.

##### DoubleFunction&lt;T&gt;
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein Ergebnis liefert.

##### DoublePredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines double Arguments dar.

##### DoubleSupplierer
Repräsentiert einen Lieferanten von double Ergebnissen.

##### DoubleToIntFunction
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein int Ergebnis erzeugt.

##### DoubleToLongFunction
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein long Ergebnis erzeugt.

##### DoubleUnaryOperator
Stellt einen Vorgang an einem einzelnen double Operanden dar, der ein double Ergebnis erzeugt.

##### Function&lt;T,R&gt;
Stellt eine Funktion dar, die ein Argument akzeptiert und ein Ergebnis erzeugt.

##### IntBinaryOperaator
Stellt eine Operation auf zwei int Operanden dar und erzeugt ein int Ergebnis.

##### IntConsumer
Stellt einen Vorgang dar, der ein einzelnes int Argument akzeptiert und kein Ergebnis zurückgibt.

##### IntFunction&lt;R&gt;
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein Ergebnis liefert.

##### IntPredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines int Arguments dar.

##### IntSupplier
Repräsentiert einen Lieferanten von int Ergebnissen.

##### IntToDoubleFunction
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein double Ergebnis erzeugt.

##### IntToLongFunction
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein long Ergebnis erzeugt.

##### IntUnaryOperator
Stellt einen Vorgang an einem einzelnen int Operanden dar, der ein int Ergebnis erzeugt.

##### LongBinaryOperaator
Stellt eine Operation auf zwei long Operanden dar und erzeugt ein long Ergebnis.

##### LongConsumer
Stellt einen Vorgang dar, der ein einzelnes long Argument akzeptiert und kein Ergebnis zurückgibt.

##### LongFunction&lt;R&gt;
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein Ergebnis liefert.

##### LongPredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines long Arguments dar.

##### LongSupplier
Repräsentiert einen Lieferanten von long Ergebnissen.

##### LongToDoubleFunction
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein double Ergebnis erzeugt.

##### LongToIntFunction
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein int Ergebnis erzeugt.

##### LongUnaryOperator
Stellt einen Vorgang an einem einzelnen long Operanden dar, der ein long Ergebnis erzeugt.

##### ObjDoubleConsumer&lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein double Argument akzeptiert und kein Ergebnis zurückgibt.

##### ObjIntConsumer%lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein int Argument akzeptiert und kein Ergebnis zurückgibt.

##### ObjLongConsumer&lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein long Argument akzeptiert und kein Ergebnis zurückgibt.

##### Predicate&lt;T&gt;
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines Arguments dar.

##### Supplier&lt;T&gt;
Repräsentiert einen Lieferanten von Ergebnissen.

##### ToDoubleBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein double Ergebnis liefert.

##### ToDoubleFunction&lt;T&gt;
Stellt eine Funktion dar, die ein double Ergebnis liefert.

##### ToIntBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein int Ergebnis erzeugt.

##### ToIntFunction&lt;T&gt;
Stellt eine Funktion dar, die ein int Ergebnis erzeugt.

##### ToLongBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein longErgebnis liefert.

##### ToLongFunction&lt;T&gt;
Repräsentiert eine Funktion, die ein long Ergebnis liefert.

##### UnaryOperator&lt;T&gt;
Stellt eine Operation auf einem einzelnen Operanden dar, die ein Ergebnis desselben Typs wie sein Operand erzeugt.


- Optional
- Comparator

- Collection ( ArrayDeque besonders )
- Map (auch mit funkt. Parameter)
 
 - AutoCloseable / Closeable
 
 - DriverManager/Connection/Statement/ResultSet
 
 - Properties/ResourceBundle
 
 - Thread / Runnable
 - AtomicInteger
 - BlockingQueue / ArrayBlockingQueue / LinkedBlockingQueue
 
 - ExecutorService / Executors / Callable
 - ForkJoin
 - CyclicBarrier

<!--
Methoden

<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>protected Object</td>
	<td>clone()</td>
	<td>Erstellt und gibt eine Kopie zurück</td>
  </tr>
  <tr>
	<td> </td>
	<td></td>
	<td></td>
  </tr>
</table>
-->
 