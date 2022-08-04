//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

 class MultiJabberServer {
    static final int PORT = 8080;

    public MultiJabberServer() {
    }

    public static void main(String[] var0) throws IOException {
        ServerSocket var1 = new ServerSocket(8080);
        System.out.println("Server Started");

        try {
            while(true) {
                Socket var2 = var1.accept();

                try {
                    new ServeOneJabber(var2);
                } catch (IOException var7) {
                    var2.close();
                }
            }
        } finally {
            var1.close();
        }
    }
}
