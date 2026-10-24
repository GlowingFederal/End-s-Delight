package cn.foggyhillside.endsdelight.legacy;

/** One bounded population pass, only on UAB outer End terrain. */
public final class EndGeneration implements cpw.mods.fml.common.IWorldGenerator {
 public void generate(java.util.Random random,int chunkX,int chunkZ,net.minecraft.world.World world,net.minecraft.world.chunk.IChunkProvider generator,net.minecraft.world.chunk.IChunkProvider provider) {
  if(!EndsDelight.generation || !vectorwing.farmersdelight.legacy.UABCompatibility.outerEnd() || world.provider.dimensionId!=1
    || !world.provider.getClass().getName().equals("ganymedes01.etfuturum.world.end.dimension.WorldProviderEFREnd")) return;
  long centerX=chunkX*16L+8,centerZ=chunkZ*16L+8;
  if(centerX*centerX+centerZ*centerZ<1024L*1024L || random.nextInt(EndsDelight.generationChance)!=0) return;
  // Shifted native population window; never load neighboring chunks ourselves.
  int baseX=chunkX*16+8,baseZ=chunkZ*16+8;
  for(int i=0;i<20;i++) {
   int x=baseX+random.nextInt(16),z=baseZ+random.nextInt(16);
   if(!world.blockExists(x,0,z)) continue;
   int y=world.getHeightValue(x,z);
   if(y<1 || y>=255 || world.getBlock(x,y-1,z)!=net.minecraft.init.Blocks.end_stone || !world.isAirBlock(x,y,z)) continue;
   world.setBlock(x,y,z,EndsDelight.BLOCKS.get("chorus_succulent"),random.nextInt(3),2);
  }
 }
}
