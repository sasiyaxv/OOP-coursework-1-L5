package CLI;

import java.io.Serializable;

public class Match implements Serializable {
    private String teamOne;
    private String teamTwo;
    private int teamOneGoals;
    private int teamTwoGoals;
    private DateTime matchDate;

    public Match(String teamOne, String teamTwo, int teamOneGoals, int teamTwoGoals, DateTime matchDate) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamOneGoals = teamOneGoals;
        this.teamTwoGoals = teamTwoGoals;
        this.matchDate = matchDate;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(String teamOne) {
        this.teamOne = teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getTeamOneGoals() {
        return teamOneGoals;
    }

    public void setTeamOneGoals(int teamOneGoals) {
        this.teamOneGoals = teamOneGoals;
    }

    public int getTeamTwoGoals() {
        return teamTwoGoals;
    }

    public void setTeamTwoGoals(int teamTwoGoals) {
        this.teamTwoGoals = teamTwoGoals;
    }

    public DateTime getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(DateTime matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamOne='" + teamOne + '\'' +
                ", teamTwo='" + teamTwo + '\'' +
                ", teamOneScore=" + teamOneGoals +
                ", teamTwoScore=" + teamTwoGoals +
                ", matchDate=" + matchDate +
                '}';
    }
}
