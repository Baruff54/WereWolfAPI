package fr.ph1lou.werewolfapi.registers.impl;

import fr.minuskube.inv.SmartInventory;
import fr.ph1lou.werewolfapi.enums.Sound;
import fr.ph1lou.werewolfapi.registers.interfaces.IRegister;
import fr.ph1lou.werewolfapi.enums.UniversalMaterial;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.BiConsumer;

/**
 * @author Ph1Lou
 */
@SuppressWarnings("unused")

public class AddonRegister implements IRegister {

    private final String key;

    private List<String> loreKey =new ArrayList<>();

    private ItemStack item= UniversalMaterial.CARROT.getStack();

    private final String defaultLanguage;

    private final Plugin plugin;

    private final Map<String,UUID> authors = new HashMap<>();

    private BiConsumer<Player, SmartInventory> action=(player, previous) -> Sound.CAT_MEOW.play(player);


    public AddonRegister(String key, String defaultLanguage, Plugin plugin) {
        this.key=key;
        this.defaultLanguage=defaultLanguage;
        this.plugin=plugin;
    }


    /**
     * Ajouter une action quand l'utilisateur clique sur l'item de l'addon dans le gui
     * @param action l'action à effectuer
     * @return instance de l'objet
     */
    public AddonRegister setAction(BiConsumer<Player, SmartInventory> action){
        this.action=action;
        return this;
    }


    public Plugin getPlugin() {
        return this.plugin;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String getAddonKey() {
        return key;
    }

    /**
     * Ajoute un auteur dans les crédits de l'addon
     * @param name de l'auteur
     * @param uuid de l'auteur
     * @return l'instance de l'objet
     */
    public AddonRegister addAuthors(String name,UUID uuid) {
        this.authors.put(name,uuid);
        return this;
    }

    public String getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public Set<? extends String> getAuthors() {
        return this.authors.keySet();
    }

    public Optional<UUID> getAuthorsUUID(String name) {
        if(this.authors.containsKey(name)){
            return Optional.empty();
        }
        return Optional.of(this.authors.get(name));
    }

    public ItemStack getItem() {
        return this.item;
    }

    public BiConsumer<Player, SmartInventory> getAction() {
        return this.action;
    }


    /**
     * Ajoute du texte dans le lore de l'objet de l'item du GUI
     * @param loreKeys des clefs du texte souhaitée
     * @return l'instance de l'objet
     */
    public AddonRegister setLoreKey(List<String> loreKeys){
        this.loreKey = loreKeys;
        return this;
    }

    /**
     * Ajoute du texte dans le lore de l'objet de l'item du GUI
     * @param lore la clef du texte souhaitée
     * @return l'instance de l'objet
     */
    public AddonRegister addLoreKey(String lore){
        this.loreKey.add(lore);
        return this;
    }

    public List<? extends String> getLoreKey() {
        return this.loreKey;
    }


    /**
     * Change l'item de l'addon dans le gui
     * @param item de l'addon
     * @return l'instance de l'objet
     */
    public AddonRegister setItem(ItemStack item) {
        this.item = item;
        return this;
    }



}
