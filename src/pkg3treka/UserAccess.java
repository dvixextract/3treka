/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3treka;

/**
 *
 * @author User
 */
public class UserAccess {

    private String Access_Level;
    private String AccessLevel_Info;
   
    UserAccess(String AccssLevel , String AccssLevelInf){
        this.Access_Level = AccssLevel;
        this.AccessLevel_Info = AccssLevelInf;
    
    }

    /**
     * @return the Access_Level
     */
    public String getAccess_Level() {
        return Access_Level;
    }

    /**
     * @param Access_Level the Access_Level to set
     */
    public void setAccess_Level(String Access_Level) {
        this.Access_Level = Access_Level;
    }

    /**
     * @return the AccessLevel_Info
     */
    public String getAccessLevel_Info() {
        return AccessLevel_Info;
    }

    /**
     * @param AccessLevel_Info the AccessLevel_Info to set
     */
    public void setAccessLevel_Info(String AccessLevel_Info) {
        this.AccessLevel_Info = AccessLevel_Info;
    }

}
