package dev.microcontrollers.betternightvision.mixin;

import dev.microcontrollers.betternightvision.config.Config;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.EntityLivingBase;
//#if MC==1.12.2
//$$ import net.minecraft.init.MobEffects;
//#endif
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EntityRenderer.class)
public class EntityRendererMixin {
    @Inject(method = "getNightVisionBrightness", at = @At("HEAD"), cancellable = true)
    private void cleanerNightVision(EntityLivingBase entitylivingbaseIn, float partialTicks, CallbackInfoReturnable<Float> cir) {
        //#if MC==1.8.9
        if (Config.cleanerNightVision) cir.setReturnValue(!(entitylivingbaseIn.getActivePotionEffect(Potion.nightVision).getDuration() < 200) ? 1.0F : (float) entitylivingbaseIn.getActivePotionEffect(Potion.nightVision).getDuration() / 200F);
        //#else
        //$$ if (Config.cleanerNightVision) cir.setReturnValue(!(entitylivingbaseIn.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() < 200) ? 1.0F : (float) entitylivingbaseIn.getActivePotionEffect(MobEffects.NIGHT_VISION).getDuration() / 200F);
        //#endif
        if (Config.disableNightVision) cir.setReturnValue(0F);
    }
}