package cn.foggyhillside.endsdelight.legacy;
public final class EndFeast extends vectorwing.farmersdelight.legacy.ServingBlock {
 public EndFeast(String id,boolean pie,String serving) { super("ends_delight",id,pie,"ends_delight:"+serving,!pie); }
 public net.minecraft.util.math.AxisAlignedBB getBoundingBox(net.minecraft.block.state.IBlockState state,net.minecraft.world.IBlockAccess world,net.minecraft.util.math.BlockPos pos) {
 double height=pie?4D/16:id.equals("grilled_shulker_block")?(portions(world.getTileEntity(pos))==0?3D/16:6D/16):11D/16;
 return new net.minecraft.util.math.AxisAlignedBB(1D/16,0,1D/16,15D/16,height,15D/16);
 }
 public boolean onBlockActivated(net.minecraft.world.World world,net.minecraft.util.math.BlockPos pos,net.minecraft.block.state.IBlockState state,net.minecraft.entity.player.EntityPlayer player,net.minecraft.util.EnumHand hand,net.minecraft.util.EnumFacing side,float x,float y,float z) {
  int before=portions(world.getTileEntity(pos));boolean used=super.onBlockActivated(world,pos,state,player,hand,side,x,y,z);
  if(!world.isRemote && pie && used && before>portions(world.getTileEntity(pos)) && player.isSneaking() && player.getHeldItemMainhand().isEmpty() && player.getHeldItemOffhand().isEmpty()) Teleport.move(player,null);
  return used;
 }
}
