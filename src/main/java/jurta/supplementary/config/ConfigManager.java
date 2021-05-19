package jurta.supplementary.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import jurta.supplementary.Supplementary;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final ConfigManager INSTANCE;

    private static final ForgeConfigSpec SPEC;

    private static final Path CONFIG_PATH =
            Paths.get("config", Supplementary.MOD_ID + ".toml");

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

    private ConfigManager(ForgeConfigSpec.Builder configSpecBuilder) {
        allowVegetalGeneration = configSpecBuilder
                .comment("Determines if vegetation should generate within worlds.")
                .translation("config.supplementary.allowVegetalGeneration.title")
                .define("allowVegetalGeneration", true);
        allowTreeGeneration = configSpecBuilder
                .comment("Determines if trees should generate within worlds.")
                .translation("config.supplementary.allowTreeGeneration.title")
                .define("allowTreeGeneration", true);
        allowRockGeneration = configSpecBuilder
                .comment("Determines if rocks should generate within worlds.")
                .translation("config.supplementary.allowRockGeneration.title")
                .define("allowRockGeneration", true);
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

    public void changeAllowVegetalGeneration(boolean newValue) {
        allowVegetalGeneration.set(newValue);
    }

    public void changeAllowTreeGeneration(boolean newValue) {
        allowTreeGeneration.set(newValue);
    }

    public void changeAllowRockGeneration(boolean newValue) {
        allowRockGeneration.set(newValue);
    }

    public void save() {
        SPEC.save();
    }
}
