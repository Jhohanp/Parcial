/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author jhopi
 */
public class STUDENTS {
    private int SID;
    private String FIRST;
    private String LAST;
    private String EMAIL;

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getFIRST() {
        return FIRST;
    }

    public void setFIRST(String FIRST) {
        this.FIRST = FIRST;
    }

    public String getLAST() {
        return LAST;
    }

    public void setLAST(String LAST) {
        this.LAST = LAST;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
}
