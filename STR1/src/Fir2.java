import java.util.concurrent.CountDownLatch;

public class Fir2 extends Thread {

    CountDownLatch cdl;

    public CountDownLatch getCdl() {
        return cdl;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run(){
        long j = 0;
        System.out.println("P4");
        long p4 = (long)(Math.random()*2 + 2);
        for(int i = 0; i <= p4 * 1000000; i++){
            j++;
        }
        this.cdl.countDown();
        System.out.println("P5");
        System.out.println("P6");
    }
}
