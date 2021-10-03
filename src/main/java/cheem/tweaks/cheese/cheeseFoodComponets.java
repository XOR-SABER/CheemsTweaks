package cheem.tweaks.cheese;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class cheeseFoodComponets {
    
    public static final FoodComponent AMETHYST_POTATO = (new FoodComponent.Builder()).hunger(5).saturationModifier( 1.1f).statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 2), 1).statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 1), 1).alwaysEdible().build();
}
