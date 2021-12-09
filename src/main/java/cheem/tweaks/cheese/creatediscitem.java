package cheem.tweaks.cheese;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class creatediscitem {

    public static final Item DISC_GUNS = register("music_guns", CheemsTweaks.GUNS_EVENT);
    public static final Item DISC_SENPAI = register("music_senpai", CheemsTweaks.SENPAI_EVENT);
    public static final Item DISC_MONSTER = register("music_monster", CheemsTweaks.MONSTER_EVENT);
    public static final Item DISC_JACK = register("music_jack", CheemsTweaks.JACK_EVENT);

    public static Item register(String id, SoundEvent sound) {
        Item.Settings settings = new Item.Settings().rarity(Rarity.RARE).maxCount(1).group(ItemGroup.MISC);
        return Registry.register(Registry.ITEM, new Identifier(CheemsTweaks.MOD_ID, id), new CreateDisc(14, sound, settings));
    }

    public static void init() { }

}
