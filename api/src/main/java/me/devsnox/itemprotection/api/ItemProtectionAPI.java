package me.devsnox.itemprotection.api;

import org.bukkit.inventory.ItemStack;

@Deprecated
public class ItemProtectionAPI {
    /*private static final ItemProtection itemProtection = new DefaultItemProtection()
    {
        @Override
        public boolean isLoaded()
        {
            return false;
        }
        
        @Nullable
        @Override
        public ItemProtection getInstance()
        {
            return null;
        }
        
        @NotNull
        @Override
        public ItemStack addProtection(@NotNull ItemStack itemStack)
        {
            return null;
        }
        
        @Override
        public void validate(@NotNull ItemStack itemStack)
        {
        }
        
        @Override
        public boolean alreadyUsed(@NotNull ItemStack itemStack)
        {
            return false;
        }
    };*/
    
    public static boolean isLoaded()
    {
        throw new UnsupportedOperationException("not implement");
        /*return itemProtection.isLoaded();*/
    }
    
    public static ItemProtectionAPI getInstance()
    {
        throw new UnsupportedOperationException("not implement");
    }
    
    public ItemStack addProtection(ItemStack itemStack)
    {
        throw new UnsupportedOperationException("not implement");
        /* return itemProtection.addProtection(itemStack);*/
    }
    
    public void validate(ItemStack itemStack)
    {
        throw new UnsupportedOperationException("not implement");
        /* itemProtection.validate(itemStack);*/
    }
    
    public boolean alreadyUsed(ItemStack itemStack)
    {
        throw new UnsupportedOperationException("not implement");
        /* return itemProtection.alreadyUsed(itemStack);*/
    }
}
