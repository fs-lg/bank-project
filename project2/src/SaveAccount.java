
import javax.print.attribute.standard.PrinterName;
import java.io.*;
import java.util.Scanner;
    class  SaveAccount{
        public boolean saveAccount(Account sAcc){
            int Num = 0;
            try( /*FileWriter fw = new FileWriter("Account.txt",true);
                 BufferedWriter bw = new BufferedWriter(fw);){

                bw.write("newAccount");
                bw.newLine();
                bw.write(sAcc.AccountNumber);
                bw.newLine();
                bw.write(sAcc.Password);
                bw.newLine();
                bw.write(String.valueOf(sAcc.t));
                bw.newLine();
                bw.write(sAcc.Aliase);
                bw.newLine();
                bw.write(String.valueOf(sAcc.balance));
                bw.newLine();
                bw.write(sAcc.isCommonly+"");
                bw.newLine();
                bw.write(sAcc.loanAmount+"");
                bw.newLine();
                bw.write(sAcc.payment+"");
                bw.newLine();
                bw.write(sAcc.payPerMonth+"");
                bw.newLine();

                bw.write(sAcc.trsSize+"");
                bw.newLine();


                for(int k=0; k< sAcc.trsSize; k++){
                    bw.write(sAcc.transactions[k]);
                    bw.newLine();
                }*/
                    PrintWriter bw = new PrintWriter("Account.txt");
                    ){

                bw.println("newAccount");
                bw.println(sAcc.AccountNumber);
                bw.println(sAcc.Password);
                bw.println(String.valueOf(sAcc.t));
                bw.println(sAcc.Aliase);
                bw.println(String.valueOf(sAcc.balance));
                bw.println(sAcc.isCommonly+"");
                bw.println(sAcc.loanAmount+"");
                bw.println(sAcc.payment+"");
                bw.println(sAcc.payPerMonth+"");
                bw.println(sAcc.trsSize+"");



                for(int k=0; k< sAcc.trsSize; k++){
                    bw.println(sAcc.transactions[k]);
                }


                try(Scanner Sc1 = new Scanner(new File("AccNumber.txt"));
                ){
                   Num=Sc1.nextInt();
                }catch(Exception er){
                    System.out.println("SaveAccount , has a problem");
                }

                Num++;

                try(PrintWriter wr1 = new PrintWriter(new File("AccNumber.txt"));
                ){
                    wr1.println(Num);
                }catch(Exception er){
                    System.out.println("SaveAccount , has a problem");
                }
                return true;


            }catch(Exception io){
                System.out.println("Exception in method saveAccount !");
                return false;
            }
        }



            public boolean  findingAccount(Account fndAcc){
                int number = 0;
                String [][] AccountList=null;
                try( Scanner in = new Scanner(new File("Account.txt"));){
                   AccountList = new String [100][20];//hadeaksar 10 tarakonesh darad
                    String temp = null;
                    int i=-1;
                    int j=0;

                    while(in.hasNext()){
                        temp = in.nextLine();
                        while(!(temp .equals("newAccount"))){
                            System.out.println(temp);

                            AccountList[i][j] = temp;
                            j++;
                            if(in.hasNext())temp = in.nextLine();
                        }
                        j=0;
                        i++;

                    }

                }//
                catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ////

                try(Scanner Sc1 = new Scanner(new File("AccNumber.txt"));
                ){
                    number=Integer.parseInt(Sc1.nextLine());
                }catch(Exception er){
                    System.out.println("SaveAccount , has a problem");
                }


                for(int i=0; i<number ;i++){
                    if(fndAcc.Password.equals(AccountList[i][1])){
                        if(fndAcc.t.equals(AccountList[i][2])){
                            Main.accountN.AccountNumber = AccountList[i][0];
                            Main.accountN.Aliase = AccountList[i][3];
                            Main.accountN.balance= Double.parseDouble(AccountList[i][4]);
                            Main.accountN.isCommonly = Boolean.parseBoolean(AccountList[i][5]);
                            Main.accountN.loanAmount =  Double.parseDouble(AccountList[i][6]);
                            Main.accountN.payment =  Double.parseDouble(AccountList[i][7]);
                            Main.accountN.payPerMonth =  Double.parseDouble(AccountList[i][8]);
                            Main.accountN.trsSize =  Integer.parseInt(AccountList[i][9]);

                            for(int k=0; k<Main.accountN.trsSize; k++){
                                Main.accountN.transactions[k]= AccountList[i][10+k];
                            }

                            return true;
                        }
                    }
                }
                return false;
            }
        }





