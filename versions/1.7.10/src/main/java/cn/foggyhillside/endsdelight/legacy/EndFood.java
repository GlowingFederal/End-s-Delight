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
  if(definition.id.equals("chorus_flower_tea")) {}
  if(teleport.equals("always") || teleport.equals("sneak")&&player.isSneaking()) Teleport.move(player,this);
 }
 public ItemStack onEaten(ItemStack stack,World world,EntityPlayer player) { ItemStack result=super.onEaten(stack,world,player);extra(world,player);return result; }
 public net.minecraft.item.EnumAction getItemUseAction(ItemStack stack) { return definition.id.equals("dragon_breath_and_chorus_soup")?net.minecraft.item.EnumAction.eat:super.getItemUseAction(stack); }
 public boolean onItemUse(ItemStack stack,EntityPlayer player,World world,int x,int y,int z,int side,float hx,float hy,float hz) {
 if(!definition.id.equals("chorus_succulent")) return false;
 if(world.getBlock(x,y,z)==EndsDelight.BLOCKS.get("chorus_succulent") && world.getBlockMetadata(x,y,z)<2 && player.canPlayerEdit(x,y,z,side,stack)) {if(!world.isRemote){world.setBlockMetadataWithNotify(x,y,z,world.getBlockMetadata(x,y,z)+1,3);if(!player.capabilities.isCreativeMode)vectorwing.farmersdelight.legacy.Stacks.shrink(stack,1);}return true;}
 if(side!=1 || !world.isAirBlock(x,y+1,z) || !player.canPlayerEdit(x,y+1,z,side,stack) || !world.getBlock(x,y,z).getMaterial().isSolid()) return false;
 if(!world.isRemote) {world.setBlock(x,y+1,z,EndsDelight.BLOCKS.get("chorus_succulent"),0,3);if(!player.capabilities.isCreativeMode)vectorwing.farmersdelight.legacy.Stacks.shrink(stack,1);}return true;
 }
}
