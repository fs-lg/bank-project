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

public class MainMenu {
    @FXML
    private Button btnViewTra;


    @FXML
    private Button btnBack;

    @FXML
    private TextField txtLoanAmount;

    @FXML
    private TextField txtPayPeriod;

    @FXML
    private Button btnApplyLoan;

    @FXML
    private TextField txtIDbill;

    @FXML
    private TextField txtCodePayBill;

    @FXML
    private Button btnPayBill;


    @FXML
    private TextField txtDesAc;

    @FXML
    private TextField txtValueTransfar;

    @FXML
    private Button btnTransferAA;

    @FXML
    private ListView<String> LVtransactionOneAcc;
    private final ObservableList<String> trsList= FXCollections.observableArrayList();

    @FXML
    private Label txtAccountNumNow;

    @FXML
    void pressBtnApplyLoan(ActionEvent event) {

        Main.accountN.applyLone(Double.parseDouble(txtLoanAmount.getText()),Double.parseDouble(txtPayPeriod.getText()));





    }

    @FXML
    void pressBtnBack(ActionEvent event) {
        try {
            Stage stage = (Stage) btnBack.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
            Scene scene = new Scene(root, 800, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {

            System.out.println("file not found!!");
        }

    }

    @FXML
    void pressBtnPayBill(ActionEvent event) {
        Main.accountN.pay_bill();

    }

    @FXML
    void pressBtnTransfer(ActionEvent event) {
        boolean temp=false;
        int iNeed=0;
        for (int i = 0; i <Main.count ; i++) {

            if(Main.clientN.myAccounts[i].AccountNumber.equals(txtDesAc.getText())){
                temp=true;
                iNeed=i;
            }

        }
        if(temp){
            Main.accountN.transfare(Main.clientN.myAccounts[iNeed],Double.parseDouble(txtValueTransfar.getText()));
            }
        else {

            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("DesAccount not found!!");
            alert6.showAndWait();
        }


    }

    public String getBalance(String Accnum) {

        return Accnum;
    }

    @FXML
    void pressBtnViewTra(ActionEvent event) {
        for (int i = 0; i < Main.accountN.trsSize; i++) {
            trsList.add(Main.accountN.transactions[i]);
            LVtransactionOneAcc.setItems(trsList);

        }


    }





}
