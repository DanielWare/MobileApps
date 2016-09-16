package edu.uco.dware6.p4danielwa;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private String mFullName;

    private String mPassword;

    private Date mDateOfBirth;

    private GenderEnum mGender;

    private ClassificationEnum mClassification;

    private String mSkills;


    public User(String mFullName, String mPassword, Date mDateOfBirth, GenderEnum mGender, ClassificationEnum mClassification, String mSkills) {
        this.mFullName = mFullName;
        this.mPassword = mPassword;
        this.mDateOfBirth = mDateOfBirth;
        this.mGender = mGender;
        this.mClassification = mClassification;
        this.mSkills = mSkills;
    }

    public String getmFullName() {
        return mFullName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public Date getmDateOfBirth() {
        return mDateOfBirth;
    }

    public GenderEnum getmGender() {
        return mGender;
    }

    public ClassificationEnum getmClassification() {
        return mClassification;
    }

    public String getmSkills() {
        return mSkills;
    }

}
