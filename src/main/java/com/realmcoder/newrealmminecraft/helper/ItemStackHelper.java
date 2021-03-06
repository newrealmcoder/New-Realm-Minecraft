package com.realmcoder.newrealmminecraft.helper;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class ItemStackHelper {
    
    public static Comparator<ItemStack> comparator = new Comparator<ItemStack>()
    {

        @Override
        public int compare(ItemStack itemStack1, ItemStack itemStack2)
        {
            if(itemStack1 != null)
            {
                if(itemStack2 != null)
                {
                    if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                    {
                        if (itemStack1.getItemDamage() == itemStack2.getItemDamage() || itemStack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || itemStack2.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                        {
                            if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                            {
                                if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                                {
                                    return itemStack1.stackSize - itemStack2.stackSize;
                                }
                                else
                                {
                                    return itemStack2.getTagCompound().hashCode() - itemStack1.getTagCompound().hashCode();
                                }
                            }
                            else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                            {
                                return itemStack1.stackSize - itemStack2.stackSize;
                            }
                        }
                    }
                    else
                    {
                        return Item.getIdFromItem(itemStack1.getItem()) - Item.getIdFromItem(itemStack2.getItem());
                    }
                }
                else
                {
                    return Integer.MAX_VALUE;
                }
            }
            return Integer.MIN_VALUE;
        }
    };

    /**
     * Checks all ItemStack components besides stackSize
     * @param itemStack1
     * @param itemStack2
     * @return
     */
    public static boolean areItemStacksAreEqualIgnoreSize(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage() || itemStack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || itemStack2.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    {
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                        {
                            if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                            {
                                return true;
                            }
                        }
                        else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                        {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * Checks for ItemStack size as well as all other ItemStack components
     * @param itemStack1
     * @param itemStack2
     * @return
     */
    public static boolean areItemStacksExactlyEqual(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.getItemDamage() == itemStack2.getItemDamage() || itemStack1.getItemDamage() == OreDictionary.WILDCARD_VALUE || itemStack2.getItemDamage() == OreDictionary.WILDCARD_VALUE)
                    {
                        if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                        {
                            if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                            {
                                return itemStack2.stackSize >= itemStack1.stackSize;
                            }
                        }
                        else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                        {
                            return itemStack2.stackSize >= itemStack1.stackSize;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean areItemStacksAreEqualIgnoreSizeAndMeta(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                    {
                        if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                        {
                            return true;
                        }
                    }
                    else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean areItemStacksEqualIgnoreMeta(ItemStack itemStack1, ItemStack itemStack2)
    {
        if(itemStack1 != null)
        {
            if(itemStack2 != null)
            {
                if(itemStack1.getItem().getIdFromItem(itemStack1.getItem()) == itemStack2.getItem().getIdFromItem(itemStack2.getItem()))
                {
                    if (itemStack1.hasTagCompound() && itemStack2.hasTagCompound())
                    {
                        if (itemStack1.getTagCompound().hashCode() == itemStack2.getTagCompound().hashCode())
                        {
                            return itemStack2.stackSize >= itemStack1.stackSize;
                        }
                    }
                    else if (!itemStack1.hasTagCompound() && !itemStack2.hasTagCompound())
                    {
                        return itemStack2.stackSize >= itemStack1.stackSize;
                    }
                }
            }
        }
        return false;
    }
}
