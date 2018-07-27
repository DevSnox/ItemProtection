package me.devsnox.itemprotection.protection

import de.tr7zw.itemnbtapi.NBTItem
import me.devsnox.itemprotection.connection.ConnectionConfig
import me.devsnox.itemprotection.connection.SkyConnection
import org.bukkit.inventory.ItemStack
import java.io.File
import java.sql.SQLException
import java.sql.Statement

class ProtectionLoader(dataFolder: File) {
    private val skyConnection: SkyConnection = SkyConnection(ConnectionConfig(dataFolder, File(dataFolder.toString() + File.separator + "mysql.yml")))
    private val table: String = "itemprotection_entites"

    init {
        this.skyConnection.connect()
//        this.connection.update("CREATE TABLE IF NOT EXISTS " + this.table + " (ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, VALIDATED TINYINT(1))")
    }

    fun addProtection(itemStack: ItemStack): ItemStack {

        val nbtItem = NBTItem(itemStack)

        try {
            val preparedStatment = this.skyConnection.connection.prepareStatement("INSERT INTO " + this.table + "(VALIDATED) VALUES(0)", Statement.RETURN_GENERATED_KEYS)
            preparedStatment.executeUpdate()
            val resultSet = preparedStatment.generatedKeys

            if (resultSet.next()) {

                nbtItem.setInteger("protectionId", resultSet.getInt(1))

                return nbtItem.item
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        nbtItem.setInteger("protectionId", 1)

        return nbtItem.item
    }

    fun validate(id: Int) {
//        this.connection.update("UPDATE " + this.table + " SET VALIDATED='1' WHERE ID='" + id + "'")
    }

    fun checkProtection(id: Int): Boolean {
//        val resultSet = this.connection.query("SELECT * FROM " + this.table + " WHERE ID='" + id + "'")

        try {
//            if (resultSet!!.next()) {
//                return resultSet.getBoolean("VALIDATED")
//            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }

        //TODO: Add Information for not sucessfully connection

        return true
    }

}
