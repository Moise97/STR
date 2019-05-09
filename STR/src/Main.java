import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(0);
        Semaphore semAdFir1 = new Semaphore(2);
        Semaphore semAdFir2 = new Semaphore(1);
        CyclicBarrier cb = new CyclicBarrier(3);
        Fir1 f1 = new Fir1();
        Fir1 f11 = new Fir1();
        Fir2 f2 = new Fir2();
        Fir2 f22 = new Fir2();
        Fir3 f3 = new Fir3();
        f1.setSemaphore(s);
        f1.setSemaphoreAditional(semAdFir1);
        f1.setCyclicBarrier(cb);
        f2.setSemaphore(s);
        f2.setSemaphoreAditional(semAdFir2);
        f2.setCyclicBarrier(cb);
        f11.setSemaphore(s);
        f11.setSemaphoreAditional(semAdFir1);
        f11.setCyclicBarrier(cb);
        f22.setSemaphore(s);
        f22.setSemaphoreAditional(semAdFir2);
        f22.setCyclicBarrier(cb);
        f3.setSemaphore(s);
        f1.start();
        f2.start();
        f3.start();
        f11.start();
        f22.start();
    }


}
