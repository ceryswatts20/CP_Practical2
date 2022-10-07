public class DekkersAlgorithm {

    // Shared variables are volatile
    public static volatile int c1 = 1;
    public static volatile int c2 = 1;
    public static volatile int turn = 1;

    public static void main(String[] args) {
        Process1 P1 = new Process1();
        Process2 P2 = new Process2();

        P1.start();
        P2.start();
    }
}
