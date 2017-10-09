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
public class UserType {

    private String Employee_Type;
    private String EmployeeType_Info;
    
    UserType(String Etype , String Etypeinfo){
    
        this.Employee_Type = Etype;
        this.EmployeeType_Info = Etypeinfo;
    }
    /**
     * @return the Employee_Type
     */
    public String getEmployee_Type() {
        return Employee_Type;
    }

    /**
     * @param Employee_Type the Employee_Type to set
     */
    public void setEmployee_Type(String Employee_Type) {
        this.Employee_Type = Employee_Type;
    }

    /**
     * @return the EmployeeType_Info
     */
    public String getEmployeeType_Info() {
        return EmployeeType_Info;
    }

    /**
     * @param EmployeeType_Info the EmployeeType_Info to set
     */
    public void setEmployeeType_Info(String EmployeeType_Info) {
        this.EmployeeType_Info = EmployeeType_Info;
    }

    
}
