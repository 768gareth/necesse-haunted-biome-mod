package HauntedBiome.Registry;

import HauntedBiome.Projectiles.CursedFireProjectile;
import necesse.engine.registries.ProjectileRegistry;

public class RegisterProjectiles
{
    public static void Register()
    {
        ProjectileRegistry.registerProjectile("cursed_fire_projectile", CursedFireProjectile.class, null, null);
    }
}
