package me.packwatch.quarryskills.db;

import me.packwatch.quarryskills.model.PlayerData;
import org.bukkit.entity.Player;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException{

        if(this.connection != null){
            return connection;
        }

        String url = "jdbc:mysql://localhost/quarrymc";
        String user = "root";
        String password = "";

        this.connection =  DriverManager.getConnection(url, user, password);

        return this.connection;

    }

    public void initDatabase() throws SQLException{

        Statement statement = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS player_data(uuid varchar(36) primary key, shards int, coins double, pebbles int, fortune double, treasure_find double, swing_strength int)";
        statement.execute(sql);

        statement.close();

    }

    public PlayerData findPlayerDataByUUID(String uuid) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_data WHERE uuid = ?");
        statement.setString(1,uuid);

        ResultSet results = statement.executeQuery();



        if (results.next()){
            int shards = results.getInt("shards");
            double coins = results.getDouble("coins");
            int pebbles = results.getInt("pebbles");
            double fortune = results.getInt("fortune");
            double treasure_find = results.getInt("treasure_find");
            int swing_strength = results.getInt("swing_strength");

            PlayerData playerData = new PlayerData(uuid, shards, coins, pebbles, fortune, treasure_find, swing_strength);
            statement.close();

            return playerData;
        }
        return null;
    }

    public void createPlayerData(PlayerData pd) throws SQLException{
        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO player_data (uuid, shards, coins, pebbles, fortune, treasure_find, swing_strength) VALUES (?,?,?,?,?,?,?)");

        statement.setString(1, pd.getUuid());
        statement.setInt(2, pd.getShards());
        statement.setDouble(3, pd.getCoins());
        statement.setInt(4, pd.getPebbles());
        statement.setDouble(5, pd.getFortune());
        statement.setDouble(6, pd.getTreasure_find());
        statement.setInt(7, pd.getSwing_strength());

        statement.executeUpdate();
        statement.close();
    }

    public String fetchStringByUUID(String column, String uuid) {
        PreparedStatement statement = null;
        try {
            statement = getConnection()
                    .prepareStatement("SELECT ? FROM player_data WHERE uuid = ?");

            ResultSet results = statement.executeQuery();

            statement.setString(1, column);
            statement.setString(2, uuid);


            String s = results.getNString(column);
            statement.close();
            return s;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public int fetchIntByUUID(String column, String uuid) {
        PreparedStatement statement = null;

        try {

            statement = getConnection()
                    .prepareStatement("SELECT ? FROM player_data WHERE uuid = ?");

            ResultSet results = statement.executeQuery();

            statement.setString(1, column);
            statement.setString(2, uuid);


            int i = results.getInt(column);
            statement.close();
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double fetchFortuneByUUID(int column, String uuid) {
        PreparedStatement statement = null;
        try {
            statement = getConnection()
                    .prepareStatement("SELECT fortune FROM player_data WHERE uuid = ?");


            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();

            if(results.next()) {
                double d = results.getDouble(column);
                statement.close();
                return d;
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

