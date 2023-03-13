package inter.practice;

public class ComparableCircle extends Circle implements CompareObject {

    public ComparableCircle(int redius) {
        super(redius);
    }

    public ComparableCircle() {
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle) o;
            if (this.redius > c.getRedius()) return 1;
            else if (this.redius < c.getRedius()) {
                return -1;
            }else {
                return 0;
            }
        } else {
            throw new RuntimeException("传入的对象不匹配");
        }
    }
}
