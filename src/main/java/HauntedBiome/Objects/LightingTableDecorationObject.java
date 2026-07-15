package HauntedBiome.Objects;

import java.awt.Color;

import necesse.level.gameObject.TableDecorationObject;

public class LightingTableDecorationObject extends TableDecorationObject
{

    public LightingTableDecorationObject(String textureName, Color mapColor, int decorationWidth, int decorationHeight, int lightLevel, int lightHue) 
    {
        super(textureName, mapColor, decorationWidth, decorationHeight);
        this.lightLevel = lightLevel;
        this.lightHue = lightHue;
    }
    
}
