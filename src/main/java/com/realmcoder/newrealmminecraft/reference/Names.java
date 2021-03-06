package com.realmcoder.newrealmminecraft.reference;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class Names {

    public static final class Items
    {
        public static final String THROWING_ROCK = "throwingRock";
        public static final String MATERIAL      = "material";
            public static final String[] MATERIAL_SUBTYPES = new String[]{
                    "gemRuby", "gemPeridot", "gemSapphire", "gemEnrichium", "gemEnergium", "ingotCopper", "ingotTin", "ingotSilver", "ingotLead", "ingotMagnetite",
                    "ingotZinc", "ingotManganese", "ingotSteel", "ingotSteamSteel", "ingotSteamGold", "ingotSteamSilver", "ingotSteamTin", "ingotSteamCopper",
                    "dustRuby", "dustPeridot", "dustSapphire", "dustEnrichium", "dustEnergium", "dustCopper", "dustTin", "dustSilver", "dustLead", "dustMagnetite",
                    "dustZinc", "dustManganese", "dustSteel", "dustSteamSteel", "dustSteamGold", "dustSteamSilver", "dustSteamTin", "dustSteamCopper", "dustIron",
                    "dustGold", "dustDiamond", "dustEmerald", "bowlStone"

            };
            public static final int MATERIAL_CRUSHABLE_LIMIT = 18;
            public static final int MATERIAL_END_OF_DUSTS = (MATERIAL_CRUSHABLE_LIMIT * 2) + 4;
            public static final int MATERIAL_IN_OREDICT_LIMIT = MATERIAL_SUBTYPES.length;
        public static final String MORTAR_AND_PESTLE = "mortarAndPestle";
    }

    public static final class Blocks
    {
        public static final String GEM_PEDESTAL = "gemPedestal";
        public static final String TILE_ENTITY_BLOCK = "tileEntityBlock";
            /**
             * A complicated construct. This contains the neccessary information to setup multisided textures for TileEntity(TE) blocks
             *     The String[] array contains each TE's set of textures
             *     Each array inside is formatted like so...
             *         baseName --> Used for getting length
             *         baseNameX --> X is a number that defines what sides should this texture variant should
             *             be shown on. 1 --> Bottom, 2 --> Top, 3 --> North, 4 --> South, 5 --> West, 6 --> East
             *             !!IMPORTANT: ZERO(0) is skipped due to the method of unpacking the numbers!!
             * !!IMPORTANT: the name of the sided textures should be TILE_ENTITY_BLOCK.baseName.baseNameX.png!!
             * Note: you can have an unsided tile entity by only having baseName, it will avoid going through the process and save space!
             */
            public static final String[][] TILE_ENTITY_BLOCK_SUBTYPES = new String[][]{
                    new String[]{
                            "grindstone", "grindstone1", "grindstone2345", "grindstone6"
                    }
            };

    }

    public static final class NBT
    {
        //General TE info
        public static final String CUSTOM_NAME = "customName";
        public static final String IS_PRIVATE  = "private";
        public static final String ORIENTATION = "orientation";
        public static final String OWNER       = "owner";
        public static final String STATE       = "state";
    }

}
