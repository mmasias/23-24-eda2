# Big O

## ¿Por qué?

A medida que desarrollamos (o elegimos) algoritmos para proyectos maś complejos, es crucial poder prever cómo el rendimiento de un programa puede cambiar con el tamaño de los datos procesados. Necesitamos una forma de entender y comunicar el impacto que tendrá uno u otro algoritmo en términos de tiempo de ejecución y uso de memoria, especialmente en casos extremos o a gran escala.

## ¿Qué?

La notación Big O es una herramienta matemática utilizada en ciencias de la computación para describir la complejidad de un algoritmo, expresando cómo el tiempo de ejecución o el espacio de memoria requerido por un algoritmo crece en relación con el tamaño de la entrada.

Se enfoca en el crecimiento a largo plazo, permitiendo comparar la eficiencia de diferentes algoritmos de una manera que es independiente de las variaciones de hardware o implementación específica.

## ¿Para qué?

|Eficiencia|Rendimiento|Escalabilidad|
|-|-|-|
Facilita la comparación entre algoritmos para elegir el más adecuado basado en su comportamiento esperado con grandes volúmenes de datos.|Identifica cuellos de botella y guía el proceso de optimización al mostrar dónde se ganará más reduciendo la complejidad.|Ayuda a entender cómo un algoritmo manejará un aumento en el tamaño de los datos, lo cual es vital para sistemas que deben ser capaces de escalar.

## ¿Cómo?

Para aplicar la notación Big O en la práctica, se sigue un proceso de identificación del peor escenario posible, simplificación de la fórmula de complejidad para resaltar el [término dominante](terminoDominante.md), y clasificación del algoritmo en una categoría de complejidad. 

Este análisis permite a los desarrolladores entender y predecir el rendimiento de los algoritmos en diferentes condiciones, facilitando decisiones informadas sobre diseño e implementación.

- **Evaluar el peor caso**: Analiza el escenario más desfavorable en términos de tiempo o espacio.
- **Simplificar la expresión**: Reduce la fórmula de complejidad al término que más crece con el tamaño de la entrada, ignorando constantes y términos menores.
- **Clasificar la complejidad**: Usa la notación para categorizar la complejidad del algoritmo, como O(1), O(n *log n*), O(n²), etc., basándose en la expresión simplificada.

Big O|Nombre|Descripción|Ejemplo
-|-|-|-
**O(1)** | constante | **El mejor.** El algoritmo siempre toma la misma cantidad de tiempo, independientemente de la cantidad de datos. |Buscar un elemento de un array por su índice.
**O(log n)** | logarítmico | **Muy bueno.** Este tipo de algoritmos reduce a la mitad la cantidad de datos en cada iteración. Si tienes 100 elementos, toma alrededor de 7 pasos encontrar la respuesta. Con 1,000 elementos, toma 10 pasos. Y 1,000,000 de elementos solo toman 20 pasos. Esto es súper rápido incluso para grandes cantidades de datos.|Búsqueda binaria.
**O(n)** | lineal | **Bueno.** Si tienes 100 elementos, esto hace 100 unidades de trabajo. Doblar la cantidad de elementos hace que el algoritmo tome exactamente el doble de tiempo (200 unidades de trabajo).|Búsqueda secuencial.
**O(n log n)** | "linealítmico" | **Decente.** Esto es ligeramente peor que lineal pero no demasiado malo.|Los algoritmos de ordenación de propósito general más rápidos.
**O(n²)** | cuadrático | **Un poco lento.** Si tienes 100 elementos, esto hace 100^2 = 10,000 unidades de trabajo. Doblar la cantidad de elementos lo hace cuatro veces más lento (porque 2 al cuadrado es igual a 4).|Algoritmos que usan bucles anidados, como el ordenamiento por inserción.
**O(n³)** | cúbico | **Rendimiento pobre.** Si tienes 100 elementos, esto hace 100^3 = 1,000,000 unidades de trabajo. Doblar el tamaño de entrada lo hace ocho veces más lento.|Multiplicación de matrices.
**O(2^n)** | exponencial | **Rendimiento muy pobre.** Quieres evitar este tipo de algoritmos, pero a veces no tienes opción. Agregar solo un bit a la entrada duplica el tiempo de ejecución.|Problema del vendedor viajero.
**O(n!)** | factorial | **Intolerablemente lento.** Literalmente toma millones de años hacer cualquier cosa.

### Simplificación (be careful)

<div align=center>

|1 bucle|2 bucles|3 bucles|...|m bucles
|:-:|:-:|:-:|:-:|:-:|
O(*n*)|O(*n²*)|O(*n³*)|...|O(*n^m*)

</div>

