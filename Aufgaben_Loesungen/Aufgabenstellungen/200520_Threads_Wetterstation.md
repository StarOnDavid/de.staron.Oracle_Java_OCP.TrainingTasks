# Aufgabe 'Threads - Wetterstation'

- In einem Thread wird jede 100 Millisekunden die Umgebungstemperatur gemessen. Simuliert wird jede Messung durch das Generieren einer Zufallszahl, die im Bereich des vorherigen Wertes +/- 5 Grad liegt. Die Anfangstemperatur kann auf 0 Grad gesetzt werden.


- In einem anderen Thread werden die drei letzten vorhandenen Messungen analysiert (1 mal pro Sekunde). Falls in diesen drei Messungen der stätige Abfall erkannt wird, wird die Tendenz auf der Konsole visualisiert. Dasselbe zur stätigen Steigung.


- Im dritten Thread werden Warnungen ausgegeben, falls die aktuelle Themperatur einen Grenzwert überschreitet (zu warm) oder unterschreitet (zu kalt). Auch die Kontrollen werden nur periodisch (1 Mal in 2 Sek) durchgeführt
