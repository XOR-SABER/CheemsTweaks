package cheem.tweaks.cheese;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class cheeseFoodComponets {
    public static final FoodComponent DIAMOND_GLOW_BERRIES = (new FoodComponent.Builder())
    .hunger(4)
    .saturationModifier(2f)
    .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 1800, 1), 1)
    .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1200, 3), 1)
    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 2), 1)
    .alwaysEdible()
    .build();
    public static final FoodComponent AMETHYST_POTATO = (new FoodComponent.Builder())
    .hunger(5)
    .saturationModifier( 1.1f)
    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 600, 2), 1)
    .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 1), 1)
    .alwaysEdible()
    .build();
    public static final FoodComponent REDSTONE_JELLY = (new FoodComponent.Builder())
    .hunger(10)
    .saturationModifier(0.1f)
    .statusEffect(new StatusEffectInstance(StatusEffects.HASTE,300, 2), 1)
    .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1600, 2), 1)
    .alwaysEdible()
    .build();
    public static final FoodComponent BERRY_JELLY = (new FoodComponent.Builder())
    .hunger(8)
    .saturationModifier(0.2f)
    .build();

}
