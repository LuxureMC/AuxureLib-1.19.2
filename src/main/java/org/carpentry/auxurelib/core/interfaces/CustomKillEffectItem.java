package org.carpentry.auxurelib.core.interfaces;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface CustomKillEffectItem {
    void getKillEffect(PlayerEntity player, LivingEntity target, ItemStack stack, World world);
}
