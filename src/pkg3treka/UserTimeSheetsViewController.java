/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author User
 */
public class UserTimeSheetsViewController implements Initializable {

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
    private TableColumn<Projects, String> projectNumberColumnTableProject;

    @FXML
    private TableColumn<Projects, String> projectNameColumnTableProject;

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
    private TableView<Projects> allProjects;

    private ObservableList<Projects> allProjectsData = FXCollections.observableArrayList();

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public UserTimeSheetsViewController() {

        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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

        //projectNumberColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("sdsds"));
//        projectNameColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("sdsds"));
        setAllProjectsInfoCellTable();
        loadAllProjectInformation();
    }

    public void loadAllProjectInformation() {
        try {
            String sql = "SELECT * FROM project";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {

                allProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2)));
                System.out.println(resultSet.getString(1) + " - " + resultSet.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        allProjects.setItems(allProjectsData);
    }

    public void setAllProjectsInfoCellTable() {

        projectNumberColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
        projectNameColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));

    }


}
