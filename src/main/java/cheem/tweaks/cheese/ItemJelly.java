package cheem.tweaks.cheese;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class ItemJelly extends Item {

	public ItemJelly(Settings item$Settings) {
		super(item$Settings);
	}
	
	public UseAction getUseAction(ItemStack itemStack) {
        return UseAction.DRINK;
    }

	public ItemStack finishUsing(ItemStack itemStack, World world, LivingEntity livingEntity) {
		if (livingEntity instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) livingEntity;
			player.getHungerManager().eat(itemStack.getItem(), itemStack);
			player.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
			
			if (player instanceof ServerPlayerEntity) {
				Criteria.CONSUME_ITEM.trigger((ServerPlayerEntity) player, itemStack);
			}
			
			player.giveItemStack(new ItemStack(CheemsTweaks.EMPTY_JAR));
		}
		
		itemStack.decrement(1);
		return itemStack;
	}

}