public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int num) {
        N = num;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return ((diff == N) || (diff == -N));
    }
}
