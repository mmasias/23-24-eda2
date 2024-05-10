package parte1;

public class Main {
  public static void main(String[] args) {
    Main main = new Main();
    main.printNumber(5);
    System.out.println("-----------------------------");
    main.printDescendent(5);
    System.out.println("-----------------------------");
    System.out.println(main.numberTotal(5));

  }

  public void printNumber(int i) {
    System.out.println("Entrando a la funcion con valor: " + i);
    if (i == 0) {
      System.out.println("El valor de i es: " + i + " no se entra de nuevo en la funcion");
      return;
    }
    System.out.println("Se resta 1 a " + i + " y se vuelve a llamar la funcion");
    printNumber(i - 1);
    System.out.println("Regresando... se imprimira el valor: " + i);
    System.out.println(i);
  }

  public void printDescendent(int i) {
    System.out.println("Entrando a la funcion con valor: " + i);
    if (i == 0) {
      System.out.println("El valor de i es: 0 y no se entra de nuevo en la funcion ni se imprime el valor");
      return;
    }
    System.out.println("Se va a imprimir el valor: " + i);
    System.out.println(i);
    printDescendent(i - 1);
  }

  public int numberTotal(int i) {
    if (i == 0) {
      System.out.println("Ya no se suma");
      return 0;
    }
    System.out.println("Se suma: " + i);

    return i + numberTotal(i - 1);
  }
}
