package io.github.mulverine.eventualdata.mixin.advancement;

import net.minecraft.advancement.criterion.Criterion;
import net.minecraft.advancement.criterion.Criterions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Criterions.class)
public interface MixinCriterions {
	@Invoker("register")
	static <T extends Criterion<?>> T registerCriterion(T criterion) {
		return null;
	}
}
