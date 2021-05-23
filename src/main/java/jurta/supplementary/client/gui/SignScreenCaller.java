package jurta.supplementary.client.gui;

import jurta.supplementary.tileentity.ModSignTileEntity;
import net.minecraft.client.Minecraft;

public class SignScreenCaller {
    public static void openSignScreen(ModSignTileEntity tile) {
        Minecraft.getInstance().setScreen(new SignScreen(tile));
    }
}
