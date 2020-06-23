## Object - Klasse

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

---
---

## Stream Interface

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

---
---

## Functional Interfaces (Package java.util.function)

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

---

##### BiFunktion&lt;T,U,R&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(T t, U u)</td>
	<td>Wendet diese Funktion auf die angegebenen Argumente an.</td>
  </tr>
</table>

---

##### BinaryOperator&lt;T&gt;
Stellt eine Operation auf zwei Operanden desselben Typs dar, die ein Ergebnis desselben Typs wie die Operanden erzeugt.
###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(T t1, T t2)</td>
	<td>Wendet diese Funktion auf die angegebenen Argumente an.</td>
  </tr>
</table>

---

##### BiPredicate&lt;T,U&gt;
Stellt ein Prädikat (Boolesche-Wert-Funktion) von zwei Argumenten.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>test(T t1, T t2)</td>
	<td>Bewertet dieses Prädikat anhand der gegebenen Argumente.</td>
  </tr>
</table>

---

##### BooleanSupplier
Repräsentiert einen Lieferanten von boolesch Werten.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>getAsBoolean</td>
	<td>Erzeugt ein boolischen-Wert.</td>
  </tr>
</table>

---

##### Consumer&lt;T&gt;
Stellt einen Vorgang dar, der ein einzelnes Eingabeargument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>accept(T t)</td>
	<td>Führt diese Operation für das angegebene Argument aus.</td>
  </tr>
</table>

---

##### DoubleBinaryOperator
Stellt eine Operation auf zwei double Operanden dar und erzeugt ein double Ergebnis.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>applyAsDouble(double left, double right)</td>
	<td>Wendet diesen Operator auf die gegebenen Operanden an.</td>
  </tr>
</table>

---

##### DoubleConsumer
Stellt einen Vorgang dar, der ein einzelnes double Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(double value)</td>
	<td>Führt diese Operation für das angegebene Argument aus.</td>
  </tr>
</table>

---

##### DoubleFunction&lt;T&gt;
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(double value)</td>
	<td>Stellt eine Funktion dar, die ein double Argument akzeptiert und ein Ergebnis liefert.</td>
  </tr>
</table>

---

##### DoublePredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines double Arguments dar.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>test(double value)</td>
	<td>Bewertet dieses Prädikat anhand des gegebenen Arguments.</td>
  </tr>
</table>

---

##### DoubleSupplierer
Repräsentiert einen Lieferanten von double Ergebnissen.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>getAsDouble()</td>
	<td>Liefert ein Ergebnis.</td>
  </tr>
</table>

---

