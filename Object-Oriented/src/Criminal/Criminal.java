package Criminal;

//囚犯问题：生成100个囚犯的编号1-200，不重复

public class Criminal {
    private int code;
    private int location;

    public Criminal(int code, int location) {
        this.code = code;
        this.location = location;
    }

    public Criminal() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public String toString() {
        return "Criminal{" +
                "code=" + code +
                ", location=" + location +
                '}';
    }
}
