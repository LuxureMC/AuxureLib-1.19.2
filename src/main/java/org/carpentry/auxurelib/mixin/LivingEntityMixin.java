package org.carpentry.auxurelib.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.carpentry.auxurelib.core.interfaces.CustomKillEffectItem;
import org.carpentry.auxurelib.core.interfaces.CustomKillSourceItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "tryUseTotem", at = @At("HEAD"))
    private void auxlib$customKillEffectItem(DamageSource source, CallbackInfoReturnable<Boolean> cir) {
        LivingEntity living = (LivingEntity) (Object) this;
        Entity misc = source.getAttacker();

        if (misc instanceof PlayerEntity player) {
            if (player.getMainHandStack().getItem() instanceof CustomKillEffectItem customKillEffectItem) {
                customKillEffectItem.getKillEffect(player, living, player.getMainHandStack(), player.getWorld());
            }
        }
    }

    @WrapOperation(
            method = "damage",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;tryUseTotem(Lnet/minecraft/entity/damage/DamageSource;)Z"
            )
    )
    private boolean auxlib$customKillSource(LivingEntity instance, DamageSource source, Operation<Boolean> original) {
        Entity attacker = source.getAttacker();
        if (attacker instanceof PlayerEntity player) {
            ItemStack stack = player.getMainHandStack();
            if (stack.getItem() instanceof CustomKillSourceItem customKillSourceItem) {
                return original.call(instance, customKillSourceItem.getKillSource(player, stack));
            }
        }
        return original.call(instance, source);
    }
}