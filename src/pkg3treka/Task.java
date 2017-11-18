///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package pkg3treka;
//
//import java.time.LocalDate;
//import java.util.Date;
//
///**
// *
// * @author User
// */
//public class Task {
//    
//    private int taskNumber;
//    private String taskName;
//    private String taskStatus;
//    private LocalDate taskFromDate;
//    private LocalDate taskToDate;
//    private String taskTeamMemberAssigned;
//    private String taskInformation;
//    private int taskTimeSpan;
//    private int projectCode;
//    

//

//
//    /**
//     * @return the taskNumber
//     */
//    public int getTaskNumber() {
//        return taskNumber;
//    }
//
//    /**
//     * @param taskNumber the taskNumber to set
//     */
//    public void setTaskNumber(int taskNumber) {
//        this.taskNumber = taskNumber;
//    }
//
//    /**
//     * @return the taskName
//     */
//    public String getTaskName() {
//        return taskName;
//    }
//
//    /**
//     * @param taskName the taskName to set
//     */
//    public void setTaskName(String taskName) {
//        this.taskName = taskName;
//    }
//
//    /**
//     * @return the taskStatus
//     */
//    public String getTaskStatus() {
//        return taskStatus;
//    }
//
//    /**
//     * @param taskStatus the taskStatus to set
//     */
//    public void setTaskStatus(String taskStatus) {
//        this.taskStatus = taskStatus;
//    }
//
//    /**
//     * @return the taskFromDate
//     */
//    public LocalDate getTaskFromDate() {
//        return taskFromDate;
//    }
//
//    /**
//     * @param taskFromDate the taskFromDate to set
//     */
//    public void setTaskFromDate(LocalDate taskFromDate) {
//        this.taskFromDate = taskFromDate;
//    }
//
//    /**
//     * @return the taskToDate
//     */
//    public LocalDate getTaskToDate() {
//        return taskToDate;
//    }
//
//    /**
//     * @param taskToDate the taskToDate to set
//     */
//    public void setTaskToDate(LocalDate taskToDate) {
//        this.taskToDate = taskToDate;
//    }
//
//    /**
//     * @return the taskTeamMemberAssigned
//     */
//    public String getTaskTeamMemberAssigned() {
//        return taskTeamMemberAssigned;
//    }
//
//    /**
//     * @param taskTeamMemberAssigned the taskTeamMemberAssigned to set
//     */
//    public void setTaskTeamMemberAssigned(String taskTeamMemberAssigned) {
//        this.taskTeamMemberAssigned = taskTeamMemberAssigned;
//    }
//
//    /**
//     * @return the taskInformation
//     */
//    public String getTaskInformation() {
//        return taskInformation;
//    }
//
//    /**
//     * @param taskInformation the taskInformation to set
//     */
//    public void setTaskInformation(String taskInformation) {
//        this.taskInformation = taskInformation;
//    }
//
//    
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author User
 */
public class Task {
    private int taskNumber;
    private String taskName;
    private int projectCode;
    private String taskStatus;
    private String taskInformation;
    private String taskTeamMemberAssigned;
    private Date taskFromDate;
    private Date taskToDate;
    private int taskTimeSpan;
    
    
    public Task (int taskNum,String taskNam, int projCode,String taskStats,String taskInformation,String taskTeamMemberAssigned ,Date taskFromdate,Date taskTodate, int timeFrame){

        this.taskNumber = taskNum;
        this.taskName = taskNam;
        this.taskStatus = taskStats;
        this.taskFromDate = taskFromdate;
        this.taskToDate = taskTodate;
        this.taskTeamMemberAssigned = taskTeamMemberAssigned;
        this.taskInformation = taskInformation;
        this.taskTimeSpan = timeFrame;
        this.projectCode = projCode;
        
    }
    
    Task() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the taskNumber
     */
    public int getTaskNumber() {
        return taskNumber;
    }

    /**
     * @param taskNumber the taskNumber to set
     */
    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    /**
     * @return the taskName
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName the taskName to set
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return the taskStatus
     */
    public String getTaskStatus() {
        return taskStatus;
    }

    /**
     * @param taskStatus the taskStatus to set
     */
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    /**
     * @return the taskFromDate
     */
    public Date getTaskFromDate() {
        return taskFromDate;
    }

    /**
     * @param taskFromDate the taskFromDate to set
     */
    public void setTaskFromDate(Date taskFromDate) {
        this.taskFromDate = taskFromDate;
    }

    /**
     * @return the taskToDate
     */
    public Date getTaskToDate() {
        return taskToDate;
    }

    /**
     * @param taskToDate the taskToDate to set
     */
    public void setTaskToDate(Date taskToDate) {
        this.taskToDate = taskToDate;
    }

    /**
     * @return the taskTeamMemberAssigned
     */
    public String getTaskTeamMemberAssigned() {
        return taskTeamMemberAssigned;
    }

    /**
     * @param taskTeamMemberAssigned the taskTeamMemberAssigned to set
     */
    public void setTaskTeamMemberAssigned(String taskTeamMemberAssigned) {
        this.taskTeamMemberAssigned = taskTeamMemberAssigned;
    }

    /**
     * @return the taskInformation
     */
    public String getTaskInformation() {
        return taskInformation;
    }

    /**
     * @param taskInformation the taskInformation to set
     */
    public void setTaskInformation(String taskInformation) {
        this.taskInformation = taskInformation;
    }

    /**
     * @return the taskTimeSpan
     */
    public int getTaskTimeSpan() {
        return taskTimeSpan;
    }

    /**
     * @param taskTimeSpan the taskTimeSpan to set
     */
    public void setTaskTimeSpan(int taskTimeSpan) {
        this.taskTimeSpan = taskTimeSpan;
    }

    /**
     * @return the projectCode
     */
    public int getProjectCode() {
        return projectCode;
    }

    /**
     * @param projectCode the projectCode to set
     */
    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }
    

    
    
}
