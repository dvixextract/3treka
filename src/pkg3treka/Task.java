
package pkg3treka;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author User
 */
public class Task {
    private int taskNumber;
    private String taskName;
    private int projectCode;
    private String taskStatus;
    private String taskInformation;
    private String taskTeamMemberAssigned;
    private String taskFromDate;
    private String taskToDate;
    private int taskTimeSpan;


    public Task(int taskNum, String taskNam, int projCode, String taskStats, String taskInformation, String taskTeamMemberAssigned, String taskFromdate, String taskTodate, int timeFrame) {

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

    public Task(int taskNum, String taskNam, int projCode, String taskStats, String taskInformation, String taskTeamMemberAssigned, int timeFrame) {

        this.taskNumber = taskNum;
        this.taskName = taskNam;
        this.taskStatus = taskStats;
        this.taskTeamMemberAssigned = taskTeamMemberAssigned;
        this.taskInformation = taskInformation;
        this.taskTimeSpan = timeFrame;
        this.projectCode = projCode;

    }

    Task() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Task(int taskNum, String taskName, String taskInformation) {
        this.taskNumber = taskNum;
        this.taskName = taskName;
        this.taskInformation = taskInformation;


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
    public String getTaskFromDate() {
        return taskFromDate;
    }

    /**
     * @param taskFromDate the taskFromDate to set
     */
    public void setTaskFromDate(String taskFromDate) {
        this.taskFromDate = taskFromDate;
    }

    /**
     * @return the taskToDate
     */
    public String getTaskToDate() {
        return taskToDate;
    }

    /**
     * @param taskToDate the taskToDate to set
     */
    public void setTaskToDate(String taskToDate) {
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

