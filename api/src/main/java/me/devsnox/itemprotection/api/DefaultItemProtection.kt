package me.devsnox.itemprotection.api

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 27.07.2018 00:39.
 * Last edit 27.07.2018
 */
interface DefaultItemProtection : ItemProtection {

    override fun isLoaded(): Boolean = instance != null
}