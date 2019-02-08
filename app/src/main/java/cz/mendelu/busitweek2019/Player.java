package cz.mendelu.busitweek2019;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

class Player {

    private static final Player currentPlayer = new Player();

    private String name;

    private long startTime;
    private long time;
    private boolean isPlaying = false;
    private String key;
    private String formattedTime;

    private int stars = 0;

    static Player getPlayer() {
        return currentPlayer;
    }

    public Player() { }

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
            time = (System.currentTimeMillis() - startTime) / 1000;
            isPlaying = false;

        }
    }

    public String getFormattedTime() {
        if(formattedTime != null){
            return formattedTime;
        }
        int secondsDifference = (int) (time);
        int seconds = secondsDifference % 60;
        int minutes = secondsDifference / 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
       return (int)time;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }
}
