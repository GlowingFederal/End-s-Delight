package cn.foggyhillside.endsdelight.legacy;
public final class Succulent extends net.minecraft.block.BlockBush implements net.minecraft.block.IGrowable {
 public Succulent() { setHardness(0);setLightLevel(3F/15); }
 public int getRenderType() { return vectorwing.farmersdelight.legacy.Foundation.proxy.modelRenderId(); }
 protected boolean canPlaceBlockOn(net.minecraft.block.Block block) { return block.getMaterial().isSolid(); }
 public boolean canBlockStay(net.minecraft.world.World world,int x,int y,int z) { return world.getBlock(x,y-1,z).getMaterial().isSolid(); }
 public int getLightValue(net.minecraft.world.IBlockAccess world,int x,int y,int z) { return 3+2*Math.min(2,world.getBlockMetadata(x,y,z)); }
 public void setBlockBoundsBasedOnState(net.minecraft.world.IBlockAccess world,int x,int y,int z) { int count=Math.min(2,world.getBlockMetadata(x,y,z));float inset=count==0?6F/16:count==1?3F/16:2F/16;setBlockBounds(inset,0,inset,1-inset,6F/16,1-inset); }
 public java.util.ArrayList<net.minecraft.item.ItemStack> getDrops(net.minecraft.world.World world,int x,int y,int z,int meta,int fortune) { java.util.ArrayList<net.minecraft.item.ItemStack> result=new java.util.ArrayList<net.minecraft.item.ItemStack>();result.add(new net.minecraft.item.ItemStack(EndsDelight.ITEMS.get("chorus_succulent"),1+Math.min(2,meta)));return result; }
 public boolean func_149851_a(net.minecraft.world.World world,int x,int y,int z,boolean client) { return true; }
 public boolean func_149852_a(net.minecraft.world.World world,java.util.Random random,int x,int y,int z) { return true; }
 public void func_149853_b(net.minecraft.world.World world,java.util.Random random,int x,int y,int z) { if(!world.isRemote && world.getBlock(x,y-1,z)==net.minecraft.init.Blocks.end_stone) world.setBlockMetadataWithNotify(x,y,z,2,3); }
 @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT) public void registerBlockIcons(net.minecraft.client.renderer.texture.IIconRegister r) {blockIcon=r.registerIcon("ends_delight:chorus_succulent");}
 public net.minecraft.item.Item getItem(net.minecraft.world.World world,int x,int y,int z) { return EndsDelight.ITEMS.get("chorus_succulent"); }
}
