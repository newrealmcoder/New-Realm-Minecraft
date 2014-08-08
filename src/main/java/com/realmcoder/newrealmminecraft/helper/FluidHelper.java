package com.realmcoder.newrealmminecraft.helper;

import java.util.Comparator;

import net.minecraftforge.fluids.FluidStack;


public class FluidHelper {
    
    public static Comparator<FluidStack> comparator = new Comparator<FluidStack>()
    {
        public int compare(FluidStack fluidStack1, FluidStack fluidStack2)
        {
            if(fluidStack1 != null)
            {
                if(fluidStack2 != null)
                {
                    if(fluidStack1.fluidID == fluidStack2.fluidID)
                    {
                        if(fluidStack1.amount == fluidStack2.amount)
                        {
                            if (fluidStack1.tag != null)
                            {
                                if (fluidStack2.tag != null)
                                {
                                    return (fluidStack1.tag.hashCode() - fluidStack2.tag.hashCode());
                                }
                                else
                                {
                                    return Integer.MAX_VALUE;
                                }
                            }
                            else
                            {
                                if (fluidStack2.tag != null)
                                {
                                    return Integer.MIN_VALUE;
                                }
                                else
                                {
                                    return 0;
                                }
                            }
                        }
                        else
                        {
                            return fluidStack2.amount - fluidStack2.amount;
                        }
                    }
                    else
                    {
                        return fluidStack2.fluidID - fluidStack1.fluidID;
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
    
}
