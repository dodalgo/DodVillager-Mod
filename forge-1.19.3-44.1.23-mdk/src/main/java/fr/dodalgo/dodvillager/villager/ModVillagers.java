package fr.dodalgo.dodvillager.villager;

import com.google.common.collect.ImmutableSet;
import fr.dodalgo.dodvillager.DodVillager;
import fr.dodalgo.dodvillager.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, DodVillager.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, DodVillager.MODID);

        public static final RegistryObject<PoiType> DOD_BLOCK = POI_TYPES.register("dod_block",
                () -> new PoiType(ImmutableSet.copyOf(ModBlocks.DOD_BLOCK.get().getStateDefinition().getPossibleStates()),
                        1, 1));

        public static final RegistryObject<VillagerProfession> TRAPPER = VILLAGER_PROFESSIONS.register("trapper",
                () -> new VillagerProfession("trapper", x -> x.get() == DOD_BLOCK.get(),
                        x -> x.get() == DOD_BLOCK.get(), ImmutableSet.of(), ImmutableSet.of(),
                        SoundEvents.VILLAGER_WORK_SHEPHERD));

    public static void registerPOIs() {
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                   "registerBlockStates", PoiType.class).invoke(null, DOD_BLOCK.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public  static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
