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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author User
 */
public class TeamsViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Teams> teamsTable;

    @FXML
    private TableColumn<Teams, String> membername;
    
       
    @FXML
    private TableColumn<Teams, String> memberRole;

    @FXML
    private TableColumn<Teams, String> numberOfProjectsInvolvedIn;

    @FXML
    private ListView<String> TeamNameListview;
    


    Connection connection = null;
    PreparedStatement preparedStatement = null;
    com.mysql.jdbc.ResultSet resultSet = null;
    ObservableList<String> TeamsOutput = FXCollections.observableArrayList();
    ObservableList<Teams> TeamsMembers = FXCollections.observableArrayList();

    public TeamsViewController() throws SQLException {
        try {
            connection = DBConnection.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setColumnTableData();
        loadTeamsInformation();
        TeamListViewClick();
    }

    public void loadTeamsInformation() {
        try {
            String sql = "SELECT * FROM Teams ";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = (ResultSet) preparedStatement.executeQuery();
            while (resultSet.next()) {
                TeamsOutput.add(resultSet.getString(1));
                
                TeamNameListview.setItems(TeamsOutput);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // teamsTable.setItems(TeamsMembers);
    }

    public void setColumnTableData() {
        membername.setCellValueFactory(new PropertyValueFactory<Teams, String>("Tnames"));
        memberRole.setCellValueFactory(new PropertyValueFactory<Teams, String>("Troles"));
        numberOfProjectsInvolvedIn.setCellValueFactory(new PropertyValueFactory<Teams, String>("ProjInvolvedIn"));
    }

    
    public void TeamListViewClick() {

        TeamNameListview.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                teamsTable.getItems().clear();


                System.out.println("user selected information -------------->>");
                System.out.println(TeamNameListview.getSelectionModel().getSelectedItem().toString());

                String SelectedTeamName = TeamNameListview.getSelectionModel().getSelectedItem().toString();

                try {
                    String sql = "SELECT Members FROM Teams where (Teamname = '" + SelectedTeamName + "')";
                    preparedStatement = connection.prepareStatement(sql);
                    resultSet = (ResultSet) preparedStatement.executeQuery();
                    System.out.println("names-------------------------");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                        TeamsMembers.add(new Teams(resultSet.getString(1)));
                        
//                        ////////////////////
//                        String SelectedTeammemberName = resultSet.getString(1);
//                        try {
//                            String sqlSt = "SELECT Role FROM Users where (U_name = '" +  SelectedTeammemberName + "')";
//                            preparedStatement = connection.prepareStatement(sqlSt);
//                            resultSet = (ResultSet) preparedStatement.executeQuery();
//                            System.out.println("names-------------------------");
//                           // while (resultSet.next()) {
//                                System.out.println(resultSet.getString(1));
//                                TeamsMembers.add(new Teams(SelectedTeammemberName,resultSet.getString(1) ));
//
//                            //}
//                        } catch (SQLException ex) {
//                            Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                        
//                        ////////////////////
                        
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdminViewController.class.getName()).log(Level.SEVERE, null, ex);
                }

                teamsTable.setItems(TeamsMembers);
                //  membername.add("something);
//               Team_Members.add(Employees.getSelectionModel().getSelectedItem().getName());
//               setMember(Employees.getSelectionM"odel().getSelectedItem().getName());
//               SelectedTeamMemb"ers.add(Employees.getSelectionModel().getSelectedItem().getUserID());
//               ClickOutput.add( Employees.getSelectionModel().getSelectedItem().getName()+":\t  "+Employees.getSelectionModel().getSelectedItem().getROLE());
//               listvw.setItems(ClickOutput);
            }

        });

    }
}
