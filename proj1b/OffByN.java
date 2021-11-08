public class OffByN implements CharacterComparator {

    private int Error;

    public OffByN(int N) {
        this.Error = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == Error;
    }
}
