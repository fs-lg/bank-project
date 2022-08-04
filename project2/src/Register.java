
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Register {

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtNc;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEmail;

    @FXML
    private Button btnDone;

    @FXML
    private Button btnBack;

    @FXML
    void pressBtnBack(ActionEvent event) {
        try {
            Stage stage = (Stage) btnDone.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("loginPage.fxml"));
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {

            System.out.println("file not found!!");
        }


    }

    @FXML
    void pressBtnDone(ActionEvent event) {
        if(txtName.getText().equals("")||txtPass.getText().equals("")||txtEmail.getText().equals("")||txtNc.getText().equals("")||txtPhone.getText().equals("")){
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Hey You");
            alert1.setContentText("Compelete all the parts!!");
            alert1.showAndWait();
        }
        else {
            Main.clientN = new Client(txtNc.getText(),txtPass.getText(),txtName.getText(),txtPhone.getText(),txtEmail.getText());
            MyFile file = new MyFile();
            if(file.clientSave(Main.clientN)){
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Hey You");
                alert1.setContentText("you have registered succesfully!");
                alert1.showAndWait();
            }else{
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Hey You");
                alert1.setContentText("Please try again!");
                alert1.showAndWait();
            }



            try {
                Stage stage = (Stage) btnDone.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("loginPage.fxml"));//
                Scene scene = new Scene(root, 600, 500);
                primaryStage.setScene(scene);
                primaryStage.show();
            }
            catch (IOException e) {

                System.out.println("file not found!!");
            }

        }

    }

}
