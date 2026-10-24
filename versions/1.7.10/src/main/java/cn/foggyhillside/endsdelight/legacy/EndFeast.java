package cn.foggyhillside.endsdelight.legacy;
public final class EndFeast extends vectorwing.farmersdelight.legacy.ServingBlock {
 public EndFeast(String id,boolean pie,String serving) { super("ends_delight",id,pie,"ends_delight:"+serving,!pie); }
 public void setBlockBoundsBasedOnState(net.minecraft.world.IBlockAccess world,int x,int y,int z) {
 float height=pie?4F/16:id.equals("grilled_shulker_block")?(portions(world.getTileEntity(x,y,z))==0?3F/16:6F/16):11F/16;
 setBlockBounds(1F/16,0,1F/16,15F/16,height,15F/16);
 }
 public boolean onBlockActivated(net.minecraft.world.World world,int x,int y,int z,net.minecraft.entity.player.EntityPlayer player,int side,float hx,float hy,float hz) {
  int before=portions(world.getTileEntity(x,y,z));boolean used=super.onBlockActivated(world,x,y,z,player,side,hx,hy,hz);
  if(!world.isRemote && pie && used && before>portions(world.getTileEntity(x,y,z)) && player.isSneaking() && vectorwing.farmersdelight.legacy.Stacks.empty(player.getHeldItem())) Teleport.move(player,null);
  return used;
 }
}
