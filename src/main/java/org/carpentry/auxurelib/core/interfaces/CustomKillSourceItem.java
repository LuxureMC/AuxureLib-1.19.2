package org.carpentry.auxurelib.core.interfaces;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface CustomKillSourceItem {
    DamageSource getKillSource(PlayerEntity player, ItemStack stack);
}