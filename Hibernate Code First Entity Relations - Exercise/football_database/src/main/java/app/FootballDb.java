package app;

import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
public class FootballDb {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("footballdb");
        EntityManager em = emf.createEntityManager();
        addDataToDb(em);
        emf.close();
    }

    private static void addDataToDb(EntityManager em) {
        em.getTransaction().begin();

        User u = new User();
        u.setFullName("Ivan Todorov");
        u.setBalance(new BigDecimal(100000));
        em.persist(u);

        Bet b = new Bet();
        b.setBetMoney(new BigDecimal(20000));
        b.setTimeOfBet(LocalDate.now());
        b.setUser(u);
        em.persist(b);

        Color c = new Color();
        c.setName("blue");
        Color c1 = new Color();
        c1.setName("black");
        em.persist(c);
        em.persist(c1);

        CompetitionType ct = new CompetitionType();
        ct.setName(CompetitionTypes.International);
        em.persist(ct);

        Competition co = new Competition();
        co.setName("UCL");
        co.setType(ct);
        em.persist(co);

        Continent con = new Continent();
        con.setName("Europe");

        Country bg = new Country();
        bg.setName("Bulgaria");
        bg.setInitials("BG");
        Set<Continent> eur = new HashSet<Continent>() {{
            add(con);
        }};
        bg.setContinents(eur);
        Country en = new Country();
        en.setName("England");
        en.setInitials("EN");
        em.persist(en);
        em.persist(bg);

        Set<Country> bgset = new HashSet<Country>() {{
            add(bg);
        }};
        con.setCountries(bgset);
        em.persist(con);

        Town pld = new Town();
        pld.setName("Plovdiv");
        pld.setCountry(bg);
        Town lon = new Town();
        lon.setName("London");
        lon.setCountry(en);
        em.persist(pld);
        em.persist(lon);

        Round round = new Round();
        round.setName("Final");
        em.persist(round);

        ResultPrediction rp = new ResultPrediction();
        rp.setPrediction("3-1");
        em.persist(rp);


        Team chelsea = new Team();
        chelsea.setName("Chelsea FC");
        chelsea.setPrimaryKitColor(c);
        chelsea.setPrimaryKitColor(c1);
        chelsea.setTown(lon);
        em.persist(chelsea);
        Team loko = new Team();
        loko.setName("Lokomotiv Plovdiv");
        loko.setPrimaryKitColor(c1);
        loko.setPrimaryKitColor(c);
        loko.setTown(pld);
        em.persist(loko);

        Game game = new Game();
        game.setAway(chelsea);
        game.setHome(loko);
        game.setCompetition(co);
        game.setRound(round);

        Position df = new Position();
        df.setDescription("Defender");
        df.setPositionInicials("DF");
        em.persist(df);

        Player terry = new Player();
        terry.setPosition(df);
        terry.setName("John Terry");
        terry.setNumber(26);
        terry.setTeam(chelsea);
        Set<Game> games = new HashSet<Game>() {{
            add(game);
        }};
        terry.setGames(games);
        em.persist(terry);
        Set<Player> terrySet = new HashSet<Player>() {{
            add(terry);
        }};
        game.setPlayers(terrySet);
        em.persist(game);

        PlayerStatistic ps = new PlayerStatistic();
        ps.setGame(game);
        ps.setGoals(2);
        ps.setAssists(1);
        ps.setMinutes(90);
        ps.setPlayer(terry);
        em.persist(ps);

        BetGame betg = new BetGame();
        betg.setGame(game);
        betg.setBet(b);
        betg.setResultPrediction(rp);
        em.persist(betg);

        em.getTransaction().commit();
        em.close();
    }
}
