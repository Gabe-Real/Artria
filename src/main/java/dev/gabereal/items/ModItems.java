package dev.gabereal.items;

import dev.gabereal.Atria;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item HEART_CONTAINER = registerItem("heart_container", new Item(new Item.Settings()));
    public static final Item LARGE_HEART_CONTAINER = registerItem("large_heart_container", new Item(new Item.Settings()));
    public static final Item DARK_HEART = registerItem("dark_heart", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Atria.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Atria.LOGGER.info("Registering Mod Items for " + Atria.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HEART_CONTAINER);
            entries.add(LARGE_HEART_CONTAINER);
            entries.add(DARK_HEART);
        });
    }
}
