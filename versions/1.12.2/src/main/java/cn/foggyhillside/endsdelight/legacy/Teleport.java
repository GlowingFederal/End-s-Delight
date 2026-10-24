package cn.foggyhillside.endsdelight.legacy;
public final class Teleport {
 public static void move(net.minecraft.entity.player.EntityPlayer player,net.minecraft.item.Item food) {
  net.minecraft.world.World world=player.world;
  for(int attempt=0;attempt<16;attempt++) {
   double x=player.posX+(world.rand.nextDouble()-.5D)*16,z=player.posZ+(world.rand.nextDouble()-.5D)*16,y=Math.max(0,Math.min(255,player.posY+world.rand.nextInt(16)-8));
   net.minecraftforge.event.entity.living.EnderTeleportEvent event=new net.minecraftforge.event.entity.living.EnderTeleportEvent(player,x,y,z,0);
   if(net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
   player.dismountRidingEntity();
   if(player.attemptTeleport(event.getTargetX(),event.getTargetY(),event.getTargetZ())) {world.playSound(null,player.posX,player.posY,player.posZ,net.minecraft.init.SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT,net.minecraft.util.SoundCategory.PLAYERS,1F,1F);if(food!=null) player.getCooldownTracker().setCooldown(food,20);return;}
  }
 }
 private Teleport() {}
}
