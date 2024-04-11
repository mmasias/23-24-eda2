# Ejercicio 1

Dado un conjunto de números enteros y un entero objetivo, devuelva los índices de dos números que sumados den el objetivo.

> Por ejemplo, dados los números [3, 2, 9, 8] y el objetivo 10, la respuesta sería 1 y 3

## Cálculo de Big-O
* **O(1) - Constante :** 
  * No hay operaciones en este código que tengan una complejidad constante.
* **O(log n) - Logarítmico :** 
  * No hay operaciones en este código que tengan una complejidad logarítmica.
* **O(n) - Lineal :**
  * El método twoSum utiliza dos bucles anidados para recorrer el array nums.
  * En el peor de los casos, ambos bucles se ejecutarán n veces, donde n es la longitud del array nums.
  * La complejidad de tiempo de este método es O(n^2), ya que hay dos bucles anidados.
* **O(n log n) - Linealítmico :**
  * No hay operaciones en este código que tengan una complejidad linealítmica.
* **O(n^2) - Cuadrático :**
  * El método twoSum se ajusta a esta complejidad, ya que utiliza dos bucles anidados.
* **O(n^3) - Cúbico :**
  * No hay operaciones en este código que tengan una complejidad cúbica.
* **O(2^n) - Exponencial :**
  * No hay operaciones en este código que tengan una complejidad exponencial.
* **O(n!) - Factorial :**
  * No hay operaciones en este código que tengan una complejidad factorial.




# Ejercicio 2

Similar al anterior, ahora trabajando un array de caracteres y una palabra clave (de tres letras, por simplificar), devolver los índices de los elementos que conforman la palabra clave

> Por ejemplo, dado el array ['a', 'c', 'd', 'i', 'm', 'r', 't', 'u'] y el objetivo "dia", la respuesta sería 2, 3 y 0

## Cálculo de Big-O
* **O(1) - Constante :**
  * No hay operaciones en este código que tengan una complejidad constante.
* **O(log n) - Logarítmico :**
  * No hay operaciones en este código que tengan una complejidad logarítmica.
* **O(n) - Lineal :**
  * El método findIndices realiza una búsqueda lineal en el array de caracteres chars para encontrar los índices de los caracteres de la palabra clave.
  * En el peor de los casos, este método iterará sobre cada carácter de la palabra clave (m iteraciones), y dentro de cada iteración, realizará una búsqueda lineal en el array chars (n iteraciones), donde m es la longitud de la palabra clave y n es la longitud del array chars.
  * Por lo tanto, la complejidad de tiempo de este método es O(m * n), donde m es la longitud de la palabra clave y n es la longitud del array chars.
  * Esto significa que el tiempo de ejecución aumenta de manera proporcional al producto de la longitud de la palabra clave y la longitud del array chars.
* **O(n log n) - Linealítmico :**
  * No hay operaciones en este código que tengan una complejidad linealítmica.
* **O(n^2) - Cuadrático :**
  * No hay operaciones en este código que tengan una complejidad cuadrática.
* **O(n^3) - Cúbico :**
  * No hay operaciones en este código que tengan una complejidad cúbica.
* **O(2^n) - Exponencial :**
  * No hay operaciones en este código que tengan una complejidad exponencial.
* **O(n!) - Factorial :**
  * No hay operaciones en este código que tengan una complejidad factorial.
