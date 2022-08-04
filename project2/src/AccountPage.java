import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountPage {
    private Account newAccount;
    private type p;

    @FXML
    private Button btnDeletAcc;
    @FXML
    private TextField passAccount;

    @FXML
    private CheckBox MoneymarketAccount;

    @FXML
    private CheckBox saving;

    @FXML
    private CheckBox checking;

    @FXML
    private CheckBox RetirementAccount;

    @FXML
    private CheckBox Certificates;

    @FXML
    private Button btnCreat;

    @FXML
    private ListView<String> LVviewAcc;
    final ObservableList<String> AccountObserList= FXCollections.observableArrayList();

    @FXML
    private Tab tabDefineCommonlyAcc;

    @FXML
    private TextField newCommonlyNumber;

    @FXML
    private TextField newCommonlyAlias;

    @FXML
    private Button btnAddCommonly;

    @FXML
    private ListView<String> LVCommonlyAccount;
    final ObservableList<String> AccountObserListCommon= FXCollections.observableArrayList();
    @FXML
    private TextField txtPassAccNow;

    @FXML
    private CheckBox MoneymarketAccountACCN;

    @FXML
    private CheckBox savingACCN;

    @FXML
    private CheckBox checkingACCN;

    @FXML
    private CheckBox RetirementAccountACCN;

    @FXML
    private CheckBox CertificatesACCN;

    @FXML
    private Button btnChoosAcc;

    @FXML
    private Button btnView;
    @FXML
    private Button btnChoosInCreat;
    @FXML
    private Button btnViewCommonlyAcc;


    @FXML
    void pressBtnAddCommonly(ActionEvent event) {
        //search dar server baray peyda kardan hesab ba in accnum
        //newAccount=new Account();
        boolean temp=false;
        int iNeed=0;
        for (int i = 0; i < Main.count; i++) {
            if(Main.clientN.myAccounts[i].AccountNumber.equals(newCommonlyNumber.getText())){
                iNeed=i;
                temp=true;
            }
        }
        if(temp){
            Main.clientN.myAccounts[iNeed].setAliase(newCommonlyAlias.getText());
            Main.clientN.myAccounts[iNeed].setCommonly(true);

            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("CommonlyAccount add succefully!!");
            alert6.showAndWait();

        }
        else{

            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Account not found!!");
            alert6.showAndWait();
        }

    }
    @FXML
    void pressBtnViewCommonlyAcc(ActionEvent event) {
        for (int i = 0; i < Main.count; i++) {
            if(Main.clientN.myAccounts[i].isCommonly){
                AccountObserListCommon.add(Main.clientN.myAccounts[i].CommonToString());
            }

        }

        LVCommonlyAccount.setItems(AccountObserListCommon);


    }
    @FXML
    void pressBtnChoosInCreat(ActionEvent event) {
        boolean temp=false;
        int iNeed=0;
        for (int i = 0; i < Main.count; i++) {

            if(Main.clientN.myAccounts[i].t.equals(newAccount.t)&&Main.clientN.myAccounts[i].Password.equals(passAccount.getText())){
                temp=true;
                iNeed=i;
            }





        }
        if(temp){
            Main.accountN=Main.clientN.myAccounts[iNeed];

            try {
                Stage stage = (Stage) btnCreat.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                Scene scene = new Scene(root, 600, 450);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch (IOException e) {

                System.out.println("file not found!!na injast :))");
            }
        }
        else {
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Account not found!!");
            alert6.showAndWait();

        }


    }

    @FXML
    void pressBtnDeletAcc(ActionEvent event) {
        boolean temp=false;
        int iNeed=0;
        for (int i = 0; i < Main.count; i++) {

            if(Main.clientN.myAccounts[i].t.equals(newAccount.t)&&Main.clientN.myAccounts[i].Password.equals(passAccount.getText())){
                temp=true;
                iNeed=i;
            }

        }
        // 0 1 4 3
        // count=4
        if(temp){
            Main.count--;
            Main.clientN.myAccounts[iNeed]= Main.clientN.myAccounts[Main.count];
            boolean b=AccountObserList.removeAll();
            if(!b){
                System.out.println("erooooooooooooor!!");

            }
        }
        else {
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Account not found!!");
            alert6.showAndWait();

        }


    }


    @FXML
    void pressBtnCreat(ActionEvent event) {
        newAccount.setPassword(passAccount.getText());
        //Main.clientN.myAccounts.add(newAccount);
        SaveAccount mf=new SaveAccount();
        if(mf.saveAccount(newAccount)){
            System.out.println("injast!!");

            Main.clientN.myAccounts[Main.count]=newAccount;
            System.out.println(Main.clientN.myAccounts[Main.count].simpleToString());

            Main.count++;
            Main.accountN=newAccount;
            boolean b=AccountObserList.removeAll();
            if(!b){
                System.out.println("erooooooooooooor!!");

            }

            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Account creat succesfully!!");
            alert6.showAndWait();




        }else {
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Please try Again!!");
            alert6.showAndWait();

        }

    }
    @FXML
    void pressBtnView(ActionEvent event) {
        for (int i = 0; i < Main.count; i++) {
            AccountObserList.add(Main.clientN.myAccounts[i].simpleToString());
        }
        LVviewAcc.refresh();
        LVviewAcc.setItems(AccountObserList);

    }


    @FXML
    void pressCertificates(ActionEvent event) {
        p= type.CERTIFICATES;

        if(Certificates.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);
            checking.setSelected(false);
            RetirementAccount.setSelected(false);


        }
        newAccount=new Account("",p);


    }
    //SAVING,CHECKING,MONEYMARKET,RETIREMENT,CERTIFICATES
    @FXML

    void pressCheckSaving(ActionEvent event) {
        p=type.SAVING;

        if(saving.isSelected()){
            MoneymarketAccount.setSelected(false);

            checking.setSelected(false);
            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }

        newAccount=new Account("",p);



    }

    @FXML
    void pressChecking(ActionEvent event) {
        p=type.CHECKING;

        if(checking.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);

            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }
        newAccount=new Account("",p);



    }

    @FXML
    void pressMoneymarketAccount(ActionEvent event) {

        if(MoneymarketAccount.isSelected()){

            saving.setSelected(false);
            checking.setSelected(false);
            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }
        newAccount=new Account("",type.MONEYMARKET);


    }

    @FXML
    void pressRetirementAccount(ActionEvent event) {

        if(RetirementAccount.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);
            checking.setSelected(false);

            Certificates.setSelected(false);
        }
        newAccount=new Account("",type.RETIREMENT);


    }


    @FXML
    void pressBtnCoosAcc(ActionEvent event) {

        newAccount.setPassword(txtPassAccNow.getText());
        SaveAccount sv=new SaveAccount();
        if(sv.findingAccount(newAccount)){
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Your account has changed successfully.");
            alert6.showAndWait();

        }
        else{
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("You do not have such an account!");
            alert6.showAndWait();

        }


    }


    @FXML
    void pressCertificatesACCN(ActionEvent event) {
        p= type.CERTIFICATES;

        if(Certificates.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);
            checking.setSelected(false);
            RetirementAccount.setSelected(false);


        }
        newAccount=new Account("",p);

    }


    @FXML
    void pressCheckSavingACCN(ActionEvent event) {
        p=type.SAVING;

        if(saving.isSelected()){
            MoneymarketAccount.setSelected(false);

            checking.setSelected(false);
            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }

        newAccount=new Account("",p);



    }


    @FXML
    void pressCheckingACCN(ActionEvent event) {
        p=type.CHECKING;

        if(checking.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);

            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }
        newAccount=new Account("",p);


    }


    @FXML
    void pressMoneymarketAccountACCN(ActionEvent event) {
        if(MoneymarketAccount.isSelected()){

            saving.setSelected(false);
            checking.setSelected(false);
            RetirementAccount.setSelected(false);
            Certificates.setSelected(false);
        }

        newAccount=new Account("",type.MONEYMARKET);


    }



    @FXML
    void pressRetirementAccountACCN(ActionEvent event) {
        if(RetirementAccount.isSelected()){
            MoneymarketAccount.setSelected(false);
            saving.setSelected(false);
            checking.setSelected(false);

            Certificates.setSelected(false);
        }
        newAccount=new Account("",type.RETIREMENT);



    }

}
