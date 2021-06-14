package kwork.common.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.Material

class StarBlock(name: String = "star") : Block(Properties.of(Material.STONE)) {
    init {
        this.setRegistryName(name)
    }
}