package dev.microcontrollers.betternightvision.config;

import dev.microcontrollers.betternightvision.BetterNightVision;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class Config extends cc.polyfrost.oneconfig.config.Config {
    @Switch(
            name = "Disable Night Vision",
            description = "Completely disables the effects of night vision."
    )
    public static boolean disableNightVision = false;

    @Switch(
            name = "Cleaner Night Vision",
            description = "Makes the night vision effect fade out instead of an epilepsy inducing effect."
    )
    public static boolean cleanerNightVision = false;

    public Config() {
        super(new Mod(BetterNightVision.NAME, ModType.UTIL_QOL), BetterNightVision.MODID + ".json");
        initialize();

        hideIf("cleanerNightVision", "disableNightVision");
    }
}

