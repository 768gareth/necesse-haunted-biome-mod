package HauntedBiome.Objects;

import java.awt.Color;

import necesse.level.gameObject.TableDecorationObject;

public class LightingTableDecorationObject extends TableDecorationObject
{

    public LightingTableDecorationObject(String textureName, Color mapColor, int decorationWidth, int decorationHeight, int lightLevel, float lightHue, float lightSat) 
    {
        super(textureName, mapColor, decorationWidth, decorationHeight);
        this.lightLevel = lightLevel;
        this.lightHue = lightHue;
        this.lightSat = 1.0F;
    }
    
}
