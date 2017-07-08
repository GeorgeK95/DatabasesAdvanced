package OnlineRadioDatabase;

import OnlineRadioDatabase.exeptions.*;

/**
 * Created by George-Lenovo on 7/8/2017.
 */
public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, String minutes, String seconds) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setLength(minutes, seconds);
    }

    private void setLength(String minutes, String seconds) {
        int m;
        int s;

        try {
            m = Integer.valueOf(minutes);
            s = Integer.valueOf(seconds);
        } catch (NumberFormatException nfe) {
            throw new InvalidSongLengthException("Invalid song length.");
        }

        this.setMinutes(m);
        this.setSeconds(s);

    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        if (artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }

        this.artistName = artistName;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 20) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.songName = songName;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }

        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }
}
