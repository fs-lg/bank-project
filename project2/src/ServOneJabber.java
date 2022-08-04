//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

class ServeOneJabber extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServeOneJabber(Socket var1) throws IOException {
        this.socket = var1;
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
        this.start();
    }

    public void run() {
        while(true) {
            try {
                String var1 = this.in.readLine();
                if (!var1.equals("END")) {
                    System.out.println("Echoing: " + var1);
                    this.out.println(var1);
                    continue;
                }

                System.out.println("closing...");
            } catch (IOException var10) {
                System.err.println("IO Exception");
            } finally {
                try {
                    this.socket.close();
                } catch (IOException var9) {
                    System.err.println("Socket not closed");
                }

            }

            return;
        }
    }
}
