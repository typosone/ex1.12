package jp.typosone.mc.mod.experimental.block

import jp.typosone.mc.mod.experimental.LOG
import jp.typosone.mc.mod.experimental.exResourceLocation
import net.minecraft.block.Block
import net.minecraft.block.material.Material

object BlockSoftStone : Block(Material.ROCK) {
    const val name = "soft_stone"

    init {
        unlocalizedName = name
        registryName = name.exResourceLocation
        LOG.info("unlocalizedName: $unlocalizedName")
        LOG.info("registryName: $registryName")
    }
}