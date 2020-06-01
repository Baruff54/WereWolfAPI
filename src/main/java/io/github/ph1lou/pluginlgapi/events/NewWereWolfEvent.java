package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class NewWereWolfEvent extends Event {

    private final UUID uuid;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public NewWereWolfEvent(UUID uuid){
        this.uuid=uuid;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getUuid() {
        return uuid;
    }
}