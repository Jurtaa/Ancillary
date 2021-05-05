package jurta.supplementary.config;

import com.mojang.blaze3d.matrix.MatrixStack;
import jurta.supplementary.Supplementary;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.IBidiTooltip;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class GenerationConfigScreen extends Screen {
    /** Distance from top of the screen to the options row list's top */
    private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
    /** Distance from bottom of the screen to the options row list's bottom */
    private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
    /** Height of each item in the options row list */
    private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;

    /** Width of a button */
    private static final int BUTTON_WIDTH = 200;
    /** Height of a button */
    private static final int BUTTON_HEIGHT = 20;
    /** Distance from bottom of the screen to the "Done" button's top */
    private static final int DONE_BUTTON_TOP_OFFSET = 26;

    private static final ConfigManager CMI = ConfigManager.getInstance();

    private final Screen parentScreen;

    /** List of options rows shown on the screen */
    // Not a final field because this cannot be initialized in the constructor,
    // as explained below
    private OptionsRowList optionsRowList;

    /** Distance from top of the screen to this GUI's title */
    private static final int TITLE_HEIGHT = 8;

    public GenerationConfigScreen(Screen parentScreen) {
        // Use the super class' constructor to set the screen's title
        super(new TranslationTextComponent("config.supplementary.generation.title", Supplementary.MOD_ID));
        this.parentScreen = parentScreen;
    }

    @Override
    protected void init() {
        // Create the options row list
        // It must be created in this method instead of in the constructor,
        // or it will not be displayed properly
        this.optionsRowList = new OptionsRowList(
                this.minecraft, this.width, this.height,
                OPTIONS_LIST_TOP_HEIGHT,
                this.height - OPTIONS_LIST_BOTTOM_OFFSET,
                OPTIONS_LIST_ITEM_HEIGHT
        );

        this.optionsRowList.addSmall(new BooleanOption(
                "config.supplementary.allowVegetalGeneration.title",
                new TranslationTextComponent("config.supplementary.allowVegetalGeneration.tooltip", Supplementary.MOD_ID),
                unused -> CMI.allowVegetalGeneration(),
                (unused, newValue) -> CMI.changeAllowVegetalGeneration(newValue)
        ), new BooleanOption(
                "config.supplementary.allowTreeGeneration.title",
                new TranslationTextComponent("config.supplementary.allowTreeGeneration.tooltip", Supplementary.MOD_ID),
                unused -> CMI.allowTreeGeneration(),
                (unused, newValue) -> CMI.changeAllowTreeGeneration(newValue))
        );

        // Add the options row list as this screen's child
        // If this is not done, users cannot click on items in the list
        this.children.add(this.optionsRowList);

        // Add the "Done" button
        this.addButton(new Button(
                (this.width - BUTTON_WIDTH) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                // Text shown on the button
                DialogTexts.GUI_DONE,
                // Action performed when the button is pressed
                button -> this.onClose()
        ));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        // First draw the background of the screen
        this.renderBackground(matrixStack);
        // Options row list must be rendered here,
        // otherwise the GUI will be broken
        this.optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);
        // Draw the title
        drawCenteredString(matrixStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        // Call the super class' method to complete rendering
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        // Allow tooltips to be drawn
        List<IReorderingProcessor> list = tooltipAt(this.optionsRowList, mouseX, mouseY);
        if (list != null) {
            this.renderTooltip(matrixStack, list, mouseX, mouseY);
        }
    }

    /**
     * Closes this screen.
     */
    @Override
    public void onClose() {
        CMI.save();
        this.minecraft.setScreen(parentScreen);
    }

    @Nullable
    public static List<IReorderingProcessor> tooltipAt(OptionsRowList optionsRowList, int mouseX, int mouseY) {
        Optional<Widget> optional = optionsRowList.getMouseOver(mouseX, mouseY);
        if (optional.isPresent() && optional.get() instanceof IBidiTooltip) {
            Optional<List<IReorderingProcessor>> optional1 = ((IBidiTooltip)optional.get()).getTooltip();
            return optional1.orElse(null);
        } else {
            return null;
        }
    }
}
