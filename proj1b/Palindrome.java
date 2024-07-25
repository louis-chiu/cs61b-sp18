public class Palindrome<T> {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = this.wordToDeque(word);
        Deque<Character> resultDeque = removeEqualsFrontAndBackChar(deque);
        return resultDeque != null && resultDeque.size() < 2;
    }

    public boolean isPalindrome(String word, CharacterComparator comparator) {
        int i = 0;
        int j = word.length() - 1;
        boolean isPalindrome = true;
        while (i < j && isPalindrome) {
            isPalindrome = comparator.equalChars(word.charAt(i), word.charAt(j));
            i += 1;
            j -= 1;
        }
        return isPalindrome;
    }

    private Deque<Character> removeEqualsFrontAndBackChar(Deque<Character> deque) {
        if (deque.size() < 2) {
            return deque;
        } else if (deque.removeFirst() == deque.removeLast()) {
            return removeEqualsFrontAndBackChar(deque);
        }
        return null;
    }

}

