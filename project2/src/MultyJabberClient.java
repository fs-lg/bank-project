//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.net.InetAddress;

 class MultiJabberClient {
    static final int MAX_THREADS = 40;

    public MultiJabberClient() {
    }

    public static void main(String[] var0) throws IOException, InterruptedException {
        InetAddress var1 = InetAddress.getByName((String)null);

        while(true) {
            if (JabberClientThread.threadCount() < 40) {
                new JabberClientThread(var1);
            }

            Thread.currentThread();
            Thread.sleep(100L);
        }
    }
}
