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

public class RedBricks {
    // Identifiers
    private static final Identifier RED_BRICKS_ID = Identifier.of("bcr", "red_bricks");
    private static final Identifier RED_BRICKS_STAIRS_ID = Identifier.of("bcr", "red_bricks_stairs");
    private static final Identifier RED_BRICKS_SLAB_ID = Identifier.of("bcr", "red_bricks_slab");
    private static final Identifier RED_BRICKS_VERTICAL_SLAB_ID = Identifier.of("bcr", "red_bricks_vertical_slab");
    private static final Identifier RED_BRICKS_PILLAR_ID = Identifier.of("bcr", "red_bricks_pillar");
    private static final Identifier RED_BRICKS_PANEL_ID = Identifier.of("bcr", "red_bricks_panel");

    // Registry Keys
    private static final RegistryKey<Block> RED_BRICKS_BLOCK_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_ID
    );
    
    private static final RegistryKey<Block> RED_BRICKS_STAIRS_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_STAIRS_ID
    );

    private static final RegistryKey<Block> RED_BRICKS_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_SLAB_ID
    );
    
    private static final RegistryKey<Item> RED_BRICKS_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_ID
    );
    
    private static final RegistryKey<Item> RED_BRICKS_STAIRS_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_STAIRS_ID
    );

    private static final RegistryKey<Item> RED_BRICKS_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_SLAB_ID
    );

    private static final RegistryKey<Block> RED_BRICKS_VERTICAL_SLAB_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_VERTICAL_SLAB_ID
    );
    
    private static final RegistryKey<Item> RED_BRICKS_VERTICAL_SLAB_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_VERTICAL_SLAB_ID
    );

    private static final RegistryKey<Block> RED_BRICKS_PILLAR_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_PILLAR_ID
    );

    private static final RegistryKey<Item> RED_BRICKS_PILLAR_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_PILLAR_ID
    );

    private static final RegistryKey<Block> RED_BRICKS_PANEL_KEY = RegistryKey.of(
        RegistryKeys.BLOCK, 
        RED_BRICKS_PANEL_ID
    );

    private static final RegistryKey<Item> RED_BRICKS_PANEL_ITEM_KEY = RegistryKey.of(
        RegistryKeys.ITEM, 
        RED_BRICKS_PANEL_ID
    );

    // Block Settings
    private static final AbstractBlock.Settings RED_BRICKS_SETTINGS = AbstractBlock.Settings.create()
        .mapColor(MapColor.RED)
        .requiresTool()
        .strength(0.8f)
        .registryKey(RED_BRICKS_BLOCK_KEY);

    // Block Instances
    public static final Block RED_BRICKS = new Block(RED_BRICKS_SETTINGS);
    public static final Block RED_BRICKS_STAIRS = new StairsBlock(RED_BRICKS.getDefaultState(), 
        AbstractBlock.Settings.copy(RED_BRICKS).registryKey(RED_BRICKS_STAIRS_KEY));
    public static final Block RED_BRICKS_SLAB = new SlabBlock(
        AbstractBlock.Settings.copy(RED_BRICKS).registryKey(RED_BRICKS_SLAB_KEY));
    public static final Block RED_BRICKS_VERTICAL_SLAB = new VerticalSlab(
        AbstractBlock.Settings.copy(RED_BRICKS)
            .nonOpaque() // Make it non-opaque
            .registryKey(RED_BRICKS_VERTICAL_SLAB_KEY)
    );
    public static final Block RED_BRICKS_PILLAR = new Pillar(
        AbstractBlock.Settings.copy(RED_BRICKS)
            .nonOpaque() // Make it non-opaque
            .registryKey(RED_BRICKS_PILLAR_KEY)
    );
    public static final Block RED_BRICKS_PANEL = new Panel(
        AbstractBlock.Settings.copy(RED_BRICKS)
            .nonOpaque()
            .registryKey(RED_BRICKS_PANEL_KEY)
    );

    // Block Item Settings
    private static final Item.Settings RED_BRICKS_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_ITEM_KEY);
    
    private static final Item.Settings RED_BRICKS_STAIRS_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_STAIRS_ITEM_KEY);

    private static final Item.Settings RED_BRICKS_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_SLAB_ITEM_KEY);

    private static final Item.Settings RED_BRICKS_VERTICAL_SLAB_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_VERTICAL_SLAB_ITEM_KEY);

    private static final Item.Settings RED_BRICKS_PILLAR_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_PILLAR_ITEM_KEY);

    private static final Item.Settings RED_BRICKS_PANEL_ITEM_SETTINGS = new Item.Settings()
        .useBlockPrefixedTranslationKey()
        .registryKey(RED_BRICKS_PANEL_ITEM_KEY);

    // Block Item Instances
    public static final BlockItem RED_BRICKS_ITEM = new BlockItem(RED_BRICKS, RED_BRICKS_ITEM_SETTINGS);
    public static final BlockItem RED_BRICKS_STAIRS_ITEM = new BlockItem(RED_BRICKS_STAIRS, RED_BRICKS_STAIRS_ITEM_SETTINGS);
    public static final BlockItem RED_BRICKS_SLAB_ITEM = new BlockItem(RED_BRICKS_SLAB, RED_BRICKS_SLAB_ITEM_SETTINGS);
    public static final BlockItem RED_BRICKS_VERTICAL_SLAB_ITEM = new BlockItem(
        RED_BRICKS_VERTICAL_SLAB, 
        RED_BRICKS_VERTICAL_SLAB_ITEM_SETTINGS
    );
    public static final BlockItem RED_BRICKS_PILLAR_ITEM = new BlockItem(
        RED_BRICKS_PILLAR, 
        RED_BRICKS_PILLAR_ITEM_SETTINGS
    );
    public static final BlockItem RED_BRICKS_PANEL_ITEM = new BlockItem(
        RED_BRICKS_PANEL, 
        RED_BRICKS_PANEL_ITEM_SETTINGS
    );

    // Registration Methods
    public static void registerBlocks() {
        Registry.register(Registries.BLOCK, RED_BRICKS_ID, RED_BRICKS);
        Registry.register(Registries.BLOCK, RED_BRICKS_STAIRS_ID, RED_BRICKS_STAIRS);
        Registry.register(Registries.BLOCK, RED_BRICKS_SLAB_ID, RED_BRICKS_SLAB);
        Registry.register(Registries.BLOCK, RED_BRICKS_VERTICAL_SLAB_ID, RED_BRICKS_VERTICAL_SLAB);
        Registry.register(Registries.BLOCK, RED_BRICKS_PILLAR_ID, RED_BRICKS_PILLAR);
        Registry.register(Registries.BLOCK, RED_BRICKS_PANEL_ID, RED_BRICKS_PANEL);
    }

    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, RED_BRICKS_ID, RED_BRICKS_ITEM);
        Registry.register(Registries.ITEM, RED_BRICKS_STAIRS_ID, RED_BRICKS_STAIRS_ITEM);
        Registry.register(Registries.ITEM, RED_BRICKS_SLAB_ID, RED_BRICKS_SLAB_ITEM);
        Registry.register(Registries.ITEM, RED_BRICKS_VERTICAL_SLAB_ID, RED_BRICKS_VERTICAL_SLAB_ITEM);
        Registry.register(Registries.ITEM, RED_BRICKS_PILLAR_ID, RED_BRICKS_PILLAR_ITEM);
        Registry.register(Registries.ITEM, RED_BRICKS_PANEL_ID, RED_BRICKS_PANEL_ITEM);
    }

    // Initialize everything
    public static void register() {
        registerBlocks();
        registerBlockItems();
    }
}
