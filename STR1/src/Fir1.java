import java.util.concurrent.CountDownLatch;

public class Fir1 extends Thread {

    CountDownLatch cdl;

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run(){
        while(true){
            System.out.println("P1");
            this.cdl.countDown();
            System.out.println("P2");
            long t2 = (long)(Math.random()*2 + 2);
            try {
                Thread.sleep(t2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P3");
        }
    }

}
