package io.github.mulverine.eventualdata;

import io.github.mulverine.eventualdata.advancement.StatChangedCriterion;
import io.github.mulverine.eventualdata.mixin.advancement.MixinCriterions;
import net.fabricmc.api.ModInitializer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EventualData implements ModInitializer {
	public static final String MOD_ID = "eventualdata";
	public static final String MOD_NAME = "Eventual Data";

	private static final String LOG_PREFIX = "[" + MOD_NAME + "] ";
	private static final Logger LOGGER = LogManager.getLogger();

	public static final Identifier PRESENCE_PACKET_ID = new Identifier(MOD_ID, "present");
	public static final Identifier UPDATE_ANVIL_TEXT_S2C_PACKET_ID = new Identifier(MOD_ID, "update_anvil_text");

	public static final StatChangedCriterion STAT_CHANGED_CRITERION = MixinCriterions.registerCriterion(new StatChangedCriterion());

	private static boolean lastReadNbtPresent = false;
	private static CompoundTag lastReadNbt;

	public static ServerPlayerEntity lastServerPlayerEntity;

	public static void logInfo(String message) {
		LOGGER.info(LOG_PREFIX + message);
	}

	public static void logWarn(String message) {
		LOGGER.warn(LOG_PREFIX + message);
	}

	public static void logError(String message) {
		LOGGER.error(LOG_PREFIX + message);
	}

	@SuppressWarnings("unused")
	public static boolean hasLastReadNbt() {
		return lastReadNbtPresent;
	}

	@SuppressWarnings("unused")
	public static void clearLastReadNbt() {
		lastReadNbt = null;
		lastReadNbtPresent = false;
	}
	
	public static void setLastReadNbt(CompoundTag nbt) {
		lastReadNbt = nbt;
		lastReadNbtPresent = true;
	}
	
	public static CompoundTag useLastReadNbt() {
		CompoundTag result = null;
		if(lastReadNbt != null) {
			result = lastReadNbt.copy();
			lastReadNbt = null;
		}
		lastReadNbtPresent = false;
		return result;
	}

	@Override
	public void onInitialize() {
	}
}
