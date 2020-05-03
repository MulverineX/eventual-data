package io.github.mulverine.eventualdata.mixin;

import io.github.mulverine.eventualdata.EventualData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.ServerStatHandler;
import net.minecraft.stat.Stat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerStatHandler.class)
public class MixinServerStatHandler {
	@Inject(method = "setStat", at = @At("TAIL"))
	public void setStat(PlayerEntity playerEntity, Stat<?> stat, int value, CallbackInfo callbackInfo) {
		if (playerEntity instanceof ServerPlayerEntity) {
			EventualData.STAT_CHANGED_CRITERION.trigger((ServerPlayerEntity) playerEntity, stat, value);
		}
	}
}
