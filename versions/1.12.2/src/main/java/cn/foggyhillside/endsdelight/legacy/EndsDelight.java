package cn.foggyhillside.endsdelight.legacy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import vectorwing.farmersdelight.legacy.Content;
import vectorwing.farmersdelight.legacy.api.FoodDefinition;
import com.google.gson.*;
@Mod(modid="ends_delight",name="End's Delight Legacy",version=BuildVersion.VERSION,acceptedMinecraftVersions="[1.12.2]",dependencies="required-after:farmersdelight@[1.0.2,)")
public final class EndsDelight {
 public static final java.util.Map<String,Item> ITEMS=new java.util.LinkedHashMap<String,Item>();
 public static final java.util.Map<String,Block> BLOCKS=new java.util.LinkedHashMap<String,Block>();
 public static boolean generation,mobDrops;public static int generationChance;
 @SidedProxy(clientSide="cn.foggyhillside.endsdelight.legacy.ClientProxy",serverSide="cn.foggyhillside.endsdelight.legacy.CommonProxy") public static CommonProxy proxy;
 @Mod.EventHandler public void preInit(FMLPreInitializationEvent event) {
  net.minecraftforge.common.config.Configuration config=new net.minecraftforge.common.config.Configuration(event.getSuggestedConfigurationFile());config.load();
  generation=config.getBoolean("chorusSucculentGeneration","general",true,"Generate succulent patches on native outer End islands (1.12.2).");
  generationChance=config.getInt("generationChance","general",8,1,Integer.MAX_VALUE,"One patch attempt per this many outer End chunks.");
  mobDrops=config.getBoolean("knifeMobDrops","general",true,"Enable the original knife-qualified End mob drops.");if(config.hasChanged()) config.save();
  Gson gson=new Gson();JsonObject[] entries;
  try(java.io.InputStreamReader reader=new java.io.InputStreamReader(EndsDelight.class.getResourceAsStream("/ends_delight/content.json"),java.nio.charset.StandardCharsets.UTF_8)) { entries=gson.fromJson(reader,JsonObject[].class); }
  catch(java.io.IOException e) { throw new IllegalStateException("Cannot load End content contract",e); }
  for(JsonObject entry:entries) if(entry.get("kind").getAsString().equals("plain")) add(entry.get("id").getAsString(),new Item());
  for(JsonObject entry:entries) {
   String kind=entry.get("kind").getAsString(),id=entry.get("id").getAsString();
   if(kind.equals("food") || kind.equals("plant")) add(id,new EndFood(gson.fromJson(entry,FoodDefinition.class),entry));
   else if(kind.equals("knife")) add(id,new EndKnife(id));
  }
  block("chorus_fruit_crate",new EndCrate(),true);block("end_stove",new EndStove(),true);
  block("chorus_succulent",new Succulent(),false);
  block("chorus_fruit_pie",new EndFeast("chorus_fruit_pie",true,"chorus_fruit_pie_slice"),true);
  block("steamed_dragon_egg_block",new EndFeast("steamed_dragon_egg_block",false,"steamed_dragon_egg"),true);
  block("dragon_meat_stew_block",new EndFeast("dragon_meat_stew_block",false,"dragon_meat_stew"),true);
  block("grilled_shulker_block",new EndFeast("grilled_shulker_block",false,"grilled_shulker"),true);
  for(String id:new String[]{"steamed_dragon_egg_block","dragon_meat_stew_block","grilled_shulker_block"}) ITEMS.get(id).setMaxStackSize(1);
  for(String id:new String[]{"dragon_egg_shell_knife","purpur_knife","end_stone_knife","dragon_tooth_knife"}) net.minecraftforge.oredict.OreDictionary.registerOre("toolKnife",new net.minecraft.item.ItemStack(ITEMS.get(id)));
  net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(new Acquisition());GameRegistry.registerWorldGenerator(new EndGeneration(),0);proxy.preInit();
 }
 @Mod.EventHandler public void init(FMLInitializationEvent event) {
  vectorwing.farmersdelight.legacy.api.SourceRecipes.addCatalog("ends_delight",EndsDelight.class,"/ends_delight/source_recipes.json");
  vectorwing.farmersdelight.legacy.SourceTags.addCatalog(EndsDelight.class,"/ends_delight/source_tags.json");
  java.util.List<String> roots=new java.util.ArrayList<String>();
  if(mobDrops) roots.addAll(java.util.Arrays.asList("ends_delight:dragon_tooth","ends_delight:dragon_leg","ends_delight:raw_dragon_meat"));if(mobDrops) roots.addAll(java.util.Arrays.asList("ends_delight:shulker_meat","ends_delight:raw_ender_mite_meat"));if(generation) roots.add("ends_delight:chorus_succulent");
  vectorwing.farmersdelight.legacy.AddonRecipes.register("ends_delight",roots.toArray(new String[roots.size()]));
 }
 private static void add(String id,Item item) { item.setTranslationKey("ends_delight."+id).setCreativeTab(Content.TAB).setRegistryName("ends_delight",id);GameRegistry.findRegistry(Item.class).register(item);ITEMS.put(id,item); }
 private static void block(String id,Block block,boolean item) { block.setTranslationKey("ends_delight."+id).setCreativeTab(Content.TAB).setRegistryName("ends_delight",id);GameRegistry.findRegistry(Block.class).register(block);if(item) add(id,new ItemBlock(block)); BLOCKS.put(id,block); }
}
