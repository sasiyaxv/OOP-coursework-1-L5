package CLI;

import java.io.Serializable;
import java.util.Objects;

public abstract class SportsClub implements Serializable {

    private String regNo;
    private String nameOfClub;
    private String locationOfClub;
    private DateTime dateCreated;
    private int contactNo;


    public SportsClub(String regNo, String nameOfClub, String locationOfClub, DateTime dateCreated, int contactNo) {
        this.regNo = regNo;
        this.nameOfClub = nameOfClub;
        this.locationOfClub = locationOfClub;
        this.dateCreated = dateCreated;
        this.contactNo = contactNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getNameOfClub() {
        return nameOfClub;
    }

    public void setNameOfClub(String nameOfClub) {
        this.nameOfClub = nameOfClub;
    }

    public String getLocationOfClub() {
        return locationOfClub;
    }

    public void setLocationOfClub(String locationOfClub) {
        this.locationOfClub = locationOfClub;
    }

    public DateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return
                "regNo='" + regNo + '\'' +
                ", nameOfClub='" + nameOfClub + '\'' +
                ", locationOfClub='" + locationOfClub + '\'' +
                ", dateCreated=" + dateCreated +
                ", contactNo=" + contactNo
                ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportsClub that = (SportsClub) o;
        return getRegNo().equals(that.getRegNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRegNo());
    }
}
