package me.devsnox.itemprotection.api

import org.bukkit.inventory.ItemStack

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 27.07.2018 00:36.
 * Last edit 27.07.2018
 */
interface ItemProtection {

    val instance: ItemProtection?

    fun addProtection(itemStack: ItemStack): ItemStack

    fun validate(itemStack: ItemStack)

    fun alreadyUsed(itemStack: ItemStack): Boolean

    fun isLoaded(): Boolean {
        TODO()
    }

}