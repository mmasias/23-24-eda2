package entregas.lopesBrenda.Reto003;

public class Documento {
        private String titulo;
        private String categoria;
        private String autor;
        private int año;

        
    
        public Documento(String titulo, String categoria, String autor, int año) {
            this.titulo = titulo;
            this.categoria = categoria;
            this.autor = autor;
            this.año = año;

        }
    
        public String getName() {
            return titulo;
        }

        public void setName(String titulo) {
            this.titulo = titulo;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setAño(int año) {
            this.año = año;
        }
    
        @Override
        public String toString() {
            return "Documento {" +
                   "Titulo = '" + titulo + '\'' +
                   ", Categoria = '" + categoria + '\'' +
                   ", Autor = " + autor +
                   ", Año de publicación = " + año +
                   '}';
        }
}