##### DoubleToIntFunction
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein int Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>getAsInt(double value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### DoubleToLongFunction
Stellt eine Funktion dar, die ein double Argument akzeptiert und ein long Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>getAsLong(double value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### DoubleUnaryOperator
Stellt einen Vorgang an einem einzelnen double Operanden dar, der ein double Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>applyAsDouble(double operand)</td>
	<td>Wendet diesen Operator auf den gegebenen Operanden an.</td>
  </tr>
</table>

---

##### Function&lt;T,R&gt;
Stellt eine Funktion dar, die ein Argument akzeptiert und ein Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(T t)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### IntBinaryOperaator
Stellt eine Operation auf zwei int Operanden dar und erzeugt ein int Ergebnis.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>applyAsInt(int left, int right)</td>
	<td>Wendet diesen Operator auf die gegebenen Operanden an.</td>
  </tr>
</table>

---

##### IntConsumer
Stellt einen Vorgang dar, der ein einzelnes int Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(int value)</td>
	<td>Führt diese Operation für das angegebene Argument aus.</td>
  </tr>
</table>

---

##### IntFunction&lt;R&gt;
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(int value)</td>
	<td>Stellt eine Funktion dar, die ein int Argument akzeptiert und ein Ergebnis liefert.</td>
  </tr>
</table>

---

##### IntPredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines int Arguments dar.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>test(int value)</td>
	<td>Bewertet dieses Prädikat anhand des gegebenen Arguments.</td>
  </tr>
</table>

---

##### IntSupplier
Repräsentiert einen Lieferanten von int Ergebnissen.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>getAsInt()</td>
	<td>Liefert ein Ergebnis.</td>
  </tr>
</table>

---

##### IntToDoubleFunction
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein double Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>getAsDouble(int value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### IntToLongFunction
Stellt eine Funktion dar, die ein int Argument akzeptiert und ein long Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>getAsLong(int value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### IntUnaryOperator
Stellt einen Vorgang an einem einzelnen int Operanden dar, der ein int Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>applyAsInt(int operand)</td>
	<td>Wendet diesen Operator auf den gegebenen Operanden an.</td>
  </tr>
</table>

---

##### LongBinaryOperaator
Stellt eine Operation auf zwei long Operanden dar und erzeugt ein long Ergebnis.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>applyAsLong(long left, long right)</td>
	<td>Wendet diesen Operator auf die gegebenen Operanden an.</td>
  </tr>
</table>

---

##### LongConsumer
Stellt einen Vorgang dar, der ein einzelnes long Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(long value)</td>
	<td>Führt diese Operation für das angegebene Argument aus.</td>
  </tr>
</table>

---

##### LongFunction&lt;R&gt;
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>R</td>
	<td>apply(long value)</td>
	<td>Stellt eine Funktion dar, die ein long Argument akzeptiert und ein Ergebnis liefert.</td>
  </tr>
</table>

---

##### LongPredicate
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines long Arguments dar.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>test(long value)</td>
	<td>Bewertet dieses Prädikat anhand des gegebenen Arguments.</td>
  </tr>
</table>

---

##### LongSupplier
Repräsentiert einen Lieferanten von long Ergebnissen.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>getAsLong()</td>
	<td>Liefert ein Ergebnis.</td>
  </tr>
</table>

---

##### LongToDoubleFunction
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein double Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>getAsDouble(long value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### LongToIntFunction
Stellt eine Funktion dar, die ein long Argument akzeptiert und ein int Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>getAsInt(long value)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### LongUnaryOperator
Stellt einen Vorgang an einem einzelnen long Operanden dar, der ein long Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>applyAsLong(long operand)</td>
	<td>Wendet diesen Operator auf den gegebenen Operanden an.</td>
  </tr>
</table>

---

##### ObjDoubleConsumer&lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein double Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(T t, double value)</td>
	<td>Führt diese Operation mit den angegebenen Argumenten aus.</td>
  </tr>
</table>

---

##### ObjIntConsumer%lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein int Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(T t, int value)</td>
	<td>Führt diese Operation mit den angegebenen Argumenten aus.</td>
  </tr>
</table>

---

##### ObjLongConsumer&lt;T&gt;
Stellt einen Vorgang dar, der ein Object und ein long Argument akzeptiert und kein Ergebnis zurückgibt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>void</td>
	<td>accept(T t, long value)</td>
	<td>Führt diese Operation mit den angegebenen Argumenten aus.</td>
  </tr>
</table>

---

##### Predicate&lt;T&gt;
Stellt ein Prädikat (Boolesche-Wert-Funktion) eines Arguments dar.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean</td>
	<td>test(T t)</td>
	<td>Bewertet dieses Prädikat anhand des gegebenen Arguments.</td>
  </tr>
</table>

---

##### Supplier&lt;T&gt;
Repräsentiert einen Lieferanten von Ergebnissen.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>T</td>
	<td>get(T t)</td>
	<td>Liefert ein Ergebins.</td>
  </tr>
</table>

---

##### ToDoubleBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein double Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>applyAsDouble(T t, u u)</td>
	<td>Wendet diese Funktion auf die angegebenen Argumente an.</td>
  </tr>
</table>

---

##### ToDoubleFunction&lt;T&gt;
Stellt eine Funktion dar, die ein double Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>applyAsDouble(T t)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### ToIntBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein int Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>applyAsInt(T t, u u)</td>
	<td>Wendet diese Funktion auf die angegebenen Argumente an.</td>
  </tr>
</table>

---

##### ToIntFunction&lt;T&gt;
Stellt eine Funktion dar, die ein int Ergebnis erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>double</td>
	<td>applyAsInt(T t)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### ToLongBiFunction&lt;T,U&gt;
Stellt eine Funktion dar, die zwei Argumente akzeptiert und ein longErgebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>applyAsLong(T t, u u)</td>
	<td>Wendet diese Funktion auf die angegebenen Argumente an.</td>
  </tr>
</table>

---

##### ToLongFunction&lt;T&gt;
Repräsentiert eine Funktion, die ein long Ergebnis liefert.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>long</td>
	<td>applyAsLong(T t)</td>
	<td>Wendet diese Funktion auf das angegebene Argument an.</td>
  </tr>
</table>

---

##### UnaryOperator&lt;T&gt;
Stellt eine Operation auf einem einzelnen Operanden dar, die ein Ergebnis desselben Typs wie sein Operand erzeugt.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>T</td>
	<td>apply(T t)</td>
	<td>Wendet diesen Operator auf das angegebene Argument an.</td>
  </tr>
</table>

---
---


## Optional&lt;T&gt;

##### Methoden
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>static &lt;T&gt; Optional&lt;T&gt;</td>
	<td>empty()</td>
	<td>Gibt ein leeres Optional zurück.</td>
  </tr>
  <tr>
	<td>boolean</td>
	<td>equals(Object obj)</td>
	<td>Zeigt an, ob ein anderes Objekt dieser Option "gleich" ist.</td>
  </tr>
  <tr>
	<td>Optional&lt;T&gt;</td>
	<td>filter(Predicate&lt;? super T&gt; predicate)</td>
	<td>Wenn ein Wert vorhanden ist und der Wert mit dem gegebenen Prädikat übereinstimmt, gibt Sie ein Optional zurück, das den Wert beschreibt, andernfalls gibt Sie ein leeres Optional zurück.</td>
  </tr>
  <tr>
	<td>&lt;U&gt; Optional&lt;U&gt;</td>
	<td>flatMap(Function&lt;? super T, Optional&lt;U&gt;&gt; mapper)</td>
	<td>Wenn ein Wert vorhanden ist, wendt Sie die bereitgestellte Zuordnungsfunktion "Optional-bearing" auf ihn an, gibt Sie das Ergebnis zurück, andernfalls gibt Sie ein leeres Optional zurück.</td>
  </tr>
  <tr>
	<td>T</td>
	<td>get()</td>
	<td>Wenn ein Wert in diesem Optional vorhanden ist, gibt Sie den Wert zurück, andernfalls wird NoSuchElementException ausgelöst.</td>
  </tr>
  <tr>
	<td>int</td>
	<td>hashCode()</td>
	<td>Gibt den Hash-Code-Wert des aktuellen Werts zurück, falls vorhanden, oder 0 (null), wenn kein Wert vorhanden ist.</td>
  </tr>
  <tr>
	<td>void</td>
	<td>ifPresent(Consumer&lt;? super T&gt; consumer)</td>
	<td>Wenn ein Wert vorhanden ist, rufen Sie den angegebenen Consumer mit dem Wert auf, andernfalls unternimmt Sie nichts.</td>
  </tr>
  <tr>
	<td>boolean</td>
	<td>ifPresent()</td>
	<td>Gibt true zurück, wenn ein Wert vorhanden ist, andernfalls false.</td>
  </tr>
  <tr>
	<td>&lt;U&gt; Optional&lt;U&gt;</td>
	<td>map(Function&lt;? super T, ? extends U&gt; mapper)</td>
	<td>Wenn ein Wert vorhanden ist, wird die bereitgestellte Abbildungsfunktion auf ihn angewendet, und wenn das Ergebnis ungleich Null ist, gibt Sie ein Optional zurück, das das Ergebnis beschreibt.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Optional&lt;T&gt;</td>
	<td>of(T value)</td>
	<td>Gibt ein Optional mit dem angegebenen aktuellen Nicht-Null-Wert zurück.</td>
  </tr>
  <tr>
	<td>static &lt;T&gt; Optional&lt;T&gt;</td>
	<td>ofNullable(T value)</td>
	<td>Gibt ein Optional zurück, das den angegebenen Wert beschreibt, wenn es ungleich null ist, andernfalls wird ein leeres Optional zurückgegeben.</td>
  </tr>
  <tr>
	<td>T</td>
	<td>orElse(T other)</td>
	<td>Gibr den Wert zurück, falls vorhanden, andernfalls wird 'other' zurück gegeben.</td>
  </tr>
  <tr>
	<td>T</td>
	<td>orElseGet(Supplier&lt;? extends T&gt; other) </td>
	<td>Gibt den Wert zurück, falls vorhanden, andernfalls wird der Supplier aufgerufen und der Wert daraus zurück gegeben.</td>
  </tr>
  <tr>
	<td>&lt;X extends Throwable&gt;</td>
	<td>orElseThrow(Supplier&lt;? extends X&gt; exceptionSupplier)</td>
	<td>Gibt den enthaltenen Wert zurück, falls vorhanden, andernfalls wird eine Exeption ausgelöst, die vom Supplier erstellt werden muss.</td>
  </tr>
  <tr>
	<td>String</td>
	<td>toString()</td>
	<td>Gibt einen nicht leeren String dieses Optional zurück, die sich zum Debuggen eignet.</td>
  </tr>
</table>

## Interface Comparator&lt;T&gt;
Eine Vergleichsfunktion, die bei einigen Sammlungen von Objekten eine Gesamtordnung liefert. Komparatoren können an eine Sortiermethode (wie z.B. Collections.sort oder Arrays.sort) übergeben werden, um eine genaue Kontrolle über die Sortierreihenfolge zu ermöglichen. Komparatoren können auch verwendet werden, um die Reihenfolge bestimmter Datenstrukturen (wie sortierte Sätze oder sortierte Karten) zu steuern oder um eine Ordnung für Sammlungen von Objekten zu schaffen, die keine natürliche Ordnung haben.

###### abstracte Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>int</td>
	<td>compare(T o1, T o2)</td>
	<td>Vergleicht seine beiden Argumente für eine Sortierung (größer/kleiner).</td>
  </tr>
  <tr>
	<td>int</td>
	<td>equals(Object obj)</td>
	<td>Zeigt an, ob ein anderes Objekt mit diesem Vergleichsobjekt "gleich" ist.</td>
  </tr>
</table>
Trotz dem es zwei abstrakte Methoden gibt ist der Comperator ein funktionalses Interface, da Methoden die aus der basis Klasse Object überschrieben werden bei dem Kriterium für ein funktionales Interface keine rolle spielen.

---

###### statische Methode
<table>
  <tr>
    <th width=200 align="left">modifier and Type</th>
	<th width=200 align="left">Methoden</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>static &lt;T,U extends Comparable&lt;? super U&gt;&gt;
Comparator&lt;T&gt;</td>
	<td>comparing(Function&lt;? super T,? extends U&gt; keyExtractor)</td>
	<td>Akzeptiert eine Funktion, die einen vergleichbaren Sortierschlüssel aus einem Typ T extrahiert und einen Comperator<T> zurückgibt, der nach diesem Sortierschlüssel vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td>comparing(Function&lt;? super T,? extends U&gt; keyExtractor, Comparator&lt;? super U&gt; keyComparator)</td>
	<td>Akzeptiert eine Funktion, die einen Sortierschlüssel aus einem Typ T extrahiert und einen Comperator<T> zurückgibt, der nach diesem Sortierschlüssel unter Verwendung des angegebenen Komparators vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td> 	comparingDouble(ToDoubleFunction&lt;? super T&gt; keyExtractor)</td>
	<td>Akzeptiert eine Funktion, die einen Sortierschlüssel für double aus einem Typ T extrahiert und einen Comparator<T> zurückgibt, der nach diesem Sortierschlüssel vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td> 	comparingInt(ToIntFunction&lt;? super T&gt; keyExtractor)</td>
	<td>Akzeptiert eine Funktion, die einen Sortierschlüssel für int aus einem Typ T extrahiert und einen Comparator<T> zurückgibt, der nach diesem Sortierschlüssel vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td> 	comparingLong(ToLongFunction&lt;? super T&gt; keyExtractor)</td>
	<td>Akzeptiert eine Funktion, die einen Sortierschlüssel für long aus einem Typ T extrahiert und einen Comparator<T> zurückgibt, der nach diesem Sortierschlüssel vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T extends Comparable&lt;? super T&gt;&gt; Comparator&lt;T&gt;</td>
	<td>naturalOrder()</td>
	<td>Gibt einen Komparator zurück, der Comparable Objekte in natürlicher Reihenfolge vergleicht.</td>
  </tr>
  <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td>nullsFirst(Comperator&lt;? super T&gt; comperator)</td>
	<td>Gibt einen null-freundlichen Komparator zurück, der Null als kleiner als Nicht-Null betrachtet.</td>
  </tr>
   <tr>
	<td>static &lt;T,U&gt; Comparator&lt;T&gt;</td>
	<td>nullsLast(Comperator&lt;? super T&gt; comperator)</td>
	<td>Gibt einen null-freundlichen Komparator zurück, der Null als größer als Nicht-Null betrachtet.</td>
  </tr>
  <tr>
	<td>static &lt;T extends Comparable&lt;? super T&gt;&gt; Comparator&lt;T&gt;</td>
	<td>reverseOrder()</td>
	<td>Gibt einen Komparator zurück, der die Umkehrung der natürlichen Ordnung erzwingt.</td>
  </tr>  
</table>

---

## Arrays and Collections 

<table>
  <tr>
    <th width=300 align="left">Schlüssel-Methoden aus java.util.Arrays</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>static List asList(T[])</td>
	<td>Wandeln Sie ein Array in eine Liste um (und bindt diese).</td>
  </tr>
  <tr>
	<td>static int binarySearch(Object[], key)<br>
	static int binarySerch(primitiv[], key)</td>
	<td>Durchsucht ein sortiertes Array nach einem bestimmten Wert(key); gibt einen Index oder eine Einfügemarke zurück.</td>
  </tr>
  <tr>
	<td>static int binarySearch(T[], key, Comperator)</td>
	<td>Durchsucht ein mit dem übergebene Komperrator sortiertes Array, nach einem bestimmten Wert (key).</td>
  </tr>
  <tr>
	<td>static boolean equals(Object[], Object[])<br>
	static boolean equals(primitiv[], primitiv[])</td>
	<td>Vergleicht zwei Arrays, um festzustellen, ob ihr Inhalt gleich ist.</td>
  </tr>
  <tr>
	<td>static void sort(Object[])<br>
	static void sort(primitiv[])</td>
	<td>Sortiert die Inhalte eines Arrays nach ihrer 'natürlichen' Ordnung (Compareable).</td>
  </tr>
  <tr>
	<td>static void sort(T[], Comperator)</td>
	<td>Sortiert die Inhalte eines Arrays nach der durch den Komperator vorgegebenen Ordnung.</td>
  </tr>
  <tr>
	<td>static String toString(Object[])<br>
	static String toString(primitiv[])</td>
	<td>Erstellt einen String mit dem Inhalt des Arrays.</td>
  </tr>
  <tr>
	<td></td>
	<td></td>
  </tr>
  <tr>
    <th width=300 align="left">Schlüssel-Methoden aus java.util.Collections</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>static int binarySearch(List, key)<br>
	static int binarySearch(List, key, Comperator)</td>
	<td>Durchsucht ein sortiertes Array nach einem bestimmten Wert(key); gibt einen Index oder eine Einfügemarke zurück.</td>
  </tr>
  <tr>
	<td>static void revers(List)</td>
	<td>Dreht die Reihenfolge der Elemente in einer Liste um.</td>
  </tr>
  <tr>
	<td>stativ Comperator reversOrder()<br>
	stativ Comperator reversOrder(Comperator)</td>
	<td>Gibt einen Comperator zurück, der umgekert zur aktuellen Reihenfolge sortiert.</td>
  </tr>
  <tr>
	<td>static void sort(List)<br>
	static void sort(List, Comperator)</td>
	<td>Sortiert die List nach der 'natürlichen' Ordnung (Compareable) oder entsprechen des übergeben Comperator.</td>
  </tr>
</table>

---
---

## Collection

<table>
  <tr>
    <th width=300 align="left">Schlüssel-Methoden aus java.util.Arrays</th>
	<th width=20 align="middle">List</th>
	<th width=20 align="middle">Set</th>
	<th width=20 align="middle">Map</th>
	<th width=500 align="left">Beschreibung</th>
  </tr>
  <tr>
	<td>boolean add(element)<br>
	boolean add(index, element)</td>
	<td vertical-align="top">x<br>x</td>
	<td vertical-align="top">x</td>
	<td vertical-align="top"></td>
	<td>Fügt ein Element hinzu. Optional für Listen an einem Indexpunkt.</td>
  </tr>
 </table>

- ArrayDeque
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
 