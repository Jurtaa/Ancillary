package jurta.supplementary.init;

import jurta.supplementary.Supplementary;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class ModTabs {
    public static final ItemGroup SUPPLEMENTARY = new ModTab(Supplementary.MOD_ID, () ->
            new ItemStack(Items.STRING));

    public static final class ModTab extends ItemGroup {
        @Nonnull
        private final Supplier<ItemStack> iconSupplier;

        /**
         * @param name  String: mod id
         * @param iconSupplier
         */
        public ModTab(@Nonnull final String name, @Nonnull final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return iconSupplier.get();
        }
    }
}
