import java.util.Scanner;

public class Ejercicio2 {

    //Similar al anterior, ahora trabajando un array de caracteres y una palabra clave (de tres letras, por simplificar), devolver los índices de los elementos que conforman la palabra clave
    //O(n^3) porque hay tres bucles anidados

    public void initEx2() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of characters you want to input: ");
        int n = s.nextInt();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the character " + (i + 1) + ": ");
            chars[i] = s.next().charAt(0);
        }
        System.out.println("Enter the keyword: ");
        String keyword = s.next();
        int[] result = sumResultEx2(chars, keyword);
        System.out.println("The index of the characters that form the keyword are: " + result[0] + ", " + result[1] + " and " + result[2]);
        s.close();
    }

    public static int[] sumResultEx2(char[] chars, String keyword) {
        int[] result = new int[3];
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == keyword.charAt(0)) {
                result[0] = i;
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == keyword.charAt(1)) {
                        result[1] = j;
                        for (int k = j + 1; k < chars.length; k++) {
                            if (chars[k] == keyword.charAt(2)) {
                                result[2] = k;
                                return result;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

   

    
    
}
