package cheem.tweaks.cheese;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheemsTweaks implements ModInitializer {

	//Varible Declarations
	public static final String MOD_ID = "cheemstweaks";
	
	//Sound events
	public static final Identifier GUNS_ID = new Identifier("cheemstweaks:gunsfnf");
	public static final Identifier MONSTER_ID = new Identifier("cheemstweaks:monsterfnf");
	public static final Identifier SENPAI_ID = new Identifier("cheemstweaks:senpaifnf");
	public static final Identifier JACK_ID = new Identifier("cheemstweaks:jack");

	public static SoundEvent GUNS_EVENT = new SoundEvent(GUNS_ID);
	public static SoundEvent MONSTER_EVENT = new SoundEvent(MONSTER_ID);
	public static SoundEvent SENPAI_EVENT = new SoundEvent(SENPAI_ID);
	public static SoundEvent JACK_EVENT = new SoundEvent(JACK_ID);

	//Block Declarations
	public static final Block RAW_SULFUR_BLOCK = new Block(FabricBlockSettings
	.of(Material.STONE)
	.strength(4, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));

	public static final Block TINTED_RAW_SULFUR_BLOCK = new Block(FabricBlockSettings
	.of(Material.STONE)
	.strength(4, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));

	public static final Block SULFUR_ORE = new SulfurOreBlock(FabricBlockSettings
	.of(Material.STONE)
	.strength(5, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));

	public static final Block DEEPSLATE_SULFUR_ORE = new SulfurOreBlock(FabricBlockSettings
	.of(Material.STONE)
	.strength(5, 3)
	.sounds(BlockSoundGroup.DEEPSLATE)
	.breakByTool(FabricToolTags.PICKAXES));

	public static final Block UNREFINED_SULFUR_BLOCK = new Block(FabricBlockSettings
	.of(Material.STONE)
	.strength(5, 3)
	.sounds(BlockSoundGroup.STONE)
	.breakByTool(FabricToolTags.PICKAXES));

	//Other Declarations
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	public static void register_item(String name_item, Item declaree) {
		Registry.register(Registry.ITEM,
		new Identifier(MOD_ID, name_item),
		declaree);
	}

	public static void register_block(String name_block, Block declaree, ItemGroup item_group) {
		Registry.register(Registry.BLOCK,
		new Identifier(MOD_ID, name_block),
		declaree);
		Registry.register(Registry.ITEM,
		new Identifier(MOD_ID, name_block),
		new BlockItem(declaree,
		new Item.Settings().
		group(item_group)));
	}

	private static ConfiguredFeature<?, ?> SULFUR_ORE_OVERWORLD = Feature.ORE
	.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, SULFUR_ORE.getDefaultState(), 9))
    .range(new RangeDecoratorConfig(
      // You can also use one of the other height providers if you don't want a uniform distribution
      UniformHeightProvider.create(YOffset.aboveBottom(16), YOffset.fixed(64)))) // Inclusive min and max height
    .spreadHorizontally()
    .repeat(5); // Number of veins per chunk

	private static ConfiguredFeature<?, ?> DEEPSLATE_SULFUR_ORE_OVERWORLD = Feature.ORE
	.configure(new OreFeatureConfig(OreFeatureConfig.Rules.DEEPSLATE_ORE_REPLACEABLES, DEEPSLATE_SULFUR_ORE.getDefaultState(), 9))
    .range(new RangeDecoratorConfig(
      // You can also use one of the other height providers if you don't want a uniform distribution
      UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(16)))) // Inclusive min and max height
    .spreadHorizontally()
    .repeat(20); // Number of veins per chunk


	@Override
	public void onInitialize() {

		//Sound Event
		Registry.register(Registry.SOUND_EVENT, CheemsTweaks.GUNS_ID, GUNS_EVENT);
		Registry.register(Registry.SOUND_EVENT, CheemsTweaks.SENPAI_ID, SENPAI_EVENT);
		Registry.register(Registry.SOUND_EVENT, CheemsTweaks.MONSTER_ID, MONSTER_EVENT);
		Registry.register(Registry.SOUND_EVENT, CheemsTweaks.JACK_ID, JACK_EVENT);
		

		//Blocks
		register_block("raw_sulfur_block", RAW_SULFUR_BLOCK, ItemGroup.BUILDING_BLOCKS);
		register_block("tinted_raw_sulfur_block", TINTED_RAW_SULFUR_BLOCK, ItemGroup.BUILDING_BLOCKS);
		register_block("sulfur_ore", SULFUR_ORE, ItemGroup.BUILDING_BLOCKS);
		register_block("deepslate_sulfur_ore", DEEPSLATE_SULFUR_ORE, ItemGroup.BUILDING_BLOCKS);
		register_block("unrefined_sulfur_block", UNREFINED_SULFUR_BLOCK, ItemGroup.BUILDING_BLOCKS);

		creatediscitem.init();
		createfooditem.init();
		createitem.init();
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		RegistryKey<ConfiguredFeature<?, ?>> sulfur_ore_Overworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
		new Identifier("cheemstweaks", "sulfur_ore_overworld"));
	  	Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, sulfur_ore_Overworld.getValue(), SULFUR_ORE_OVERWORLD);
	  	BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, sulfur_ore_Overworld);

		RegistryKey<ConfiguredFeature<?, ?>> deepslate_sulfur_ore_Overworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
		new Identifier("cheemstweaks", "deepslate_sulfur_ore_overworld"));
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deepslate_sulfur_ore_Overworld.getValue(),DEEPSLATE_SULFUR_ORE_OVERWORLD);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_DECORATION, deepslate_sulfur_ore_Overworld);

		LOGGER.info("Cheems Tweaks loaded!");
	}
}
