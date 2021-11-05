package c.uriah.radar.mixin.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import c.uriah.radar.gui.RadarGui;
import c.uriah.radar.util.Reference;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

@Mixin({GuiIngameMenu.class})
public class MixinGuiIngameMenu extends GuiScreen{
	@Inject(method = {"drawScreen"}, at = {@At("TAIL")}, cancellable = true)
	public void drawText(CallbackInfo ci) {
		ScaledResolution sr = new ScaledResolution(mc);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Radar "+Reference.VERSION, sr.getScaledWidth()-Minecraft.getMinecraft().fontRenderer.getStringWidth("Radar "+Reference.VERSION)-2, sr.getScaledHeight()-12, 0xaaaaaa);

	}
	
	@Inject(method = "actionPerformed", at = @At("HEAD"))
	public void actionPerformed(GuiButton button, CallbackInfo ci){
	    if(button.id == 420){
	    mc.displayGuiScreen(new RadarGui());
	    
	    }
	}
}
