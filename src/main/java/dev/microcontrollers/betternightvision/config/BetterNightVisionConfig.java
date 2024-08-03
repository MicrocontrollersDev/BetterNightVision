package dev.microcontrollers.betternightvision.config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class BetterNightVisionConfig {
    public static final ConfigClassHandler<BetterNightVisionConfig> CONFIG = ConfigClassHandler.createBuilder(BetterNightVisionConfig.class)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("betternightvision.json"))
                    .build())
            .build();

    @SerialEntry public boolean disableNightVision = false;
    @SerialEntry public boolean cleanerNightVision = true;

    @SuppressWarnings("deprecation")
    public static Screen configScreen(Screen parent) {
        return YetAnotherConfigLib.create(CONFIG, ((defaults, config, builder) -> builder
                .title(Text.translatable("better-night-vision.better-night-vision"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("better-night-vision.better-night-vision"))
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.translatable("better-night-vision.disable-night-vision"))
                                .description(OptionDescription.of(Text.translatable("better-night-vision.disable-night-vision.description")))
                                .binding(defaults.disableNightVision, () -> config.disableNightVision, newVal -> config.disableNightVision = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .option(Option.createBuilder(boolean.class)
                                .name(Text.translatable("better-night-vision.cleaner-night-vision-decay"))
                                .description(OptionDescription.of(Text.translatable("better-night-vision.cleaner-night-vision-decay.description")))
                                .binding(defaults.cleanerNightVision, () -> config.cleanerNightVision, newVal -> config.cleanerNightVision = newVal)
                                .controller(TickBoxControllerBuilder::create)
                                .build())
                        .build())
        )).generateScreen(parent);
    }

}