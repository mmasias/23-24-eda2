# Gestión de biblioteca digital

## Contexto

||||
|-|-|-|
|Una biblioteca digital necesita un sistema para gestionar su colección de documentos.|Los documentos pueden ser libros, revistas, artículos o papers científicos.|Cada documento se caracteriza por su título, autores, año de publicación, tipo de documento (libro, revista, artículo, paper) y  palabras clave.|

## Proceso

|Proceso|Descripción|
|-|-|
Gestión de documentos|Los usuarios pueden agregar, editar, modificar y eliminar documentos en la biblioteca, especificando los detalles requeridos.
Búsqueda|Los usuarios pueden buscar documentos por título, autor, año de publicación, tipo de documento, o temas/palabras clave.
Clasificación|Los documentos deben ser clasificados en categorías basadas en su tipo y temas o palabras clave.

## Detalles específicos

- **Autores**: Un documento puede tener múltiples autores.
- **Temas/Palabras clave**: Un documento puede estar asociado a varios temas o palabras clave.

### Consideraciones

- La colección de documentos es dinámica; se agregan, eliminan o actualizan documentos regularmente.
- Se debe poder acceder rápidamente a la información de los documentos para realizar búsquedas eficientes.
- La interfaz de usuario será en modo texto, permitiendo a los usuarios realizar operaciones como agregar, buscar y listar documentos.

## Reto

Desarrollar un sistema en Java que permita organizar y gestionar la colección de documentos de esta biblioteca digital.

Este sistema debe permitir el ingreso de nuevos documentos, la búsqueda de documentos existentes y la clasificación automática de documentos según su tipo y temas/palabras clave.

## Estructura de datos propuesta

- **Documentos**: Utilizar clases para representar diferentes tipos de documentos con herencia para compartir características comunes y permitir especificidades.
- **Colección de documentos**: Utilizar listas para almacenar documentos y permitir búsquedas.
- **Búsqueda y clasificación**: Implementar una búsqueda secuencial para organizar y acceder a los documentos según diferentes criterios.
