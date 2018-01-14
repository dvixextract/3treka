/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

//import com.mysql.jdbc.ResultSet;

import java.sql.ResultSet;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AdminViewController extends SucessfulCreateProjectViewController {

    /**
     * Initializes the controller class.
     */
    @FXML
    public TabPane AdminTabPane;

    @FXML
    private TableColumn<Projects, String> duration;

    @FXML
    private TableView<Projects> AllProjectsTable;

    @FXML
    private TableColumn<Projects, String> Project_Name;

    @FXML
    private TableColumn<Projects, String> Project_Code;

    @FXML
    private TableColumn<Projects, String> NumberOF_Sprints;

    @FXML
    private TableColumn<Projects, String> Num_Tasks;

    @FXML
    private TableColumn<Projects, String> TM_Assgn;

    @FXML
    private TableColumn<Projects, String> Project_Desc;

    @FXML
    private TextField ProjectSearch;

    @FXML
    private TableView<User> ListAllEmployees;

    @FXML
    private TableColumn<User, String> E_name;

    @FXML
    private TableColumn<User, String> E_surname;

    @FXML
    private TableColumn<User, String> E_type;

    @FXML
    private TableColumn<User, String> Acc_level;

    @FXML
    private TableColumn<User, String> R_ole;

    @FXML
    private TableColumn<User, String> P_hone;

    @FXML
    private TableColumn<User, String> E_mail;

    @FXML
    private TextField searchEmployee;

    @FXML
    private TextField teamname;

    @FXML
    private Button addResources;

    @FXML
    private Button saveTeam;
    
    @FXML
    private TableView<User> Employees;

    @FXML
    private TableColumn<User, String> EID;

    @FXML
    private TableColumn<User, String> Ename;

    @FXML
    private TableColumn<User, String> Erole;

    @FXML
    private Button createEmployee;

    @FXML
    private TableColumn<User, String> AccessLvl;

    @FXML
    private ListView<String> listvw;

    @FXML
    private TextField Projectname;

    @FXML
    private TextField TasksNumber;

    @FXML
    private TextField ProjectCode;

    @FXML
    private TextField SprintsNumber;

    @FXML
    private TextField CompleteProject;

    @FXML
    private ComboBox<String> AssignTeam;

    @FXML
    private TextArea ProjectDescription;

    @FXML
    private Button saveNewProject;

    @FXML
    private Label label;

    @FXML
    private ComboBox<String> projectSelectedCombobox;

    @FXML
    private ComboBox<String> createTaskSelectTeamCombobox;


    @FXML
    private GridPane newTaskGrid;

    @FXML
    private Label taskNumberLabel;

    @FXML
    private TextArea taskInformationTextArea;
    

    @FXML
    private TextField taskTimeFrameTextField;

    @FXML
    private ComboBox<String> assignTaskToTeamLeadCombobox;

    @FXML
    private Button addTasksButton;

    @FXML
    private Button saveTasksButton;


    @FXML
    private Label taskCompletionStatusLabel;

    @FXML
    private TextField taskNameTextBox;

    private String mmber;
    
      // Begining of Create Task UI Components  
    @FXML
    private Label taskNumberCreateTask;

    @FXML
    private Label taskStatusCreateTask;

    @FXML
    private TextField taskNameCreateTask;

    @FXML
    private DatePicker fromDateCreateTask;

    @FXML
    private DatePicker toDateCreateTask;

    @FXML
    private ComboBox<String> teamHeadComboBoxCreateTask;

    @FXML
    private TextArea taskInformationCreateTask;

    @FXML
    private Button AddNewTaskBtnCreateTask;

    @FXML
    private Button deleteTaskBtnCreateTask;
    
    @FXML
    private VBox vboxCreateTask;

    @FXML
    private HBox hboxCreateTask;
    
    @FXML
    private TableView<Task> createTaskTable;
    
    @FXML
    private TableColumn<Task, Integer> taskNumberCreateTaskColumn;

    @FXML
    private TableColumn<Task, String> taskStatusCreateTaskColumn;

    @FXML
    private TableColumn<Task, String> taskNameCreateTaskColumn;

    @FXML
    private TableColumn<Task, String> taskInformationCreateTaskColumn;

    @FXML
    private TableColumn<Task, String> fromDateCreateTaskColumn;

    @FXML
    private TableColumn<Task,String> toDateCreateTaskColumn;

    @FXML
    private TableColumn<Task, String> teamMemberAssignedCreateTaskColumn;
    
    @FXML
    private TableColumn<Task, Integer> timeSpanColumn;
    
    @FXML
    private TableColumn<Task,Integer> projectCodeColumnCreateTask;

   //End of Create Task UI Components 
    

    private ObservableList<User> masterData = FXCollections.observableArrayList();
    private ObservableList<User> AllUserData = FXCollections.observableArrayList();
    private ObservableList<Task> AllTaskData = FXCollections.observableArrayList();
    private ObservableList<Projects> AllProjectsData = FXCollections.observableArrayList();
    private ObservableList<User> filteredData = FXCollections.observableArrayList();
    private ObservableList<String> masterData3;
    ArrayList<String> Team_Members = new ArrayList<String>();
    ObservableList TeamList = FXCollections.observableArrayList();
    ObservableList ProjectList = FXCollections.observableArrayList();
    ObservableList<String> ClickOutput = FXCollections.observableArrayList();
    //ObservableList<String> SelectedTeamMembers = FXCollections.observableArrayList();
    ArrayList<String> SelectedTeamMembers = new ArrayList<String>();
    private int taskCount = 0;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    
    
    
    public AdminViewController() {

        try {
            connection = DBConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

//    
        masterData.add(new User("Dennis", "Masha", "Director", "Tier 3"));//test data
//
// String date = "2016-08-16";
//        LocalDate localDate = LocalDate.parse(date);
        
        // Initially add all data to filtered data
        filteredData.addAll(masterData);

        // Listen for changes in master data.
        // Whenever the master data changes we must also update the filtered data.
        masterData.addListener(new ListChangeListener<User>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends User> change) {
                updateFilteredData();
            }
        });

    }

    @FXML
    void handleSaveNewProjectAction(ActionEvent event) {
        CreateProject();
    }

    @FXML
    void handleButtonAction(ActionEvent event) {

        String TmNmae = teamname.getText().toString();
        if (TmNmae.isEmpty() || TmNmae == null) {
            DBConnection.infoBox("Unable to create a Team with empty team name", "Error", "Failure to create a Team");
        } else {

            String sql = " insert into Teams (Teamname, Members)"
                    + " values (?, ?)";

            try {

                Iterator teamdata = SelectedTeamMembers.iterator();

                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, TmNmae);

                //  while(teamdata.hasNext()){  
                preparedStatement.setString(2, (String) teamdata.next());
                preparedStatement.execute();
                // }
                DBConnection.infoBox("Team created Successfull", "Success", null);

            } catch (Exception e) {
                DBConnection.infoBox("Error Saving Data", "Fail", null);
                e.printStackTrace();
            }
        }
    }

    @FXML
    void handleCreateEmployee(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("NewUserView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());//next page size
            Stage stage = new Stage();
            stage.setTitle("Creaate Employee");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }

    }

    @FXML
    void handleViewTeams(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("TeamsView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());//next page size
            Stage stage = new Stage();
            stage.setTitle("View Teams");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }
    }

    @FXML
    void handleAddResourcesButton(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("ResourcesView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());//next page size
            Stage stage = new Stage();
            stage.setTitle("Edit Member Resources");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            DBConnection.infoBox("Error Opening Edit Resources Page", "Fail", null);
            e.printStackTrace();
        }
    }

    public void setMember(String mmber) {

        this.mmber = mmber;
    }

    public String getMember() {

        return mmber;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the person table


        Mediator.getInstance().register(s -> {
            switch (s) {
                case "createTask":
                    AdminTabPane.getSelectionModel().select(3);
                    break;
            }
        });


        setCellTable();
        setAllUserInfoCellTable();
        setAllProjectsInfoCellTable();
        loadDataFromDatabase();
        loadAllUserInformation();
        loadAllProjectsInformation();
        setAllUserNewTaskInfoCellTable();
        AssignTeam.setItems(TeamList);
        projectSelectedCombobox.setItems(ProjectList);

        // Add filtered data to the table
        Employees.setItems(filteredData);
        //listvw.setItems();
        // Listen for text changes in the filter text field
        searchEmployee.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                                String oldValue, String newValue) {

                updateFilteredData();
            }
        });
        start();

    tabChange();
    


    }


    public void tabChange() {

        AdminTabPane.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
            taskNumberCreateTask.setText("");
            projectSelectedCombobox.getItems().clear();
            teamHeadComboBoxCreateTask.getItems().clear();
            createTaskSelectTeamCombobox.getItems().clear();
            AssignTeam.getItems().clear();
            //loadTeamsDataFromDatabase();
            loadTeamsDataFromfDatabase() ;
            loadProjectsDataFromDatabase();
            loadTeamLeadDataFromDatabase();
        });

    }

    public void start() {

        Employees.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                System.out.println("user selected information -------------->>");
                System.out.println(Employees.getSelectionModel().getSelectedItem().getName());
                System.out.println(Employees.getSelectionModel().getSelectedItem().getSurName());
                System.out.println(Employees.getSelectionModel().getSelectedItem().getROLE());
                System.out.println(Employees.getSelectionModel().getSelectedItem().getUserID());
                Team_Members.add(Employees.getSelectionModel().getSelectedItem().getName());
                setMember(Employees.getSelectionModel().getSelectedItem().getName());
                SelectedTeamMembers.add(Employees.getSelectionModel().getSelectedItem().getUserID());
                ClickOutput.add(Employees.getSelectionModel().getSelectedItem().getName() + ":\t  " + Employees.getSelectionModel().getSelectedItem().getROLE());
                listvw.setItems(ClickOutput);
            }

        });

    }

    // public void startArra() {
