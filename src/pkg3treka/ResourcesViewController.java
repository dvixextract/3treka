/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import com.mysql.jdbc.ResultSet;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ResourcesViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<MemberAccessInfo> rolesTable;   
    
    @FXML
    private TableView<UserType> employeeTypeTable;
    
    @FXML
    private TableView<UserAccess> accessLevelTable;
    
    @FXML
    private TextField newRoleTextField;

    @FXML
    private TextField newEmployeeTextField;

    @FXML
    private TextField newAccessLevelTextField;

    @FXML
    private TextArea accessLevelTextArea;

    @FXML
    private TableColumn<MemberAccessInfo, String> roleID;

    @FXML
    private TableColumn<MemberAccessInfo, String> roleInfoColumn;

    @FXML
    private TableColumn<UserType, String> employeeTypeID;

    @FXML
    private TableColumn<UserType, String> employeeTypeInfoColumn;

    @FXML
    private TableColumn<UserAccess, String> accessLevelID;

    @FXML
    private TableColumn<UserAccess, String> accessLevelInfo;

    @FXML
    private TextArea roleTextArea;

    @FXML
    private TextArea employeeTypeTextArea;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    com.mysql.jdbc.ResultSet resultSet = null;
 
    ObservableList<MemberAccessInfo> RoleInfoData = FXCollections.observableArrayList();
    ObservableList<UserAccess> AccessInfoData = FXCollections.observableArrayList();
    ObservableList<UserType> EmployementTypeInfoData = FXCollections.observableArrayList();

    void OpenConnection() throws ClassNotFoundException{
       
            try {
                connection = DBConnection.getConnection();
            } catch (SQLException ex) {
                Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
       
    }
    
    void CloseConnection(){
    
          try {
              connection.close();
          } catch (SQLException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    @FXML
    void handleSaveRoleButton(ActionEvent event) {
          try {
              OpenConnection();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        if(newRoleTextField.getText().isEmpty() || newRoleTextField.getText() == null
                || roleTextArea.getText().isEmpty()|| roleTextArea.getText() == null ){
                DBConnection.infoBox("Please enter details in the textfield  ", "Fail", null);
        }else{
        

        String textFieldRole = newRoleTextField.getText();
        String textAreaRole = roleTextArea.getText();
        
        String sql = " insert into UserRole (Role, RoleInfo)" + " values (?, ?)";
        
            try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, textFieldRole);
        preparedStatement.setString(2, textAreaRole);

        try{
            preparedStatement.execute();
            DBConnection.infoBox("New User Role Created Successfull", "Success", null);
            } catch(Exception e){
              DBConnection.infoBox("Error Saving Data", "Fail", null);
              e.printStackTrace();
        }


        }catch(Exception e){
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }

            CloseConnection();
        }
    }
    
    @FXML
    void handleSaveAccessLevelButton(ActionEvent event) {
        
        try {
              OpenConnection();
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newAccessLevelTextField.getText().isEmpty() || newAccessLevelTextField.getText() == null
                || accessLevelTextArea.getText().isEmpty() || accessLevelTextArea.getText() == null ){
                DBConnection.infoBox("Please enter details in the textfield  ", "Fail", null);
        }else{
        

        String textFieldAccessLevel = newAccessLevelTextField.getText();
        String textAreaAccessLevelInfo = accessLevelTextArea.getText();
        
        String sql = " insert into UserAccessLevel (AccessLevel, AccessLevelInfo)" + " values (?, ?)";
        
            try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, textFieldAccessLevel);
        preparedStatement.setString(2, textAreaAccessLevelInfo);

        try{
            preparedStatement.execute();
            DBConnection.infoBox("New Access Level Created Successfull", "Success", null);
            } catch(Exception e){
              DBConnection.infoBox("Error Saving Data", "Fail", null);
              e.printStackTrace();
        }


        }catch(Exception e){
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }
            CloseConnection();
        }
    }

    @FXML
    void handleSaveEmployeeTypeButton(ActionEvent event) {
        
        try {
              OpenConnection();
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(newEmployeeTextField.getText().isEmpty() || newEmployeeTextField.getText() == null
                || employeeTypeTextArea.getText().isEmpty() || employeeTypeTextArea.getText() == null ){
                DBConnection.infoBox("Please enter details in the textfield  ", "Fail", null);
        }else{
        
        
        String textFieldEmployeeType = newEmployeeTextField.getText();
        String textAreaEmployeeType = employeeTypeTextArea.getText();
        
        String sql = " insert into UserType (EmployeeType, EmployeeTypeInfo)" + " values (?, ?)";
        
            try{

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, textFieldEmployeeType);
        preparedStatement.setString(2, textAreaEmployeeType);

        try{
            preparedStatement.execute();
            DBConnection.infoBox("New Employee Type Created Successfull", "Success", null);
            } catch(Exception e){
              DBConnection.infoBox("Error Saving Data", "Fail", null);
              e.printStackTrace();
        }


        }catch(Exception e){
            DBConnection.infoBox("Error Saving Data", "Fail", null);
            e.printStackTrace();
        }
            CloseConnection();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setColumnTableData();
        loadAllMembersRoleInformation();
        loadAllAccessInformation();
        loadAllEmploymentTypeInformation();
        
    }    
    

    public void setColumnTableData(){
        roleInfoColumn.setCellValueFactory(new PropertyValueFactory<MemberAccessInfo, String>("Role_Info"));
        roleID.setCellValueFactory(new PropertyValueFactory<MemberAccessInfo, String>("Role_"));
        employeeTypeID.setCellValueFactory(new PropertyValueFactory<UserType, String>("Employee_Type"));
        employeeTypeInfoColumn.setCellValueFactory(new PropertyValueFactory<UserType, String>("EmployeeType_Info"));
        accessLevelID.setCellValueFactory(new PropertyValueFactory<UserAccess, String>("Access_Level"));
        accessLevelInfo.setCellValueFactory(new PropertyValueFactory<UserAccess, String>("AccessLevel_Info"));
        
    }
    
    public void loadAllMembersRoleInformation(){
        
        try {
              OpenConnection();
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    try {
            String sql = "SELECT * FROM UserRole";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
 
               RoleInfoData.add(new MemberAccessInfo(""+resultSet.getString(1),""+resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        rolesTable.setItems(RoleInfoData);
         CloseConnection();
    }
    
    public void loadAllAccessInformation(){
        
        try {
              OpenConnection();
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    try {
            String sql = "SELECT * FROM UserAccessLevel";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
 
               AccessInfoData.add(new UserAccess(""+resultSet.getString(1),""+resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        accessLevelTable.setItems(AccessInfoData);
         CloseConnection();
    }
    
    public void loadAllEmploymentTypeInformation(){
        
        try {
              OpenConnection();
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ResourcesViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    try {
            String sql = "SELECT * FROM UserType";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while(resultSet.next()){
 
               EmployementTypeInfoData.add(new UserType(""+resultSet.getString(1),""+resultSet.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        employeeTypeTable.setItems(EmployementTypeInfoData);
         CloseConnection();
    }
}
