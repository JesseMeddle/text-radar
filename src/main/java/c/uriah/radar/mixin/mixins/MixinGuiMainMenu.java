package c.uriah.radar.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import c.uriah.radar.util.Reference;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;

@Mixin({GuiMainMenu.class})
public class MixinGuiMainMenu extends GuiScreen{
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
	public void drawText(CallbackInfo ci) {
		
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Radar "+Reference.VERSION+" by Uriah", 2, 2, 0xffffff);
	}
}
