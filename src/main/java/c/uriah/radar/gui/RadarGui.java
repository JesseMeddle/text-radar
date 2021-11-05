package c.uriah.radar.gui;

import java.io.IOException;

import com.mojang.realmsclient.gui.ChatFormatting;

import c.uriah.radar.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class RadarGui extends GuiScreen {
    private GuiTextField watermark;
    
    public void initGui() {
        this.watermark = new GuiTextField(0, this.mc.fontRenderer, this.width / 2 - 100, this.height / 2 - 50, 200, 20);
        addButton(new GuiButton(2, this.width / 2 - 102, this.height / 2, 204, 20, "Apply"));
        addButton(new GuiButton(3, this.width / 2 - 102, this.height / 2 + 80, 204, 20, "Back"));
        addButton(new GuiButton(0420, this.width / 2 - 102, this.height / 2 + 24, 204, 20, TextFormatting.GREEN+"Enable "+TextFormatting.WHITE+"Radar"));
        addButton(new GuiButton(4200, this.width / 2 - 102, this.height / 2 + 48, 204, 20,  TextFormatting.RED+"Disable "+TextFormatting.WHITE+"Radar"));
        this.watermark.setFocused(true);
        this.watermark.setText("Watermark...");
        this.watermark.setMaxStringLength(150);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
        drawDefaultBackground();
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Radar Menu" , sr.getScaledWidth() / 2-Minecraft.getMinecraft().fontRenderer.getStringWidth("Radar Menu")/2, sr.getScaledHeight() / 4 , 0xffffff);
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("Radar "+Reference.VERSION+" running on "+Minecraft.getMinecraft().getVersion(), sr.getScaledWidth()-Minecraft.getMinecraft().fontRenderer.getStringWidth("Radar "+Reference.VERSION+" running on "+Minecraft.getMinecraft().getVersion())-2, sr.getScaledHeight()-12, 0xaaaaaa);
        this.watermark.drawTextBox();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    protected void actionPerformed(GuiButton button) {
        if (button.id == 2) apply(this.watermark.getText());
        if (button.id == 3) this.mc.displayGuiScreen(null);
        if(button.id == 0420) {
        	RadarOverlay.rEnable();
        	Minecraft.getMinecraft().player.sendMessage(new TextComponentString((ChatFormatting.DARK_RED + "<Radar "+Reference.VERSION+">")+(ChatFormatting.WHITE+" Enabled the radar")));
    		System.out.println("[Radar] Enabled the radar.");
        }
        if(button.id == 4200) {
        	RadarOverlay.rDisable();
        	Minecraft.getMinecraft().player.sendMessage(new TextComponentString((ChatFormatting.DARK_RED + "<Radar "+Reference.VERSION+">")+(ChatFormatting.WHITE+" Disabled the radar")));
    		System.out.println("[Radar] Disabled the radar.");
        }

    }

    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        this.watermark.mouseClicked(mouseX, mouseY, mouseButton);
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    protected void keyTyped(char typedChar, int keyCode) {
        this.watermark.textboxKeyTyped(typedChar, keyCode);
    }

    private void apply(String title) {
    	RadarOverlay.rSetWatermark(title);
    	Minecraft.getMinecraft().player.sendMessage(new TextComponentString((ChatFormatting.DARK_RED + "<Radar "+Reference.VERSION+">")+(ChatFormatting.WHITE+" Set watermark to \""+title+"\"")));
    	System.out.println("[Radar] Watermark set to "+title);
    }

}
