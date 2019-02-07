package cz.mendelu.busitweek2019;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

class Player {

    private static final Player currentPlayer = new Player();

    private String name;

    private long startTime;
    private long endTime;
    private boolean isPlaying = false;

    private int stars = 0;

    static Player getPlayer() {
        return currentPlayer;
    }

    private Player() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void startTimer() {
        startTime = System.currentTimeMillis();
        isPlaying = true;
    }

    public void endTimer() {
        if(isPlaying){
            endTime = System.currentTimeMillis();
            isPlaying = false;
        }
    }

    public String getFormattedTime() {
        Log.d("timer", String.valueOf(endTime));

        Log.d("timer", String.valueOf(startTime));

        int secondsDifference = (int) ((endTime - startTime) / 1000);
        int seconds = secondsDifference % 60;
        int minutes = secondsDifference / 60;

        return String.format("%02d:%02d", minutes, seconds);
    }
}
