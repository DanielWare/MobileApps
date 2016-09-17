package edu.uco.dware6.p4danielwa;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private String mFullName;

    private String mPassword;

    private Date mDateOfBirth;

    private GenderEnum mGender;

    private ClassificationEnum mClassification;

    private Boolean[] mSkills;

    public User(String mFullName, String mPassword, Date mDateOfBirth, GenderEnum mGender, ClassificationEnum mClassification, Boolean[] mSkills) {
        this.mFullName = mFullName;
        this.mPassword = mPassword;
        this.mDateOfBirth = mDateOfBirth;
        this.mGender = mGender;
        this.mClassification = mClassification;
        this.mSkills = mSkills;
    }

    public String getFullName() {
        return mFullName;
    }

    public String getPassword() {
        return mPassword;
    }

    public Date getDateOfBirth() {
        return mDateOfBirth;
    }

    public GenderEnum getGender() {
        return mGender;
    }

    public ClassificationEnum getClassification() {
        return mClassification;
    }

    public Boolean[] getSkills() {
        return mSkills;
    }

}
