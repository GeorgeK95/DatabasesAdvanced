package app.console;

import app.model.Album;
import app.model.Picture;
import app.model.Town;
import app.model.User;
import app.service.api.AlbumService;
import app.service.api.PictureService;
import app.service.api.TownService;
import app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService<User, Long> userService;
    @Autowired
    private TownService<Town, Long> townService;
    @Autowired
    private PictureService<Picture, Long> pictureService;
    @Autowired
    private AlbumService<Album, Long> albumService;

    @Override
    public void run(String... strings) throws Exception {
        seedUsers();
//        List<Town> towns = seedTowns();
//        setTownToUser(towns);
//        setFriends();
//        seedPicturesAndAlbums();
//        task_16();
//        task_17();
//        task_18();
    }

    private void task_18() throws ParseException {
        Scanner in = new Scanner(System.in);
        String dateS = in.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateS);
        List<User> allUsers = userService.getInnactiveUsers(date);

        for (User current : allUsers) {
            current.setDeleted(true);
            userService.save(current);
        }

        deleteUsers();
    }

    private void deleteUsers() {
        List<User> found = userService.findDeletedUsers();
        for (User user : found) {
            userService.remove(user);
        }
        int n = found.size();
        if (n == 1) {
            System.out.printf("%d user have been deleted", n);
        } else {
            System.out.printf("%d user have been deleted", n);
        }
    }

    private void task_17() {
        Scanner in = new Scanner(System.in);
        String num = in.nextLine();

        List<Byte> ll = new ArrayList<>();
        for (char c : num.toCharArray()) {
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            ll.add(Byte.parseByte(sb.toString()));
            sb.setLength(0);
        }

        byte[] arr = new byte[ll.size()];
        for (int i = 0; i < ll.size(); i++) {
            byte curr = ll.get(i);
            arr[i] = curr;
        }
        Long res = userService.getUsersCountWithBiggerPicture(arr);
        if (res == 0) {
            System.out.printf("No users have profile picture wider than %s pixels", num);
        } else {
            System.out.printf("%s users have profile pictures wider than %s pixels ", res, num);
        }
    }

    private void task_16() {
        Scanner in = new Scanner(System.in);
        String provider = in.nextLine();
        List<String> found = userService.getUsersByEmailProvider(provider);
        if (found.size() == 0) {
            System.out.println("No users found with email domain abv.bg");
        } else {
            for (String s : found) {
                System.out.println(s);
            }
        }
    }

    private void seedPicturesAndAlbums() {
        List<User> all = userService.findAll();
        Album a = new Album();
        a.setName("Cars");
        a.setColor("Black");
        a.setPublic(true);
        a.setOwner(all.get(0));

        Picture p = new Picture();
        p.setCaption("caption");
        p.setPath("SomePath");
        p.setTitle("boring homework!!!");
        p.setAlbums(new HashSet<Album>() {{
            add(a);
        }});
        a.setPictures(new HashSet<Picture>() {{
            add(p);
        }});
        pictureService.save(p);
        albumService.save(a);


    }

    private void setFriends() {
        List<User> all = userService.findAll();
        all.get(0).setFriends(new HashSet<User>() {{
            add(all.get(1));
        }});
        userService.save(all.get(0));
    }

    private void setTownToUser(List<Town> towns) {
        User u = userService.findById(new Long(1));
        u.setLivingTown(towns.get(1));
        u.setBornTown(towns.get(0));
        userService.save(u);
    }

    private List<Town> seedTowns() {
        List<Town> towns = new ArrayList<>();
        Town pld = new Town();
        pld.setCountry("Bulgaria");
        pld.setName("Plovdiv");
        Town lnd = new Town();
        lnd.setCountry("UK");
        lnd.setName("London");
        towns.add(pld);
        towns.add(lnd);
        townService.save(pld);
        townService.save(lnd);
        return towns;
    }

    private void seedUsers() throws ParseException {
        User us = new User();
        us.setAge(99);
        us.setDeleted(false);
//        Scanner in = new Scanner(System.in);
//        String em = in.nextLine();
        us.setEmail("oxaaaaaq.ggg@gmail.bg");
//        us.setLastTimeLoggedIn(date);
//        us.setRegisteredOn(date2);
        us.setPassword("incorrect");
        us.setProfilePicture(new byte[5]);
        us.setFirstName("Alan");
        us.setLastName("Harper");
        us.setUserName("ah_harp23NEW");

//        User u = new User();
//        u.setAge(119);
//        u.setDeleted(false);
//        u.setEmail("oxaaaaaq.ggg@abv.bg");
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
//        String dateInString = "31-08-1995 10:20:56";
//        Date date = sdf.parse(dateInString);
//        Date date2 = sdf.parse(dateInString);
//
//        u.setLastTimeLoggedIn(date);
//        u.setRegisteredOn(date2);
//        u.setPassword("opalqA12@o");
//        u.setProfilePicture(new byte[5]);
//        u.setFirstName("Alan");
//        u.setLastName("Harper");
//        u.setUserName("ah_harp23NEW");
//        u.setFriends(new HashSet<User>() {{
//            add(us);
//        }});
//
//        byte[] opalq = new byte[3];
//        opalq[0] = 1;
//        opalq[1] = 2;
//        opalq[2] = 0;
//
//        u.setProfilePicture(opalq);
        userService.save(us);
//        userService.save(u);
    }
}
