package jp.typosone.mc.mod.soneex;

import jp.typosone.mc.mod.soneex.block.ExBlocksKt;
import jp.typosone.mc.mod.soneex.item.ExItemsKt;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExperimentalMain.MOD_ID, version = ExperimentalMain.VERSION, dependencies = "required-after:forgelin@[1.8.0,);")
@Mod.EventBusSubscriber(modid = ExperimentalMain.MOD_ID)
public class ExperimentalMain {
    public static final String MOD_ID = "soneex";
    public static final String VERSION = "0.0.1";
    public static final Logger LOG = LogManager.getLogger(MOD_ID);

    @SubscribeEvent
    static void registerItems(RegistryEvent.Register<Item> event) {
        ExBlocksKt.experimentalBlockItemsRegister(event.getRegistry());
        ExItemsKt.experimentalItemsRegister(event.getRegistry());
    }

    @SubscribeEvent
    static void registerBlocks(RegistryEvent.Register<Block> event) {
        ExBlocksKt.experimentalBlocksRegister(event.getRegistry());
    }

    @SubscribeEvent
    static void registerModels(ModelRegistryEvent event) {
        ExBlocksKt.experimentalBlockItemModelsRegister();
        ExItemsKt.experimentalItemModelsRegister();
    }
}
