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
public class MemberAccessInfo {

    private String Role_Info;
    private String Role_;

    
    MemberAccessInfo(String role){
    
        this.Role_=role;
    }
    
    MemberAccessInfo(String role, String roleinfo){
    
        this.Role_=role;
        this.Role_Info = roleinfo;
    }

    /**
     * @return the Role_Info
     */
    public String getRole_Info() {
        return Role_Info;
    }

    /**
     * @param Role_Info the Role_Info to set
     */
    public void setRole_Info(String Role_Info) {
        this.Role_Info = Role_Info;
    }

    /**
     * @return the Role_
     */
    public String getRole_() {
        return Role_;
    }

    /**
     * @param Role_ the Role_ to set
     */
    public void setRole_(String Role_) {
        this.Role_ = Role_;
    }

    /**
     * @return the Employee_Type
     */
   
}
