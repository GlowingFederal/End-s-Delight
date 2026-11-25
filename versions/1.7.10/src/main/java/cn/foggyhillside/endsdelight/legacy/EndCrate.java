package cn.foggyhillside.endsdelight.legacy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public final class EndCrate extends Block {
    private IIcon top;
    private IIcon bottom;

    public EndCrate() {
        super(Material.wood);
        setHardness(2F);
        setStepSound(soundTypeWood);
        setBlockTextureName("ends_delight:chorus_fruit_crate_side");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        super.registerBlockIcons(register);
        top = register.registerIcon("ends_delight:chorus_fruit_crate_top");
        bottom = register.registerIcon("farmersdelight:crate_bottom");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int face, int meta) {
        if (face == 0) return bottom;
        if (face == 1) return top;
        return blockIcon;
    }
}
