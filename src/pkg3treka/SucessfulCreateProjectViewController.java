/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.SelectionModel;

public class SucessfulCreateProjectViewController implements Initializable  {

    
   @FXML
    private Button OkButton;
   
    @FXML
    private Button createTasksButton;


    @FXML
    void handleCreateTasksButtonAction(ActionEvent event) {

    }


    @FXML
    void handleOKButtonAction(ActionEvent event) {
    Stage stage = (Stage) OkButton.getScene().getWindow();
    stage.close();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createTasksButton.setOnAction(event -> Mediator.getInstance().fireEvent("createTask"));
         
    }    
    
}



