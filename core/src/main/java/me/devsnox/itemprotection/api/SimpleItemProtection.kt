package me.devsnox.itemprotection.api

import de.tr7zw.itemnbtapi.NBTItem
import org.bukkit.inventory.ItemStack
import java.util.*

/**
 * @author Lars Artmann | LartyHD
 * Created by Lars Artmann | LartyHD on 27.07.2018 00:52.
 * Last edit 06.06.2019
 */
class SimpleItemProtection : ItemProtection {

	private val protectionId = "protectionId"

	override fun addProtection(itemStack: ItemStack): ItemStack = NBTItem(itemStack).apply { setString(protectionId, UUID.randomUUID().toString()) }.item

	override fun validate(itemStack: ItemStack): Unit = NBTItem(itemStack).removeKey(protectionId)

	override fun alreadyUsed(itemStack: ItemStack): Boolean = NBTItem(itemStack).hasKey(protectionId)

}