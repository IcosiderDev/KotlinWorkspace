package kwork.api

import kwork.KWork
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.MathHelper
import net.minecraft.world.chunk.Chunk

class ManaImpl : Mana {
    var mana = 0.0
        set(value) {
            field = MathHelper.clamp(field + value, .0, max)
        }
    var max = 100.0
    var convertTax = 0.2

    override fun drain(value: Double) = this.apply {
        if (this.mana != value)
            this.mana = -(this.mana * convertTax)
    }

    override fun fill(value: Double) = this.apply {
        if (this.mana != value)
            this.mana = 0.025
    }

    override fun toString(): String {
        return "ManaImpl(mana=$mana, max=$max, convertTax=$convertTax)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ManaImpl

        if (mana != other.mana) return false
        if (max != other.max) return false
        if (convertTax != other.convertTax) return false
        return true
    }

    override fun hashCode(): Int {
        var result = mana.hashCode()
        result = 31 * result + max.hashCode()
        result = 31 * result + convertTax.hashCode()
        return result
    }

    companion object {
        fun get(chunk: Chunk): ManaImpl? =
                chunk.getCapability(KWork.manaCap, EnumFacing.DOWN) as? ManaImpl
    }
}