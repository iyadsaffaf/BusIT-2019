package cz.mendelu.busitweek2019;

public class Player {

    private String name;
    private  int time;
    private int stars;



    public Player(String name, int time, int stars) {
        this.name = name;
        this.time = time;
        this.stars = stars;
    }

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int sters) {
        this.stars = sters;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", Time=" + time +
                ", stars=" + stars +
                '}';
    }
}
