package pkg3treka;

import java.sql.Date;

/**
 * Created by Mohale_Potsane on 1/15/2018.
 */
public class TaskEvent {

    private String projectNumber;

    private String taskNumber;

    private String duration;

    private Date date;

    public TaskEvent(String projectNumber, String taskNumber, String duration, Date date) {
        this.projectNumber = projectNumber;
        this.taskNumber = taskNumber;
        this.duration = duration;
        this.date = date;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
