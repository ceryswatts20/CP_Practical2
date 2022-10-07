import java.util.Random;

public class Process2 extends Thread {
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
        System.out.println("P2 ncs: Entering non-critical section.");
        Time.delay(rnd.nextInt(120));
        System.out.println("P2 ncs: In non-critical section.");
        System.out.println("P2 ncs: Leaving non-critical section.");
    }
    public void preProtocolSection() {
        System.out.println("P2 prep: Entering pre-protocol section.");
        DekkersAlgorithm.c2 = 0;

        while(DekkersAlgorithm.c1 != 1) {
            Time.delay(rnd.nextInt(120));

            if (DekkersAlgorithm.turn == 1) {
                DekkersAlgorithm.c2 = 1;
                Time.delay(rnd.nextInt(120));
                // While turn != 2 DO NOTHING
                while(DekkersAlgorithm.turn != 2) {}

                DekkersAlgorithm.c2 = 0;
            }
        }
        System.out.println("P2 prep: Leaving pre-protocol section.");
    }

    public void criticalSection() {
        System.out.println("P2 cs: Entering critical section.");
        System.out.println("P2 cs: In critical section.");
        Time.delay(rnd.nextInt(120));
        System.out.println("P2 cs: Leaving critical section.");
    }

    public void postProtocolSection() {
        System.out.println("P2 post: Entering post-protocol section.");
        DekkersAlgorithm.c2 = 1;
        DekkersAlgorithm.turn = 1;
        System.out.println("P2 post: Leaving post-protocol section.");
        Time.delay(rnd.nextInt(120));
    }
}
