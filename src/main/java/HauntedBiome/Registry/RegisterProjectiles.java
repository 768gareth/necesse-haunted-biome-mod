package HauntedBiome.Registry;

import HauntedBiome.Projectiles.CursedFireProjectile;
import HauntedBiome.Projectiles.NightmareBowProjectile;
import necesse.engine.registries.ProjectileRegistry;

public class RegisterProjectiles
{
    public static void Register()
    {
        ProjectileRegistry.registerProjectile("cursed_fire_projectile", (Class)CursedFireProjectile.class, null, null);
        ProjectileRegistry.registerProjectile("nightmare_bow_projectile", (Class)NightmareBowProjectile.class, "nightpiercerarrow", "nightpiercerarrow_shadow");
    }
}
