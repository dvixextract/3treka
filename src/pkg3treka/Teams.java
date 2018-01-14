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
public class Teams {

    
    
    
    
    private String Tnames;
    private String Tmembers;
    private String Troles;
    private String ProjInvolvedIn;

    
    public Teams(String teamnames, String membrs, String rls, String projIn) {
        this.Tnames = teamnames;
        this.Tmembers = membrs;
        this.Troles = rls;
        this.ProjInvolvedIn = projIn;
    }
    
    public Teams(String teamnames, String membrs) {
        this.Tnames = teamnames;
        this.Tmembers = membrs;
    }
    public Teams(String teamnames) {
        this.Tnames = teamnames;
    }
    /**
     * @return the Tnames
     */
    public String getTnames() {
        return Tnames;
    }

    /**
     * @param Tnames the Tnames to set
     */
    public void setTnames(String Tnames) {
        this.Tnames = Tnames;
    }

    /**
     * @return the Tmembers
     */
    public String getTmembers() {
        return Tmembers;
    }

    /**
     * @param Tmembers the Tmembers to set
     */
    public void setTmembers(String Tmembers) {
        this.Tmembers = Tmembers;
    }

    /**
     * @return the Troles
     */
    public String getTroles() {
        return Troles;
    }

    /**
     * @param Troles the Troles to set
     */
    public void setTroles(String Troles) {
        this.Troles = Troles;
    }

    /**
     * @return the ProjInvolvedIn
     */
    public String getProjInvolvedIn() {
        return ProjInvolvedIn;
    }

    /**
     * @param ProjInvolvedIn the ProjInvolvedIn to set
     */
    public void setProjInvolvedIn(String ProjInvolvedIn) {
        this.ProjInvolvedIn = ProjInvolvedIn;
    }


}
