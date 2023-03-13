package inter.practice;

public class InterfaceTest {


    public static void main(String[] args) {
        ComparableCircle Circle1 = new ComparableCircle(1);
        ComparableCircle Circle2 = new ComparableCircle(2);
//        System.out.println(Circle1.compareTo(Circle2));

        ComparableRectangle rectangle1 = new ComparableRectangle(4,6);
        ComparableRectangle rectangle2 = new ComparableRectangle(3,8);
        System.out.println(rectangle1.compareTo(Circle1));
    }



}
