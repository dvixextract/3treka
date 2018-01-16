/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
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
import org.apache.commons.lang3.time.StopWatch;

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
    private TableColumn<TaskProject, String> projectNumberColumnTimeSheetTable;

    @FXML
    private TableColumn<TaskProject, String> projectNameColumnTimeSheetTable;

    @FXML
    private TableColumn<TaskProject, String> taskCodeColumnTimeSheetTable;

    @FXML
    private TableColumn<TaskProject, String> taskNameColumnTimeSheetTable;

    @FXML
    private TableColumn<TaskProject, String> taskDescriptionColumnTimeSheetTable;

    @FXML
    private TableColumn<TaskProject, String> statusColumnTimesheetTable;

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
    private TableColumn<TaskEvent, String> allTaskNumber;

    @FXML
    private TableColumn<TaskEvent, String> allProjectNumber;

    @FXML
    private TableColumn<TaskEvent, String> allTaskDate;

    @FXML
    private TableColumn<TaskEvent, String> allTaskDuration;

    @FXML
    private TableColumn<TaskEvent, String> todayTaskNumber;

    @FXML
    private TableColumn<TaskEvent, String> todayProjectNumber;

    @FXML
    private TableColumn<TaskEvent, String> todayTaskDate;

    @FXML
    private TableColumn<TaskEvent, String> todayTaskDuration;

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

    @FXML
    private TableView<TaskProject> taskTimeSheets;


    @FXML
    private TableView<Projects> projectsSheet;

    @FXML
    private TableView<Task> taskTimeSheet;

    @FXML
    private TableView<TaskEvent> allTimeSheets;

    @FXML
    private TableView<TaskEvent> todayTimeSheets;

    @FXML
    private TableView<TaskProject> granularSheet;


    private ObservableList<Projects> allProjectsData = FXCollections.observableArrayList();

    private ObservableList<Task> allTasksData = FXCollections.observableArrayList();

    private ObservableList<TaskProject> taskTimeSheetsData = FXCollections.observableArrayList();

    private ObservableList<TaskEvent> allTaskEventsData = FXCollections.observableArrayList();

    private ObservableList<TaskEvent> todayTaskEventsData = FXCollections.observableArrayList();


    private StopWatch stopWatch = new StopWatch();

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
        if (stopWatch.isStarted() && taskTimeSheets.getSelectionModel().getSelectedItem() != null) {
            saveDetails();
            stopWatch.stop();
            stopWatch.reset();
            int projectNumber = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getProjectNumber()));
            String projectName = taskTimeSheets.getSelectionModel().getSelectedItem().getProjectName();
            int taskCode = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getTaskCode()));
            String taskName = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskName();
            String taskDescription = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskDescription();
            String presentStatus = "STOPPED";
            taskTimeSheets.getItems().clear();
            taskTimeSheetsData.add(new TaskProject(projectNumber, projectName, taskCode, taskName, taskDescription, presentStatus));
            taskTimeSheets.setItems(taskTimeSheetsData);
        } else {
            DBConnection.infoBox("Error please select an ongoing task", "Select task", null);
        }

    }

    private void saveDetails() {

        int projectNumber = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getProjectNumber()));
        int taskCode = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getTaskCode()));
        long duration = stopWatch.getTime(TimeUnit.MINUTES);

        String sql = " insert into task_event (project_num, task_num, duration, task_event_date)"
                + " values (?, ?, ?, ?)";
        java.util.Date date = new java.util.Date();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectNumber);
            preparedStatement.setInt(2, taskCode);
            preparedStatement.setLong(3, duration);
            preparedStatement.setDate(4, new java.sql.Date(date.getTime()));
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleStartButtonEventAction(ActionEvent event) {

        if (!stopWatch.isStarted() && taskTimeSheets.getSelectionModel().getSelectedItem() != null) {
            stopWatch.start();
            int projectNumber = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getProjectNumber()));
            String projectName = taskTimeSheets.getSelectionModel().getSelectedItem().getProjectName();
            int taskCode = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getTaskCode()));
            String taskName = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskName();
            String taskDescription = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskDescription();
            String presentStatus = "RUNNING";
            taskTimeSheets.getItems().clear();
            taskTimeSheetsData.add(new TaskProject(projectNumber, projectName, taskCode, taskName, taskDescription, presentStatus));
            taskTimeSheets.setItems(taskTimeSheetsData);
        } else {
            DBConnection.infoBox("Error please select a stopped task", "Select task", null);
        }
    }

    @FXML
    void pauseButtonEventAction(ActionEvent event) {

        if (stopWatch.isStarted() && taskTimeSheets.getSelectionModel().getSelectedItem() != null) {
            stopWatch.suspend();
            int projectNumber = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getProjectNumber()));
            String projectName = taskTimeSheets.getSelectionModel().getSelectedItem().getProjectName();
            int taskCode = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getTaskCode()));
            String taskName = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskName();
            String taskDescription = taskTimeSheets.getSelectionModel().getSelectedItem().getTaskDescription();
            String presentStatus = "PAUSED";
            taskTimeSheets.getItems().clear();
            taskTimeSheetsData.add(new TaskProject(projectNumber, projectName, taskCode, taskName, taskDescription, presentStatus));
            taskTimeSheets.setItems(taskTimeSheetsData);
        } else {
            DBConnection.infoBox("Error please select a running task", "Select task", null);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setProjectsTaskInfoCellTable();
        setAllProjectsInfoCellTable();
        setTaskSheetInfoCellTable();
        setTimeSheetsInfoCellTable();
        setTodayTimeSheetInfoCellTable();
        loadAllProjectInformation();
        loadAllUserTimeSheets();
        loadTodayUserTimeSheets();
        start();
    }

    private void loadAllUserTimeSheets() {
        try {
            String sql = "SELECT * FROM task_event";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {
                allTaskEventsData.add(new TaskEvent(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        allTimeSheets.setItems(allTaskEventsData);
    }

    private void loadTodayUserTimeSheets() {
        java.util.Date date = new java.util.Date();
        try {
            String sql = "SELECT * FROM task_event where task_event_date =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, new java.sql.Date(date.getTime()));
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {
                todayTaskEventsData.add(new TaskEvent(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        todayTimeSheets.setItems(todayTaskEventsData);
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

    public void loadProjectsInformation(int projectCode) {
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

    public void loadProjectsTaskInformation(int projectCode) {
        try {
            String sql = "SELECT * FROM task where P_projectCode =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectCode);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {
                allTasksData.add(new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
        projectsTask.setItems(allTasksData);
    }

    public void loadtaskTimeSheetsData(int taskCode) {
        try {
            String sql = "SELECT * FROM task where T_id =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, taskCode);
            resultSet = (ResultSet) preparedStatement.executeQuery();

            while (resultSet.next()) {
                taskTimeSheetsData.add(new TaskProject(resultSet.getInt(4), "Test", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(6), "STOPED"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

        taskTimeSheets.setItems(taskTimeSheetsData);
    }


    public void start() {
        allProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                projectsTask.getItems().clear();
                loadProjectsTaskInformation(Integer.valueOf(allProjects.getSelectionModel().getSelectedItem().getProjCode()));
            }
        });

        projectsTask.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                taskTimeSheets.getItems().clear();
                loadtaskTimeSheetsData(Integer.valueOf(projectsTask.getSelectionModel().getSelectedItem().getTaskNumber()));
            }
        });
    }

    public void setAllProjectsInfoCellTable() {

        projectNumberColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
        projectNameColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));
    }

    public void setProjectsTaskInfoCellTable() {

        taskCodeColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskNumber"));
        taskNameColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        taskDescriptionColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskInformation"));
    }

    private void setTaskSheetInfoCellTable() {

        projectNumberColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("projectNumber"));
        projectNameColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("projectName"));
        taskCodeColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskCode"));
        taskNameColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskName"));
        taskDescriptionColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskDescription"));
        statusColumnTimesheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("presentStatus"));
    }

    private void setTimeSheetsInfoCellTable() {
        allTaskNumber.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("taskNumber"));
        allProjectNumber.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("projectNumber"));
        allTaskDate.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("date"));
        allTaskDuration.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("duration"));
    }

    private void setTodayTimeSheetInfoCellTable() {
        todayTaskNumber.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("taskNumber"));
        todayProjectNumber.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("projectNumber"));
        todayTaskDate.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("date"));
        todayTaskDuration.setCellValueFactory(new PropertyValueFactory<TaskEvent, String>("duration"));
    }
}
