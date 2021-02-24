package CLI;

public class SchoolFootballClub {

    private String schoolName;

    public SchoolFootballClub() {
    }

    public SchoolFootballClub(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "SchoolFootballClub{" + super.toString()+
                "schoolName='" + schoolName + '\'' +
                "} " ;
    }
}
