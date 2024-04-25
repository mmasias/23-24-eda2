import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Big0 {
    public static void main(String[] args){
        int[] datosNum = {3, 2, 9, 8};
        int objetivoNum = 10;
        int[] resultadoNum = busquedaNum(datosNum,objetivoNum);
        if(resultadoNum !=null) {
            System.out.println("Los indices de los numeros que suman " + objetivoNum + "son: " + resultadoNum[0] + " y "+resultadoNum[1]);
        } else{
            System.out.println("No se encontraron numeros que cumplan la condicion");
        }


        char[] datosChar = {'a','c','d','i','m','r','t','u'};
        String objetivoString = "dia";
        List<Integer> indices = busquedaChar(datosChar, objetivoString);
        if(!indices.isEmpty()){
            System.out.println("Los indices de los caracteres que forman parte de la palabra " + objetivoString + " son: " +indices);
        } else {
            System.out.println("No se encontraron caracteres que formen parte de la palabra");
        }
    }

    public static int[] busquedaNum(int[] nums, int objetivo){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i],i);
            int llave = objetivo - nums[i];
            if(map.containsKey(llave)){
                return new int[]{ map.get(llave), i};
            }
        }
        return null;
    }

    public static List<Integer> busquedaChar(char[] chars, String objetivo){
        List<Integer> indices = new ArrayList<>();
        for (char letra : objetivo.toCharArray()){
            for(int i = 0; i<chars.length; i++){
                if (chars[i]==letra){
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }
}
