package app.service.impl.book;

import app.dao.api.book.Dao;
import app.domain.book.Author;
import app.domain.book.Book;
import app.domain.book.Category;
import app.service.api.book.CategoryService;
import app.transaction.Command;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public final class CategoryServiceImpl extends AbstractService implements CategoryService {

    public CategoryServiceImpl(Dao dao) {
        super();
    }

    @Override
    public Category findByName(String name) {
        return (Category) runInTransaction(new Command<Category>() {
            @Override
            public Category execute() {
                List<Category> all = dao.findAll(Author.class);
                return all.stream().filter(x -> x.getName().equals(name)).findFirst().orElse(null);
            }
        });
    }

    @Override
    public Set<Book> getCategoryBooks(Category category) {
        return category.getBooks();
    }
}
