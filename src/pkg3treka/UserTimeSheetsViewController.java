///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pkg3treka;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Iterator;
//import java.util.ResourceBundle;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.ListView;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import org.apache.commons.lang3.time.StopWatch;
//
///**
// * @author User
// */
//public class UserTimeSheetsViewController implements Initializable {
//
//    @FXML
//    private TableColumn<?, ?> projectCodeColumnProjectListTable;
//
//    @FXML
//    private TableColumn<?, ?> projectNameColumnProjectListTable;
//
//    @FXML
//    private TableColumn<?, ?> taskCodeColumnProjectListTable;
//
//    @FXML
//    private TableColumn<?, ?> taskNameColumnProjectListTable;
//
//    @FXML
//    private ListView<?> teamMemberOfListview;
//
//    @FXML
//    private TableColumn<TaskProject, String> projectNumberColumnTimeSheetTable;
//
//    @FXML
//    private TableColumn<TaskProject, String> projectNameColumnTimeSheetTable;
//
//    @FXML
//    private TableColumn<TaskProject, String> taskCodeColumnTimeSheetTable;
//
//    @FXML
//    private TableColumn<TaskProject, String> taskNameColumnTimeSheetTable;
//
//    @FXML
//    private TableColumn<TaskProject, String> taskDescriptionColumnTimeSheetTable;
//
//    @FXML
//    private TableColumn<TaskProject, String> dayColumnTimesheetTable;
//
//    @FXML
//    private TableColumn<Projects, String> projectNumberColumnTableProject;
//
//    @FXML
//    private TableColumn<Projects, String> projectNameColumnTableProject;
//
//    @FXML
//    private TableColumn<Task, String> taskCodeColumnTableTask;
//
//    @FXML
//    private TableColumn<Task, String> taskNameColumnTableTask;
//
//    @FXML
//    private TableColumn<Task, String> taskDescriptionColumnTableTask;
//
//    @FXML
//    private Button startBtn;
//
//    @FXML
//    private Button pauseBtn;
//
//    @FXML
//    private Button closeBtn;
//
//    @FXML
//    private TableView<Task> projectsTask;
//
//    @FXML
//    private TableView<Projects> allProjects;
//
//    @FXML
//    private TableView<TaskProject> taskTimeSheets;
//
//
//    @FXML
//    private TableView<Projects> projectsSheet;
//
//    @FXML
//    private TableView<Task> taskTimeSheet;
//
//    @FXML
//    private TableView<TaskProject> granularSheet;
//
//
//    private ObservableList<Projects> allProjectsData = FXCollections.observableArrayList();
//
//    private ObservableList<Task> allTasksData = FXCollections.observableArrayList();
//
//    private ObservableList<TaskProject> taskTimeSheetsData = FXCollections.observableArrayList();
//
//    private StopWatch stopWatch = new StopWatch();
//
//    Connection connection = null;
//    PreparedStatement preparedStatement = null;
//    ResultSet resultSet = null;
//
//    public UserTimeSheetsViewController() {
//
//        try {
//            connection = DBConnection.getConnection();
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @FXML
//    void closeButtonEventAction(ActionEvent event) {
//        if (stopWatch.isStarted()) {
//            stopWatch.stop();
//        }
//        saveDetails();
//    }
//
//    private void saveDetails() {
//
//        int projectNumber = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getProjectNumber()));
//        int taskCode = (Integer.valueOf(taskTimeSheets.getSelectionModel().getSelectedItem().getTaskCode()));
//        long duration = stopWatch.getTime(TimeUnit.MINUTES);
//
//        String sql = " insert into task_event (project_num, task_num, duration)"
//                + " values (?, ?, ?)";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, projectNumber);
//            preparedStatement.setInt(2, taskCode);
//            preparedStatement.setLong(3, duration);
//            preparedStatement.execute();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void handleStartButtonEventAction(ActionEvent event) {
//
//        if (!stopWatch.isStarted()) {
//            stopWatch.start();
//        }
//    }
//
//    @FXML
//    void pauseButtonEventAction(ActionEvent event) {
//
//        if (stopWatch.isStarted()) {
//            stopWatch.suspend();
//        }
//
//    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        setProjectsTaskInfoCellTable();
//        setAllProjectsInfoCellTable();
//        setTaskSheetInfoCellTable();
//        loadAllProjectInformation();
//        start();
//    }
//
//    public void loadAllProjectInformation() {
//        try {
//            String sql = "SELECT * FROM project";
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = (ResultSet) preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                allProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex);
//        }
//        allProjects.setItems(allProjectsData);
//    }
//
//    public void loadProjectsInformation(int projectCode) {
//        try {
//            String sql = "SELECT * FROM project";
//            preparedStatement = connection.prepareStatement(sql);
//            resultSet = (ResultSet) preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                allProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex);
//        }
//        allProjects.setItems(allProjectsData);
//    }
//
//    public void loadProjectsTaskInformation(int projectCode) {
//        try {
//            String sql = "SELECT * FROM task where P_projectCode =?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, projectCode);
//            resultSet = (ResultSet) preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                allTasksData.add(new Task(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(6)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex);
//        }
//
//        projectsTask.setItems(allTasksData);
//    }
//
//    public void loadtaskTimeSheetsData(int taskCode) {
//        try {
//            String sql = "SELECT * FROM task where T_id =?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setInt(1, taskCode);
//            resultSet = (ResultSet) preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//
//                taskTimeSheetsData.add(new TaskProject(resultSet.getInt(4), "Test", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(6)));
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//            throw new RuntimeException(ex);
//        }
//
//        taskTimeSheets.setItems(taskTimeSheetsData);
//    }
//
//
//    public void start() {
//
//        allProjects.setOnMouseClicked(new EventHandler<MouseEvent>() {
//
//            @Override
//            public void handle(MouseEvent event) {
//                projectsTask.getItems().clear();
//                loadProjectsTaskInformation(Integer.valueOf(allProjects.getSelectionModel().getSelectedItem().getProjCode()));
//            }
//
//        });
//
//        projectsTask.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                taskTimeSheets.getItems().clear();
//                loadtaskTimeSheetsData(Integer.valueOf(projectsTask.getSelectionModel().getSelectedItem().getTaskId()));
//            }
//        });
//
//    }
//
//    public void setAllProjectsInfoCellTable() {
//
//        projectNumberColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
//        projectNameColumnTableProject.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));
//    }
//
//    public void setProjectsTaskInfoCellTable() {
//
//        taskCodeColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskId"));
//        taskNameColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
//        taskDescriptionColumnTableTask.setCellValueFactory(new PropertyValueFactory<Task, String>("taskDescription"));
//    }
//
//    private void setTaskSheetInfoCellTable() {
//
//        projectNumberColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("projectNumber"));
//        projectNameColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("projectName"));
//        taskCodeColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskCode"));
//        taskNameColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskName"));
//        taskDescriptionColumnTimeSheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskDescription"));
////        dayColumnTimesheetTable.setCellValueFactory(new PropertyValueFactory<TaskProject, String>("taskDescription"));
//    }
//
//
//}
