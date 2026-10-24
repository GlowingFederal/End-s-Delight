package cn.foggyhillside.endsdelight.legacy;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
public final class Succulent extends net.minecraft.block.BlockBush implements net.minecraft.block.IGrowable {
 public static final net.minecraft.block.properties.PropertyInteger COUNT=net.minecraft.block.properties.PropertyInteger.create("succulent",1,3);
 public Succulent() { setHardness(0);setDefaultState(blockState.getBaseState().withProperty(COUNT,1)); }
 protected net.minecraft.block.state.BlockStateContainer createBlockState() { return new net.minecraft.block.state.BlockStateContainer(this,COUNT); }
 public IBlockState getStateFromMeta(int meta) { return getDefaultState().withProperty(COUNT,1+Math.min(2,meta)); }
 public int getMetaFromState(IBlockState state) { return state.getValue(COUNT)-1; }
 protected boolean canSustainBush(IBlockState state) { return state.getMaterial().isSolid(); }
 public boolean canBlockStay(World world,BlockPos pos,IBlockState state) { return world.getBlockState(pos.down()).getMaterial().isSolid(); }
 public int getLightValue(IBlockState state,IBlockAccess world,BlockPos pos) { return 1+2*state.getValue(COUNT); }
 public net.minecraft.util.BlockRenderLayer getRenderLayer() { return net.minecraft.util.BlockRenderLayer.CUTOUT; }
 public net.minecraft.util.math.AxisAlignedBB getBoundingBox(IBlockState state,IBlockAccess world,BlockPos pos) { int count=state.getValue(COUNT);double inset=count==1?6D/16:count==2?3D/16:2D/16;return new net.minecraft.util.math.AxisAlignedBB(inset,0,inset,1-inset,6D/16,1-inset); }
 public void getDrops(net.minecraft.util.NonNullList<net.minecraft.item.ItemStack> drops,IBlockAccess world,BlockPos pos,IBlockState state,int fortune) { drops.add(new net.minecraft.item.ItemStack(EndsDelight.ITEMS.get("chorus_succulent"),state.getValue(COUNT))); }
 public boolean canGrow(World world,BlockPos pos,IBlockState state,boolean client) { return true; }
 public boolean canUseBonemeal(World world,java.util.Random random,BlockPos pos,IBlockState state) { return true; }
 public void grow(World world,java.util.Random random,BlockPos pos,IBlockState state) { if(!world.isRemote && world.getBlockState(pos.down()).getBlock()==net.minecraft.init.Blocks.END_STONE) world.setBlockState(pos,state.withProperty(COUNT,3),3); }
 public net.minecraft.item.ItemStack getItem(net.minecraft.world.World world,net.minecraft.util.math.BlockPos pos,net.minecraft.block.state.IBlockState state) { return new net.minecraft.item.ItemStack(EndsDelight.ITEMS.get("chorus_succulent")); }
}
