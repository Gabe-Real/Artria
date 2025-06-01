package dev.gabereal.items;

import dev.gabereal.Atria;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static final Item HEART_CONTAINER = registerItem("heart_container", Item::new);
    public static final Item LARGE_HEART_CONTAINER = registerItem("large_heart_container", Item::new);
    public static final Item DARK_HEART = registerItem("dark_heart", Item::new);
    public static final Item HEART = registerItem("heart", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Atria.MOD_ID, name),
         function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Atria.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Atria.LOGGER.info("Registering Mod Items for " + Atria.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(HEART_CONTAINER);
            entries.add(LARGE_HEART_CONTAINER);
            entries.add(DARK_HEART);
            entries.add(HEART);
        });
    }
}
