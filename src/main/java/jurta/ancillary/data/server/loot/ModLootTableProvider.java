package jurta.ancillary.data.server.loot;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import jurta.ancillary.Ancillary;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModLootTableProvider extends LootTableProvider {

	public ModLootTableProvider(DataGenerator dataGeneratorIn) {
		super(dataGeneratorIn);
	}

    @Override
    public String getName() {
        return "Loot Tables: " + Ancillary.MOD_ID;
    }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(ModBlockLootTableProvider::new, LootParameterSets.BLOCK)
        );
    }
	
	@Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218436_2_, p_218436_3_) -> LootTableManager.validate(validationtracker, p_218436_2_, p_218436_3_));
    }
}
