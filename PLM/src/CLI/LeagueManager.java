package CLI;

public interface LeagueManager {

    void addFootballClub(FootballClub footballClub);
    void deleteFootballClub(String regNo);
    void viewClubData(String regNo);
    void displayPremiereLeagueTable();
    void addPlayedMatch(Match playedMatch);
}
