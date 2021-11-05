package c.uriah.radar.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CreateButton extends Gui {
	
	@SubscribeEvent
	   public void GuiEvent(GuiScreenEvent.InitGuiEvent.Post event){
	       GuiScreen gui = event.getGui();
	       if(gui instanceof GuiIngameMenu){event.getButtonList().add(new Button(420, gui.width / 2 - 100, gui.height / 4 + 144+ -16, 200 ,20, "Radar Options..."));
	       }
	   }
}
