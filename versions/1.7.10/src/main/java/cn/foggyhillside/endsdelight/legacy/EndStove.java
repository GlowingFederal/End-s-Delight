package cn.foggyhillside.endsdelight.legacy;
public final class EndStove extends vectorwing.farmersdelight.legacy.GrillBlock {
 public EndStove() { super(true); }
 @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT) private net.minecraft.util.IIcon top,bottom,side,front,on;
 @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT) public void registerBlockIcons(net.minecraft.client.renderer.texture.IIconRegister r) {top=r.registerIcon("ends_delight:end_stove_top");bottom=r.registerIcon("ends_delight:end_stove_bottom");side=r.registerIcon("ends_delight:end_stove_side");front=r.registerIcon("ends_delight:end_stove_front");on=r.registerIcon("ends_delight:end_stove_front_on");}
 @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT) public net.minecraft.util.IIcon getIcon(int face,int meta) {return face==0?bottom:face==1?top:face==new int[]{2,5,3,4}[meta&3]?((meta&4)!=0?on:front):side;}
}
