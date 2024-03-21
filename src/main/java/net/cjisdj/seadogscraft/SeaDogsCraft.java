package net.cjisdj.seadogscraft;

import com.mojang.logging.LogUtils;
import net.cjisdj.seadogscraft.block.ModBlocks;
import net.cjisdj.seadogscraft.effect.ModEffects;
import net.cjisdj.seadogscraft.entity.ModEntities;
import net.cjisdj.seadogscraft.entity.client.*;
import net.cjisdj.seadogscraft.entity.init.SeaDogsCraftModEntities;
import net.cjisdj.seadogscraft.entity.init.SeaDogsCraftModItems;
import net.cjisdj.seadogscraft.entity.init.TradingExampleModMenus;
import net.cjisdj.seadogscraft.item.ModCreativeModTabs;
import net.cjisdj.seadogscraft.item.ModItems;
import net.cjisdj.seadogscraft.loot.ModLootModifiers;
import net.cjisdj.seadogscraft.particle.ModParticles;
import net.cjisdj.seadogscraft.potion.BetterBrewingRecipe;
import net.cjisdj.seadogscraft.potion.ModPotions;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(SeaDogsCraft.MOD_ID)
public class SeaDogsCraft
{
    public static final String MOD_ID = "seadogscraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public SeaDogsCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModTabs.register(modEventBus);

        ModItems.register(modEventBus);

        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        ModPotions.register(modEventBus);

        ModEffects.register(modEventBus);

        ModParticles.register(modEventBus);

        SeaDogsCraftModEntities.REGISTRY.register(modEventBus);
        SeaDogsCraftModItems.REGISTRY.register(modEventBus);



        TradingExampleModMenus.REGISTRY.register(bus);

        GeckoLib.initialize();


        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD, Items.SWEET_BERRIES, ModPotions.WINE_BOTTLE1.get()));

    }

    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MOD_ID, MOD_ID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
    private static int messageID = 0;

    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();
    public static void queueServerWork(int tick, Runnable action) {
        workQueue.add(new AbstractMap.SimpleEntry(action, tick));
    }
    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.RHINO.get(), RhinoRenderer::new);
            EntityRenderers.register(ModEntities.MAGIC_PROJECTILE.get(), MagicProjectileRenderer::new);
            EntityRenderers.register(ModEntities.CANNON_PROJECTILE.get(), CannonProjectileRenderer::new);
            EntityRenderers.register(ModEntities.SNIPER_PROJECTILE.get(), SniperProjectileRenderer::new);
            EntityRenderers.register(ModEntities.COMMON_PROJECTILE.get(), CommonProjectileRenderer::new);
            EntityRenderers.register(ModEntities.FLINTLOCK_PROJECTILE.get(), FlintlockProjectileRenderer::new);
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }

}
