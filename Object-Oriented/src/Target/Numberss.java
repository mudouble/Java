package Target;

public class Numberss {
    private int value;
    private int start;
    private int end;

    public Numberss() {
    }

    public Numberss(int value, int start, int end) {
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
