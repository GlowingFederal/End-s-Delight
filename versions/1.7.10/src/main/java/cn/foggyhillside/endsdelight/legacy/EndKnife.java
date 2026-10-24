package cn.foggyhillside.endsdelight.legacy;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
public final class EndKnife extends vectorwing.farmersdelight.legacy.Knife {
 private final String repair;
 public EndKnife(String id) {
  super(net.minecraftforge.common.util.EnumHelper.addToolMaterial("ENDS_DELIGHT_"+id.toUpperCase(java.util.Locale.ROOT),id.equals("end_stone_knife")||id.equals("purpur_knife")?1:2,id.equals("dragon_tooth_knife")?1561:id.equals("dragon_egg_shell_knife")?1250:200,4F,id.equals("dragon_tooth_knife")?4F:id.equals("dragon_egg_shell_knife")?2.5F:1F,5));
  repair=id.equals("end_stone_knife")?"minecraft:end_stone":id.equals("purpur_knife")?"minecraft:popped_chorus_fruit":id.equals("dragon_tooth_knife")?"minecraft:bone_block":"ends_delight:dragon_egg_shell";
 }
 public boolean getIsRepairable(ItemStack tool,ItemStack ingredient) { ItemStack expected=vectorwing.farmersdelight.legacy.Stacks.resolve(repair);return !vectorwing.farmersdelight.legacy.Stacks.empty(expected) && vectorwing.farmersdelight.legacy.Stacks.matches(java.util.Collections.singletonList(expected),ingredient); }
}
