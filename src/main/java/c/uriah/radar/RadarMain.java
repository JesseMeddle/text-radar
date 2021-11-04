package c.uriah.radar;

import c.uriah.radar.mods.Radar;
import c.uriah.radar.proxy.CommonProxy;
import c.uriah.radar.util.Reference;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class RadarMain {
	
	public static FontRenderer fontRenderer;
	
	@Instance
	public RadarMain instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit (FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void init (FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(new Radar());
		System.out.println("[Radar] Initialization completed.");
	}
	
	@EventHandler
	public void PositInit (FMLPreInitializationEvent event) {
		
	}
}
