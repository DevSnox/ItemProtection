package me.devsnox.itemprotection.api

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 27.07.2018 00:52.
 * Last edit 27.07.2018
 */
class SimpleItemProtection : ItemProtection {
    override fun addProtection(itemStack: org.bukkit.inventory.ItemStack): org.bukkit.inventory.ItemStack {

    }

    override fun validate(itemStack: org.bukkit.inventory.ItemStack) {
    }

    override fun alreadyUsed(itemStack: org.bukkit.inventory.ItemStack): Boolean {
    }

}