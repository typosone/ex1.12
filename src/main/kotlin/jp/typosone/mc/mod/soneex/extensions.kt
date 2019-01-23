package jp.typosone.mc.mod.soneex

import jp.typosone.mc.mod.soneex.ExperimentalMain.LOG
import jp.typosone.mc.mod.soneex.ExperimentalMain.MOD_ID
import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.util.ResourceLocation

val Block.exItem: Item
    get() = Item.getItemFromBlock(this)

fun Block.createBlockItem(): Item {
    val item = ItemBlock(this)
    item.registryName = this.registryName
    return item
}

val String.exResourceLocation: ResourceLocation
    get() = ResourceLocation(MOD_ID, this)

fun info(value: Any) {
    LOG.info(value)
}