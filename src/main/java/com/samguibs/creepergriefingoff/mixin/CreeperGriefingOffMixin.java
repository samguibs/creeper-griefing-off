package com.samguibs.creepergriefingoff.mixin;

import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(net.minecraft.world.entity.monster.Creeper.class)
public class CreeperGriefingOffMixin {

    @ModifyArgs(
        method = "explodeCreeper",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/server/level/ServerLevel;explode(Lnet/minecraft/world/entity/Entity;DDDFLnet/minecraft/world/level/Level$ExplosionInteraction;)V"
        )
    )
    private void disableCreeperBlockDamage(Args args) {
        args.set(5, Level.ExplosionInteraction.NONE);
    }
}