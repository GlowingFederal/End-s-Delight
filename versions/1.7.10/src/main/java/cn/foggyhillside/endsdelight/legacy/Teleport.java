package cn.foggyhillside.endsdelight.legacy;
public final class Teleport {
 public static void move(net.minecraft.entity.player.EntityPlayer player,net.minecraft.item.Item food) {
  net.minecraft.world.World world=player.worldObj;
  for(int attempt=0;attempt<16;attempt++) {
   double x=player.posX+(world.rand.nextDouble()-.5D)*16,z=player.posZ+(world.rand.nextDouble()-.5D)*16,y=Math.max(0,Math.min(255,player.posY+world.rand.nextInt(16)-8));
   net.minecraftforge.event.entity.living.EnderTeleportEvent event=new net.minecraftforge.event.entity.living.EnderTeleportEvent(player,x,y,z,0);
   if(net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event)) return;
   x=event.targetX;y=event.targetY;z=event.targetZ;
   int bx=net.minecraft.util.MathHelper.floor_double(x),bz=net.minecraft.util.MathHelper.floor_double(z),by=(int)y;
   if(!world.blockExists(bx,by,bz)) continue;
   while(by>0 && !world.getBlock(bx,by-1,bz).getMaterial().isSolid()) by--;
   if(by<=0) continue;
   net.minecraft.util.AxisAlignedBB box=player.boundingBox.copy().offset(x-player.posX,by-player.posY,z-player.posZ);
   if(!world.getCollidingBoundingBoxes(player,box).isEmpty() || world.isAnyLiquid(box)) continue;
   player.mountEntity(null);player.setPositionAndUpdate(x,by,z);world.playSoundAtEntity(player,"mob.endermen.portal",1F,1F);return;
  }
 }
 private Teleport() {}
}
