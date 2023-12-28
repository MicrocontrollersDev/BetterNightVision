package dev.microcontrollers.betternightvision.mixin;

import dev.microcontrollers.betternightvision.config.Config;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityRenderer.class)
public class EntityRendererMixin {
    @Inject(method = "getNightVisionBrightness", at = @At("HEAD"), cancellable = true)
    private void cleanerNightVision(EntityLivingBase entitylivingbaseIn, float partialTicks, CallbackInfoReturnable<Float> cir) {
        if (Config.cleanerNightVision) cir.setReturnValue(!(entitylivingbaseIn.getActivePotionEffect(Potion.nightVision).getDuration() < 200) ? 1.0F : (float) entitylivingbaseIn.getActivePotionEffect(Potion.nightVision).getDuration() / 200F);
        if (Config.disableNightVision) cir.setReturnValue(0F);
    }
}