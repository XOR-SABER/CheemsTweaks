package cheem.tweaks.cheese;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class createfooditem {
    
    public static Item AMETHYST_POTATO = registerfood("amethyst_potato", 16, Rarity.EPIC, cheeseFoodComponets.AMETHYST_POTATO);
    public static Item DIAMOND_GLOW_BERRIES = registerfood("diamond_glow_berries", 16, Rarity.EPIC, cheeseFoodComponets.DIAMOND_GLOW_BERRIES);
    public static Item REDSTONE_JELLY = registerJelly("redstone_jelly", 16, Rarity.EPIC, cheeseFoodComponets.REDSTONE_JELLY);
    public static Item BERRY_JELLY = registerJelly("sweet_berry_jelly", 16, Rarity.COMMON, cheeseFoodComponets.BERRY_JELLY);

    //MODIFED TO ACCEPT DIFFERENT TYPES
    public static Item registerfood(String id, int max_count, Rarity type, FoodComponent component){
        Item.Settings settings = new Item.Settings().maxCount(max_count).rarity(type).food(component).group(ItemGroup.FOOD);
        return Registry.register(Registry.ITEM, new Identifier(CheemsTweaks.MOD_ID, id), new Item(settings));
    }
    //I think of it like a Macro in C
    public static Item registerJelly(String id, int max_count, Rarity type, FoodComponent component){
        ItemJelly.Settings settings = new ItemJelly.Settings().maxCount(max_count).rarity(type).food(component).group(ItemGroup.FOOD);
        return Registry.register(Registry.ITEM, new Identifier(CheemsTweaks.MOD_ID, id), new ItemJelly(settings));
    }

    public static void init(){

    }
}
