package jurta.ancillary.client.gui;

import jurta.ancillary.tileentity.ModSignTileEntity;
import net.minecraft.client.Minecraft;

public class SignScreenCaller {
    public static void openSignScreen(ModSignTileEntity tile) {
        Minecraft.getInstance().setScreen(new SignScreen(tile));
    }
}
