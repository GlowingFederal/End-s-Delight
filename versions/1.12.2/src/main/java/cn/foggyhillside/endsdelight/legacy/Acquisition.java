package cn.foggyhillside.endsdelight.legacy;
public final class Acquisition {
 @net.minecraftforge.fml.common.eventhandler.SubscribeEvent public void drops(net.minecraftforge.event.entity.living.LivingDropsEvent event) {
  net.minecraft.entity.EntityLivingBase entity=event.getEntityLiving();
  if(entity.world.isRemote || !EndsDelight.mobDrops) return;
  net.minecraft.entity.Entity killer=event.getSource().getTrueSource();
  if(!(killer instanceof net.minecraft.entity.EntityLivingBase) || !vectorwing.farmersdelight.legacy.Ingredients.isKnife(((net.minecraft.entity.EntityLivingBase)killer).getHeldItemMainhand())) return;
  if(entity instanceof net.minecraft.entity.boss.EntityDragon) {
   add(event,"dragon_leg",2);add(event,"raw_dragon_meat",2+(entity.world.rand.nextFloat()>.5F?1:0)+(entity.world.rand.nextFloat()>.5F?1:0));add(event,"dragon_tooth",1+(entity.world.rand.nextFloat()>.7F?1:0));
  } else if((entity instanceof net.minecraft.entity.monster.EntityShulker || entity instanceof net.minecraft.entity.monster.EntityEndermite) && entity.world.rand.nextFloat()>.1F) add(event,entity instanceof net.minecraft.entity.monster.EntityShulker?"shulker_meat":"raw_ender_mite_meat",1);
 }
 private void add(net.minecraftforge.event.entity.living.LivingDropsEvent event,String id,int amount) { net.minecraft.entity.EntityLivingBase entity=event.getEntityLiving();event.getDrops().add(new net.minecraft.entity.item.EntityItem(entity.world,entity.posX,entity.posY,entity.posZ,new net.minecraft.item.ItemStack(EndsDelight.ITEMS.get(id),amount))); }
}
