package fr.dodalgo.dodvillager.block;

import fr.dodalgo.dodvillager.DodVillager;
import fr.dodalgo.dodvillager.item.VillagerItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

//4.46

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DodVillager.MODID);

    public static final RegistryObject<Block> DOD_BLOCK = registryBlock("dod_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.AMETHYST)), CreativeModeTabs.BUILDING_BLOCKS);

    private  static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private  static <T extends  Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                                CreativeModeTab tab) {
        return VillagerItem.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(64)));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}

// probleme creative tab donc a voire le tuto pour passer en 1.19.3 donc c'est ep10