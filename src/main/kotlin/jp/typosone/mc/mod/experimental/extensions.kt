package jp.typosone.mc.mod.experimental

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