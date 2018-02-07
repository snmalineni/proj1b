/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        // In in = new In("../../library-sp18/data/words.txt");

        for (int N = 0; N < 26; N++) {
            In in = new In("../../library-sp18/data/words.txt");
            Palindrome palindrome = new Palindrome();
            CharacterComparator cc = new OffByN(N);
            int numOfPalindromeForN = 0;
            int longestPalindromeForN = 0;
            while (!in.isEmpty()) {
                String word = in.readString();
                if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                    System.out.println(word);
                    numOfPalindromeForN++;
                    if (word.length() > longestPalindromeForN) {
                        longestPalindromeForN = word.length();
                    }
                }
            }
            System.out.println("numOfPalindromeOffBy " + N + ": " + numOfPalindromeForN + ", longestPalindrome: " + longestPalindromeForN);
        }
    }
}
