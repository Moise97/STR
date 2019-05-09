import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);
        Fir1 f1 = new Fir1();
        Fir2 f2 = new Fir2();
        Fir3 f3 = new Fir3();
        f1.setCdl(cdl);
        f2.setCdl(cdl);
        f3.setCdl(cdl);
        f1.start();
        f2.start();
        f3.start();
    }

}
