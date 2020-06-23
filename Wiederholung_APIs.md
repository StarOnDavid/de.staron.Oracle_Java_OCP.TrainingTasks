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
	<td><R, A> R</td>
	<td>collect(Collector&lt;? super T, A, R&gt; collector)</td>
	<td>
	Führt mit Hilfe eines Collectors eine veränderbare (mutable) Reduktionsoperation an den Elementen dieses Stroms durch.</td>
  </tr>
   <tr>
	<td><R> R</td>
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
	<td><R> Stream&lt;R></td>
	<td>flatMap(Function&lt;? super T. ? extends Stream&lt;? extends R&gt;&gt; mapper)</td>
	<td>
	Gibt einen Strom zurück, der aus den Ergebnissen der Ersetzung jedes Elements dieses Stroms durch den Inhalt eines abgebildeten Stroms besteht, der durch Anwendung der bereitgestellten Abbildungsfunktion auf jedes Element erzeugt wurde.</td>
  </tr>
  <tr>
	<td></td>
	<td></td>
  </tr>
</table>


- Functional Interfaces (BiFunction, UnearyOp. etc.)
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
 