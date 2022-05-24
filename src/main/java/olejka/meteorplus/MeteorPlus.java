package olejka.meteorplus;

import meteordevelopment.meteorclient.systems.Systems;
import meteordevelopment.meteorclient.systems.commands.Commands;
import olejka.meteorplus.hud.MeteorPlusLogoHud;
import olejka.meteorplus.modules.*;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.hud.HUD;
import net.minecraft.item.Items;
import olejka.meteorplus.modules.AutoSell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class MeteorPlus extends MeteorAddon {
	public static final Logger LOG = LoggerFactory.getLogger(MeteorPlus.class);
	public static final Category CATEGORY = new Category("Meteor Plus", Items.EMERALD_BLOCK.getDefaultStack());

	@Override
	public void onInitialize() {
		LOG.info("MeteorPlus initializing...");

		// Required when using @EventHandler
		MeteorClient.EVENT_BUS.registerLambdaFactory("olejka.meteorplus", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

		//Commands
		LOG.info("MeteorPlus initializing commands...");
		Commands commands = Commands.get();
		//commands.add(new EClipCommand());
		LOG.info("MeteorPlus loaded commands");

		//Modules
		LOG.info("MeteorPlus initializing modules...");
		Modules modules = Modules.get();
		modules.add(new MiddleClickExtraPlus());
		modules.add(new KillAuraPlus());
		modules.add(new AutoDropPlus());
		modules.add(new NoFallPlus());
		modules.add(new SpeedPlus());
		modules.add(new FlyPlus());
		modules.add(new SpiderPlus());
		modules.add(new JesusPlus());
		modules.add(new BoatAura());
		modules.add(new BedrockStorageBruteforce());
		modules.add(new AutoSell());
		modules.add(new AutoCraftPlus());
		modules.add(new AutoPortalMine());
		modules.add(new XrayBruteforce());
		modules.add(new AutoLeave());
		modules.add(new AutoAccept());
		modules.add(new AutoRepair());
		modules.add(new GhostBlockFixer());
		modules.add(new SafeMine());
		modules.add(new Freeze());
		modules.add(new Noclip());
		LOG.info("MeteorPlus loaded modules");

		// Hud
		LOG.info("MeteorPlus initializing hud...");
		HUD hud = Systems.get(HUD.class);
		hud.elements.add(new MeteorPlusLogoHud(hud));
		LOG.info("MeteorPlus loaded hud");

		LOG.info("MeteorPlus loaded");
	}

	@Override
	public void onRegisterCategories() {
		LOG.info("MeteorPlus registering categories...");
		Modules.registerCategory(CATEGORY);
		LOG.info("MeteorPlus register categories");
	}
}
