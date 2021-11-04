package c.uriah.radar.mods;

import java.util.Iterator;

import c.uriah.radar.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Radar extends Gui {
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
			int y=2;
			Iterator iterator = Minecraft.getMinecraft().world.playerEntities.iterator();
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Radar "+"(release-"+Reference.VERSION+")" , 2, 2, 0xffffff);
			for (EntityPlayer nextPlayer : Minecraft.getMinecraft().world.playerEntities) {		
				do{
					if(!iterator.hasNext())   		
						return;
		            	nextPlayer = (EntityPlayer)iterator.next();
				} 
		    
				while(nextPlayer.getName().equals(Minecraft.getMinecraft().player.getName()));
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(TextFormatting.DARK_RED+">"+nextPlayer.getName()+" " +(int)Minecraft.getMinecraft().player.getDistance(nextPlayer), 2, y+12, 0xffffff);
				y+= Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT+2;	
			}
		}
	}
}
