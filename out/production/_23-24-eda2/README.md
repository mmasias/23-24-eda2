## Informacion relevante:
- El archivo ejecutable para el Sort es el archivo `RetoEDA`.
- Se utilizó el BubbleSort para ordenar las cartas, tanto por `Palos` como por `Número`.
- En el menú principal se puede seleccionar la opción de ordenar por `Palos` o por `Número`, y se mostrará el resultado en consola, además de la opción de volver a barajar.
- La siguiente expresión es digna de explicación: `Comparator.comparing(Carta::getPalo).thenComparing(Carta::getNumero)`, primero se hace una comparación del objeto Carta por el atributo `Palo`, y si estos son iguales, se compara por el atributo `Número`.