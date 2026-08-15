package HauntedBiome.Utils;

import HauntedBiome.Tiles.VoidRiftTile;
import necesse.engine.modLoader.annotations.ModMethodPatch;
import necesse.level.gameObject.GameObject;
import necesse.level.maps.Level;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.asm.Advice.OnMethodExit;

@ModMethodPatch(target = GameObject.class, name = "canPlace", arguments = {Level.class, int.class, int.class, int.class, int.class, boolean.class, boolean.class})
public class GameObjectPatch 
{
  @OnMethodExit
  static void onExit(@Advice.Return(readOnly = false) String thisReturn, @Advice.Argument(0) Level thisLevel, @Advice.Argument(2) int x, @Advice.Argument(3) int y) 
  {
    if (thisLevel.getTile(x, y) instanceof VoidRiftTile) 
    {
        thisReturn = "void_rift_tile";
    }
  }
    
}
