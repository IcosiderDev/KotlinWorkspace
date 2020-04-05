package kwork.common.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material

class BlockStar(name: String = "star") : Block(Material.ROCK) {
    init {
        this.setRegistryName(name)
        this.unlocalizedName = name
    }
}