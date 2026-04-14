package org.carpentry.auxurelib.core;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.carpentry.auxurelib.core.util.MiscUtils;
import org.carpentry.auxurelib.internal.registry.InternalItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuxureLib implements ModInitializer {
	public static final String MOD_ID = "auxlib";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public void onInitialize() {
		if (MiscUtils.isDev()){
			InternalItems.init();
		}

		LOGGER.info("AuxureLib initializing.");
	}

	public static Identifier id (String path){return Identifier.of(MOD_ID, path); }
}