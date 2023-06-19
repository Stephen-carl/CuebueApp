package com.project.cuebue;

public class ProfileDetails {

    private int Profil_ID;
    private String Profil_BVN;
    private String Profil_Nickname;
    private String Profil_Pin;
    private String Profil_AcctNo;
    private String Profil_AcctPhoneNumber;
    private String Profil_AcctName;

    public ProfileDetails(int profil_ID, String profil_BVN, String profil_Nickname, String profil_Pin, String profil_AcctNo, String profil_AcctPhoneNumber, String profil_AcctName) {
        this.Profil_ID = profil_ID;
        this.Profil_BVN = profil_BVN;
        this.Profil_Nickname = profil_Nickname;
        this.Profil_Pin = profil_Pin;
        this.Profil_AcctNo = profil_AcctNo;
        this.Profil_AcctPhoneNumber = profil_AcctPhoneNumber;
        this.Profil_AcctName = profil_AcctName;
    }

    public ProfileDetails(){

    }

    //get and set

    public int getProfil_ID() {
        return Profil_ID;
    }

    public void setProfil_ID(int profil_ID) {
        Profil_ID = profil_ID;
    }

    public String getProfil_BVN() {
        return Profil_BVN;
    }

    public void setProfil_BVN(String profil_BVN) {
        Profil_BVN = profil_BVN;
    }

    public String getProfil_Nickname() {
        return Profil_Nickname;
    }

    public void setProfil_Nickname(String profil_Nickname) {
        Profil_Nickname = profil_Nickname;
    }

    public String getProfil_Pin() {
        return Profil_Pin;
    }

    public void setProfil_Pin(String profil_Pin) {
        Profil_Pin = profil_Pin;
    }

    public String getProfil_AcctNo() {
        return Profil_AcctNo;
    }

    public void setProfil_AcctNo(String profil_AcctNo) {
        Profil_AcctNo = profil_AcctNo;
    }

    public String getProfil_AcctPhoneNumber() {
        return Profil_AcctPhoneNumber;
    }

    public void setProfil_AcctPhoneNumber(String profil_AcctPhoneNumber) {
        Profil_AcctPhoneNumber = profil_AcctPhoneNumber;
    }

    public String getProfil_AcctName() {
        return Profil_AcctName;
    }

    public void setProfil_AcctName(String profil_AcctName) {
        Profil_AcctName = profil_AcctName;
    }
}
