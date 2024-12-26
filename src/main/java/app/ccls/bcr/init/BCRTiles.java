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

public class BCRTiles {
    // Identifiers
    private static final Identifier BCR_TILES_ID = Identifier.of("bcr", "bcr_tiles");
    private static final Identifier BCR_TILES_STAIRS_ID = Identifier.of("bcr", "bcr_tiles_stairs");
    private static final Identifier BCR_TILES_SLAB_ID = Identifier.of("bcr", "bcr_tiles_slab");
    private static final Identifier BCR_TILES_VERTICAL_SLAB_ID = Identifier.of("bcr", "bcr_tiles_vertical_slab");
    private static final Identifier BCR_TILES_PILLAR_ID = Identifier.of("bcr", "bcr_tiles_pillar");
    private static final Identifier BCR_TILES_PANEL_ID = Identifier.of("bcr", "bcr_tiles_panel");

    // Registry Keys
    private static final RegistryKey<Block> BCR_TILES_BLOCK_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_ID
    );
    
    private static final RegistryKey<Block> BCR_TILES_STAIRS_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_STAIRS_ID
    );

    private static final RegistryKey<Block> BCR_TILES_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_SLAB_ID
    );
    
    private static final RegistryKey<Item> BCR_TILES_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_ID
    );
    
    private static final RegistryKey<Item> BCR_TILES_STAIRS_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_STAIRS_ID
    );

    private static final RegistryKey<Item> BCR_TILES_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_SLAB_ID
    );

    private static final RegistryKey<Block> BCR_TILES_VERTICAL_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_VERTICAL_SLAB_ID
    );
    
    private static final RegistryKey<Item> BCR_TILES_VERTICAL_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_VERTICAL_SLAB_ID
    );

    private static final RegistryKey<Block> BCR_TILES_PILLAR_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_PILLAR_ID
    );

    private static final RegistryKey<Item> BCR_TILES_PILLAR_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_PILLAR_ID
    );

    private static final RegistryKey<Block> BCR_TILES_PANEL_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        BCR_TILES_PANEL_ID
    );

    private static final RegistryKey<Item> BCR_TILES_PANEL_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        BCR_TILES_PANEL_ID
    );

    // Block Settings
    private static final AbstractBlock.Settings BCR_TILES_SETTINGS = AbstractBlock.Settings.create()
        .mapColor(MapColor.RED)
        .requiresTool()
        .strength(0.8f)
        .registryKey(BCR_TILES_BLOCK_KEY);

    // Block Instances
    public static final Block BCR_TILES = new Block(BCR_TILES_SETTINGS);
    public static final Block BCR_TILES_STAIRS = new StairsBlock(BCR_TILES.getDefaultState(), 
        AbstractBlock.Settings.copy(BCR_TILES).registryKey(BCR_TILES_STAIRS_KEY));
    public static final Block BCR_TILES_SLAB = new SlabBlock(
        AbstractBlock.Settings.copy(BCR_TILES).registryKey(BCR_TILES_SLAB_KEY));
    public static final Block BCR_TILES_VERTICAL_SLAB = new VerticalSlab(
        AbstractBlock.Settings.copy(BCR_TILES)
            .nonOpaque() // Make it non-opaque
            .registryKey(BCR_TILES_VERTICAL_SLAB_KEY)
    );
    public static final Block BCR_TILES_PILLAR = new Pillar(
        AbstractBlock.Settings.copy(BCR_TILES)
            .nonOpaque() // Make it non-opaque
            .registryKey(BCR_TILES_PILLAR_KEY)
    );
    public static final Block BCR_TILES_PANEL = new Panel(
        AbstractBlock.Settings.copy(BCR_TILES)
            .nonOpaque()
            .registryKey(BCR_TILES_PANEL_KEY)
    );

    // Block Item Settings
    private static final Item.Settings BCR_TILES_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_ITEM_KEY);
    
    private static final Item.Settings BCR_TILES_STAIRS_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_STAIRS_ITEM_KEY);

    private static final Item.Settings BCR_TILES_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_SLAB_ITEM_KEY);

    private static final Item.Settings BCR_TILES_VERTICAL_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_VERTICAL_SLAB_ITEM_KEY);

    private static final Item.Settings BCR_TILES_PILLAR_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_PILLAR_ITEM_KEY);

    private static final Item.Settings BCR_TILES_PANEL_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(BCR_TILES_PANEL_ITEM_KEY);

    // Block Item Instances
    public static final BlockItem BCR_TILES_ITEM = new BlockItem(BCR_TILES, BCR_TILES_ITEM_SETTINGS);
    public static final BlockItem BCR_TILES_STAIRS_ITEM = new BlockItem(BCR_TILES_STAIRS, BCR_TILES_STAIRS_ITEM_SETTINGS);
    public static final BlockItem BCR_TILES_SLAB_ITEM = new BlockItem(BCR_TILES_SLAB, BCR_TILES_SLAB_ITEM_SETTINGS);
    public static final BlockItem BCR_TILES_VERTICAL_SLAB_ITEM = new BlockItem(
        BCR_TILES_VERTICAL_SLAB, 
        BCR_TILES_VERTICAL_SLAB_ITEM_SETTINGS
    );
    public static final BlockItem BCR_TILES_PILLAR_ITEM = new BlockItem(
        BCR_TILES_PILLAR, 
        BCR_TILES_PILLAR_ITEM_SETTINGS
    );
    public static final BlockItem BCR_TILES_PANEL_ITEM = new BlockItem(
        BCR_TILES_PANEL, 
        BCR_TILES_PANEL_ITEM_SETTINGS
    );

    // Registration Methods
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, BCR_TILES_ID, BCR_TILES);
        Registry.register(Registries.BLOCK, BCR_TILES_STAIRS_ID, BCR_TILES_STAIRS);
        Registry.register(Registries.BLOCK, BCR_TILES_SLAB_ID, BCR_TILES_SLAB);
        Registry.register(Registries.BLOCK, BCR_TILES_VERTICAL_SLAB_ID, BCR_TILES_VERTICAL_SLAB);
        Registry.register(Registries.BLOCK, BCR_TILES_PILLAR_ID, BCR_TILES_PILLAR);
        Registry.register(Registries.BLOCK, BCR_TILES_PANEL_ID, BCR_TILES_PANEL);
    }

    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, BCR_TILES_ID, BCR_TILES_ITEM);
        Registry.register(Registries.ITEM, BCR_TILES_STAIRS_ID, BCR_TILES_STAIRS_ITEM);
        Registry.register(Registries.ITEM, BCR_TILES_SLAB_ID, BCR_TILES_SLAB_ITEM);
        Registry.register(Registries.ITEM, BCR_TILES_VERTICAL_SLAB_ID, BCR_TILES_VERTICAL_SLAB_ITEM);
        Registry.register(Registries.ITEM, BCR_TILES_PILLAR_ID, BCR_TILES_PILLAR_ITEM);
        Registry.register(Registries.ITEM, BCR_TILES_PANEL_ID, BCR_TILES_PANEL_ITEM);
    }

    // Initialize everything
    public static void register() {
        registerBlocks();
        registerBlockItems();
    }
}
