package me.devsnox.itemprotection.protection;

import de.tr7zw.itemnbtapi.NBTItem;
import me.devsnox.itemprotection.connection.ConnectionConfig;
import me.devsnox.itemprotection.connection.SkyConnection;
import me.devsnox.itemprotection.connection.SyncMySQL;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProtectionLoader {

    private Plugin plugin;

    private SkyConnection skyConnection;
    private SyncMySQL connection;

    private String table;

    public ProtectionLoader(Plugin plugin) {
        this.plugin = plugin;

        this.table = "itemprotection_entites";

        this.skyConnection = new SkyConnection(new ConnectionConfig(plugin.getDataFolder(), new File(plugin.getDataFolder() + File.separator + "mysql.yml")));
        this.skyConnection.connect();
        this.connection = this.skyConnection.sync();

        this.connection.update("CREATE TABLE IF NOT EXISTS " + table + " (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, VALIDATED TINYINT(1))");
    }

    public ItemStack addProtection(ItemStack itemStack) {

        NBTItem nbtItem = new NBTItem(itemStack);

        try {
            PreparedStatement preparedStatment = this.skyConnection.getConnection().prepareStatement("INSERT INTO " + table + "(VALIDATED) VALUES(0)", Statement.RETURN_GENERATED_KEYS);
            preparedStatment.executeUpdate();
            ResultSet resultSet = preparedStatment.getGeneratedKeys();

            if(resultSet.next()) {

                nbtItem.setInteger("protectionId", resultSet.getInt(1));

                return nbtItem.getItem();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        nbtItem.setInteger("protectionId", 1);

        return nbtItem.getItem();
    }

    public void validate(int id) {
        this.connection.update("UPDATE " + table + " SET VALIDATED='1' WHERE ID='" + id + "'");
    }

    public boolean checkProtection(int id) {
        ResultSet resultSet = this.connection.query("SELECT * FROM " + table + " WHERE ID='" + id + "'");

        try {
            if(resultSet.next()) {
                return resultSet.getBoolean("VALIDATED");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //TODO: Add Information for not sucessfully connection

        return true;
    }

    public SyncMySQL getConnection() {
        return connection;
    }
}
