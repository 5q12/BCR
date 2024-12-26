package app.ccls.bcr.init;

import net.minecraft.block.Block;
import app.ccls.bcr.block.Panel;
import app.ccls.bcr.block.Pillar;
import app.ccls.bcr.block.VerticalSlab;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Hardstone {
    // Identifiers
    private static final Identifier HARDSTONE_ID = Identifier.of("bcr", "hardstone");
    private static final Identifier HARDSTONE_STAIRS_ID = Identifier.of("bcr", "hardstone_stairs");
    private static final Identifier HARDSTONE_SLAB_ID = Identifier.of("bcr", "hardstone_slab");
    private static final Identifier HARDSTONE_VERTICAL_SLAB_ID = Identifier.of("bcr", "hardstone_vertical_slab");
    private static final Identifier HARDSTONE_PILLAR_ID = Identifier.of("bcr", "hardstone_pillar");
    private static final Identifier HARDSTONE_PANEL_ID = Identifier.of("bcr", "hardstone_panel");

    // Registry Keys
    private static final RegistryKey<Block> HARDSTONE_BLOCK_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_ID
    );
    
    private static final RegistryKey<Block> HARDSTONE_STAIRS_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_STAIRS_ID
    );

    private static final RegistryKey<Block> HARDSTONE_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_SLAB_ID
    );
    
    private static final RegistryKey<Item> HARDSTONE_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_ID
    );
    
    private static final RegistryKey<Item> HARDSTONE_STAIRS_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_STAIRS_ID
    );

    private static final RegistryKey<Item> HARDSTONE_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_SLAB_ID
    );

    private static final RegistryKey<Block> HARDSTONE_VERTICAL_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_VERTICAL_SLAB_ID
    );
    
    private static final RegistryKey<Item> HARDSTONE_VERTICAL_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_VERTICAL_SLAB_ID
    );

    private static final RegistryKey<Block> HARDSTONE_PILLAR_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_PILLAR_ID
    );

    private static final RegistryKey<Item> HARDSTONE_PILLAR_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_PILLAR_ID
    );

    private static final RegistryKey<Block> HARDSTONE_PANEL_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        HARDSTONE_PANEL_ID
    );

    private static final RegistryKey<Item> HARDSTONE_PANEL_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        HARDSTONE_PANEL_ID
    );

    // Block Settings
    private static final AbstractBlock.Settings HARDSTONE_SETTINGS = AbstractBlock.Settings.create()
        .mapColor(MapColor.RED)
        .requiresTool()
        .strength(0.8f)
        .registryKey(HARDSTONE_BLOCK_KEY);

    // Block Instances
    public static final Block HARDSTONE = new Block(HARDSTONE_SETTINGS);
    public static final Block HARDSTONE_STAIRS = new StairsBlock(HARDSTONE.getDefaultState(), 
        AbstractBlock.Settings.copy(HARDSTONE).registryKey(HARDSTONE_STAIRS_KEY));
    public static final Block HARDSTONE_SLAB = new SlabBlock(
        AbstractBlock.Settings.copy(HARDSTONE).registryKey(HARDSTONE_SLAB_KEY));
    public static final Block HARDSTONE_VERTICAL_SLAB = new VerticalSlab(
        AbstractBlock.Settings.copy(HARDSTONE)
            .nonOpaque() // Make it non-opaque
            .registryKey(HARDSTONE_VERTICAL_SLAB_KEY)
    );
    public static final Block HARDSTONE_PILLAR = new Pillar(
        AbstractBlock.Settings.copy(HARDSTONE)
            .nonOpaque() // Make it non-opaque
            .registryKey(HARDSTONE_PILLAR_KEY)
    );
    public static final Block HARDSTONE_PANEL = new Panel(
        AbstractBlock.Settings.copy(HARDSTONE)
            .nonOpaque()
            .registryKey(HARDSTONE_PANEL_KEY)
    );

    // Block Item Settings
    private static final Item.Settings HARDSTONE_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_ITEM_KEY);
    
    private static final Item.Settings HARDSTONE_STAIRS_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_STAIRS_ITEM_KEY);

    private static final Item.Settings HARDSTONE_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_SLAB_ITEM_KEY);

    private static final Item.Settings HARDSTONE_VERTICAL_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_VERTICAL_SLAB_ITEM_KEY);

    private static final Item.Settings HARDSTONE_PILLAR_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_PILLAR_ITEM_KEY);

    private static final Item.Settings HARDSTONE_PANEL_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(HARDSTONE_PANEL_ITEM_KEY);

    // Block Item Instances
    public static final BlockItem HARDSTONE_ITEM = new BlockItem(HARDSTONE, HARDSTONE_ITEM_SETTINGS);
    public static final BlockItem HARDSTONE_STAIRS_ITEM = new BlockItem(HARDSTONE_STAIRS, HARDSTONE_STAIRS_ITEM_SETTINGS);
    public static final BlockItem HARDSTONE_SLAB_ITEM = new BlockItem(HARDSTONE_SLAB, HARDSTONE_SLAB_ITEM_SETTINGS);
    public static final BlockItem HARDSTONE_VERTICAL_SLAB_ITEM = new BlockItem(
        HARDSTONE_VERTICAL_SLAB, 
        HARDSTONE_VERTICAL_SLAB_ITEM_SETTINGS
    );
    public static final BlockItem HARDSTONE_PILLAR_ITEM = new BlockItem(
        HARDSTONE_PILLAR, 
        HARDSTONE_PILLAR_ITEM_SETTINGS
    );
    public static final BlockItem HARDSTONE_PANEL_ITEM = new BlockItem(
        HARDSTONE_PANEL, 
        HARDSTONE_PANEL_ITEM_SETTINGS
    );

    // Registration Methods
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, HARDSTONE_ID, HARDSTONE);
        Registry.register(Registries.BLOCK, HARDSTONE_STAIRS_ID, HARDSTONE_STAIRS);
        Registry.register(Registries.BLOCK, HARDSTONE_SLAB_ID, HARDSTONE_SLAB);
        Registry.register(Registries.BLOCK, HARDSTONE_VERTICAL_SLAB_ID, HARDSTONE_VERTICAL_SLAB);
        Registry.register(Registries.BLOCK, HARDSTONE_PILLAR_ID, HARDSTONE_PILLAR);
        Registry.register(Registries.BLOCK, HARDSTONE_PANEL_ID, HARDSTONE_PANEL);
    }

    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, HARDSTONE_ID, HARDSTONE_ITEM);
        Registry.register(Registries.ITEM, HARDSTONE_STAIRS_ID, HARDSTONE_STAIRS_ITEM);
        Registry.register(Registries.ITEM, HARDSTONE_SLAB_ID, HARDSTONE_SLAB_ITEM);
        Registry.register(Registries.ITEM, HARDSTONE_VERTICAL_SLAB_ID, HARDSTONE_VERTICAL_SLAB_ITEM);
        Registry.register(Registries.ITEM, HARDSTONE_PILLAR_ID, HARDSTONE_PILLAR_ITEM);
        Registry.register(Registries.ITEM, HARDSTONE_PANEL_ID, HARDSTONE_PANEL_ITEM);
    }

    // Initialize everything
    public static void register() {
        registerBlocks();
        registerBlockItems();
    }
}
