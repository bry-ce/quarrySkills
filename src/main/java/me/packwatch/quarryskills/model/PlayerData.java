package me.packwatch.quarryskills.model;

public class PlayerData {
    private String uuid;
    private int shards;
    private double coins;
    private int pebbles;
    private double fortune;
    private double treasure_find;
    private int swing_strength;

    public PlayerData(String uuid, int shards, double coins, int pebbles, double fortune, double treasure_find, int swing_strength) {
        this.uuid = uuid;
        this.shards = shards;
        this.coins = coins;
        this.pebbles = pebbles;
        this.fortune = fortune;
        this.treasure_find = treasure_find;
        this.swing_strength = swing_strength;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getShards() {
        return shards;
    }

    public void setShards(int shards) {
        this.shards = shards;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public int getPebbles() {
        return pebbles;
    }

    public void setPebbles(int pebbles) {
        this.pebbles = pebbles;
    }

    public double getFortune() {
        return fortune;
    }

    public void setFortune(double fortune) {
        this.fortune = fortune;
    }

    public double getTreasure_find() {
        return treasure_find;
    }

    public void setTreasure_find(double treasure_find) {
        this.treasure_find = treasure_find;
    }

    public int getSwing_strength() {
        return swing_strength;
    }

    public void setSwing_strength(int swing_strength) {
        this.swing_strength = swing_strength;
    }
}
