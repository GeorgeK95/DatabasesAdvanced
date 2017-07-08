package OnlineRadioDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 7/8/2017.
 */
public class OnlineRadioDatabase {
    private List<Song> songList;

    public OnlineRadioDatabase() {
        this.songList = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        this.songList.add(song);
    }

    public int getSongsCount() {
        return songList.size();
    }

    public String getFormattedTotalTime() {
        int sec = songList.stream().mapToInt(Song::getSeconds).sum();
        int min = songList.stream().mapToInt(Song::getMinutes).sum();

        int totalLength = min * 60 + sec;
        int hours = totalLength / 60 / 60;
        int minutes = (totalLength / 60) - (hours * 60);
        int seconds = totalLength % 60;

        return String.format("Playlist length: %dh %dm %ds", hours, minutes, seconds);
    }
}
