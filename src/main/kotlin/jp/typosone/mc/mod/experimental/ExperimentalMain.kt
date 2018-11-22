package jp.typosone.mc.mod.experimental

import jp.typosone.mc.mod.experimental.block.experimentalBlockItemsRegister
import jp.typosone.mc.mod.experimental.block.experimentalBlocksRegister
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.client.event.ModelRegistryEvent
import net.minecraftforge.event.RegistryEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import org.apache.logging.log4j.LogManager


const val MOD_ID = "experimental"
const val LANGUAGE_ADAPTER = "net.shadowfacts.forgelin.KotlinAdapter"
const val VERSION = "0.0.1"
val LOG = LogManager.getLogger(MOD_ID)

@Mod(modid = MOD_ID, version = VERSION, modLanguage = "kotlin", modLanguageAdapter = LANGUAGE_ADAPTER)
@Mod.EventBusSubscriber(modid = MOD_ID)
object ExperimentalMain {

    @SubscribeEvent
    fun registerItems(event: RegistryEvent.Register<Item>) {
        LOG.info("registerItems")
        experimentalBlockItemsRegister(event.registry)
    }

    @SubscribeEvent
    fun registerBlocks(event: RegistryEvent.Register<Block>) {
        LOG.info("experimental registerBlocks")
        experimentalBlocksRegister(event.registry)
    }

    @SubscribeEvent
    fun registerModels(event: ModelRegistryEvent) {
        LOG.info("registerModels")
    }
}