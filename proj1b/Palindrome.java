public class Palindrome {
	public Deque<Character> wordToDeque(String word) {
		if (word == null) {
			return null;
		}
		LinkedListDeque<Character> result = new LinkedListDeque<>();
		int lenth = word.length();
		for (int i = 0; i < lenth; i += 1) {
			char toAdd = word.charAt(i);
			result.addLast(toAdd);
		}
		return result;
	}
	
	public boolean isPalindrome(String word) {
		if (word.length() == 1 || word.length() == 0) {
			return true;
		}
		return isPalindromeHelper(wordToDeque(word));
	}
	
	public boolean isPalindromeHelper(Deque<Character> d) {
		if (d.size() <= 1) {
			return true;
		} else {
			return (Character.toLowerCase(d.removeFirst()) == Character.toLowerCase(d.removeLast()))
					&& isPalindromeHelper(d);
		}
	}
	
	public boolean isPalindrome(String word, CharacterComparator cc) {
		if (word.length() == 1 || word.length() == 0) {
			return true;
		}
		return isPalindromeHelper(wordToDeque(word), cc);
	}
	
	public boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc) {
		if (d.size() <= 1) {
			return true;
		} else {
			return cc.equalChars(Character.toLowerCase(d.removeFirst()), Character.toLowerCase(d.removeLast()))
					&& isPalindromeHelper(d, cc);
		}
	}
	
	
}
