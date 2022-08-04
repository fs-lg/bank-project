/*
 */
import java.io.*;
import java.util.*;

class MyFile  {
    Client []sampleArray=new Client[100];
    Integer size=0;

    public boolean clientSave(Object b){

        try(    Scanner o1= new Scanner(new File("size.txt"));
        )
        {
            size= o1.nextInt();

        }catch(FileNotFoundException e){
            System.out.println("File size  not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ioexp in open size");
            return false;
        }catch(Exception e){

            e.printStackTrace();
            System.out.println("exp in open size");
            return false;
        }
        if (size != 0) {
            try(    FileInputStream file2= new FileInputStream(new File("client.dat"));
                    ObjectInputStream o2 = new ObjectInputStream(file2)) {

                for (int i = 0; i < size; i++) {
                    sampleArray[i]= (Client) o2.readObject();
                }


            }catch(FileNotFoundException e){

                System.out.println("File client2  not found!");
                return false;
            }catch(IOException e){
                e.printStackTrace();
                System.out.println("io exp in client2");
                return false;
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("exp in client2");
                return false;
            }
        }
        try(    FileOutputStream file= new FileOutputStream(new File("client.dat"),true);
                ObjectOutputStream o = new ObjectOutputStream(file);){
            sampleArray[size]= (Client) b;
            size++;

            try(    PrintWriter file2= new PrintWriter(new File("size.txt"));
            ){
                file2.print(size);

            }


            for (int i = 0; i < size; i++) {
                o.writeObject(sampleArray[i]);

            }

            return true;
        }catch(FileNotFoundException e){
            System.out.println("File client  not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("io exp");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("exp!!");
            return false;
        }
    }

    ////////////////////////////////////
    public boolean findingClient(Client c){

        try(    Scanner o1= new Scanner(new File("size.txt"));
        )
        {
            size=(Integer) o1.nextInt();

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        try(    FileInputStream file= new FileInputStream(new File("client.dat"));
                ObjectInputStream o = new ObjectInputStream(file);){
            try{
                for (int i = 0; i < size; i++) {
                    sampleArray[i]=(Client) o.readObject();

                }
            }catch(ClassNotFoundException e1){
                System.out.println(e1.getMessage());

            }catch (Exception e1){
                System.out.println("exp e1 in finding c :"+e1.getMessage());///karbar vojud nadarad
                System.out.println(size) ;
                return true;
            }

            for(int i=0 ; i<size; i++){
                if(sampleArray[i].passWord.equals(c.passWord) && sampleArray[i].nationalN.equals(c.nationalN)){
                    Main.clientN = sampleArray[i];
                    //////shayad dastore bala delkhah ma amal nakonad!!!!!!!!!
                    return true;
                }
            }
            return false;

        }catch(Exception e3){
            System.out.println("Find in file Exception!!");
            return false;
        }
    }
}







////////////////////////////////////////
/*/*
ط·آ¨ط·آ³ط¸â€¦ ط·آ§ط¸â€‍ط¸â€‍ط¸â€، ط·آ§ط¸â€‍ط·آ±ط·آ­ط¸â€¦ط¸â€  ط·آ§ط¸â€‍ط·آ±ط·آ­ط؛إ’ط¸â€¦
 */
/*
import java.io.*;

/////////////new
 class MyObjectOutputStream extends ObjectOutputStream {
    // Define the benefits of static
    private static File f;



    /**
     * Initialize static file objects, and return to class objects
     *
     * @param file
     * File object, used to initialize static file objects
     * @param out
     * Output stream
     * @return MyObjectOutputStream
     * @throws IOException

    public static MyObjectOutputStream newInstance(File file, OutputStream out) throws IOException {
        f = file; // This method is the most important place: Building a file object, is the same one by two file objects belonging to the same
        return new MyObjectOutputStream(out, f);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        if (!f.exists() || (f.exists() && f.length() == 0)) {
            super.writeStreamHeader();
        } else {
            super.reset();
        }

    }

    public MyObjectOutputStream(OutputStream out, File f) throws IOException {
        super(out);
    }

}
/*

/////end new

//client va account va transaction bayad Serializable ra implement konand
public class MyFile  {

    public boolean clientSave(Object b){
        File file = new File("client.txt");
        try(	//FileInputStream file= new FileInputStream(new File("client.txt"));

                FileInputStream file1= new FileInputStream(file);
                ObjectInputStream o = new ObjectInputStream(file1)){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }
        try(
            OutputStream os = new FileOutputStream(file,true);
            // buffering flow
            BufferedOutputStream bos = new BufferedOutputStream(os);
            // processing flow
            //ObjectOutputStream oos = new ObjectOutputStream(bos);
            MyObjectOutputStream oos = MyObjectOutputStream.newInstance(file, bos)){

            oos.writeObject(b);
            return true;

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            System.out.println("Error initializing stream!");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ////////////////////////////////////
    public boolean findingClient(Client c){
        Object b = new Object();
        int flag =0;
        int end=0;
        try(	//FileInputStream file= new FileInputStream(new File("client.txt"));

                FileInputStream file= new FileInputStream("client.txt");
                ObjectInputStream o = new ObjectInputStream(file)){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }
            while(flag==0 && end==0){
                if(((Client)b).passWord == c.passWord && ((Client)b).nationalN==c.nationalN)
                    flag=1;

                try{
                    b = o.readObject();
                }catch(ClassNotFoundException e){
                    end=1;
                }
            }

            if(flag==1){
                c = (Client)b ;
            }//ettelaat c ro tebgh file kamel kone


            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            System.out.println("Error initializing stream!");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean clientSave(Client client){


    }


}



/////////////////////////////////////////////////////////////////////////
/*
 /*

import java.io.*;

//client va account va transaction bayad Serializable ra implement konand
class MyFile  {

    public boolean clientSave(String client ){
        try(
                //
                FileOutputStream file= new FileOutputStream(new File("client.dat"),true);
                DataOutputStream o = new DataOutputStream(file);){

            o.writeChars(client);


            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    ////////////////////////////////////
    public boolean findingClient(Client c){
        Object b = new Object();
        int flag =0;
        int end=0;

        try(
                FileInputStream file= new FileInputStream(new File("client.dat"));
                ObjectInputStream o = new ObjectInputStream(file);){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }catch (Exception e1){
                System.out.println(e1.getMessage());
            }
            while(flag==0 && end==0){
                if(((Client)b).passWord == c.passWord && ((Client)b).nationalN==c.nationalN){
                    flag=1;
                    System.out.println("client found");
                    break;
                }


                try{
                    b = o.readObject();
                }catch(ClassNotFoundException e){
                    end=1;
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                    end=1;
                }
            }

            if(flag==1){
                c = (Client)b ;
                System.out.println("inside");
                return true;
            }
            //ettelaat c ro tebgh file kamel kone
            return false;

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }

}
*/






////////////////////////////////////////
/*/*
ط¨ط³ظ… ط§ظ„ظ„ظ‡ ط§ظ„ط±ط­ظ…ظ† ط§ظ„ط±ط­غŒظ…
 */
/*
import java.io.*;

/////////////new
 class MyObjectOutputStream extends ObjectOutputStream {
    // Define the benefits of static
    private static File f;



    /**
     * Initialize static file objects, and return to class objects
     *
     * @param file
     * File object, used to initialize static file objects
     * @param out
     * Output stream
     * @return MyObjectOutputStream
     * @throws IOException

    public static MyObjectOutputStream newInstance(File file, OutputStream out) throws IOException {
        f = file; // This method is the most important place: Building a file object, is the same one by two file objects belonging to the same
        return new MyObjectOutputStream(out, f);
    }
    @Override
    protected void writeStreamHeader() throws IOException {
        if (!f.exists() || (f.exists() && f.length() == 0)) {
            super.writeStreamHeader();
        } else {
            super.reset();
        }

    }

    public MyObjectOutputStream(OutputStream out, File f) throws IOException {
        super(out);
    }

}
/*

/////end new

//client va account va transaction bayad Serializable ra implement konand
public class MyFile  {

    public boolean clientSave(Object b){
        File file = new File("client.txt");
        try(	//FileInputStream file= new FileInputStream(new File("client.txt"));

                FileInputStream file1= new FileInputStream(file);
                ObjectInputStream o = new ObjectInputStream(file1)){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }
        try(
            OutputStream os = new FileOutputStream(file,true);
            // buffering flow
            BufferedOutputStream bos = new BufferedOutputStream(os);
            // processing flow
            //ObjectOutputStream oos = new ObjectOutputStream(bos);
            MyObjectOutputStream oos = MyObjectOutputStream.newInstance(file, bos)){

            oos.writeObject(b);
            return true;

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            System.out.println("Error initializing stream!");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ////////////////////////////////////
    public boolean findingClient(Client c){
        Object b = new Object();
        int flag =0;
        int end=0;
        try(	//FileInputStream file= new FileInputStream(new File("client.txt"));

                FileInputStream file= new FileInputStream("client.txt");
                ObjectInputStream o = new ObjectInputStream(file)){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }
            while(flag==0 && end==0){
                if(((Client)b).passWord == c.passWord && ((Client)b).nationalN==c.nationalN)
                    flag=1;

                try{
                    b = o.readObject();
                }catch(ClassNotFoundException e){
                    end=1;
                }
            }

            if(flag==1){
                c = (Client)b ;
            }//ettelaat c ro tebgh file kamel kone


            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            System.out.println("Error initializing stream!");
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public boolean clientSave(Client client){


    }


}



/////////////////////////////////////////////////////////////////////////
/*
 /*

import java.io.*;

//client va account va transaction bayad Serializable ra implement konand
class MyFile  {

    public boolean clientSave(String client ){
        try(
                //
                FileOutputStream file= new FileOutputStream(new File("client.dat"),true);
                DataOutputStream o = new DataOutputStream(file);){

            o.writeChars(client);


            return true;
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    ////////////////////////////////////
    public boolean findingClient(Client c){
        Object b = new Object();
        int flag =0;
        int end=0;

        try(
                FileInputStream file= new FileInputStream(new File("client.dat"));
                ObjectInputStream o = new ObjectInputStream(file);){
            try{
                b = o.readObject();
            }catch(ClassNotFoundException e){
                end=1;
            }catch (Exception e1){
                System.out.println(e1.getMessage());
            }
            while(flag==0 && end==0){
                if(((Client)b).passWord == c.passWord && ((Client)b).nationalN==c.nationalN){
                    flag=1;
                    System.out.println("client found");
                    break;
                }


                try{
                    b = o.readObject();
                }catch(ClassNotFoundException e){
                    end=1;
                }catch (Exception e1){
                    System.out.println(e1.getMessage());
                    end=1;
                }
            }

            if(flag==1){
                c = (Client)b ;
                System.out.println("inside");
                return true;
            }
            //ettelaat c ro tebgh file kamel kone
            return false;

        }catch(FileNotFoundException e){
            System.out.println("File not found!");
            return false;
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }


    }

}
*/