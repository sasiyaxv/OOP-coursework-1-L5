package CLI;

import java.io.Serializable;

public class FootballClub  extends SportsClub implements Comparable<FootballClub>,Serializable{

    private int matchesWin;
    private int matchesDraw;
    private int matchesLost;
    private int noOfGoalsReceived;
    private int noOfGoalsScored;
    private int noOfPoints;
    private int matchesPlayed;

    public FootballClub(String regNo, String nameOfClub, String locationOfClub, DateTime dateCreated, int contactNo, int matchesWin, int matchesDraw, int matchesLost, int noOfGoalsReceived, int noOfGoalsScored, int noOfPoints, int matchesPlayed) {
        super(regNo, nameOfClub, locationOfClub, dateCreated, contactNo);
        this.matchesWin = matchesWin;
        this.matchesDraw = matchesDraw;
        this.matchesLost = matchesLost;
        this.noOfGoalsReceived = noOfGoalsReceived;
        this.noOfGoalsScored = noOfGoalsScored;
        this.noOfPoints = noOfPoints;
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWin() {
        return matchesWin;
    }

    public void setMatchesWin(int matchesWin) {
        if (matchesWin < 0 ){
            System.out.println("Matches cant be negative,");
            throw new IllegalArgumentException();
        }else {
            this.matchesWin = matchesWin;
        }
    }

    public int getMatchesDraw() {
        return matchesDraw;
    }

    public void setMatchesDraw(int matchesDraw) {
        this.matchesDraw = matchesDraw;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getNoOfGoalsReceived() {
        return noOfGoalsReceived;
    }

    public void setNoOfGoalsReceived(int noOfGoalsReceived) {
        this.noOfGoalsReceived = noOfGoalsReceived;
    }

    public int getNoOfGoalsScored() {
        return noOfGoalsScored;
    }

    public void setNoOfGoalsScored(int noOfGoalsScored) {
        this.noOfGoalsScored = noOfGoalsScored;
    }

    public int getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(int noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public int compareTo(FootballClub footballClub) {
        if (this.getNoOfPoints() > footballClub.getNoOfPoints())
        {
            return -1;
        }
        else if (this.getNoOfPoints() < footballClub.getNoOfPoints()){
            return 1;
        }
        else {
            if (this.getNoOfGoalsScored() > footballClub.getNoOfGoalsScored())
            {
                return -1;
            }
            else if (this.getNoOfGoalsScored() < footballClub.getNoOfGoalsScored()){
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return  "Footballclub { "+super.toString()+
                "matchesWin=" + matchesWin +
                ", matchesDraw=" + matchesDraw +
                ", matchesLost=" + matchesLost +
                ", noOfGoalsReceived=" + noOfGoalsReceived +
                ", noOfGoalsScored=" + noOfGoalsScored +
                ", noOfPoints=" + noOfPoints +
                ", matchesPlayed=" + matchesPlayed +
                "} " ;
    }
}
