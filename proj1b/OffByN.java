public class OffByN implements CharacterComparator {
    int n;
    public OffByN(int n) {
        this.n = n >= 0 ? n : -n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x - y <= n && x - y >= -n;
    }
}
