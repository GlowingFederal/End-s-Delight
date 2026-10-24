package cn.foggyhillside.endsdelight.legacy;
public final class EndGeneration implements net.minecraftforge.fml.common.IWorldGenerator {
 public void generate(java.util.Random random,int chunkX,int chunkZ,net.minecraft.world.World world,net.minecraft.world.gen.IChunkGenerator generator,net.minecraft.world.chunk.IChunkProvider provider) {
  if(!EndsDelight.generation || world.provider.getDimension()!=1 || random.nextInt(EndsDelight.generationChance)!=0) return;
  long centerX=chunkX*16L+8,centerZ=chunkZ*16L+8;if(centerX*centerX+centerZ*centerZ<1024L*1024L) return;
  for(int i=0;i<20;i++) {net.minecraft.util.math.BlockPos pos=world.getHeight(new net.minecraft.util.math.BlockPos(chunkX*16+random.nextInt(16),0,chunkZ*16+random.nextInt(16)));if(pos.getY()<1 || pos.getY()>=255 || world.getBlockState(pos.down()).getBlock()!=net.minecraft.init.Blocks.END_STONE || !world.isAirBlock(pos)) continue;
   world.setBlockState(pos,EndsDelight.BLOCKS.get("chorus_succulent").getDefaultState().withProperty(Succulent.COUNT,1+random.nextInt(3)),2);
  }
 }
}
