package fr.dodalgo.dodvillager.item;

import fr.dodalgo.dodvillager.DodVillager;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VillagerItem {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DodVillager.MODID);

    public static final RegistryObject<Item> Villager_Item = ITEMS.register("villager_item", () -> new Item(new Item.Properties().stacksTo(64)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

