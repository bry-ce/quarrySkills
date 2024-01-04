package me.packwatch.quarryskills.db;

import me.packwatch.quarryskills.model.PlayerData;
import me.packwatch.quarryskills.model.PlayerSkillXP;
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

        Statement playerdatastatement = getConnection().createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS player_data(uuid varchar(36) primary key, shards int, coins double, pebbles int, fortune double, treasure_find double, swing_strength int)";
        playerdatastatement.execute(sql);
        playerdatastatement.close();

        PreparedStatement  skillxpstatement = getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS player_skill_xp(uuid varchar(36) primary key, geologist_xp double, geologist_level int, spelunker_xp double, spelunker_level int, demolitionist_xp double, demolitionist_level int)");
        skillxpstatement.execute();
        skillxpstatement.close();

    }

    public PlayerData findPlayerDataByUUID(String uuid)  {
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_data WHERE uuid = ?");
            statement.setString(1, uuid);

            ResultSet results = statement.executeQuery();


            if (results.next()) {
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
        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
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

    public void createPlayerSkillXP(PlayerSkillXP pxp) throws SQLException {
        PreparedStatement statement = getConnection()
                .prepareStatement("INSERT INTO player_skill_xp (uuid, geologist_xp, geologist_level, spelunker_xp, spelunker_level, demolitionist_xp, demolitionist_level) VALUES (?,?,?,?,?,?,?)");

        statement.setString(1, pxp.getUuid());
        statement.setInt(3, pxp.getGeologistLevel());
        statement.setDouble(2, pxp.getGeologistXp());
        statement.setInt(5, pxp.getSpelunkerLevel());
        statement.setDouble(4, pxp.getSpelunkerXp());
        statement.setInt(7, pxp.getDemolitionistLevel());
        statement.setDouble(6, pxp.getDemolitionistXp());

        statement.executeUpdate();
        statement.close();
    }

    public PlayerSkillXP findPlayerSkillXpByUUID(String uuid) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_skill_xp WHERE uuid = ?");
        statement.setString(1,uuid);

        ResultSet results = statement.executeQuery();



        if (results.next()){
            int geolvl = results.getInt("geologist_level");
            int spellvl = results.getInt("spelunker_level");
            int demolvl = results.getInt("demolitionist_level");
            double geoxp = results.getDouble("geologist_xp");
            double spelxp = results.getDouble("spelunker_xp");
            double demoxp = results.getDouble("demolitionist_xp");

            PlayerSkillXP pxp = new PlayerSkillXP(uuid, geoxp, spelxp, demoxp, geolvl, spellvl, demolvl);
            statement.close();

            return pxp;
        }
        return null;
    }

    public double fetchFortuneByUUID(String uuid) {
        PreparedStatement statement = null;
        try {
            statement = getConnection()
                    .prepareStatement("SELECT fortune FROM player_data WHERE uuid = ?");

            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();

            if(results.next()) {
                double d = results.getDouble(1);
                statement.close();
                return d;
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public double fetchTreasureFindByUUID(String uuid){
        PreparedStatement statement = null;
        try {
            statement = getConnection()
                    .prepareStatement("SELECT treasure_find FROM player_data WHERE uuid = ?");


            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();

            if(results.next()) {
                double d = results.getDouble(1);
                statement.close();
                return d;
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public int fetchSwingStrengthByUUID(String uuid){
        PreparedStatement statement = null;
        try {
            statement = getConnection()
                    .prepareStatement("SELECT swing_strength FROM player_data WHERE uuid = ?");


            statement.setString(1, uuid);
            ResultSet results = statement.executeQuery();

            if(results.next()) {
                int i = results.getInt(1);
                statement.close();
                return i;
            }

            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public double fetchSkillXPByUUID(String uuid, String xp_column_name){
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement("SELECT geologist_xp FROM player_skill_xp WHERE uuid = ?");
            //statement.setString(1, xp_column_name);
            statement.setString(1, uuid);

            ResultSet results = statement.executeQuery();

            if (results.next()){
                double d = results.getDouble(1);
                statement.close();
                return d;
            }

            return 0;

        } catch (SQLException ex){
            throw new RuntimeException(ex);
        }
    }

    public void updatePlayerData(PlayerData pd) throws SQLException{
        PreparedStatement statement = getConnection()
                .prepareStatement("UPDATE player_data SET coins = ? WHERE uuid = ?");

        statement.setDouble(1, pd.getCoins());
        statement.setString(2, pd.getUuid());

        statement.executeUpdate();
        statement.close();
    }

}

