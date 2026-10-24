package cn.foggyhillside.endsdelight.legacy;
public final class ClientProxy extends CommonProxy {
 public void preInit() {
  vectorwing.farmersdelight.legacy.CommonProxy core=vectorwing.farmersdelight.legacy.Foundation.proxy;
  core.registerModels(EndsDelight.BLOCKS.get("chorus_fruit_pie"),"ends_delight",new String[]{"chorus_fruit_pie_slice3","chorus_fruit_pie_slice3","chorus_fruit_pie_slice2","chorus_fruit_pie_slice1","chorus_fruit_pie"});
  core.registerModels(EndsDelight.BLOCKS.get("steamed_dragon_egg_block"),"ends_delight",new String[]{"steamed_dragon_egg_leftover","steamed_dragon_egg_stage4","steamed_dragon_egg_stage3","steamed_dragon_egg_stage2","steamed_dragon_egg_stage1"});
  core.registerModels(EndsDelight.BLOCKS.get("dragon_meat_stew_block"),"ends_delight",new String[]{"steamed_dragon_egg_leftover","dragon_meat_stew_stage4","dragon_meat_stew_stage3","dragon_meat_stew_stage2","dragon_meat_stew_stage1"});
  core.registerModels(EndsDelight.BLOCKS.get("grilled_shulker_block"),"ends_delight",new String[]{"grilled_shulker_block_leftover","grilled_shulker_block_stage4","grilled_shulker_block_stage3","grilled_shulker_block_stage2","grilled_shulker_block_stage1"});
  int[] stages=new int[16];for(int i=0;i<16;i++) stages[i]=Math.min(2,i);
  core.registerMetadataModels(EndsDelight.BLOCKS.get("chorus_succulent"),"ends_delight",new String[]{"chorus_succulent","chorus_succulent_2","chorus_succulent_3"},stages);
 }
}
