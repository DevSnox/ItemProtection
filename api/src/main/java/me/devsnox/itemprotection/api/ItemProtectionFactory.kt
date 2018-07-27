package me.devsnox.itemprotection.api

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 27.07.2018 19:44.
 * Last edit 27.07.2018
 */
object ItemProtectionFactory {

    var itemProtection: ItemProtection? = null

    fun isLoaded(): Boolean = itemProtection != null

}