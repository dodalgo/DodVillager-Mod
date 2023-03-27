package fr.dodalgo.dodvillager;

import com.mojang.logging.LogUtils;
import fr.dodalgo.dodvillager.block.ModBlocks;
import fr.dodalgo.dodvillager.item.VillagerItem;
import fr.dodalgo.dodvillager.villager.ModVillagers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(DodVillager.MODID)
public class DodVillager
{

    public static final String MODID = "dodvillager";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DodVillager()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::addCreative);
        ModVillagers.register(modEventBus);

        VillagerItem.register(modEventBus);
        ModBlocks.register(modEventBus);

        LOGGER.info("Mod stated successfuly!");
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
        ModVillagers.registerPOIs();
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == DodCreativeTab.DOD_VILLAGER_TABS){
            event.accept(VillagerItem.Villager_Item);
            event.accept(ModBlocks.DOD_BLOCK);
        }
    }
}
