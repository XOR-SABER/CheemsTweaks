package cheem.tweaks.cheese;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheemsTweaks implements ModInitializer {

	//Varible Declarations
	public static final String MOD_ID = "cheemstweaks";

	//Item Declarations
	public static final Item RAW_SULFUR = new Item(new Item
	.Settings()
	.group(ItemGroup.MATERIALS));
	public static final Item PURE_SULFUR = new Item(new Item
	.Settings()
	.group(ItemGroup.MATERIALS));
	
	//Food Declarations
	public static final Item AMETHYST_POTATO = new Item(new Item
	.Settings()
	.group(ItemGroup.FOOD)
	.food(cheeseFoodComponets.AMETHYST_POTATO));
	public static final Item DIAMOND_GLOW_BERRIES = new Item(new Item
	.Settings()
	.group(ItemGroup.FOOD)
	.food(cheeseFoodComponets.DIAMOND_GLOW_BERRIES));

	//Block Declarations
	public static final Block RAW_SULFUR_BLOCK = new Block(FabricBlockSettings
	.of(Material.STONE)
	.strength(4, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));
	public static final Block SULFUR_ORE = new Block(FabricBlockSettings
	.of(Material.STONE)
	.strength(5, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));

	//Other Declarations
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	

	public static void register_item(String name_item, Item declaree) {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, name_item), declaree);
	}

	public static void register_block(String name_block, Block declaree, ItemGroup item_group) {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name_block), declaree);
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, name_block), new BlockItem(declaree, new Item.Settings().group(item_group)));
	}

	@Override
	public void onInitialize() {
		
		//Items

		//Ore Items
		register_item("raw_sulfur", RAW_SULFUR);
		register_item("pure_sulfur", PURE_SULFUR);
		//Food Items
		register_item("amethyst_potato", AMETHYST_POTATO);
		register_item("diamond_glow_berries", DIAMOND_GLOW_BERRIES);
		
		//Blocks
		register_block("raw_sulfur_block", RAW_SULFUR_BLOCK, ItemGroup.BUILDING_BLOCKS);
		register_block("sulfur_ore", SULFUR_ORE, ItemGroup.BUILDING_BLOCKS);
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Cheems Tweaks loaded!");
	}
}
