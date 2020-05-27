# Aufgabe 'JDBC - MySqlUtils'


###### A1.

Datei 'selectAll.sql' hat den Text:  select * from autos
	
Die Methode loadScript soll den Text aus einer Datei aus dem Classpath laden und liefern
	
String script = loadScript("/jdbc/mysql/selectAll.sql");
// Im String script ist jetzt der Text "select * from autos"

	
###### A2.

rebuildTestTable soll eine Test-Tabelle erzeugen (alte löschen)

SQL, Tabelle löschen:  drop table tiere
	- MySQL, Tabelle löschen falls sie existiert:  drop table if exists tiere
	- SQL, Tabelle erstellen

	CREATE TABLE tiere (
		`id` INT NOT NULL,
		`name` VARCHAR(45) NOT NULL,
		`alter` INT NOT NULL)
		
###### A3.

printTestTable soll die Test-Tabelle 'tiere' formatiert ausgeben

		| id | name   | alter |
		|  1 |  Tom   |     3 |
		|  2 |  Jerry |     5 |
		|  3 |  Rex   |     2 |
