package app.entities;

import app.annotations.description.Description;
import app.annotations.price.Price;
import app.annotations.title.Title;
import app.annotations.url.Url;
import app.annotations.video.Video;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Title
    private String title;
    @Video
    private String trailerVideoId;
    @Url
    private String url;
    @Price(digitsAfterDecPlate = 1)
    private BigDecimal size;
    @Price
    private BigDecimal price;
    @Description
    private String description;
    private Date releaseDate;


    @ManyToMany
    @JoinTable(name = "games_users", joinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})
    private Set<User> owners;

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }


    public Game() {
    }

    public Game(String title, String trailerVideoId, String url, BigDecimal size, BigDecimal price, String description, Date releaseDate) {
        this.title = title;
        this.trailerVideoId = trailerVideoId;
        this.url = url;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerVideoId() {
        return trailerVideoId;
    }

    public void setTrailerVideoId(String trailerVideoId) {
        this.trailerVideoId = trailerVideoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
