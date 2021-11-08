public class OffByN implements CharacterComparator {

    private int Error;

    OffByN(int N) {

        this.Error = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == Error;
    }
}
