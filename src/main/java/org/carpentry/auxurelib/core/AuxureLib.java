package org.carpentry.auxurelib.core;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.carpentry.auxurelib.internal.registry.InternalItems;

public class AuxureLib implements ModInitializer {
	public static final String MOD_ID = "auxlib";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		if (FabricLoader.getInstance().isDevelopmentEnvironment()){
			InternalItems.init();
		} // only register internal items if its a dev environment

		LOGGER.info("AuxureLib initializing.");
	}

	public static Identifier id (String path){return Identifier.of(MOD_ID, path); } // use AuxureLib.id() instead of new Identifier("auxurelib")
	// thanks ig? Not really sure what the point is but ok
}