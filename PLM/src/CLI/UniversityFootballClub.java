package CLI;

public class UniversityFootballClub  {

private String universityName;

    public UniversityFootballClub() {
    }

    public UniversityFootballClub(String universityName) {
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "UniversityFootballClub{" +  super.toString()+
                "universityName='" + universityName + '\'' +
                "} " ;
    }
}
