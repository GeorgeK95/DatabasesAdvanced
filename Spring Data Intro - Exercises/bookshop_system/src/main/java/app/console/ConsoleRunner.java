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
import java.text.SimpleDateFormat;
import java.util.*;

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
    private CategoryService categoryService;

    @Override
    public void run(String... strings) throws Exception {
//        seedDatabase();
//        task_3();
        task_4();
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
