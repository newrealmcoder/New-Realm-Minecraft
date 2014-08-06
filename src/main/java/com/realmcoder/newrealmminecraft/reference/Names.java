package com.realmcoder.newrealmminecraft.reference;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class Names {

    public static class Items
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

    public static class Blocks
    {
        public static final String RUBY_PEDESTAL = "rubyPedestal";
    }

}
