package org.carpentry.auxurelib.core.interfaces;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface CustomCritEffectItem {
    void getCritEffect(PlayerEntity player, LivingEntity target, ItemStack stack);
}