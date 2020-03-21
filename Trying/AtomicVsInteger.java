import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVsInteger {

    Integer a = 3;
    Integer b = a;

    AtomicInteger AtomicA = new AtomicInteger(3);
    AtomicInteger AtomicB = AtomicA;

    public static void main(String[] args) {
        AtomicVsInteger instance = new AtomicVsInteger();

        System.out.println("Before Increment:");
        System.out.println("AtomicA: " + instance.AtomicA);
        System.out.println("AtomicB: " + instance.AtomicB);
        System.out.println("a: " + instance.a);
        System.out.println("b: " + instance.b);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println();
        instance.increment();
        System.out.println("After Increment:");
        System.out.println("AtomicA: " + instance.AtomicA);
        System.out.println("AtomicB: " + instance.AtomicB);
        System.out.println("a: " + instance.a);
        System.out.println("b: " + instance.b);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

    }

    void increment() {
        AtomicA.incrementAndGet();
        a++;
    }

}