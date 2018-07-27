package me.devsnox.itemprotection.api;

import org.bukkit.inventory.ItemStack;

@Deprecated
public class ItemProtectionAPI {
    private static ItemProtectionAPI instance;
    
    public static boolean isLoaded()
    {
        return ItemProtectionFactory.INSTANCE.isLoaded();
    }
    
    public static ItemProtectionAPI getInstance()
    {
        return instance;
    }
    
    public ItemStack addProtection(ItemStack itemStack)
    {
        if (!check(itemStack))
        {
            return null;
        }
        return ItemProtectionFactory.INSTANCE.getItemProtection().addProtection(itemStack);
    }
    
    public void validate(ItemStack itemStack)
    {
        if (!check(itemStack))
        {
            ItemProtectionFactory.INSTANCE.getItemProtection().validate(itemStack);
        }
    }
    
    public boolean alreadyUsed(ItemStack itemStack)
    {
        if (check(itemStack))
        {
            return false;
        }
        return ItemProtectionFactory.INSTANCE.getItemProtection().alreadyUsed(itemStack);
    }
    
    private Boolean check(ItemStack itemStack)
    {
        return itemStack != null || ItemProtectionFactory.INSTANCE.isLoaded();
    }
}
