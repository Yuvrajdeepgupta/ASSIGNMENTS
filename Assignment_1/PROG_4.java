import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        String characters = "carbon";
        List<String> permutations = generatePermutations(characters);
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> generatePermutations(String characters) {
        List<String> permutations = new ArrayList<>();
        if (characters.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char initial = characters.charAt(0);
        String remaining = characters.substring(1);
        List<String> words = generatePermutations(remaining);
        for (String word : words) {
            for (int i = 0; i <= word.length(); i++) {
                String permutation = insertCharAt(word, initial, i);
                permutations.add(permutation);
            }
        }
        return permutations;
    }

    public static String insertCharAt(String word, char c, int position) {
        String start = word.substring(0, position);
        String end = word.substring(position);
        return start + c + end;
    }
}
