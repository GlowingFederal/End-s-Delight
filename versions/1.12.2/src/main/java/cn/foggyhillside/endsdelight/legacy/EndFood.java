package cn.foggyhillside.endsdelight.legacy;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import vectorwing.farmersdelight.legacy.api.FoodDefinition;
public final class EndFood extends vectorwing.farmersdelight.legacy.LegacyFood {
 private final String teleport;
 public EndFood(FoodDefinition definition,com.google.gson.JsonObject source) { super(definition);teleport=source.has("teleport")?source.get("teleport").getAsString():""; }
 private void extra(World world,EntityPlayer player) {
  if(world.isRemote) return;
  if(definition.id.equals("chorus_flower_tea")) player.removePotionEffect(net.minecraft.init.MobEffects.LEVITATION);
  if(teleport.equals("always") || teleport.equals("sneak")&&player.isSneaking()) Teleport.move(player,this);
 }
 public ItemStack onItemUseFinish(ItemStack stack,World world,net.minecraft.entity.EntityLivingBase consumer) { ItemStack result=super.onItemUseFinish(stack,world,consumer);if(consumer instanceof EntityPlayer) extra(world,(EntityPlayer)consumer);return result; }
 public net.minecraft.item.EnumAction getItemUseAction(ItemStack stack) { return definition.id.equals("dragon_breath_and_chorus_soup")?net.minecraft.item.EnumAction.EAT:super.getItemUseAction(stack); }
 public net.minecraft.util.EnumActionResult onItemUse(EntityPlayer player,World world,net.minecraft.util.math.BlockPos pos,net.minecraft.util.EnumHand hand,net.minecraft.util.EnumFacing side,float x,float y,float z) {
 if(!definition.id.equals("chorus_succulent")) return net.minecraft.util.EnumActionResult.PASS;
 ItemStack stack=player.getHeldItem(hand);net.minecraft.block.state.IBlockState state=world.getBlockState(pos);
 if(state.getBlock()==EndsDelight.BLOCKS.get("chorus_succulent") && state.getValue(Succulent.COUNT)<3 && player.canPlayerEdit(pos,side,stack)) {if(!world.isRemote){world.setBlockState(pos,state.withProperty(Succulent.COUNT,state.getValue(Succulent.COUNT)+1),3);if(!player.capabilities.isCreativeMode)stack.shrink(1);}return net.minecraft.util.EnumActionResult.SUCCESS;}
 net.minecraft.util.math.BlockPos target=pos.up();if(side!=net.minecraft.util.EnumFacing.UP || !world.isAirBlock(target) || !player.canPlayerEdit(target,side,stack) || !state.getMaterial().isSolid()) return net.minecraft.util.EnumActionResult.PASS;
 if(!world.isRemote){world.setBlockState(target,EndsDelight.BLOCKS.get("chorus_succulent").getDefaultState(),3);if(!player.capabilities.isCreativeMode)stack.shrink(1);}return net.minecraft.util.EnumActionResult.SUCCESS;
 }
}
