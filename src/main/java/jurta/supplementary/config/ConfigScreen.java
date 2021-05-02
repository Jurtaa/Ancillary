package jurta.supplementary.config;

import com.mojang.blaze3d.matrix.MatrixStack;
import jurta.supplementary.Supplementary;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.text.TranslationTextComponent;

public class ConfigScreen extends Screen {
    /** Width of a button */
    private static final int BUTTON_WIDTH = 200;
    /** Height of a button */
    private static final int BUTTON_HEIGHT = 20;
    /** Distance from bottom of the screen to the "Done" button's top */
    private static final int DONE_BUTTON_TOP_OFFSET = 26;

    private static final ConfigManager CMI = ConfigManager.getInstance();

    private final Screen parentScreen;

    /** Distance from top of the screen to this GUI's title */
    private static final int TITLE_HEIGHT = 15;

    public ConfigScreen(Screen parentScreen) {
        // Use the super class' constructor to set the screen's title
        super(new TranslationTextComponent("supplementary.configGui.title", Supplementary.MOD_ID));
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        this.addButton(new Button(this.width / 2 - 75, this.height / 6 - 6, 150, 20, new TranslationTextComponent("supplementary.configGui.generation"), (generation) -> {
            this.minecraft.setScreen(new GenerationConfigScreen(this));
        }, (tooltip, matrixStack, mouseX, mouseY) -> {
            this.renderTooltip(matrixStack, new TranslationTextComponent("supplementary.configGui.generation.tooltip"), mouseX, mouseY);
        }));
        // Add the "Done" button
        this.addButton(new Button(
                (this.width - BUTTON_WIDTH) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                // Text shown on the button
                new TranslationTextComponent("gui.done"),
                // Action performed when the button is pressed
                button -> this.onClose()
        ));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        // First draw the background of the screen
        this.renderBackground(matrixStack);
        // Draw the title
        drawCenteredString(matrixStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        // Call the super class' method to complete rendering
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }

    /**
     * Closes this screen.
     */
    @Override
    public void onClose() {
        CMI.save();
        this.minecraft.setScreen(parentScreen);
    }
}
