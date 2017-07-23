package app.transaction;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface TransactionExecutor<E> {
    E runInTransaction(Command<E> command);

    List<E> runInTransaction(MultiCommand<E> command);

}
