package kwork.common.mixin.client;

import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MainWindow.class)
public abstract class MixinMainWindow {
    @Redirect(method = "setTitle", at = @At(value = "INVOKE", target = "Lorg/lwjgl/glfw/GLFW;glfwSetWindowTitle(JLjava/lang/CharSequence;)V"))
    public void setTitleInj(long windowId, String title) {
        GLFW.glfwSetWindowTitle(windowId, "Minecraft " + Minecraft.getInstance().getVersionType() + ": KWork Edition");
    }
}