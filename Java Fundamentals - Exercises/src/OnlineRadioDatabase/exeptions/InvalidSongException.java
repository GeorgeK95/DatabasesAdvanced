package OnlineRadioDatabase.exeptions;

/**
 * Created by George-Lenovo on 7/8/2017.
 */
public class InvalidSongException extends RuntimeException {
    public InvalidSongException(String message) {
        super(message);
    }
}
