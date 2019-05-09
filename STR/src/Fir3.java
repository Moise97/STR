import java.util.concurrent.Semaphore;

public class Fir3 extends Thread{

    Semaphore semaphore;

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    public void run(){
        while(true){
            System.out.println("P9");
            // temporizare necesara deoarece firul 3 tine ocupat procesorul
            long t8 = (long)(Math.random()*2 + 2);
            try {
                Thread.sleep(t8 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                this.semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P10");

            P11 p11 = new P11();
            P12 p12 = new P12();
            P13 p13 = new P13();
            p11.start();
            p12.start();
            p13.start();
            try {
                p11.join();
                p12.join();
                p13.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println("P14");
        }
    }
}
