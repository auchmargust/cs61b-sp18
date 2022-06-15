public class OffByN implements CharacterComparator {
	private int N;
	
	public OffByN(int n) {
		N = n;
	}
	
	@Override
	public boolean equalChars(char x, char y) {
		x = Character.toLowerCase(x);
		y = Character.toLowerCase(y);
		if (((int) x >= 97) && ((int) x <= 122)
				&&
				((int) y >= 97) && ((int) y <= 122)) {
			int diff = x - y;
			if (diff == N || diff == -N) {
				return true;
			}
		}
		return false;
	}
}
