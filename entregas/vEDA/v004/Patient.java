package vEDA.v004;

import java.util.Scanner;

public class Patient {
    
    private String name;
    private DietNode firstDiet;

    public Patient(String name) {
        this.name = name;
        this.firstDiet = null;
        this.manage();
    }

    private void addDiet(Diet diet) {
        DietNode newDietNode = new DietNode(diet);
        if (firstDiet == null) {
            firstDiet = newDietNode;
        } else {
            DietNode current = firstDiet;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newDietNode);
        }
    }

    private void createDiet() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Creando dieta para el paciente " + name);
            System.out.println("Número de dieta (-1 para terminar):");
            int dietNumber = userInput.nextInt();
            if (dietNumber == -1) {
                creating = !creating;
            } else {
                Diet diet = new Diet(dietNumber);
                diet.manage();
                addDiet(diet);
            }
        }
    }

    private void editDiet() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Número de dieta a editar (-1 para terminar):");
            int dietNumber = userInput.nextInt();
            if (dietNumber == -1) {
                editing = !editing;
            } else {
                editDiet(dietNumber);
            }
        }
    }

    private void editDiet(int dietNumber){
        DietNode current = firstDiet;
        while (current != null) {
            if (current.getDiet().getDietNumber() == dietNumber) {
                current.getDiet().manage();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Dieta no encontrada");
    }

    private void deleteDiet() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Número de dieta a eliminar (-1 para terminar):");
            int dietNumber = userInput.nextInt();
            if (dietNumber == -1) {
                deleting = !deleting;
            } else {
                removeDiet(dietNumber);
            }
        }        
    }

    private void removeDiet(int dietNumber){
        if (firstDiet.getDiet().getDietNumber() == dietNumber) {
            firstDiet = firstDiet.getNext();
            return;
        } else {
            DietNode current = firstDiet;
            while (current.getNext() != null && current.getNext().getDiet().getDietNumber() != dietNumber) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    private void renamePatient() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nuevo nombre del paciente " + name);
        String newName = userInput.nextLine();
        this.name = newName;
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        while (managing) {
            System.out.println("Gestionando paciente " + name);
            System.out.println("[C]reate / [R]ead / Re[N]ame  / [U]pdate / [D]elete / e[X]it");
            char userOption = userInput.nextLine().toUpperCase().charAt(0);
            switch (userOption) {
                case 'C':
                    createDiet();
                    break;
                case 'R':
                    System.out.println(this.toString());
                    break;
                case 'U':
                    editDiet();
                    break;
                case 'N':
                    renamePatient();
                    break;                    
                case 'D':
                    deleteDiet();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado no es válido.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String dietListing = "";
        DietNode current = firstDiet;
        while (current != null) {
            dietListing += current.getDiet().toString() + "\n";
            current = current.getNext();
        }
        return "Paciente: " + name + "\n" + dietListing;
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient("Manuel");
        patient1.manage();
    }
}
