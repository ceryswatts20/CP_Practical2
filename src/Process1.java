import java.util.Random;

public class Process1 extends Thread {
    Random rnd = new Random();

    @Override
    public void run() {
        while(true) {
            nonCriticalSection();
            preProtocolSection();
            criticalSection();
            postProtocolSection();
        }
    }

    public void nonCriticalSection() {
        System.out.println("P1 ncs: Entering non-critical section.");
        Time.delay(rnd.nextInt(120));
        System.out.println("P1 ncs: In non-critical section.");
        System.out.println("P1 ncs: Leaving non-critical section.");
    }

    public void preProtocolSection() {
        System.out.println("P1 prep: Entering pre-protocol section.");
        DekkersAlgorithm.c1 = 0;

        while(DekkersAlgorithm.c2 != 1) {
            Time.delay(rnd.nextInt(120));

            if (DekkersAlgorithm.turn == 2) {
                DekkersAlgorithm.c1 = 1;
                Time.delay(rnd.nextInt(120));
                // While turn != 1 DO NOTHING
                while(DekkersAlgorithm.turn != 1) {}

                DekkersAlgorithm.c1 = 0;
            }
        }
        System.out.println("P1 prep: Leaving pre-protocol section.");
    }

    public void criticalSection() {
        System.out.println("P1 cs: Entering critical section.");
        System.out.println("P1 cs: In critical section.");
        Time.delay(rnd.nextInt(120));
        System.out.println("P1 cs: Leaving critical section.");
    }

    public void postProtocolSection() {
        System.out.println("P1 post: Entering post-protocol section.");
        DekkersAlgorithm.c1 = 1;
        DekkersAlgorithm.turn = 2;
        System.out.println("P1 post: Leaving post-protocol section.");
        Time.delay(rnd.nextInt(120));
    }
}
