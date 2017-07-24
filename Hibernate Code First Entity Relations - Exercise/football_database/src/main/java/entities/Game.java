package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    private Team home;

    @OneToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    private Team away;
    private int homeGoals;
    private int awayGoals;
    private LocalDate timeOfGame;
    private BigDecimal homeWinRate;
    private BigDecimal awayWinRate;
    private BigDecimal drawWinRate;

    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    @ManyToMany(mappedBy = "games")
    private Set<Player> players;


    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public LocalDate getTimeOfGame() {
        return timeOfGame;
    }

    public void setTimeOfGame(LocalDate timeOfGame) {
        this.timeOfGame = timeOfGame;
    }

    public BigDecimal getHomeWinRate() {
        return homeWinRate;
    }

    public void setHomeWinRate(BigDecimal homeWinRate) {
        this.homeWinRate = homeWinRate;
    }

    public BigDecimal getAwayWinRate() {
        return awayWinRate;
    }

    public void setAwayWinRate(BigDecimal awayWinRate) {
        this.awayWinRate = awayWinRate;
    }

    public BigDecimal getDrawWinRate() {
        return drawWinRate;
    }

    public void setDrawWinRate(BigDecimal drawWinRate) {
        this.drawWinRate = drawWinRate;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
