import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Fir1 extends Thread{

    Semaphore semaphore,semaphoreAditional;
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
            System.out.println("P1");
            long p1 = (long)(Math.random()*3 + 3);
            for(int i = 0; i <= p1 * 1000000; i++){
                j++;
            }
            this.semaphore.release(2);
            System.out.println("P2");
            long t2 = (long)(Math.random()*3 + 3);
            try {
                Thread.sleep(t2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P3");
            try {
                this.semaphoreAditional.acquire(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P3*");
            try {
                this.cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("P4*");
            this.semaphoreAditional.release(1);
            System.out.println("P4");
        }
    }

}
