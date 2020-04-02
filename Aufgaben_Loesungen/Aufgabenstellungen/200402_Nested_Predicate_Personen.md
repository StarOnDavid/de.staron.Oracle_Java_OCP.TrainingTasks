# Aufgabe 'Nested - Predicate - Personen'

#### A1.
Jede Person hat Vornamen, Nachnamen und Geburtsjahr.
Erzeugen Sie in der main-Methode einer Test-Klasse mindestens 4 Personen und speichern sie in einem Array.


#### A2.
Definieren Sie in der Test-Klasse eine weitere Methode:
   
        List<Person> filtern(Person[], Predicate<Person>)

Die Methode durchsucht das Array, das als 1. Parameter übergeben wird. Sie liefert eine `java.util.List` zurück, in der nur die Personen gespeichert sind, die mit dem übergebenem Predicate (2. Parameter) akzeptiert werden. 


#### A3.
Erzeugen Sie mit einer Toplevel-Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die nach einem bestimmten Jahr geboren wurden. Testen Sie den Filter mit der Methode `filtern`.


#### A4.
Erzeugen Sie mit einer inneren Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens ein 'a' haben. Testen Sie den Filter mit der Methode `filtern`.


#### A5.
Erzeugen Sie mit einer lokalen Klasse einen Predicate-Filter, der nur die Personen akzeptiert, die in ihrem Nachnamen mindestens 4 Zeichen haben. Testen Sie den Filter mit der Methode `filtern`.

   
#### A6.
Erzeugen Sie mit einer anonymen Klasse einen Predicate-Filter, der die Eigenschaften zwei anderer Filter (im weiteren A und B genannt) vereint. Akzeptiert werden mit dem neuen Filter nur die Personen, die von Filter A UND Filter B akzeptiert werden. Benutzen Sie zum Testen als Filter A und B die Filter aus den bisherigen Aufgabenpunkten. Testen Sie den neuen Predicate-Filter mit der Methode `filtern`.

> Überprüfen Sie ob die Predicate-API alternative Möglichkeiten anbietet zwei vorhandene Predicates logisch (mit UND) zu verknüpfen.

#### A7.
Realisieren Sie einen weiteren Predicate-Filter mit einer Lambda-Funktion, mit der nur die Personen akzeptiert werden, die in einem Schaltjahr geboren wurden. Testen Sie den Filter mit der Methode filtern. 

> Tipp: Verwenden Sie die Methode `isLeapYear` aus der Klasse `LocalDate` oder die Methode `isLeap`aus der Klasse `Year`.