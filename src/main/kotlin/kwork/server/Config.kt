package kwork.server

import net.minecraftforge.common.config.Config

@Config(modid = "kwork", name = "KWork")
object Config {
    @JvmField
    @Config.Comment("First config value")
    var firstValue = 0

    @JvmField
    @Config.Comment("Second config value")
    var secondValue = false

    @JvmField
    @Config.Comment("Category value")
    var category = Category()

    data class Category(
            @JvmField
            var catFirstValue: String = "Default value",

            @JvmField
            @Config.Comment("Category config value")
            var catSecondValue: Boolean = true
    )
}