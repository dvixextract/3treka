/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;

/**
 *
 * @author User
 */
public class UserTimeSheetsViewController  implements Initializable{
    
    @FXML
    private TableColumn<?, ?> projectCodeColumnProjectListTable;

    @FXML
    private TableColumn<?, ?> projectNameColumnProjectListTable;

    @FXML
    private TableColumn<?, ?> taskCodeColumnProjectListTable;

    @FXML
    private TableColumn<?, ?> taskNameColumnProjectListTable;

    @FXML
    private ListView<?> teamMemberOfListview;

    @FXML
    private TableColumn<?, ?> projectNumberColumnTimeSheetTable;

    @FXML
    private TableColumn<?, ?> projectNameColumnTimeSheetTable;

    @FXML
    private TableColumn<?, ?> taskCodeColumnTimeSheetTable;

    @FXML
    private TableColumn<?, ?> taskNameColumnTimeSheetTable;

    @FXML
    private TableColumn<?, ?> taskDescriptionColumnTimeSheetTable;

    @FXML
    private TableColumn<?, ?> dayColumnTimesheetTable;

    @FXML
    private TableColumn<?, ?> projectNumberColumnTableProject;

    @FXML
    private TableColumn<?, ?> projectNameColumnTableProject;

    @FXML
    private TableColumn<?, ?> taskCodeColumnTableTask;

    @FXML
    private TableColumn<?, ?> taskNameColumnTableTask;

    @FXML
    private TableColumn<?, ?> taskDescriptionColumnTableTask;
    
    @FXML
    private Button startBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    private Button closeBtn;

    @FXML
    void closeButtonEventAction(ActionEvent event) {

    }

    @FXML
    void handleStartButtonEventAction(ActionEvent event) {

    }

    @FXML
    void pauseButtonEventAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        }
    
}
