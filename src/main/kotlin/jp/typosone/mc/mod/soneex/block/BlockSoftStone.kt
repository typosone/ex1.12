package jp.typosone.mc.mod.soneex.block

import jp.typosone.mc.mod.soneex.exResourceLocation
import net.minecraft.block.Block
import net.minecraft.block.material.Material

object BlockSoftStone : Block(Material.ROCK) {
    const val name = "soft_stone"

    init {
        unlocalizedName = name
        registryName = name.exResourceLocation
    }
}