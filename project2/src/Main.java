import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
class ClientServer {
    Socket mSocket;
    int port = 9090;
    String serverAddress = "127.0.0.1";
    InputStream fromServerStream;
    OutputStream toServerStream;
    DataInputStream reader;
    PrintWriter writer;
    public ClientServer() {
        try {
            mSocket = new Socket(serverAddress, port);
            System.out.println("connect to server ....");
// input stream (stream from server)
            fromServerStream = mSocket.getInputStream();
// output stream (stream to server)
            toServerStream = mSocket.getOutputStream();
            reader = new DataInputStream(fromServerStream);
            writer = new PrintWriter(toServerStream, true);
// first : read server message
            //   String msg=reader.readLine();
            //   System.out.println("server:"+msg);

        } catch (UnknownHostException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMassage(String key,Object obj){
        writer.println(key);
        writer.println(obj);
        System.out.println("sending "+obj+" to server for "+key);
    }
    public boolean getMassage(){
        try {
            return reader.readBoolean();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;


    }

}

public class Main extends Application {
    public static Account accountN;
    public static Object saveList=new Client[100];
    public static Client clientN;
    public static Integer count=0;
    @Override
    public void start(Stage primaryStage) throws Exception {

/*
        Timeline tl = new Timeline(new KeyFrame(new Duration(800),
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        a.moveDown();
                        if (a.getY() == 17) {
                            a = new Shape(0, 0, 2);
                            root.getChildren().add(a);
                        }
                    }
                }));
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.play();
*/
        try {
            Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(root, 550, 500));
            primaryStage.show();
        }
        finally {
            System.out.println("java version: "+System.getProperty("java.version"));
            System.out.println("javafx.version: " + System.getProperty("javafx.version"));
            System.out.println("sean builder version : "+System.getProperty("SeanBuilder.version"));

        }
    }

    public static void main(String[] args) {

        launch();

    }
}



/////////////////////////////////////////////////////////////////////////////
/*//: c15:Main.java
// From 'Thinking in Java, 2nd ed.' by Bruce Eckel
// www.BruceEckel.com. See copyright notice in CopyRight.txt.
// Client that tests the MultiJabberServer
// by starting up multiple clients.
import java.net.*;
import java.io.*;

class JabberClientThread extends Thread {
  private Socket socket;
  private BufferedReader in;
  private PrintWriter out;
  private static int counter = 0;
  private int id = counter++;
  private static int threadcount = 0;
  public static int threadCount() {
    return threadcount;
  }
  public JabberClientThread(InetAddress addr) {
    System.out.println("Making client " + id);
    threadcount++;
    try {
      socket =
              new Socket(addr, MultiJabberServer.PORT);
    } catch(IOException e) {
      System.err.println("Socket failed");
      // If the creation of the socket fails,
      // nothing needs to be cleaned up.
    }
    try {
      in =
              new BufferedReader(
                      new InputStreamReader(
                              socket.getInputStream()));
      // Enable auto-flush:
      out =
              new PrintWriter(
                      new BufferedWriter(
                              new OutputStreamWriter(
                                      socket.getOutputStream())), true);
      start();
    } catch(IOException e) {
      // The socket should be closed on any
      // failures other than the socket
      // constructor:
      try {
        socket.close();
      } catch(IOException e2) {
        System.err.println("Socket not closed");
      }
    }
    // Otherwise the socket will be closed by
    // the run() method of the thread.
  }
  public void run() {
    try {
      Main main=new Main();
      main.start();
      for(int i = 0; i < 25; i++) {
        out.println("Client " + id + ": " + i);
        String str = in.readLine();
        System.out.println(str);
      }
      out.println("END");
    } catch(IOException e) {
      System.err.println("IO Exception");
    } finally {
      // Always close it:
      try {
        socket.close();
      } catch(IOException e) {
        System.err.println("Socket not closed");
      }
      threadcount--; // Ending this thread
    }
  }
}



public class MultiJabberClient {
  static final int MAX_THREADS = 3;
  public static void main(String[] args) 
      throws IOException, InterruptedException {
    InetAddress addr = 
      InetAddress.getByName(null);
    while(true) {
      if(JabberClientThread.threadCount() 
         < MAX_THREADS)
        new JabberClientThread(addr);
      Thread.currentThread().sleep(100);
    }
  }
} ///:~*/