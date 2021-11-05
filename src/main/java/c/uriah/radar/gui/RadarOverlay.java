package c.uriah.radar.gui;

import java.util.Iterator;

import c.uriah.radar.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RadarOverlay extends Gui {
	
	public static boolean toggled = true;
	public static String rwatermark = "Radar";
	
	public static void rEnable() {
		toggled = true;
	}
	public static void rDisable() {
		toggled = false;
	}
	
	public static boolean rIsToggled() {
		return toggled;
	}
	
	public static void rSetWatermark(String title) {
		rwatermark = title;
	}
	
	public static String rGetWatermark() {
		return rwatermark;
	}
	
	@SubscribeEvent
	public void renderOverlay(RenderGameOverlayEvent event) {
		if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT && toggled == true) {
			int y=2;
			Iterator iterator = Minecraft.getMinecraft().world.playerEntities.iterator();
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(rwatermark+" (release-"+Reference.VERSION+")" , 2, 2, 0xffffff);
			for (EntityPlayer nextPlayer : Minecraft.getMinecraft().world.playerEntities) {		
				do{
					if(!iterator.hasNext())   		
						return;
		            nextPlayer = (EntityPlayer)iterator.next();
				} 
		    
				while(nextPlayer.getName().equals(Minecraft.getMinecraft().player.getName()));
				Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(">"+nextPlayer.getName()+" " +(int)Minecraft.getMinecraft().player.getDistance(nextPlayer), 2, y+12, 0xff0000);
				y+= Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT+2;	
			}
		}
	}
}
