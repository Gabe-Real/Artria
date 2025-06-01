package dev.gabereal.items.custom;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class HeartContainerItem extends Item {

    public HeartContainerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!world.isClient) {
            double currentMax = player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue();

            if (currentMax < 20) {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(currentMax + 2);
                player.setHealth((float) (player.getHealth() + 2));
                itemStack.decrement(1);
            }
        }

        return ActionResult.SUCCESS; // or CONSUME if you'd rather consume without swing animation
    }
}
