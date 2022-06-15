public class OffByOne implements CharacterComparator {
	@Override
	public boolean equalChars(char x, char y) {
		int diff = Character.toLowerCase(x) - Character.toLowerCase(y);
		if (diff == 1 || diff == -1) {
			return true;
		} else {
			return false;
		}
	}
}
