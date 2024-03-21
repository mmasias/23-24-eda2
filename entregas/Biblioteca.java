import java.util.*;

public class Biblioteca {

        private ObraNode first;
    
        public Biblioteca() {
            first = null;
        }
    
        public void addObra(Obra obra) {
            ObraNode newObraNode = new ObraNode(obra);
            if (first == null) {
                first = newObraNode;
            } else {
                ObraNode current = first;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(newObraNode);
            }
        }

        public void printObraListing() {
            System.out.println(this.toString());
        }

        public String toString() {
            String obraListing = "";
            ObraNode current = first;
            while (current != null) {
                obraListing = obraListing + current.getObra().toString() + "\n";
                current = current.getNext();
            }
            return obraListing;
        }

        public static void main(String[] args) {

            Biblioteca biblioteca = new Biblioteca();
        
            // Lista de autores para cada obra
            List<String> autores1 = Arrays.asList("Anonimo");
            List<String> autores2 = Arrays.asList("Cervantes");
            List<String> autores3 = Arrays.asList("Jane Austen");
            List<String> autores4 = Arrays.asList("Mary Shelley");
            List<String> autores5 = Arrays.asList("Alexandre Dumas");
            List<String> autores6 = Arrays.asList("Emily Brontë");
        
            // Lista de temas para cada obra
            List<String> temas1 = Arrays.asList("Oriente Medio", "Simbad", "Novela literaria");
            List<String> temas2 = Arrays.asList("Caballería", "Sancho", "Novela literaria");
            List<String> temas3 = Arrays.asList("Clásico", "Orgullo", "Comedia romántica");
            List<String> temas4 = Arrays.asList("Fantástica", "Frankenstein", "Novela gótica");
            List<String> temas5 = Arrays.asList("Aventuras", "Honor y lealtad", "Novela literaria");
            List<String> temas6 = Arrays.asList("Profunda", "Metafísica", "Novela literaria");
        
            Obra obra1 = new Obra("Las mil y una noches", autores1, 1784, temas1, Arrays.asList("Palabra1", "Palabra2", "Palabra3"), "Novela literaria");
            Obra obra2 = new Obra("Don Quijote de la Mancha", autores2, 1605, temas2, Arrays.asList("Palabra4", "Palabra5", "Palabra6"), "Novela literaria");
            Obra obra3 = new Obra("Orgullo y prejuicio", autores3, 1813, temas3, Arrays.asList("Palabra7", "Palabra8", "Palabra9"), "Comedia romántica");
            Obra obra4 = new Obra("Frankenstein o el moderno Prometeo", autores4, 1818, temas4, Arrays.asList("Palabra10", "Palabra11", "Palabra12"), "Novela gótica");
            Obra obra5 = new Obra("Los tres mosqueteros", autores5, 1844, temas5, Arrays.asList("Palabra13", "Palabra14", "Palabra15"), "Novela literaria");
            Obra obra6 = new Obra("Cumbres borrascosas", autores6, 1847, temas6, Arrays.asList("Palabra16", "Palabra17", "Palabra18"), "Novela literaria");
        
            biblioteca.addObra(obra1);
            biblioteca.addObra(obra2);
            biblioteca.addObra(obra3);
            biblioteca.addObra(obra4);
            biblioteca.addObra(obra5);
            biblioteca.addObra(obra6);
        
            System.out.println("Obras en la biblioteca:");
            biblioteca.printObraListing();
        }
        
    }
    