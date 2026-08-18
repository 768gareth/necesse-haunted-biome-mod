package HauntedBiome.Objects;

import java.awt.Color;

import necesse.inventory.item.Item;
import necesse.level.gameObject.HappinessObject;
import necesse.level.gameObject.container.DisplayStandObject;

public class VoidAltarObject extends DisplayStandObject implements HappinessObject
{
    public VoidAltarObject(String[] category) 
    {
        super("void_altar_display", new Color(128, 0, 128), 20, category);
        this.rarity = Item.Rarity.EPIC;
    }
}
