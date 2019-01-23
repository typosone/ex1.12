package jp.typosone.mc.mod.soneex.item

import jp.typosone.mc.mod.soneex.ExperimentalMain.MOD_ID
import jp.typosone.mc.mod.soneex.exResourceLocation
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry

object ExItems {
    @GameRegistry.ObjectHolder("$MOD_ID:destructor")
    val destructor: Item? = null
}

fun experimentalItemsRegister(registry: IForgeRegistry<Item>) {
    registry.registerAll(
            ItemDestructor
    )
}

@SideOnly(Side.CLIENT)
fun experimentalItemModelsRegister() {
    ModelLoader.setCustomModelResourceLocation(
            ItemDestructor, 0,
            ModelResourceLocation(ItemDestructor.name.exResourceLocation, "inventory")
    )
}