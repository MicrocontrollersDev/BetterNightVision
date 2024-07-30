package dev.microcontrollers.betternightvision;

import dev.microcontrollers.betternightvision.config.BetterNightVisionConfig;
import net.fabricmc.api.ModInitializer;

public class BetterNightVision implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterNightVisionConfig.CONFIG.load();
    }
}