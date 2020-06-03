package io.github.ph1lou.pluginlgapi.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.UUID;

public class CitizenCancelVoteEvent extends Event {

    private final UUID playerUUID;
    private final UUID voteUUID;
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public CitizenCancelVoteEvent(UUID voterUUID, UUID voteUUID){
        this.playerUUID =voterUUID;
        this.voteUUID =voteUUID;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public UUID getVoteUUID() {
        return voteUUID;
    }
}
