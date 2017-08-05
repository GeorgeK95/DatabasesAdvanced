package app.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "seller", fetch = FetchType.EAGER)
    private Set<Product> soldProducts;

    private String firstName;

    @Size(min = 3)
    @Column(nullable = false)
    private String lastName;

    private int age;



    public Set<Product> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<Product> soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


//    @ManyToOne
//    private Set<Product> boughtProducts;
//    private Set<User> friends;


    //    @ManyToMany(/*fetch = FetchType.EAGER*/)
//    @JoinTable(name = "users_friends", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
//            inverseJoinColumns = {@JoinColumn(name = "friend_id", referencedColumnName = "id")})


//    public Set<User> getFriends() {
//        return friends;
//    }
//
//    public void setFriends(Set<User> friends) {
//        this.friends = friends;
//    }




    /*@ManyToMany(mappedBy = "owners", fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(name = "games_users", joinColumns = {@JoinColumn(name = "game_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")})*/

}
