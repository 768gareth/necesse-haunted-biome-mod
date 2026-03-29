package HauntedBiome.Objects;

import java.awt.Color;

import necesse.level.gameObject.TableDecorationObject;

public class VoidFragmentSampleObject extends TableDecorationObject
{
    public VoidFragmentSampleObject() 
    {
        super("void_fragment_sample", new Color(221, 221, 221), 11, 14, 0, 4);
        this.lightLevel = 40;
        this.lightHue = 255;
    }
}
