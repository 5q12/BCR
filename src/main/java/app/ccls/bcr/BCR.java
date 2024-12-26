package app.ccls.bcr;

import net.fabricmc.api.ModInitializer;
import app.ccls.bcr.init.RedBricks;
import app.ccls.bcr.init.BCRItemGroups;
import app.ccls.bcr.init.BCRTiles;
import app.ccls.bcr.init.Hardstone;
import app.ccls.bcr.init.QuartzBricks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import app.ccls.bcr.block.entity.PanelBlockEntity;


public class BCR implements ModInitializer {
    public static final String MOD_ID = "bcr";

    public static final BlockEntityType<PanelBlockEntity> PANEL_BLOCK_ENTITY = 
    Registry.register(
        Registries.BLOCK_ENTITY_TYPE,
        Identifier.of("bcr", "panel"),
        FabricBlockEntityTypeBuilder.create(
            PanelBlockEntity::new, 
            QuartzBricks.QUARTZ_BRICKS_PANEL,  // Quartz Bricks Panel
            RedBricks.RED_BRICKS_PANEL,       // Red Bricks Panel
            BCRTiles.BCR_TILES_PANEL,  
            Hardstone.HARDSTONE_PANEL 
        ).build()
    );

	@Override
	public void onInitialize() {
		QuartzBricks.register();
        RedBricks.register();
        BCRTiles.register();
        Hardstone.register();
        BCRItemGroups.registerItemGroup();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}