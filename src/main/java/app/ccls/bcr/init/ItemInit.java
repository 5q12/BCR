package app.ccls.bcr.init;

import app.ccls.bcr.BCR;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ItemInit {
    public static Item EXAMPLE_ITEM;

    private static <T extends Item> T register(String name, T item) {
        Identifier id = BCR.id(name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void load() {
        Identifier id = BCR.id("example_item");
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        
        Item.Settings settings = new Item.Settings()
            .registryKey(key);
        
        EXAMPLE_ITEM = register("example_item", new Item(settings));
    }
}
