public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dqc = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++) {
            dqc.addLast(word.charAt(i));
        }

        return dqc;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> dqc = wordToDeque(word);

        return isPalindromeHelp(dqc);
    }

    private boolean isPalindromeHelp(Deque<Character> inQue) {
        if (inQue.size() <= 1) {
            return true;
        }

        Character front = inQue.removeFirst();
        Character tail  = inQue.removeLast();

        return (front == tail) && isPalindromeHelp(inQue);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dqc = wordToDeque(word);

        return isPalindromeHelp(dqc, cc);
    }

    private boolean isPalindromeHelp(Deque<Character> inQue, CharacterComparator cc) {
        if (inQue.size() <= 1) {
            return true;
        }

        Character front = inQue.removeFirst();
        Character tail  = inQue.removeLast();

        return (cc.equalChars(front, tail)) && isPalindromeHelp(inQue, cc);
    }
}
