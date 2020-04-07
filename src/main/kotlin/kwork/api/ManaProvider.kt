package kwork.api

import kwork.KWork
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilitySerializable

class ManaProvider : ICapabilitySerializable<NBTTagCompound> {
    private val capImpl = KWork.manaCap.defaultInstance

    override fun <T : Any?> getCapability(cap: Capability<T>, side: EnumFacing?): T? =
            if (cap === KWork.manaCap) KWork.manaCap.cast(capImpl) else null

    override fun deserializeNBT(nbt: NBTTagCompound) {
        KWork.manaCap.storage.readNBT(KWork.manaCap, capImpl, EnumFacing.DOWN, nbt)
    }

    override fun serializeNBT() =
            KWork.manaCap.storage.writeNBT(KWork.manaCap, capImpl, EnumFacing.DOWN) as NBTTagCompound

    override fun hasCapability(cap: Capability<*>, side: EnumFacing?) =
            cap === KWork.manaCap
}