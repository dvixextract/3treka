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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
    private TableColumn<Task, String> taskCodeColumnTableTask;

    @FXML
    private TableColumn<Task, String> taskNameColumnTableTask;

    @FXML
    private TableColumn<Task, String> taskDescriptionColumnTableTask;

    @FXML
    private Button startBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private TableView<Task> projectsTask;

    @FXML
    private TableView<Projects> allProjects;

    private ObservableList<Projects> allProjectsData = FXCollections.observableArrayList();

    private ObservableList<Task> allTasksData = FXCollections.observableArrayList();

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

        setProjectsTaskInfoCellTable();
        setAllProjectsInfoCellTable();
        loadAllProjectInformation();
        start();
    }

    public void loadAllProjectInformation() {
        try {
            String sql = "SELECT * FROM project";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {

                allProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        allProjects.setItems(allProjectsData);
    }

    public void loadProjectsInformation(int projectCode ) {
        try {
            String sql = "SELECT * FROM project";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {

                allProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        allProjects.setItems(allProjectsData);
    }

    public void loadProjectsTaskInformation(int projectCode ) {
        try {
            String sql = "SELECT * FROM task where P_projectCode =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectCode);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {

                allTasksData.add(new Task(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        projectsTask.setItems(allTasksData);
    }



    public void start() {

        allProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                projectsTask.getItems().clear();
                loadProjectsTaskInformation(Integer.valueOf(allProjects.getSelectionModel().getSelectedItem().getProjCode()));
            }

        });

    }

    public void setAllProjectsInfoCellTable() {

        projectNumberColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
        projectNameColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));
    }

    public void setProjectsTaskInfoCellTable() {

        taskCodeColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskId"));
        taskNameColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskDescriptionColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskDescription"));
    }


}
