package org.carpentry.auxurelib.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.carpentry.auxurelib.core.interfaces.CustomCritEffectItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(
            method = "attack",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;addCritParticles(Lnet/minecraft/entity/Entity;)V"
            )
    )
    private void auxlib$customCritEffectItem(Entity target, CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        if (target instanceof LivingEntity living) {
            if (player.getMainHandStack().getItem() instanceof CustomCritEffectItem customCritEffectItem) {
                customCritEffectItem.getCritEffect(player, living, player.getMainHandStack());
            }
        }
    }
}