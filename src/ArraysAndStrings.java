import java.util.HashMap;
import java.util.HashSet;

public class ArraysAndStrings {
    public static void main(String[] args) {
//        Unique
//        String unique = "abcdefghijklmnopqrstuvwxyz";
//        boolean oneOfAKind = isUnique(unique);
//        System.out.println(unique + " is unique: " + oneOfAKind);
//        Permutations
//        String s1 = "abcdefgh";
//        String s2 = "hgfdecab";
//        String s3 = "a";
//        String s4 = "aabcde";
//        String s5 = "aaaaaaa";
//        boolean isPerm = checkPermutation(s1, s3);
//        System.out.printf("%s is a permutation of %s: %b\n", s1, s3, isPerm);
//        URLify
//        String phrase = "Mr John Smith    ";
//        int end = 13;
//        String newPhrase = URLlify(phrase, end);
//        System.out.println(newPhrase);
//        Palindrome Permutation
//        String phrase = "Tac Coa";
//        boolean isPal = palinPerm(phrase);
//        System.out.printf("%s is a palindrome permutation: %b\n", phrase, isPal);
//        One Away
//        String s1 = "pale";
//        String s2 = "bake";
//        boolean oneEdit = oneAway(s1,s2);
//        System.out.println(oneEdit);


    }

    private static boolean oneAway(String s1, String s2) {
        //if the hashset gets larger than 1, that means it's done
        //You should find the size AFTER adjustments have been made
        int x = 0;
        int y = 0;
        HashSet<Character> hs = new HashSet<>();

        while(x < s1.length() || y < s2.length()) {
            if( x < s1.length()) {
                if (!hs.contains(s1.charAt(x))) {
                    hs.add(s1.charAt(x));
                } else {
                    hs.remove(s1.charAt(x));
                }
                x++;
            }
            if(y < s2.length()) {
                if(!hs.contains(s2.charAt(y))) {
                    hs.add(s2.charAt((y)));
                } else {
                    hs.remove((s2.charAt(y)));
                }
                y++;
            }
        }
        if(hs.size() <= 2) {
            return true;
        }

        return false;
    }

    private static boolean palinPerm(String phrase) {
        int[] arr = new int[26];
        char letter;
        //subtract 97 to get indices
        //toLowerCase
        for(int i = 0 ; i < phrase.length();i++) {
            letter = phrase.charAt(i);
            if(((int)letter > 64 && (int)letter < 91) || ((int)letter >96 && (int)letter < 123) ) {
                arr[(int) (Character.toLowerCase(letter)) - 97]++;
            }
        }
        //check for only 1 odd;
        int odds = 0;

        for(int i: arr) {
            if(odds > 1) {
                return false;
            }
            if(i % 2 != 0) {
                odds++;
            }
        }
        return true;
    }

    private static String URLlify(String phrase, int end) {
        char[] phraseArr = phrase.toCharArray();
        int i = phraseArr.length-1;
        end--;
        //start subtracting end and putting them into the char array, when end hits a space, att %20
        while(i >= 0 && end >= 0) {
            if(phraseArr[end] == ' ') {
                phraseArr[i] = '0';
                phraseArr[i-1] = '2';
                phraseArr[i-2] = '%';
                i = i-3;
                end--;
            }
            else {
                phraseArr[i] = phraseArr[end];
                end--;
                i--;
            }
        }
        String ans = new String(phraseArr);
        return ans;
    }

    private static boolean checkPermutation(String s1, String s2) {
        HashMap<Character, Integer> hs = new HashMap<>();
        for(char c : s1.toCharArray()) {
            if(!hs.containsKey(c)) {
                hs.put(c, 1);
            }
            else {
                hs.put(c, (hs.get(c)+1));
            }
        }
        for(char d : s2.toCharArray()) {
            if(!hs.containsKey(d)) {
                return false;
            }
            else {
                hs.put(d, hs.get(d)-1);
                System.out.println(hs.get(d));
                if(hs.get(d) == 0) {
                    hs.remove(d);
                }
            }
        }

        System.out.println("Size of hash map: " + hs.size());

        if(hs.size() ==0)
        return true;
        else return false;
    }

    private static boolean isUnique(String unique) {
        HashSet<Character> hs = new HashSet<>();
        for (char c: unique.toCharArray()) {
            if(!hs.add(c)) {
                return false;
            }
        }
        return true;
    }
}
