package pkg3treka;

/**
 * Created by Mohale_Potsane on 11/5/2017.
 */
public class ProjectUtils {

    private static  ProjectUtils instance = new ProjectUtils();

    private String projectName;

    public ProjectUtils() {
    }

    public ProjectUtils getInstance() {
        return instance;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
