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
import java.net.InetAddress;
import java.net.Socket;

class JabberClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private static int counter = 0;
    private int id;
    private static int threadcount = 0;

    public static int threadCount() {
        return threadcount;
    }

    public JabberClientThread(InetAddress var1) {
        this.id = counter++;
        System.out.println("Making client " + this.id);
        ++threadcount;

        try {
            this.socket = new Socket(var1, 8080);
        } catch (IOException var6) {
            System.err.println("Socket failed");
        }

        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream())), true);
            this.start();
        } catch (IOException var5) {
            try {
                this.socket.close();
            } catch (IOException var4) {
                System.err.println("Socket not closed");
            }
        }

    }

    public void run() {
        try {
            for(int var1 = 0; var1 < 25; ++var1) {
                this.out.println("Client " + this.id + ": " + var1);
                String var2 = this.in.readLine();
                System.out.println(var2);
            }

            this.out.println("END");
        } catch (IOException var11) {
            System.err.println("IO Exception");
        } finally {
            try {
                this.socket.close();
            } catch (IOException var10) {
                System.err.println("Socket not closed");
            }

            --threadcount;
        }

    }
}
