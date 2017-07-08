package OnlineRadioDatabase;

import OnlineRadioDatabase.exeptions.InvalidSongException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/8/2017.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        OnlineRadioDatabase onlineRadioDatabase = new OnlineRadioDatabase();

        for (int i = 0; i < n; i++) {
            String line = in.nextLine().trim();
            String[] spl = line.split(";");
            String[] time = spl[2].split(":");

            try {
                Song song = new Song(spl[0], spl[1], time[0], time[1]);
                onlineRadioDatabase.addSong(song);
                System.out.println("Song added.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println("Songs added: " + onlineRadioDatabase.getSongsCount());
        System.out.println(onlineRadioDatabase.getFormattedTotalTime());
    }

}
