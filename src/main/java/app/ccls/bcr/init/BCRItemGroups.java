package app.ccls.bcr.init;

import app.ccls.bcr.BCR;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BCRItemGroups {

    public static final RegistryKey<ItemGroup> BCR_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(BCR.MOD_ID, "bcr_item_group"));

    public static final ItemGroup BCR_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(RedBricks.RED_BRICKS)) // Representative item
            .displayName(Text.translatable("itemGroup.bcr.bcr_item_group"))
            .build();

    public static void registerItemGroup() {
        // Correct registry usage with RegistryKey
        Registry.register(Registries.ITEM_GROUP, BCR_ITEM_GROUP_KEY.getValue(), BCR_ITEM_GROUP);

        // Add items to the group
        ItemGroupEvents.modifyEntriesEvent(BCR_ITEM_GROUP_KEY).register(itemGroup -> {
            // Add Red Bricks variants
            itemGroup.add(RedBricks.RED_BRICKS);
            itemGroup.add(RedBricks.RED_BRICKS_PANEL);
            itemGroup.add(RedBricks.RED_BRICKS_STAIRS);
            itemGroup.add(RedBricks.RED_BRICKS_SLAB);
            itemGroup.add(RedBricks.RED_BRICKS_VERTICAL_SLAB);
            itemGroup.add(RedBricks.RED_BRICKS_PILLAR);

            // Add Quartz Bricks variants
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS);
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS_PANEL);
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS_STAIRS);
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS_SLAB);
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS_VERTICAL_SLAB);
            itemGroup.add(QuartzBricks.QUARTZ_BRICKS_PILLAR);

            // Add BCR Tiles variants
            itemGroup.add(BCRTiles.BCR_TILES);
            itemGroup.add(BCRTiles.BCR_TILES_PANEL);
            itemGroup.add(BCRTiles.BCR_TILES_STAIRS);
            itemGroup.add(BCRTiles.BCR_TILES_SLAB);
            itemGroup.add(BCRTiles.BCR_TILES_VERTICAL_SLAB);
            itemGroup.add(BCRTiles.BCR_TILES_PILLAR);

            // Add Hardstone variants
            itemGroup.add(Hardstone.HARDSTONE);
            itemGroup.add(Hardstone.HARDSTONE_PANEL);
            itemGroup.add(Hardstone.HARDSTONE_STAIRS);
            itemGroup.add(Hardstone.HARDSTONE_SLAB);
            itemGroup.add(Hardstone.HARDSTONE_VERTICAL_SLAB);
            itemGroup.add(Hardstone.HARDSTONE_PILLAR);
        });
    }
}
