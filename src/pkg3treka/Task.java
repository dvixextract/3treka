package pkg3treka;

/**
 * Created by Mohale_Potsane on 11/19/2017.
 */
public class Task {

   private int taskId;

   private String taskName;

   private int taskTimeSpan;

   private int projectCode;

   private String taskStatus;

   private String taskDescription;

   private String taskTeamLead;

    public Task(int taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getTaskTimeSpan() {
        return taskTimeSpan;
    }

    public void setTaskTimeSpan(int taskTimeSpan) {
        this.taskTimeSpan = taskTimeSpan;
    }

    public int getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(int projectCode) {
        this.projectCode = projectCode;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskTeamLead() {
        return taskTeamLead;
    }

    public void setTaskTeamLead(String taskTeamLead) {
        this.taskTeamLead = taskTeamLead;
    }
}


