public class OffByN implements CharacterComparator {
	public int N;
	
	public OffByN(int n) {
		N = n;
	}
	
	@Override
	public boolean equalChars(char x, char y) {
		int diff = x - y;
		if (diff == N || diff == -N) {
			return true;
		} else {
			return false;
		}
	}
}
