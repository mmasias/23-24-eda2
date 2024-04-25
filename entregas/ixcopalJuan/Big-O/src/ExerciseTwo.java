public class ExerciseTwo {

    public static void SearchWordIndex(String keyword ){
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r'};
        int[] response = findIndices(chars, keyword);
        System.out.print("Los índices de los caracteres que forman la palabra " + keyword + " son: ");
        for (int index : response) {
            System.out.print(index + ", ");
        }
    }

    public static int[] findIndices(char[] chars, String keyword){
        keyword = keyword.toLowerCase();
        int[] indices = new int[keyword.length()];
        for (int i = 0; i < keyword.length(); i++) {
            char ch = keyword.charAt(i);

            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == ch) {
                    indices[i] = j;
                    break;
                }
            }
        }
        return indices;
    }
}
