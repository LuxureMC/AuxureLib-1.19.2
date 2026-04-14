package org.carpentry.auxurelib.core.interfaces;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface CustomHeldPoseItem {
    BipedEntityModel.ArmPose getArmPose(PlayerEntity player, ItemStack stack);
}
