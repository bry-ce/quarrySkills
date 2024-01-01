package me.packwatch.quarryskills.model;

public class PlayerSkillXP {
    private String uuid;
    private double geologistXp;
    private double spelunkerXp;
    private double demolitionistXp;
    private int geologistLevel;
    private int spelunkerLevel;
    private int demolitionistLevel;

    public int getGeologistLevel() {
        return geologistLevel;
    }

    public void setGeologistLevel(int geologistLevel) {
        this.geologistLevel = geologistLevel;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getGeologistXp() {
        return geologistXp;
    }

    public void setGeologistXp(double geologistXp) {
        this.geologistXp = geologistXp;
    }

    public double getSpelunkerXp() {
        return spelunkerXp;
    }

    public void setSpelunkerXp(double spelunkerXp) {
        this.spelunkerXp = spelunkerXp;
    }

    public double getDemolitionistXp() {
        return demolitionistXp;
    }

    public void setDemolitionistXp(double demolitionistXp) {
        this.demolitionistXp = demolitionistXp;
    }

    public int getSpelunkerLevel() {
        return spelunkerLevel;
    }

    public void setSpelunkerLevel(int spelunkerLevel) {
        this.spelunkerLevel = spelunkerLevel;
    }

    public int getDemolitionistLevel() {
        return demolitionistLevel;
    }

    public void setDemolitionistLevel(int demolitionistLevel) {
        this.demolitionistLevel = demolitionistLevel;
    }

    public PlayerSkillXP(String uuid, double geologistXp, double spelunkerXp, double demolitionistXp, int geologistLevel, int spelunkerLevel, int demolitionistLevel) {
        this.uuid = uuid;
        this.geologistXp = geologistXp;
        this.spelunkerXp = spelunkerXp;
        this.demolitionistXp = demolitionistXp;
        this.geologistLevel = geologistLevel;
        this.spelunkerLevel = spelunkerLevel;
        this.demolitionistLevel = demolitionistLevel;
    }
}
