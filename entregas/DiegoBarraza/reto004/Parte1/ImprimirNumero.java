public class ImprimirNumero{
    public static void main (String[]args){
        int x=10;
        contarnumeros(x);
    }
    public static void contarnumeros(int n){
        if(n>0){
            contarnumeros(n-1);
            System.out.print("Llamada recursiva para restarle un 1 al numero "+ n + "\n");
            System.out.print("El valor actual de n es "+ n + "\n");
        }
        if(n==0){
            System.out.print("Una vez llegado al numero 0, dejo de restar y se acaba "+"\n");
        }
    }
   
}