//
//for(int i=0;i<Team_Members.size();i++){
//    System.out.println(Team_Members.get(i));
//} 
//}
//     
    public String onEdit() {
        // check the table's selected item and get selected item
        String sur_name = "";
        String na_me = "";
        String full_name = "";
        if (Employees.getSelectionModel().getSelectedItem() != null) {
            User selectedPerson = Employees.getSelectionModel().getSelectedItem();
            na_me = (selectedPerson.getName());
            sur_name = (selectedPerson.getSurName());

            full_name = na_me + "_" + sur_name;
        } else {
            full_name = "";
        }
        return full_name;
    }

    public void setCellTable() {

        EID.setCellValueFactory(new PropertyValueFactory<User, String>("surName"));
        Ename.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        Erole.setCellValueFactory(new PropertyValueFactory<User, String>("ROLE"));
        AccessLvl.setCellValueFactory(new PropertyValueFactory<User, String>("ACCESSLEVEL"));
    }

    public void loadDataFromDatabase() {

        try {
            String sql = "SELECT * FROM Users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                masterData.add(new User("" + resultSet.getString(4), "" + resultSet.getString(3), "" + resultSet.getString(8), "" + resultSet.getString(9), "" + resultSet.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Employees.setItems(masterData);
    }

    public void setAllUserInfoCellTable() {

        E_name.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        E_surname.setCellValueFactory(new PropertyValueFactory<User, String>("surName"));
        E_type.setCellValueFactory(new PropertyValueFactory<User, String>("EMPLOYEETYPE"));
        Acc_level.setCellValueFactory(new PropertyValueFactory<User, String>("ACCESSLEVEL"));
        R_ole.setCellValueFactory(new PropertyValueFactory<User, String>("ROLE"));
        P_hone.setCellValueFactory(new PropertyValueFactory<User, String>("PHone"));
        E_mail.setCellValueFactory(new PropertyValueFactory<User, String>("email"));
    }

    public void loadAllUserInformation() {

        try {
            String sql = "SELECT * FROM Users";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                //AllUserData.add(new User (resultSet.getString(3),""+resultSet.getString(5),""+resultSet.getString(6),""+resultSet.getString(8) ));
                AllUserData.add(new User(resultSet.getString(3), resultSet.getString(4), "" + resultSet.getString(10), "" + resultSet.getString(9), "" + resultSet.getString(8), "" + resultSet.getString(6), "" + resultSet.getString(5)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListAllEmployees.setItems(AllUserData);
    }

    public void setAllProjectsInfoCellTable() {

        Project_Name.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjName"));
        Project_Code.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjCode"));
        NumberOF_Sprints.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjNumOfSprints"));
        Num_Tasks.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjNumOfTasks"));
        TM_Assgn.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjTeam"));
        Project_Desc.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjDescriptions"));
        duration.setCellValueFactory(new PropertyValueFactory<Projects, String>("ProjDuration"));

    }

    public void loadAllProjectsInformation() {

        try {
            String sql = "SELECT * FROM Project";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                AllProjectsData.add(new Projects(resultSet.getString(1), resultSet.getString(2), "" + resultSet.getString(3), "" + resultSet.getString(4), "" + resultSet.getString(5), "" + resultSet.getString(6), "" + resultSet.getString(7)));
                projectSelectedCombobox.getItems().add(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AllProjectsTable.setItems(AllProjectsData);
    }

    public void loadTeamsDataFromfDatabase() {

        try {
            String sql = "SELECT * FROM Teams ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                AssignTeam.getItems().add(resultSet.getString(1));
                createTaskSelectTeamCombobox.getItems().add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //to load data into projects combo-box, on the taskss tab.
    public void loadProjectsDataFromDatabase() {

        try {
            String sql = "SELECT * FROM project ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                projectSelectedCombobox.getItems().add(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadTeamLeadDataFromDatabase() {

        try {
            String sql = "SELECT * FROM users where Role = 'Team Lead' ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {

                teamHeadComboBoxCreateTask.getItems().add(resultSet.getString(2) + " " + resultSet.getString(3));
                //taskNumberCreateTask.setText(Integer.valueOf(getTotalNumberOfTasks() + 1).toString());
                taskStatusCreateTask.setText("Incomplete");

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getTotalNumberOfTasks() {

        try {
            String sql = "SELECT * FROM task";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            
            System.out.println("****************"+resultSet.getFetchSize());
            return resultSet.getFetchSize();
            
           
        } catch (SQLException ex) {
            //Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }

    }

    private int getProjectId(String projectName) {
        try {
            String sql = "SELECT * FROM project where P_name =?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, projectName);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            resultSet.next();

            return resultSet.getInt(1);

        } catch (SQLException ex) {
            //Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }


    public void createTask() {

        int taskNumber = Integer.parseInt(taskNumberCreateTask.getText());
        String taskName = taskNameCreateTask.getText();
        String taskStatus = taskStatusCreateTask.getText();
        String taskcompletionTime = taskTimeFrameTextField.getText();
        int projectId = getProjectId(projectSelectedCombobox.getValue());
        String taskDescription = taskInformationCreateTask.getText();
        String teamLead = teamHeadComboBoxCreateTask.getValue();

        String sql = " insert into Task (T_id, T_name, T_timespan, P_projectCode, T_status, T_Description, T_lead)"
                + " values (?, ?, ?, ?, ?,?,?)";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, taskNumber);
            preparedStatement.setString(2, taskName);
            preparedStatement.setString(3, taskcompletionTime);
            preparedStatement.setInt(4, projectId);
            preparedStatement.setString(5, taskStatus);
            preparedStatement.setString(6, taskDescription);
            preparedStatement.setString(7, teamLead);
            try {
                preparedStatement.execute();
                //Enter code for showing sucess view
                //DBConnection.infoBox("Project created Successfull", "Success", null);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("SucessfulCreateProjectView.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Success");
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    DBConnection.infoBox("Error Unable to Open View", "Fail", null);
                    e.printStackTrace();
                }


            } catch (Exception e) {
                DBConnection.infoBox("Error Saving Data", "Fail", null);
                e.printStackTrace();
            }

        } catch (Exception e) {
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }

    }

    public void CreateProject() {

        String textProjectName = Projectname.getText().toString();
        int textProjectCode = Integer.parseInt(SprintsNumber.getText());
        int textNumberOfSprints = Integer.parseInt(SprintsNumber.getText());
        int textNumerOfTasks = Integer.parseInt(TasksNumber.getText());
        String textProjectDescription = ProjectDescription.getText().toString();
        String textProjectTimeToComplete = CompleteProject.getText().toString();
        String assignTeam = AssignTeam.getValue();

        String sql = " insert into Project (P_code, P_name, P_timespan, NumTasks, NumSprints, P_Desc,P_AsgnTeam)"
                + " values (?, ?, ?, ?, ?,?,?)";

        try {

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, textProjectCode);
            preparedStatement.setString(2, textProjectName);
            preparedStatement.setString(3, textProjectTimeToComplete);
            preparedStatement.setInt(4, textNumerOfTasks);
            preparedStatement.setInt(5, textNumberOfSprints);
            preparedStatement.setString(6, textProjectDescription);
            preparedStatement.setString(7, assignTeam);
            try {
                preparedStatement.execute();
                //Enter code for showing sucess view
                //DBConnection.infoBox("Project created Successfull", "Success", null);
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("SucessfulCreateProjectView.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Success");
                    stage.setScene(scene);
                    stage.show();

                } catch (Exception e) {
                    DBConnection.infoBox("Error Unable to Open View", "Fail", null);
                    e.printStackTrace();
                }


            } catch (Exception e) {
                DBConnection.infoBox("Error Saving Data", "Fail", null);
                e.printStackTrace();
            }

        } catch (Exception e) {
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }

    }

    /**
     * Updates the filteredData to contain all data from the masterData that
     * matches the current filter.
     */
    private void updateFilteredData() {
        filteredData.clear();

        for (User p : masterData) {
            if (matchesFilter(p)) {
                filteredData.add(p);
            }
        }

        // Must re-sort table after items changed
        reapplyTableSortOrder();
    }

    /**
     * Returns true if the person matches the current filter. Lower/Upper case
     * is ignored.
     *
     * @param person
     * @return
     */
    private boolean matchesFilter(User person) {
        String filterString = searchEmployee.getText();
        if (filterString == null || filterString.isEmpty()) {
            // No filter --> Add all.
            return true;
        }

        String lowerCaseFilterString = filterString.toLowerCase();

        if (person.getName().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        } else if (person.getSurName().toLowerCase().indexOf(lowerCaseFilterString) != -1) {
            return true;
        }

        return false; // Does not match
    }

    private void reapplyTableSortOrder() {
        ArrayList<TableColumn<User, ?>> sortOrder = new ArrayList<>(Employees.getSortOrder());
        Employees.getSortOrder().clear();
        Employees.getSortOrder().addAll(sortOrder);
    }

    
    
    public void setAllUserNewTaskInfoCellTable() {

        taskNumberCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task,Integer>("taskNumber"));
        fromDateCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskFromDate"));
        toDateCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task,String>("taskToDate"));
        
        taskStatusCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskStatus"));
        taskNameCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskName"));
        teamMemberAssignedCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskTeamMemberAssigned"));
        taskInformationCreateTaskColumn.setCellValueFactory(new PropertyValueFactory<Task, String>("taskInformation"));
        timeSpanColumn.setCellValueFactory(new PropertyValueFactory<Task, Integer>("taskToDate"));
        projectCodeColumnCreateTask.setCellValueFactory(new PropertyValueFactory<Task, Integer>("projectCode"));
    }
    
    private int timeSpan(){
        int toFromDateTime = 0;
//        LocalDateTime tempDateTime = LocalDateTime.from( fromDateCreateTask.getValue());
//        int days = (int) tempDateTime.until( toDateCreateTask.getValue(), ChronoUnit.DAYS);
//        tempDateTime = tempDateTime.plusDays( days );
//       // toFromDateTime = tempDateTime;
    return toFromDateTime;
    }
    
    @FXML
    void handleAddTasksButtonAction(ActionEvent event) {

//
//        AllTaskData.add(new Task(  Integer.parseInt(taskNumberCreateTask.getText()), taskStatusCreateTask.getText(), fromDateCreateTask.getValue(), 
//                toDateCreateTask.getValue(), (String) teamHeadComboBoxCreateTask.getValue(), taskInformationCreateTask.getText(), getProjectId(projectSelectedCombobox.getValue()) ));
//        
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String datTo = df.format(toDateCreateTask.getValue());
//        String datFrom = df.format(fromDateCreateTask.getValue());

        AllTaskData.add(new Task(
                Integer.parseInt(taskNumberCreateTask.getText()),
                taskNameCreateTask.getText(),
                getProjectId(projectSelectedCombobox.getValue()),
                taskStatusCreateTask.getText(),
                taskInformationCreateTask.getText(), 
                (String) teamHeadComboBoxCreateTask.getValue(),
//                fromDateCreateTask.getValue().toString(),
//                toDateCreateTask.getValue().toString(),
//                fromDateCreateTask.getEditor().getText(),
//                toDateCreateTask.getEditor().getText(),
                timeSpan()));
         createTaskTable.setItems(AllTaskData);
    }

    @FXML
    void handleSaveTasksButtonAction(ActionEvent event) {
        //createTask();
        createMultipleTasks() ;
    }
 
    
   //Create Task UI Components 
     
    
    
    @FXML
    void handleDeleteTaskAction(ActionEvent event) {

    }
    
    
    void addTaskToTable(){
    
//        AllTaskData.add(new Task(  Integer.parseInt(taskNumberCreateTask.getText()), taskStatusCreateTask.getText(), 
//        taskNameCreateTask.getText(), fromDateCreateTask.getValue(), 
//        toDateCreateTask.getValue(), (String) teamHeadComboBoxCreateTask.getValue(), taskInformationCreateTask.getText(),getProjectId(projectSelectedCombobox.getValue()) ));
        
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String datTo = df.format(toDateCreateTask.getValue());
//        String datFrom = df.format(fromDateCreateTask.getValue());
        
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy", Locale.getDefault());
//                String convertedDate= formatter.format(date3);




        AllTaskData.add(new Task(
                Integer.parseInt(taskNumberCreateTask.getText()),
                taskNameCreateTask.getText(),
                getProjectId(projectSelectedCombobox.getValue()),
                taskStatusCreateTask.getText(),
                taskInformationCreateTask.getText(), 
                (String) teamHeadComboBoxCreateTask.getValue(),
//                fromDateCreateTask.getEditor().getText(),
//                toDateCreateTask.getEditor().getText(),
                timeSpan()));
         createTaskTable.setItems(AllTaskData);
         
        taskNameCreateTask.clear();
//        fromDateCreateTask.getEditor().clear();
//        toDateCreateTask.getEditor().clear();
        teamHeadComboBoxCreateTask.setValue("Team Lead");
        taskInformationCreateTask.clear();
        taskCount++;
         
        taskNumberCreateTask.setText(Integer.valueOf(getTotalNumberOfTasks() + 1+taskCount).toString());
         
    }

    @FXML
    void handleAddNewTaskAction(ActionEvent event) {
        
        if (taskNameCreateTask.getText()==null || taskNameCreateTask.getText()==" " || taskNameCreateTask.getText().isEmpty() ||
         
            teamHeadComboBoxCreateTask.getValue() == null || teamHeadComboBoxCreateTask.getValue().isEmpty() || teamHeadComboBoxCreateTask.getValue() == "Team Lead" ||
            taskInformationCreateTask.getText() == null || taskInformationCreateTask.getText().isEmpty() || taskInformationCreateTask.getText() == " "
                ){
          DBConnection.infoBox("Please enter text in missing fields", "Error Adding Data", "nil");
        }else{
            
        addTaskToTable();
        
        }
    }

    public void createMultipleTasks() {

        String sql = " insert into Task (T_id, T_name, P_projectCode, T_status, T_Description, T_lead,T_startDate,T_endDate,T_timespan)"
                + " values (?, ?, ?, ?, ?,?,?,?,?)";

        if(AllTaskData.isEmpty() || AllTaskData == null){
        DBConnection.infoBox("Error Saving Data", "Fail", null);
        } else{
          
          try {
            

            
            for(Task userTasks: AllTaskData){
              
            int taskNumber = userTasks.getTaskNumber();
            String taskName = userTasks.getTaskName();
            String taskStatus = userTasks.getTaskStatus();
            String taskDescription = userTasks.getTaskInformation();
            String teamLead = userTasks.getTaskTeamMemberAssigned();
            String startingDate = userTasks.getTaskFromDate();
            String endingingDate = userTasks.getTaskToDate();
            int taskcompletionTime = userTasks.getTaskTimeSpan();
            int projectId = userTasks.getProjectCode();//getProjectId(projectSelectedCombobox.getValue());
        
        

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, taskNumber);
            preparedStatement.setString(2, taskName);
            preparedStatement.setInt(3, projectId);
            preparedStatement.setString(4, taskStatus);
            preparedStatement.setString(5, taskDescription);
            preparedStatement.setString(6, teamLead);
            preparedStatement.setString(7, startingDate);
            preparedStatement.setString(8,endingingDate);
            preparedStatement.setInt(9, taskcompletionTime);
            
            try{
            preparedStatement.execute();
            }catch (Exception e) {
                    DBConnection.infoBox("Error Saving Data", "Fail", null);
                    e.printStackTrace();
                }
            }
                try {
                 DBConnection.infoBox("Click ok to cancel this message", "Sucess", "Saving of tasks has been successfull");

                } catch (Exception e) {
                    DBConnection.infoBox("Error Unable to Open View", "Fail", null);
                    e.printStackTrace();
                }

        } catch (Exception e) {
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }
        }


    }
    

}
