package dev.gabereal.items.custom;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class LargeHeartContainerItem extends Item {

    public LargeHeartContainerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (!world.isClient) {
            double currentMax = player.getAttributeInstance(EntityAttributes.MAX_HEALTH).getBaseValue();

            if (currentMax < 40) {
                player.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(currentMax + 4);
                player.setHealth((float) (player.getHealth() + 4));
                itemStack.decrement(1);
            }
        }

        return ActionResult.SUCCESS; // or CONSUME if you'd rather consume without swing animation
    }
}
