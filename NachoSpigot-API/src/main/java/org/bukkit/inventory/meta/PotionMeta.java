package org.bukkit.inventory.meta;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

/**
 * Represents a potion ({@link Material#POTION}) that can have custom effects.
 */
public interface PotionMeta extends ItemMeta {

    /**
     * Checks for the presence of custom potion effects.
     *
     * @return true if custom potion effects are applied
     */
    boolean hasCustomEffects();

    /**
     * Gets an immutable list containing all custom potion effects applied to
     * this potion.
     * <p>
     * Plugins should check that hasCustomEffects() returns true before
     * calling this method.
     *
     * @return the immutable list of custom potion effects
     */
    List<PotionEffect> getCustomEffects();

    /**
     * Adds a custom potion effect to this potion.
     *
     * @param effect the potion effect to add
     * @param overwrite true if any existing effect of the same type should be
     *     overwritten
     * @return true if the potion meta changed as a result of this call
     */
    boolean addCustomEffect(PotionEffect effect, boolean overwrite);

    /**
     * Removes a custom potion effect from this potion.
     *
     * @param type the potion effect type to remove
     * @return true if the potion meta changed as a result of this call
     */
    boolean removeCustomEffect(PotionEffectType type);

    /**
     * Checks for a specific custom potion effect type on this potion.
     * 
     * @param type the potion effect type to check for
     * @return true if the potion has this effect
     */
    boolean hasCustomEffect(PotionEffectType type);

    /**
     * Moves a potion effect to the top of the potion effect list.
     * <p>
     * This causes the client to display the potion effect in the potion's
     * name.
     *
     * @param type the potion effect type to move
     * @return true if the potion meta changed as a result of this call
     */
    boolean setMainEffect(PotionEffectType type);

    /**
     * Removes all custom potion effects from this potion.
     *
     * @return true if the potion meta changed as a result of this call
     */
    boolean clearCustomEffects();

    /**
     * Checks for existence of a potion color.
     *
     * @return true if this has a custom potion color
     */
    boolean hasColor();

    /**
     * Gets the potion color that is set. A custom potion color will alter the
     * display of the potion in an inventory slot.
     * <p>
     * Plugins should check that hasColor() returns <code>true</code> before
     * calling this method.
     *
     * @return the potion color that is set
     */
    Color getColor();

    /**
     * Sets the potion color. A custom potion color will alter the display of
     * the potion in an inventory slot.
     *
     * @param color the color to set
     */
    void setColor(Color color);

    PotionMeta clone();
}
