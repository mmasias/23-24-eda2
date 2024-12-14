# Bucket Sort

## ¿Por qué?

El Bucket Sort es un algoritmo de ordenamiento que distribuye los elementos en varios "buckets" o contenedores y luego ordena cada bucket individualmente. Es eficiente cuando los datos se distribuyen uniformemente, ya que permite reducir la complejidad temporal en comparación con otros algoritmos de ordenación. Además, si el ordenador de buckets es estable, el Bucket Sort puede ser un algoritmo estable en sí mismo. Sin embargo, su rendimiento depende significativamente de la distribución de los datos, ya que una distribución desigual puede provocar un desequilibrio en la carga de los buckets.

## ¿Qué?

El Bucket Sort divide el rango de valores en intervalos discretos, cada uno asociado con un bucket. Luego, distribuye cada elemento del arreglo original en su bucket correspondiente. Después de la distribución, se ordena cada bucket individualmente, ya sea utilizando otro algoritmo de ordenación o recursivamente aplicando Bucket Sort si se requiere mayor precisión. Finalmente, los elementos ordenados de cada bucket se concatenan para formar el arreglo ordenado final.

## ¿Para qué?

El Bucket Sort es útil en situaciones donde se trabaja con datos distribuidos uniformemente, como la clasificación de valores en un rango predefinido. Es especialmente eficiente cuando los datos están dispersos uniformemente, ya que permite distribuir el trabajo de ordenación en varios buckets de manera paralela. Además, puede ser estable si el ordenador de buckets utilizado mantiene el orden relativo de los elementos con el mismo valor.

## ¿Cómo?

### Implementación

```python
def bucket_sort(arr):
    n = len(arr)
    buckets = [[] for _ in range(n)]

    # Distribución de elementos en los buckets
    for num in arr:
        index = int(num * n)
        buckets[index].append(num)

    # Ordenación de cada bucket individualmente
    for bucket in buckets:
        bucket.sort()

    # Concatenación de los buckets ordenados
    sorted_arr = []
    for bucket in buckets:
        sorted_arr.extend(bucket)

    return sorted_arr

# Ejemplo de uso
arr = [0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51]
sorted_arr = bucket_sort(arr)
print("Arreglo ordenado:", sorted_arr)

```


### Traza

**Arreglo de entrada inicial:** [170, 45, 75, 90, 802, 24, 2, 66]

#### Pasos de la Ordenación

1. **Distribución en Buckets:**
   - Creación de buckets basados en la distribución del rango de valores.
     - Asignación de elementos del arreglo original a los buckets correspondientes según sus valores.
   
   Arreglo de buckets:
   - Bucket 0.2: [2, 24]
   - Bucket 0.4: [45]
   - Bucket 0.5: [66, 75]
   - Bucket 0.8: [170]
   - Bucket 8.0: [802]
   
2. **Ordenación de cada Bucket:**
   - Aplicación de un algoritmo de ordenación estable (por ejemplo, Insertion Sort) para ordenar cada bucket individualmente.
   
   Arreglo de buckets ordenados:
   - Bucket 0.2: [2, 24]
   - Bucket 0.4: [45]
   - Bucket 0.5: [66, 75]
   - Bucket 0.8: [170]
   - Bucket 8.0: [802]
   
3. **Concatenación de los Buckets Ordenados:**
   - Concatenación de los buckets ordenados para formar el arreglo final ordenado.
   
   Arreglo ordenado final: [2, 24, 45, 66, 75, 170, 802]

El arreglo está ahora completamente ordenado.
