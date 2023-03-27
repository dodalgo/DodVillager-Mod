package fr.dodalgo.dodvillager;

import com.google.common.eventbus.Subscribe;
import fr.dodalgo.dodvillager.item.VillagerItem;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;

@Mod.EventBusSubscriber(modid = DodVillager.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DodCreativeTab {
    public static CreativeModeTab DOD_VILLAGER_TABS;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        DOD_VILLAGER_TABS = event.registerCreativeModeTab(new ResourceLocation(DodVillager.MODID, "dodtabs"), builder -> builder.icon(() -> new ItemStack(VillagerItem.Villager_Item.get())).title(Component.literal("DOD TAB")));
    }
}
