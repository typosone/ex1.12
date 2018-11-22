package jp.typosone.mc.mod.experimental.block

import jp.typosone.mc.mod.experimental.MOD_ID
import jp.typosone.mc.mod.experimental.createBlockItem
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraftforge.fml.common.registry.GameRegistry
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