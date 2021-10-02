package cheem.tweaks.cheese;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheemsTweaks implements ModInitializer {
	public static final Item RAW_SULFUR = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
	public static final Logger LOGGER = LogManager.getLogger("cheemstweaks");

	@Override
	public void onInitialize() {

		Registry.register(Registry.ITEM, new Identifier("cheemstweaks", "raw_sulfur"), RAW_SULFUR);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
