package net.cjisdj.seadogscraft.entity.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.function.Supplier;

@Mod.EventBusSubscriber
public class SetPageTradesProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player);
        }
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (entity.getPersistentData().getDouble("playerTradePage") == 1) {
            if (new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        if (stack != null)
                            return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(0) == 0) {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(1)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem1") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem1") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem1") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            } else {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(2)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem1") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem1") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.CHAINMAIL_CHESTPLATE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem1") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.LAPIS_LAZULI);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount1"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            }
        } else if (entity.getPersistentData().getDouble("playerTradePage") == 2) {
            if (new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        if (stack != null)
                            return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(0) == 0) {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(1)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem2") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GOLD_INGOT);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem2") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.DIAMOND);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem2") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            } else {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(2)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem2") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GOLD_INGOT);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem2") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.DIAMOND);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem2") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.AMETHYST_SHARD);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount2"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            }
        } else if (entity.getPersistentData().getDouble("playerTradePage") == 3) {
            if (new Object() {
                public int getAmount(int sltid) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
                        if (stack != null)
                            return stack.getCount();
                    }
                    return 0;
                }
            }.getAmount(0) == 0) {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(1)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem3") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GUNPOWDER);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem3") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GREEN_DYE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem3") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.WHITE_DYE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(2)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            } else {
                if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                    ((Slot) _slots.get(2)).set(ItemStack.EMPTY);
                    _player.containerMenu.broadcastChanges();
                }
                if (entity.getPersistentData().getDouble("playerTradeItem3") == 1) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GUNPOWDER);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem3") == 2) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.GREEN_DYE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                } else if (entity.getPersistentData().getDouble("playerTradeItem3") == 3) {
                    if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
                        ItemStack _setstack = new ItemStack(Items.WHITE_DYE);
                        _setstack.setCount((int) entity.getPersistentData().getDouble("playerTradeCount3"));
                        ((Slot) _slots.get(1)).set(_setstack);
                        _player.containerMenu.broadcastChanges();
                    }
                }
            }
        }
    }
}
