/*

 */


import javafx.scene.control.Alert;

import java.io.Serializable;
import java.util.*;
/*

 */

import java.util.Random;

enum type{SAVING,CHECKING,MONEYMARKET,RETIREMENT,CERTIFICATES};
enum TransactionE{PAYING_THE_BILL,MONEY_TRANSFER,LOAN_REPAYMENT};
class Account implements Serializable {
    String[] transactions = new String[3];
    int trsSize = 0;
    double balance = 10000;
    String AccountNumber = "";
    String Password = "";
    type t;
    String Aliase = "temp";
    boolean isCommonly = false;

    public Account(String passwordAccount, type t) {

        this.t = t;
        Random rnd = new Random();
        int AccNum = rnd.nextInt(1000);
        AccountNumber = "6969" + String.valueOf(AccNum);
        Password = passwordAccount;

    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setCommonly(boolean commonly) {
        isCommonly = commonly;
    }

    public void transfare(Account des, double value) {

        if (value > balance) {

            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Balance is not enough!!");
            alert6.showAndWait();//mojudy kafi nist


        } else {
            this.balance -= value;//apdate balance by server
            for (int i = 0; i < Main.count; i++) {
                if(Main.clientN.myAccounts[i].AccountNumber.equals(this.AccountNumber)){
                    Main.clientN.myAccounts[i].balance=this.balance;
                }

            }
            des.balance += value;//apdate balance by server
            transactions[trsSize] = "transaction:MONEY_TRANSFER   amount:" + value + "   desAccountNumber:" + des.AccountNumber;
            trsSize++;

        }


    }


    public void Withdrawa(double value) {
        if (value > balance) {//mojodi kafi nist

        } else {
            balance = -value;
            transactions[trsSize] = "transaction:WITHDRAWAL   amount:" + value;
            trsSize++;


        }
    }


    public void Deposit(double value) {
        balance += value;
        transactions[trsSize] = "transaction:DEPOSIT   amount:" + value;
        trsSize++;


    }

    public void pay_bill() {
        Random rand = new Random();
        int value = rand.nextInt(100) + 100;
        balance -= value;
        transactions[trsSize] = "transaction:PAYING_THE_BILL   amount:" + value;
        trsSize++;

    }

    public void setAliase(String aliase) {
        Aliase = aliase;
    }

    double loanAmount, payment, payPerMonth;

    public void applyLone(double LoanAmount, double Payment) {
        payPerMonth = loanAmount / payment;
        this.balance += LoanAmount;
        transactions[trsSize] = "transaction:APPLY_LOAN   amount:" + LoanAmount;
        trsSize++;

    }
   /* public String toString(){
        return "*AccountNumber:"+ AccountNumber+"*Password:"+Password+"*balance:"+balance+"*type:"+t+"*payPerMonth:"+
                payPerMonth+"*payment:"+payment+"*Aliase:"+Aliase;
    }*/

    public String simpleToString() {
        return "*AccountNumber:" + AccountNumber + "\t*Password:" + Password + "\t*type:" + t + "\t*balance:" + balance;

    }
    public String CommonToString() {
        return "*AccountNumber:" + AccountNumber + "\t*Password:" + Password + "\t*type:" + t + "\t*balance:" + balance+"\t*Aliase:"+Aliase;

    }
}


public class Client implements Serializable {
    String nationalN,passWord;
    String name,phoneN,email;
    Account[]  myAccounts = new Account[10];
    Account AccountNow;

    Client(String NationalN,String pass,String Name,String phone,String Email){
        name = Name;
        nationalN = NationalN;
        passWord = pass;
        phoneN = phone;
        email = Email;
    }


 /*  public void newAccount(type type, String accPass){
        myAccounts.add ( new Account(accPass, type));
    }*/

    @Override
    public String toString() {
        return "";
    }

    public void setAccountNow(Account accountNow) {
        AccountNow = accountNow;
    }
}
////////////////////////////////////////////////////////


class Transaction implements Serializable{
    public String trans;
    public double amount;
    public String accountN;

    public Transaction(String  t,double amount,String accN ){
        trans = t;
        this.amount = amount;
        accountN = accN;

    }

}








