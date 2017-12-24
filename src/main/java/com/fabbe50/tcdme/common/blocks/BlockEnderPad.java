package com.fabbe50.tcdme.common.blocks;

import com.fabbe50.tcdme.Reference;
import com.fabbe50.tcdme.common.data.EnderPadStorage;
import com.fabbe50.tcdme.common.tileentities.TEEnderPad;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by fabbe on 24/12/2017 - 2:07 PM.
 */
public class BlockEnderPad extends Block implements ITileEntityProvider {
    public BlockEnderPad(String name) {
        super(Material.ANVIL);
        setName(name);
    }

    private void setName(String name) {
        this.setRegistryName(Reference.MODID, name);
        this.setUnlocalizedName(this.getRegistryName().toString());
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        EnderPadStorage.enderPads.add((TEEnderPad)worldIn.getTileEntity(pos));
    }

    @Override
    public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
        EnderPadStorage.enderPads.add((TEEnderPad)world.getTileEntity(pos));
    }

    @Override
    public void onBlockDestroyedByPlayer(World worldIn, BlockPos pos, IBlockState state) {
        EnderPadStorage.enderPads.add((TEEnderPad)worldIn.getTileEntity(pos));
    }

    @Override
    public void onBlockDestroyedByExplosion(World worldIn, BlockPos pos, Explosion explosionIn) {
        EnderPadStorage.enderPads.add((TEEnderPad)worldIn.getTileEntity(pos));
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (playerIn.getHeldItem(hand).getItem() == Items.STICK) {
            EnderPadStorage.enderPads.clear();
            worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
        return true;
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        if (stack.hasTagCompound()) {
            TileEntity enderPad = new TEEnderPad();
            if (stack.hasTagCompound()) {
                NBTTagCompound tag = new NBTTagCompound();
                tag.setString("owner", ((EntityPlayer)placer).getDisplayNameString());

                if (stack.hasDisplayName()) {
                    tag.setString("name", stack.getDisplayName());
                }
                enderPad.readFromNBT(tag);
                enderPad.validate();
                worldIn.setTileEntity(pos, enderPad);
            }
        }

        if (!worldIn.isRemote)
            EnderPadStorage.enderPads.add((TEEnderPad)worldIn.getTileEntity(pos));
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TEEnderPad();
    }
}
