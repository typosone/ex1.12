package jp.typosone.mc.mod.soneex.block

import jp.typosone.mc.mod.soneex.ExperimentalMain.MOD_ID
import jp.typosone.mc.mod.soneex.createBlockItem
import jp.typosone.mc.mod.soneex.exItem
import jp.typosone.mc.mod.soneex.exResourceLocation
import net.minecraft.block.Block
import net.minecraft.client.renderer.block.model.ModelResourceLocation
import net.minecraft.item.Item
import net.minecraftforge.client.model.ModelLoader
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraftforge.registries.IForgeRegistry


object ExBlocks {
    @GameRegistry.ObjectHolder("$MOD_ID:soft_stone")
    val soft_stone: Block? = null

}

fun experimentalBlocksRegister(registry: IForgeRegistry<Block>) {
    registry.registerAll(
            BlockSoftStone
    )
}

fun experimentalBlockItemsRegister(registry: IForgeRegistry<Item>) {
    registry.registerAll(
            BlockSoftStone.createBlockItem()
    )
}

@SideOnly(Side.CLIENT)
fun experimentalBlockItemModelsRegister() {
    ModelLoader.setCustomModelResourceLocation(
            BlockSoftStone.exItem, 0,
            ModelResourceLocation(BlockSoftStone.name.exResourceLocation, "inventory")
    )
}