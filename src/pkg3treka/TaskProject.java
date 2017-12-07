package pkg3treka;

/**
 * Created by Mohale_Potsane on 12/7/2017.
 */
public class TaskProject {

    private int projectNumber;

    private String getProjectName;

    private int taskCode;

    private String taskName;

    private String taskDescription;

    public TaskProject(int projectNumber, String getProjectName, int taskCode, String taskName, String taskDescription) {

        this.projectNumber = projectNumber;
        this.getProjectName = getProjectName;
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getGetProjectName() {
        return getProjectName;
    }

    public void setGetProjectName(String getProjectName) {
        this.getProjectName = getProjectName;
    }

    public int getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(int taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
