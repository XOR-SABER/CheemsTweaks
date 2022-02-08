package cheem.tweaks.cheese;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class createitem {
    
    public static final Item RAW_SULFUR = register("raw_sulfur", 64);
    public static final Item PURE_SULFUR = register("pure_sulfur", 64);
    public static final Item VINYL_SHARDS = register("vinyl_shards", 64);
    public static final Item BLANK_VINYL = register("blank_vinyl", 64);
    public static final Item EMPTY_JAR = register("empty_jar", 64);

    public static Item register(String id, int max_count){
        Item.Settings settings = new Item.Settings().maxCount(max_count).group(ItemGroup.MATERIALS);
        return Registry.register(Registry.ITEM, new Identifier(CheemsTweaks.MOD_ID,id), new Item(settings));
    }

    public static void init(){}
}
