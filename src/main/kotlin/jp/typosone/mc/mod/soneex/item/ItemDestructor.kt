package jp.typosone.mc.mod.soneex.item

import jp.typosone.mc.mod.soneex.exResourceLocation
import net.minecraft.block.Block
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks.*
import net.minecraft.item.Item
import net.minecraft.util.EnumActionResult
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object ItemDestructor : Item() {
    const val name = "destructor"
    val liquidBlockList = listOf(
            WATER, FLOWING_WATER, LAVA, FLOWING_LAVA
    )
    val solidBlockList = listOf(
            STONE, GRASS, DIRT, COBBLESTONE
    )
    val fallingBlockList = listOf(
            SAND, GRAVEL
    )
    val targetBlockList = liquidBlockList + solidBlockList + fallingBlockList


    init {
        unlocalizedName = name
        registryName = name.exResourceLocation
        creativeTab = CreativeTabs.MATERIALS
    }

    override fun onItemUse(player: EntityPlayer, worldIn: World, pos: BlockPos, hand: EnumHand, facing: EnumFacing,
                           hitX: Float, hitY: Float, hitZ: Float): EnumActionResult {
        if (!worldIn.isRemote) {
            if (facing in listOf(EnumFacing.UP, EnumFacing.DOWN)) {
                return EnumActionResult.PASS;
            }
            val playerFacing = facing.rotateY().rotateY()
            for (depth in 0..127) {
                // 外周(上下)にカバー
                for (side in -2..2) {
                    // 上
                    var targetPos = pos.offset(playerFacing, depth).up(4).offset(playerFacing.rotateY(), side)
                    var target = worldIn.getBlockState(targetPos).block
                    if (target in (fallingBlockList + liquidBlockList)) {
                        worldIn.setBlockState(targetPos, COBBLESTONE.defaultState)
                    }
                    // 下
                    targetPos = pos.offset(playerFacing, depth).down(2).offset(playerFacing.rotateY(), side)
                    target = worldIn.getBlockState(targetPos).block
                    if (target in (liquidBlockList + AIR)) {
                        worldIn.setBlockState(targetPos, COBBLESTONE.defaultState)
                    }
                }
                // 外周(左右)にカバー
                for (y in -1..3) {
                    // 左
                    var targetPos = pos.offset(playerFacing, depth).up(y).offset(playerFacing.rotateYCCW(), 3)
                    var target = worldIn.getBlockState(targetPos).block
                    if (target in liquidBlockList) {
                        worldIn.setBlockState(targetPos, COBBLESTONE.defaultState)
                    }
                    // 右
                    targetPos = pos.offset(playerFacing, depth).down(y).offset(playerFacing.rotateY(), 3)
                    target = worldIn.getBlockState(targetPos).block
                    if (target in liquidBlockList) {
                        worldIn.setBlockState(targetPos, COBBLESTONE.defaultState)
                    }
                }
                // 削っていく
                for (side in -2..2) {
                    for (y in -1..3) {
                        val targetPos = pos.offset(playerFacing, depth).up(y).offset(playerFacing.rotateY(), side)
                        val target = worldIn.getBlockState(targetPos).block
                        var replaced = false
                        if (target.isDestruct()) {
                            worldIn.setBlockToAir(targetPos)
                            replaced = true
                        }
                        // 定期的に松明を置く
                        if (replaced && side == 0 && y == -1 && depth % 4 == 0) {
                            worldIn.setBlockState(targetPos, TORCH.defaultState)
                        }
                    }
                }
            }
        }

        return EnumActionResult.SUCCESS
    }

    private fun Block.isDestruct(): Boolean {
        return this in targetBlockList
    }
}