public class OffByOne implements CharacterComparator {
	
	@Override
	public boolean equalChars(char x, char y) {
		//transform x & y to lower case
		x = Character.toLowerCase(x);
		y = Character.toLowerCase(y);
		if (((int) x >= 97) && ((int) x <= 122) &&
				((int) y >= 97) && ((int) y <= 122)) {
			int diff = Character.toLowerCase(x) - Character.toLowerCase(y);
			if (diff == 1 || diff == -1)
				return true;
		}
		return false;
	}
}
