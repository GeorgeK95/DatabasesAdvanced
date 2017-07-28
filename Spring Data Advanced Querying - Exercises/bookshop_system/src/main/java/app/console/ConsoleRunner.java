package app.console;

import app.domain.*;
import app.service.api.AuthorService;
import app.service.api.BookService;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {
    private String folder = "E:\\SOFTUNI\\Databases Frameworks - Hibernate & Spring Data\\SPRING DATA INTRO\\08. DB-Advanced-Spring-Data-Intro-Exercises\\08. DB-Advanced-Spring-Data-Intro-Exercises\\";

    private String BOOK_PATH = folder + "books.txt";
    private String AUTHOR_PATH = folder + "authors.txt";
    private String CATEGORY_PATH = folder + "categories.txt";

    @Autowired
    private BookService<Book, Long> bookService;
    @Autowired
    private AuthorService<Author, Long> authorService;
    @Autowired
    private CategoryService<Category, Long> categoryService;

    @Override
    public void run(String... strings) throws Exception {
//        seedDatabase();
//        task_3();
//        task_4();

        //Exercises: Spring Data Advanced Quering
//        task_1();
//        task_2();
//        task_33();
//        task_44();
//        task_5();
//        task_6();
//        task_7();
//        task_8();
//        task_9();
//        task_10();
//        task_11();
//        task_12();
//        task_13();
//        task_14();
//        task_15();
//        task_16();
        //FAIL
//        task_17();
    }

    private void task_17() throws SQLException {
        Scanner in = new Scanner(System.in);
        String fName = "ui";//in.nextLine();
        String lName = "ui";//in.nextLine();
        int opalq = authorService.booksCountByAuthor(fName, lName);
    }

    private void task_16() {
        Scanner in = new Scanner(System.in);
        int count = Integer.valueOf(in.nextLine());
        int result = bookService.findBooksCountWithLowerCopies(count);
        bookService.removeBooksWithLowerCopies(count);
        if (result == 1) {
            System.out.printf("%d book was deleted", result);
        } else {
            System.out.printf("%d books were deleted", result);
        }
    }

    private void task_15() throws ParseException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

        Date date = sdf.parse(input);
        int count = Integer.parseInt(in.nextLine());
        bookService.increaseBookCopies(count, date);
        System.out.println(bookService.findAllBooksByReleaseDateAfter(date) * count);
    }

    private void task_14() {
        Scanner in = new Scanner(System.in);
        String title = in.nextLine();
        ReducedBook result = bookService.findAllBooksByTitle(title);
        if (result != null) {
            System.out.printf("%s %s %s %.2f", result.getTitle(), result.getEditionType(), result.getAgeRestriction(), result.getPrice());
        } else {
            System.out.println("No book found");
        }
    }

    private void task_13() {
        List<Category> categories = categoryService.mostRecentBooks();
        for (Category category : categories) {
            System.out.printf("--%s: %d books\n", category.getName(), category.getBooks().size());
            Set<Book> bookList = category.getBooks();
            bookList.stream()
                    .sorted(Comparator.comparing(Book::getReleaseDate).reversed().thenComparing(Book::getTitle))
                    .limit(3)
                    .forEach(x -> System.out.printf("%s (%s)\n", x.getTitle(), x.getReleaseDate().getYear()));
        }
    }

    private void task_12() {
        List<Object[]> categories = categoryService.findProfit();
        for (Object[] current : categories) {
            System.out.printf("%s - $%f\n", current[0], current[1]);
        }
    }

    private void task_11() {
        List<Object[]> found = authorService.totalBooksCopied();
        for (Object[] current : found) {
            System.out.printf("%s %d\n", current[0], current[1]);
        }
    }

    private void task_10() {
        Scanner in = new Scanner(System.in);
        Long num = Long.valueOf(in.nextLine());
        System.out.println(bookService.countBooks(num));
    }

    private void task_9() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        bookService.findAllBooksByAuthor_LastNameStartsWith(str)
                .forEach(x -> System.out.printf("%s <-> %s %s\n", x.getTitle(), x.getAuthor().getFirstName(), x.getAuthor().getLastName()));
    }

    private void task_8() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        bookService.findAllBooksByTitleContains(str).forEach(x -> System.out.println(x.getTitle()));
    }

    private void task_7() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        authorService.findAllAuthorsByFirstNameEndsWith(str)
                .forEach(x -> System.out.println(x.getFirstName()));
    }

    private void task_6() throws ParseException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(input);

        bookService.findAllBooksByReleaseDateBefore(date)
                .forEach(x -> System.out.printf("%s %s %f\n", x.getTitle(), x.getEditionType().toString(), x.getPrice()));
    }

    private void task_5() {
        Scanner in = new Scanner(System.in);
        List<String> categoriesNames = Arrays.stream(in.nextLine().split("\\s+")).collect(Collectors.toList());

        List<Category> categories = categoryService.findAllCategoriesByName(categoriesNames);

        List<Book> foundBooks = bookService.findAllBooksByCategoriesIn(categories);
        for (Book foundBook : foundBooks) {
            System.out.println(foundBook.getTitle());
        }
    }

    private void task_44() throws ParseException {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = sdf.parse(input);

        List<Book> titles = bookService.findAllBooksByReleaseDateIsNot(date);
        for (Book book : titles) {
            System.out.println(book.getTitle());
        }
    }

    private void task_33() {
        List<Object[]> res = bookService.findTitlesAndPrice();
        for (Object[] current : res) {
            System.out.printf("%s %f\n", current[0], current[1]);
        }
//                .forEach(System.out::println);
    }

    private void task_2() {
        List<Book> found = bookService.findGoldTypeBooks(EditionType.GOLD);
        for (Book book : found) {
            System.out.println(book.getTitle());
        }
    }

    private void task_1() {
        Scanner in = new Scanner(System.in);
        String restriction = in.nextLine().toLowerCase();
        AgeRestriction ar = null;

        switch (restriction) {
            case "minor":
                ar = AgeRestriction.MINOR;
                break;
            case "adult":
                ar = AgeRestriction.ADULT;
                break;
            case "teen":
                ar = AgeRestriction.TEEN;
                break;
            default:
                System.out.println("Invalid restriction");
                break;
        }

        List<Book> found = bookService.findAllBooksByRestriction(ar);
        for (Book book : found) {
            System.out.println(book.getTitle());
        }
    }

    private void task_4() {
        List<Book> books = (List<Book>) bookService.findAll();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

//save related books to the database
        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }

    }

    private void task_3() {
        //1
        bookService.findBooksAfter2000().forEach(System.out::println);
        //2
        authorService.findAllAuthorsWithAtLeastOneBookAfter1990()
                .forEach(x -> System.out.printf("%s %s\n", x.getFirstName(), x.getLastName()));
        //3
        authorService.findAll()
                .stream()
                .sorted(Comparator.comparing((Author x) -> x.getBooks().size()).reversed())
                .forEach(x -> System.out.printf("%s %s %d\n", x.getFirstName(), x.getLastName(), x.getBooks().size()));
        //4
        bookService.findAllBooksByGeorgePowell()
                .stream()
                .sorted(Comparator.comparing((Book x) -> x.getReleaseDate()).reversed()
                        .thenComparing(x -> x.getTitle()))
                .forEach(x -> System.out.printf("%s %s %d\n", x.getTitle(), x.getReleaseDate(), x.getCopies()));
    }

    private void seedDatabase() throws Exception {
        List<Author> authors = persistAuthors();
        Set<Category> categories = persistCategories();
        readBooks(categories, authors);
    }

    private void readBooks(Set<Category> categories, List<Author> authors) throws Exception {
        BufferedReader booksReader = new BufferedReader(new FileReader(BOOK_PATH));
        String line = booksReader.readLine();
        Random random = new Random();

        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);

            bookService.save(book);
        }
    }

    private Set<Category> persistCategories() throws Exception {
        BufferedReader booksReader = new BufferedReader(new FileReader(CATEGORY_PATH));
        String line = booksReader.readLine();
        Random random = new Random();
        Set<Category> categories = new HashSet<>();

        while (true) {
            if (line == null) {
                break;
            }
            if (line.equals("")) {
                line = booksReader.readLine();
            }
            Category cat = new Category();
            cat.setName(line);
            categoryService.save(cat);
            categories.add(cat);
            line = booksReader.readLine();
        }

        return categories;
    }

    private List<Author> persistAuthors() throws Exception {
        BufferedReader booksReader = new BufferedReader(new FileReader(AUTHOR_PATH));
        String line = booksReader.readLine();
        Random random = new Random();
        List<Author> authors = new ArrayList<>();
        line = booksReader.readLine();

        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            String fName = data[0];
            String lName = data[1];
            Author a = new Author();
            a.setFirstName(fName);
            a.setLastName(lName);
            authorService.save(a);

            authors.add(a);
            line = booksReader.readLine();
        }

        return authors;
    }
}
