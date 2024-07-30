package dev.microcontrollers.betternightvision.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.microcontrollers.betternightvision.config.BetterNightVisionConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GameRenderer.class)
public class GameRendererMixin {
    @ModifyReturnValue(method = "getNightVisionStrength", at = @At("RETURN"))
    private static float cleanerNightVision(float original) {
        if (BetterNightVisionConfig.CONFIG.instance().disableNightVision) return 0F;
        assert MinecraftClient.getInstance().player != null;
        StatusEffectInstance statusEffectInstance = MinecraftClient.getInstance().player.getStatusEffect(StatusEffects.NIGHT_VISION);
        assert statusEffectInstance != null;
        if (BetterNightVisionConfig.CONFIG.instance().cleanerNightVision)
            return !statusEffectInstance.isDurationBelow(200) ? 1.0F : (float) statusEffectInstance.getDuration() / 200F;
        return original;
    }
}