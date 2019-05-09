import java.util.concurrent.CountDownLatch;

public class Fir3 extends Thread {

    CountDownLatch cdl;

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run(){
        while(true){
            System.out.println("P7");
            try {
                this.cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P8");
            try {
                Thread.sleep(7 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.cdl.countDown();
            System.out.println("P9");
        }
    }
}
