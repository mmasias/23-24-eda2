# Laberinto

Dado un laberinto:

```
Laberinto:
==========================================
 · [ ] ·  · [ ] ·  · [ ] ·  · [ ] ·  ·  · 
 · [ ] · [ ][ ] · [ ][ ] · [ ][ ] · [ ] · 
 ·  ·  · [ ] ·  · [ ] ·  · [ ] ·  · [ ] · 
[ ][ ] · [ ] ·  ·  ·  ·  · [ ] ·  · [ ] · 
 · [ ] · [ ][ ] · [ ][ ] · [ ][ ] · [ ] · 
 ·  ·  · [ ] ·  · [ ] ·  ·  ·  ·  · [ ] · 
[ ][ ] · [ ] ·  · [ ][ ] · [ ] ·  · [ ] · 
 ·  ·  ·  ·  · [ ] ·  ·  ·  ·  · [ ] ·  · 
==========================================
```

La recursividad se puede utilizar para explorar diferentes caminos posibles de manera sistemática, moviéndose desde un punto de inicio (0,0) hasta un punto de destino, evitando las paredes y explorando diferentes caminos posibles hasta encontrar la salida:

```
Ruta de escape:
==========================================
 * [ ] ·  · [ ] ·  · [ ] ·  · [ ] *  *  * 
 * [ ] · [ ][ ] · [ ][ ] · [ ][ ] * [ ] * 
 *  *  * [ ] ·  · [ ] ·  · [ ] ·  * [ ] * 
[ ][ ] * [ ] ·  *  *  *  * [ ] ·  * [ ] * 
 · [ ] * [ ][ ] * [ ][ ] * [ ][ ] * [ ] * 
 ·  ·  * [ ] ·  * [ ] ·  *  ·  ·  * [ ] * 
[ ][ ] * [ ] *  * [ ][ ] * [ ] *  * [ ] * 
 ·  ·  *  *  * [ ] ·  ·  *  *  * [ ] ·  * 
==========================================
```

## Algoritmo

El algoritmo del laberinto, basado en la recursividad, simula la búsqueda de un camino desde un punto de inicio hasta un punto de salida en un laberinto estructurado como una cuadrícula. Aquí te explico cómo funciona el algoritmo de una manera sencilla y comprensible:

### Concepto Básico

El objetivo es encontrar un camino desde la esquina superior izquierda del laberinto hasta la esquina inferior derecha.

### Pasos del Algoritmo

1. **Inicio**:
   - Empieza en la esquina superior izquierda del laberinto.

2. **Verificación de condiciones**:
   - **Fuera de límites**: Si la posición actual está fuera del rango del laberinto, termina esa ruta (retorna `false`).
   - **Pared o bloqueo**: Si la posición actual es una pared, también termina esa ruta.
   - **Meta alcanzada**: Si la posición actual es la esquina inferior derecha del laberinto, se ha encontrado un camino exitoso.

3. **Marcar el camino**:
   - Marca la posición actual como parte del camino para evitar que el algoritmo vuelva a pasar por aquí y cause un ciclo infinito.

4. **Exploración recursiva**:
   - Intenta moverse en cuatro direcciones: hacia abajo, hacia la derecha, hacia arriba y hacia la izquierda (orden típico para explorar "primero hacia adelante y luego girar si es necesario").
   - Hace una llamada recursiva para cada dirección desde la posición actual.

5. **Backtracking**:
   - Si una dirección no lleva a la solución (es decir, todas las llamadas recursivas desde esa dirección retornan `false`), desmarca la posición actual del camino (marca como `VISITED`) y prueba otra dirección.
   - Este "volver atrás" permite al algoritmo explorar nuevas posibilidades tras haber encontrado un callejón sin salida.

6. **Finalización**:
   - Si se encuentra un camino a través de alguna de las direcciones, propaga un `true` hacia arriba (a las llamadas anteriores) indicando que se ha encontrado un camino viable.
   - Si ninguna dirección funciona, retorna `false` a la llamada anterior, indicando que no hay camino por esa ruta.

### Ejemplo Ilustrativo

Supongamos un laberinto simple:

```
0 1 0
0 1 0
0 0 0
```
- `0` representa un camino libre.
- `1` representa una pared.

Iniciando desde la esquina superior izquierda (0,0), el algoritmo intentará primero moverse hacia abajo a (1,0), luego seguirá hacia abajo a (2,0), y finalmente hacia la derecha a (2,1) y otra vez a la derecha a (2,2), encontrando así un camino al destino.

### Simplificación

Este algoritmo es una representación práctica del método de "divide y vencerás" mediante recursividad, dividiendo el problema global del laberinto en subproblemas más pequeños (¿puedo avanzar hacia adelante, abajo, arriba, o derecha desde aquí?). Utiliza el backtracking para deshacer movimientos incorrectos y reintentar otras opciones, una estrategia común en la resolución de puzzles y problemas de búsqueda en espacio de estados.