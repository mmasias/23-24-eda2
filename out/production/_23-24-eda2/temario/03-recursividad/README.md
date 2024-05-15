# Recursividad

## ¿Por qué?

La recursividad (en desarrollo) surgió como una solución natural a problemas matemáticos que son, por su propia naturaleza, recursivos. Estos problemas a menudo implican tareas que se repiten con un conjunto de reglas consistentes que pueden aplicarse a sus resultados.

## ¿Qué?

Una función se llama a sí misma (directamente o indirectamente) para resolver un problema.

Este enfoque divide el problema principal en subproblemas más pequeños y manejables, cada uno de los cuales es una instancia más simple del problema principal.

La recursividad es fundamentalmente un enfoque de *divide y vencerás*.

## ¿Para qué?

La recursividad se introdujo y se ha utilizado en programación por varias razones clave:

|||
|-|-|
Naturalidad en problemas recurrentes|Algunos problemas, como el cálculo factorial, la generación de series Fibonacci, o la exploración de estructuras de datos no lineales (como árboles y grafos), presentan una naturaleza inherentemente recursiva. La recursividad proporciona una manera directa de modelar estos problemas conforme a su estructura natural.
Simplicidad de implementación|A menudo, un enfoque recursivo puede resultar más limpio y más fácil de implementar que un enfoque iterativo, especialmente cuando el problema se alinea bien con estrategias recursivas.
Reducción de complejidad|La recursividad ayuda a reducir la complejidad del código al dividir un problema grande y complejo en subproblemas más simples y manejables, cada uno de los cuales puede ser resuelto de manera independiente.

## ¿Cómo?

Codificando algunos algoritmos recursivos muy simples

- Imprimir los números del 1 a x, sin usar bucles.
- Imprimir los números de x a y en orden descendente, sin usar bucles.
- Sumar los números de x a y, sin usar bucles.

Entendiendo (al detalle) algunos problemas clásicos:

- Búsqueda binaria - [Código](/src/casosDeUso/recursion/BinarySearchExampleMuted.java) - [Código](/src/casosDeUso/recursion/BinarySearchExample.java)
- [Torres de hanoi](https://es.wikipedia.org/wiki/Torres_de_Han%C3%B3i) - [Código](/src/casosDeUso/recursion/HanoiMuted.java) - [Código verbose](/src/casosDeUso/recursion/Hanoi.java)
- [*n* Reinas](https://es.wikipedia.org/wiki/Problema_de_las_ocho_reinas) - [Código](/src/casosDeUso/recursion/QueensMuted.java) - [Código verbose](/src/casosDeUso/recursion/Queens.java)
