package jurta.ancillary.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import jurta.ancillary.Ancillary;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final ConfigManager INSTANCE;

    private static final ForgeConfigSpec SPEC;

    private static final Path CONFIG_PATH =
            Paths.get("config", Ancillary.MOD_ID + ".toml");

    static {
        Pair<ConfigManager, ForgeConfigSpec> specPair =
                new ForgeConfigSpec.Builder().configure(ConfigManager::new);
        INSTANCE = specPair.getLeft();
        SPEC = specPair.getRight();
        CommentedFileConfig config = CommentedFileConfig.builder(CONFIG_PATH)
                .sync()
                .autoreload()
                .writingMode(WritingMode.REPLACE)
                .build();
        config.load();
        config.save();
        SPEC.setConfig(config);
    }

    private final ForgeConfigSpec.BooleanValue allowVegetalGeneration;
    private final ForgeConfigSpec.BooleanValue allowTreeGeneration;
    private final ForgeConfigSpec.BooleanValue allowRockGeneration;
    private final ForgeConfigSpec.BooleanValue allowLushStoneGeneration;
    private final ForgeConfigSpec.BooleanValue allowCropGeneration;
    private final ForgeConfigSpec.BooleanValue allowBiomeGeneration;

    private ConfigManager(ForgeConfigSpec.Builder configSpecBuilder) {
        allowVegetalGeneration = configSpecBuilder
                .comment("Determines if vegetation should generate within worlds.")
                .translation("config.ancillary.allowVegetalGeneration.title")
                .define("allowVegetalGeneration", true);
        allowTreeGeneration = configSpecBuilder
                .comment("Determines if trees should generate within worlds.")
                .translation("config.ancillary.allowTreeGeneration.title")
                .define("allowTreeGeneration", true);
        allowRockGeneration = configSpecBuilder
                .comment("Determines if rocks should generate within worlds.")
                .translation("config.ancillary.allowRockGeneration.title")
                .define("allowRockGeneration", true);
        allowLushStoneGeneration = configSpecBuilder
                .comment("Determines if lush stone should generate within worlds.")
                .translation("config.ancillary.allowLushStoneGeneration.title")
                .define("allowLushStoneGeneration", true);
        allowCropGeneration = configSpecBuilder
                .comment("Determines if crops should generate within worlds.")
                .translation("config.ancillary.allowCropGeneration.title")
                .define("allowCropGeneration", true);
        allowBiomeGeneration = configSpecBuilder
                .comment("Determines if biomes should generate within worlds.")
                .translation("config.ancillary.allowBiomeGeneration.title")
                .define("allowBiomeGeneration", false);
    }

    public static ConfigManager getInstance() {
        return INSTANCE;
    }

    public boolean allowVegetalGeneration() {
        return allowVegetalGeneration.get();
    }

    public boolean allowTreeGeneration() {
        return allowTreeGeneration.get();
    }

    public boolean allowRockGeneration() {
        return allowRockGeneration.get();
    }

    public boolean allowLushStoneGeneration() {
        return allowLushStoneGeneration.get();
    }

    public boolean allowCropGeneration() {
        return allowCropGeneration.get();
    }

    public boolean allowBiomeGeneration() {
        return allowBiomeGeneration.get();
    }

    public void changeAllowVegetalGeneration(boolean newValue) {
        allowVegetalGeneration.set(newValue);
    }

    public void changeAllowTreeGeneration(boolean newValue) {
        allowTreeGeneration.set(newValue);
    }

    public void changeAllowRockGeneration(boolean newValue) {
        allowRockGeneration.set(newValue);
    }

    public void changeAllowLushStoneGeneration(boolean newValue) {
        allowLushStoneGeneration.set(newValue);
    }

    public void changeAllowCropGeneration(boolean newValue) {
        allowCropGeneration.set(newValue);
    }

    public void changeAllowBiomeGeneration(boolean newValue) {
        allowBiomeGeneration.set(newValue);
    }

    public void save() {
        SPEC.save();
    }
}
