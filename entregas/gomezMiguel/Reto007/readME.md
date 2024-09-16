A lo largo del proceso de creación hubo que reflexionar como lidiar con la protección de los atributos: 

- En la clase Baraja la matriz de objetos Carta = cartas
- En la clase Carta los atributos "numero" y "palo"

De no ser por las protecciones los métodos de ordenación los métodos de ordenación hubiesen lucido así, que es como los trabaje inicialmente:

```java
public void ordenarPorPalo1(Baraja baraja) {
        for (int i = 0; i < baraja.cartas.length; i++) {
            for (int j = 0; j < baraja.cartas.length - 1; j++) {
                if (baraja.cartas[j].palo > baraja.cartas[j + 1].palo) {
                    Carta temp = baraja.cartas[j];
                    baraja.cartas[j] = baraja.cartas[j + 1];
                    baraja.cartas[j + 1] = temp;
                }
            }
        }
    }
```

Es decir accediendo a los datos directamente, luego, vi que se podía acceder al numero y al palo por medio de getters que es como ya trabajé la entrega:

Apliqué este método para cartas (getCartas) pero en el [4º commit](https://github.com/miguelgomez75/23-24-eda2/commit/), Creé los getters de los 3 atributos pero omití que había quitado el private de cartas, lo cuál me permitía trabajar el método así:

```java
public void ordenarPorPalo1(Baraja baraja){
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getpalo() > cartas[j + 1].getpalo()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
    }
```

Pero como no se debía modificar el código original (es decir, implementar métodos se puede pero no editar el código ya escrito) tuve que deshacer la eliminación de dicho private y dejar los métodos como se ven ahora:

```java
public void ordenarPorPalo1(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getpalo() > cartas[j + 1].getpalo()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
        baraja.setCartas(cartas);
    }
```

PD: Todos los métodos de ordenación se usaron basandose en el bubblesort y muchos de ellos se pudieron sacar de los primeros hechos (ordenación por número y palo siguen la misma lógica pero con distinto getter y el asc o desc es por el mayor o menor que los compara, haciendo las distintas variaciones una casi copia de la anterior)