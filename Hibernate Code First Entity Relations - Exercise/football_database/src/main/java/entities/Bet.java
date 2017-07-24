package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal betMoney;
    private LocalDate timeOfBet;
    @OneToMany(mappedBy = "bet")
    private Set<BetGame> betGameSet;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public LocalDate getTimeOfBet() {
        return timeOfBet;
    }

    public void setTimeOfBet(LocalDate timeOfBet) {
        this.timeOfBet = timeOfBet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Set<BetGame> getBetGameSet() {
        return betGameSet;
    }

    public void setBetGameSet(Set<BetGame> betGameSet) {
        this.betGameSet = betGameSet;
    }
}
