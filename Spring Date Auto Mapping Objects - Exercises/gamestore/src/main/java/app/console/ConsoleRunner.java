package app.console;

import app.dto.GameDetailsDto;
import app.dto.GameDto;
import app.entities.Game;
import app.entities.User;
import app.service.api.GameService;
import app.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService<User, Long> userService;
    @Autowired
    private GameService<Game, Long> gameService;
    private User currentUser;

    @Override
    public void run(String... strings) throws Exception {
        Scanner in = new Scanner(System.in);
        String line = null;

        while (true) {
            line = in.nextLine();
            String[] spl = line.split("\\|");

            if (line.equals("end")) {
                break;
            }

            switch (spl[0]) {
                case "Register":
                    doRegister(spl);
                    break;
                case "Login":
                    doLogin(spl);
                    break;
                case "Logout":
                    doLogout();
                    break;
                case "AddGame":
                    if (currentUser != null) {
                        if (currentUser.isAdmin()) {
                            addGame(spl);
                        }
                    }
                    break;
                case "EditGame":
                    if (currentUser != null) {
                        if (currentUser.isAdmin()) {
                            editGame(spl);
                        }
                    }
                    break;
                case "DeleteGame":
                    if (currentUser != null) {
                        if (currentUser.isAdmin()) {
                            deleteGame(spl);
                        }
                    }
                    break;
                case "AllGames":
                    printAllGames();
                    break;
                case "GameDetails":
                    printGameDetails(spl[1]);
                    break;
                case "OwnedGames":
                    printOwnedGames();
                    break;
            }

        }
    }

    private void printOwnedGames() {
        Set<User> userSet = new HashSet<User>() {{
            add(currentUser);
        }};
        List<Game> games = gameService.findGameByOwners(userSet);
        ModelMapper modelMapper = new ModelMapper();
        GameDto g = null;
        for (Game game : games) {
            g = modelMapper.map(game, GameDto.class);
            System.out.printf("%s\n", g.getTitle());
        }
    }

    private void printGameDetails(String title) {
        Game game = gameService.findGameByTitle(title);
        ModelMapper modelMapper = new ModelMapper();
        GameDetailsDto gameDetailsDto = modelMapper.map(game, GameDetailsDto.class);
        System.out.printf("%s\n%.2f\n%.2f\n%s\n%s\n%s\n%s\n", gameDetailsDto.getTitle(), gameDetailsDto.getPrice(), gameDetailsDto.getSize(),
                gameDetailsDto.getTrailer(), gameDetailsDto.getUrl(), gameDetailsDto.getDescription(), gameDetailsDto.getReleaseDate());
    }

    private void printAllGames() {
        List<Game> allGames = gameService.findAll();
        ModelMapper modelMapper = new ModelMapper();
        GameDto gameDto = null;
        for (Game game : allGames) {
            gameDto = modelMapper.map(game, GameDto.class);
            System.out.printf("%s %.2f\n", gameDto.getTitle(), gameDto.getPrice());
        }
    }

    private void deleteGame(String[] spl) {
        Game g = gameService.findById(Long.valueOf(spl[1]));
        if (g != null) {
            gameService.remove(g);
            System.out.printf("Deleted %s", g.getTitle());
        } else {
            System.out.println("Game not found.");
        }
    }

    private void editGame(String[] spl) throws ParseException {
        Game g = gameService.findById(Long.valueOf(spl[1]));
        if (g != null) {
            editGameDetails(spl, g);
            gameService.save(g);
            System.out.printf("Editted %s", g.getTitle());
        } else {
            System.out.println("Game not found.");
        }
    }

    private void editGameDetails(String[] spl, Game g) throws ParseException {
        for (int i = 2; i < spl.length; i++) {
            String s = spl[i];
            String[] propertyValue = s.split("=");

            switch (propertyValue[0]) {
                case "title":
                    g.setTitle(propertyValue[1]);
                    break;
                case "price":
                    g.setPrice(new BigDecimal(propertyValue[1]));
                    break;
                case "size":
                    g.setSize(new BigDecimal(propertyValue[1]));
                    break;
                case "trailer":
                    g.setTrailerVideoId(propertyValue[1]);
                    break;
                case "url":
                    g.setUrl(propertyValue[1]);
                    break;
                case "description":
                    g.setDescription(propertyValue[1]);
                    break;
                case "releasedate":
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    g.setReleaseDate(sdf.parse(propertyValue[1]));
                    break;
            }
        }
    }

    private void addGame(String[] spl) throws ParseException {
        String title = spl[1];
        BigDecimal price = BigDecimal.valueOf(Double.valueOf(spl[2]));
        BigDecimal size = BigDecimal.valueOf(Double.valueOf(spl[3]));
        String videoId = spl[4];
        String url = spl[5];
        String description = spl[6];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(spl[7]);

        Game game = new Game();
        game.setPrice(price);
        game.setTitle(title);
        game.setSize(size);
        game.setTrailerVideoId(videoId);
        game.setUrl(url);
        game.setDescription(description);
        game.setReleaseDate(date);
        gameService.save(game);
        System.out.printf("Added %s\n", game.getTitle());
    }

    private void doLogout() {
        try {
            User u = userService.findById(currentUser.getId());
            u.setLoggedIn(false);
            userService.save(u);
            currentUser = null;
            System.out.printf("User %s successfully logged out", u.getFullName());
            currentUser = null;
        } catch (NullPointerException e) {
            System.out.println("Cannot log out. No user was logged in.");
        }
//        List<User> userByIsLoggedInTrue = userService.findUserByIsLoggedInTrue();
//        if (userByIsLoggedInTrue.size() != 0) {
//            User u = userService.findById(currentUser.getId());
//            u.setLoggedIn(false);
//            userService.save(u);
//            currentUser = null;
//            System.out.printf("User %s successfully logged out", u.getFullName());
//        } else {
//            System.out.println("Cannot log out. No user was logged in.");
//        }
    }

    private void doLogin(String[] spl) {
        String email = spl[1];
        String pass = spl[2];
        loginUserIfExist(email, pass);
    }

    private void loginUserIfExist(String email, String pass) {
        User found = getLoggedUser(email, pass);
        if (found != null) {
            found.setLoggedIn(true);
            currentUser = found;
            userService.save(found);
            System.out.printf("Successfully logged in %s", found.getFullName());
        } else {
            System.out.println("Incorrect username / password");
        }
    }

    private User getLoggedUser(String email, String pass) {
        return userService.findUserByEmailAndPassword(email, pass);
    }

    private void doRegister(String[] spl) {
        String email = spl[1];
        String pass = spl[2];
        String confirmPass = spl[3];
        String fullName = spl[4];

        if (pass.equals(confirmPass)) {
            User u = new User();
            u.setEmail(email);
            u.setPassword(pass);
            u.setFullName(fullName);

            if (userService.findAll().size() == 0) {
                u.setAdmin(true);
            }

            userService.save(u);
            System.out.printf("%s was registered", fullName);
        } else {
            System.out.println("Mismatch passwords");
        }

    }

}