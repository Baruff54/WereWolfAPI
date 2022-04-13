package fr.ph1lou.werewolfapi.events.roles.flute_player;

import fr.ph1lou.werewolfapi.events.roles.SelectionEvent;
import fr.ph1lou.werewolfapi.player.interfaces.IPlayerWW;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class EnchantedEvent extends SelectionEvent {
    private static final HandlerList HANDLERS_LIST = new HandlerList();

    public EnchantedEvent(IPlayerWW playerWW, IPlayerWW playerWW1){
        super(playerWW,playerWW1);
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }
}
