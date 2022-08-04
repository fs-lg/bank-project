/*import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPage {

    @FXML
    private TextField txtuserName;

    @FXML
    private RadioButton btnManagerLogin;

    @FXML
    private RadioButton btnClientLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnSignIn;

    @FXML
    private PasswordField txtPass;

    @FXML
    void pressBtnSignIn(ActionEvent event) {
        if(txtPass.getText().equals("")||txtuserName.getText().equals("")||(!btnClientLogin.isSelected()&&!btnManagerLogin.isSelected())){
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Compelete all the parts!!");
            alert6.showAndWait();
        }
        else{
          //server search for client
            if(true){//etelaat esttebah ast
                Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
                alert6.setTitle("Hey You");
                alert6.setContentText("did not found !!\ntry again");
                alert6.showAndWait();

            }
            else{
                if(btnManagerLogin.isSelected()){
                    try {
                        Stage stage = (Stage) btnSignUp.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main-Transactions.fxml"));
                        Scene scene = new Scene(root, 800, 500);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    }
                     catch (IOException e) {

                        System.out.println("file not found!!");
                    }

                }
                else{
                    try {
                        Stage stage = (Stage) btnSignUp.getScene().getWindow();
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
            }


        }



    }

    @FXML
    void pressBtnSignUp(ActionEvent event)  {
        try {
            Stage stage = (Stage) btnSignUp.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main-Transactions.fxml"));
            Scene scene = new Scene(root, 800, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e2){
            System.out.println("file not found!!");
        }


    }

}*/
//////////////////////
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class LoginPage {
    @FXML
    private ImageView ImgBackGrandLogin;

    @FXML
    private ImageView ImagBlueLogin;


    @FXML
    private TextField txtuserName;

    @FXML
    private RadioButton btnManagerLogin;

    @FXML
    private RadioButton btnClientLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnSignIn;

    @FXML
    private PasswordField txtPass;


    @FXML
    void pressBtnSignIn(ActionEvent event) {
        if(txtPass.getText().equals("")||txtuserName.getText().equals("")||(!btnClientLogin.isSelected()&&!btnManagerLogin.isSelected())){
            Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
            alert6.setTitle("Hey You");
            alert6.setContentText("Compelete all the parts!!");
            alert6.showAndWait();
        }
        else{
            //server search for client
            Main.clientN=new Client(txtuserName.getText(),txtPass.getText(),"","","");
////////////////////////////////////////////////////////////////////////////////////


            MyFile myFile=new MyFile();
            if(myFile.findingClient(Main.clientN)==false){//etelaat esttebah ast
                Alert alert6 = new Alert(Alert.AlertType.INFORMATION);
                alert6.setTitle("Hey You");
                alert6.setContentText("did not found !!\ntry again");
                alert6.showAndWait();

            }
            else{
                if(btnManagerLogin.isSelected()){
                    try {
                        Stage stage = (Stage) btnSignUp.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));///
                        Scene scene = new Scene(root, 800, 500);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    }
                    catch (IOException e) {

                        System.out.println("file not found!! shayad injast XD");
                    }

                }
                else{
                    try {
                        Stage stage = (Stage) btnSignUp.getScene().getWindow();
                        stage.close();
                        Stage primaryStage = new Stage();
                        AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
                        Scene scene = new Scene(root, 600, 450);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    }
                    catch (IOException e) {

                        System.out.println("file not found!!na injast :))");
                    }


                }
            }


        }



    }


    @FXML
    void pressBtnSignUp(ActionEvent event)  {
        try {
            Stage stage = (Stage) btnSignUp.getScene().getWindow();
            stage.close();
            Stage primaryStage = new Stage();
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Register.fxml"));
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e2){
            System.out.println("file not found!! exp injast :)");
        }


    }
}
