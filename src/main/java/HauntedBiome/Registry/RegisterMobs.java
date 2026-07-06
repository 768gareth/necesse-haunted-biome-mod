package HauntedBiome.Registry;

import HauntedBiome.Mobs.VoidCavelingMob;
import HauntedBiome.Mobs.VoidGatewayMob;
import HauntedBiome.Mobs.ZombieMageMob;
import HauntedBiome.Mobs.ZombieWarriorMob;
import necesse.engine.registries.MobRegistry;

public class RegisterMobs 
{
    // TODO: Could have actual demons/void entities in the Deep Caves? e.g Void Devourer is a big worm thing.
    public static void Register()
    {
        // Neutral
        MobRegistry.registerMob("void_caveling", VoidCavelingMob.class, true);
        // Lost Soul (surface mob, a kind of 'wandering' ghost that dies in bright light?)

        // Surface
        // Skeleton (same name as the other one, doesn't drop bones)

        // Caves
        // Void Cultist (attacks using ranged magic), also spawns in certain surface presets.
        // Void Scholar (rarer ranged enemy with more powerful magic, serves a mini-mini-boss that drops some nice loot)
        MobRegistry.registerMob("zombie_warrior", ZombieWarriorMob.class, true);
        MobRegistry.registerMob("zombie_mage", ZombieMageMob.class, true);

        // Deep Caves
        // Void Devourer (worm enemy)
        // Void Ascendant (attacks using ranged magic, summons weak skeletons)
        // Void Revenant (slow moving brute melee enemy)

        // Boss/misc
        MobRegistry.registerMob("void_gateway_boss", VoidGatewayMob.class, true);
    }
}
