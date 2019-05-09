import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir2 extends Thread{

    Semaphore semaphore, semaphoreAditional;
    CyclicBarrier cyclicBarrier;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public Semaphore getSemaphoreAditional() {
        return semaphoreAditional;
    }

    public void setSemaphoreAditional(Semaphore semaphoreAditional) {
        this.semaphoreAditional = semaphoreAditional;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public void setCyclicBarrier(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        long j = 0;
        while(true){
            System.out.println("P5");
            long p5 = (long)(Math.random() + 4 );
            for(int i = 0; i <= p5 * 1000000; i++){
                j++;
            }
            try {
                this.semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P6");
            long t5 = (long)(Math.random()*2 + 2);
            try {
                Thread.sleep(t5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P7");
            try {
                this.semaphoreAditional.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P7*");
            try {
                this.cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("P8*");
            this.semaphoreAditional.release(1);
            System.out.println("P8");
        }
    }
}
