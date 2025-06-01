package dev.gabereal;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.network.ServerPlayerEntity;

public class PlayerJoinHandler {
    private static final String INIT_TAG = "atria:initialized_health";

    public static void register() {
        ServerPlayerEvents.JOIN.register(PlayerJoinHandler::initializePlayerHealth);
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> initializePlayerHealth(newPlayer));
    }

    private static void initializePlayerHealth(ServerPlayerEntity player) {
        double currentMaxHealth = player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue();

        if (currentMaxHealth > 6.0) {
            player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(6.0);
            player.setHealth(6.0F);
        }
    }
}
