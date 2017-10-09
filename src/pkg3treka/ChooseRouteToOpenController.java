/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ChooseRouteToOpenController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button adminPageButton;

    @FXML
    private Button UserPageButton;
    
    @FXML
    void handleAdminPageButtonAction(ActionEvent event) {
        
    try{
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("AdminView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());//next page size
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }catch(Exception e){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        e.printStackTrace();
    }

    }

    @FXML
    void handleUserButtonAction(ActionEvent event) {
        try {
            //              try{
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("UserTimeSheetsView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());//next page size
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
//    }catch(Exception e){
//        DBConnection.infoBox("Error Saving Data", "Fail", null);
//        e.printStackTrace();
//    }
        } catch (IOException ex) {
            Logger.getLogger(ChooseRouteToOpenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
