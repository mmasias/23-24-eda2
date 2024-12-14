@startuml



Biblioteca -- Documento
Documento -- Autor
Documento -- Titulo
Documento -- Keywords

Class Biblioteca {
List<Documento> documento
}

Class Documento {
int id
Titulo titulo
String tipo
Autor[] autor
String[] keywords
String año de publicacion
}

Class Titulo {
int id
string name
}

Class Autor {
int id
String name
}

Class Keywords {
int id
String keyword
}
@enduml