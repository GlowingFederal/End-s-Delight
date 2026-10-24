package cn.foggyhillside.endsdelight.legacy;
public final class Acquisition {
 @cpw.mods.fml.common.eventhandler.SubscribeEvent public void drops(net.minecraftforge.event.entity.living.LivingDropsEvent event) {
  net.minecraft.entity.EntityLivingBase entity=event.entityLiving;
  if(entity.worldObj.isRemote || !EndsDelight.mobDrops) return;
  net.minecraft.entity.Entity killer=event.source.getEntity();
  if(!(killer instanceof net.minecraft.entity.EntityLivingBase) || !vectorwing.farmersdelight.legacy.Ingredients.isKnife(((net.minecraft.entity.EntityLivingBase)killer).getHeldItem())) return;
  if(entity instanceof net.minecraft.entity.boss.EntityDragon) {
   add(event,"dragon_leg",2);add(event,"raw_dragon_meat",2+(entity.worldObj.rand.nextFloat()>.5F?1:0)+(entity.worldObj.rand.nextFloat()>.5F?1:0));add(event,"dragon_tooth",1+(entity.worldObj.rand.nextFloat()>.7F?1:0));
  } else if((vectorwing.farmersdelight.legacy.UABCompatibility.isMob(entity,"Shulker") || vectorwing.farmersdelight.legacy.UABCompatibility.isMob(entity,"Endermite")) && entity.worldObj.rand.nextFloat()>.1F) {
   add(event,vectorwing.farmersdelight.legacy.UABCompatibility.isMob(entity,"Shulker")?"shulker_meat":"raw_ender_mite_meat",1);
  }
 }
 private void add(net.minecraftforge.event.entity.living.LivingDropsEvent event,String id,int amount) { for(net.minecraft.entity.item.EntityItem drop:event.drops) if(drop.getEntityItem().getItem()==EndsDelight.ITEMS.get(id)) return;net.minecraft.entity.EntityLivingBase entity=event.entityLiving;event.drops.add(new net.minecraft.entity.item.EntityItem(entity.worldObj,entity.posX,entity.posY,entity.posZ,new net.minecraft.item.ItemStack(EndsDelight.ITEMS.get(id),amount))); }
}
