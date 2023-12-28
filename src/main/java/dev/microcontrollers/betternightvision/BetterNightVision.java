package dev.microcontrollers.betternightvision;

import dev.microcontrollers.betternightvision.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BetterNightVision.MODID, name = BetterNightVision.NAME, version = BetterNightVision.VERSION)
public class BetterNightVision {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    // Sets the variables from `gradle.properties`. See the `blossom` config in `build.gradle.kts`.
    @Mod.Instance(MODID)
    public static BetterNightVision INSTANCE; // Adds the instance of the mod, so we can access other variables.
    public static Config config;

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        config = new Config();
    }
}
