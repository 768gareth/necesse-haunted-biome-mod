package HauntedBiome.Mobs.Caves;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

import necesse.engine.gameLoop.tickManager.TickManager;
import necesse.engine.network.PacketReader;
import necesse.engine.network.PacketWriter;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;
import necesse.engine.util.GameRandom;
import necesse.entity.mobs.DeathMessageTable;
import necesse.entity.mobs.MaskShaderOptions;
import necesse.entity.mobs.Mob;
import necesse.entity.mobs.MobDrawable;
import necesse.entity.mobs.PathDoorOption;
import necesse.entity.mobs.PlayerMob;
import necesse.entity.mobs.ai.behaviourTree.AINode;
import necesse.entity.mobs.ai.behaviourTree.BehaviourTreeAI;
import necesse.entity.mobs.ai.behaviourTree.trees.ConfusedItemAttackerPlayerChaserWandererAI;
import necesse.entity.mobs.buffs.BuffModifiers;
import necesse.entity.mobs.hostile.HostileItemAttackerMob;
import necesse.entity.mobs.itemAttacker.CheckSlotType;
import necesse.entity.mobs.itemAttacker.ItemAttackSlot;
import necesse.entity.particle.FleshParticle;
import necesse.entity.particle.Particle;
import necesse.gfx.GameSkin;
import necesse.gfx.HumanLook;
import necesse.gfx.camera.GameCamera;
import necesse.gfx.drawOptions.DrawOptions;
import necesse.gfx.drawOptions.human.HumanDrawOptions;
import necesse.gfx.drawables.OrderableDrawables;
import necesse.inventory.InventoryItem;
import necesse.inventory.item.Item;
import necesse.inventory.item.armorItem.cosmetics.misc.ShirtArmorItem;
import necesse.inventory.item.armorItem.cosmetics.misc.ShoesArmorItem;
import necesse.level.maps.Level;
import necesse.level.maps.light.GameLight;

public class VoidWarrior extends HostileItemAttackerMob {
    public int lookSeed;

    public HumanLook look = new HumanLook();

    public InventoryItem helmet;

    public InventoryItem chest;

    public InventoryItem boots;

    public VoidWarrior() {
        super(150);
        setSpeed(25.0F);
        setFriction(3.0F);
        setArmor(10);
        getLookSeed();
        this.collision = new Rectangle(-10, -7, 20, 14);
        this.hitBox = new Rectangle(-14, -12, 28, 24);
        this.selectBox = new Rectangle(-14, -41, 28, 48);
        this.swimMaskMove = 16;
        this.swimMaskOffset = -2;
        this.swimSinkOffset = -4;
    }

    public void init() {
        super.init();
        updateLook();
        this.ai = new BehaviourTreeAI((Mob) this,
                (AINode) new ConfusedItemAttackerPlayerChaserWandererAI(null, 512, getWeapon(), 40000));
        this.helmet = null;
        this.chest = new InventoryItem("demonicchestplate");
        this.boots = new InventoryItem("demonicboots");
    }
    
    public static InventoryItem getWeapon() {
    InventoryItem inventoryItem = new InventoryItem("demonicsword");
    inventoryItem.getGndData().setFloat("damage", 25.0F);
    inventoryItem.getGndData().setFloat("knockback", 25.0F);
    return inventoryItem;
  }

    public PathDoorOption getPathDoorOption() {
        if (getLevel() != null) {
            if (((Boolean) this.buffManager.getModifier(BuffModifiers.CAN_BREAK_OBJECTS)).booleanValue())
                return (getLevel()).regionManager.CAN_BREAK_OBJECTS_OPTIONS;
            return (getLevel()).regionManager.CAN_OPEN_DOORS_OPTIONS;
        }
        return null;
    }

    public void addSaveData(SaveData save) {
        super.addSaveData(save);
        save.addInt("lookSeed", this.lookSeed);
    }

    public void applyLoadData(LoadData save) {
        super.applyLoadData(save);
        this.lookSeed = save.getInt("lookSeed", this.lookSeed);
        getLookSeed();
        this.updateLook();
    }

    public void applySpawnPacket(PacketReader reader) {
        super.applySpawnPacket(reader);
        this.lookSeed = reader.getNextInt();
        updateLook();
    }

    public void setupSpawnPacket(PacketWriter writer) {
        super.setupSpawnPacket(writer);
        writer.putNextInt(this.lookSeed);
    }

    public void updateLook() {
        this.look.setSkin(11);
        this.look.setEyeType(2);
        this.look.setEyeColor(16);
        this.look.setHair(0);
    }

    public void getLookSeed() {
        if (this.lookSeed == 0)
            this.lookSeed = GameRandom.globalRandom.nextInt();
    }

    public void spawnDeathParticles(float knockbackX, float knockbackY) {
        GameSkin gameSkin = this.look.getGameSkin(true);
        for (int i = 0; i < 4; i++)
            (getLevel()).entityManager
                    .addParticle(
                            (Particle) new FleshParticle(getLevel(), gameSkin, GameRandom.globalRandom.nextInt(5), 8,
                                    32, this.x, this.y, 10.0F, knockbackX, knockbackY),
                            Particle.GType.IMPORTANT_COSMETIC);
    }

    public void addDrawables(List<MobDrawable> list, OrderableDrawables tileList, OrderableDrawables topList,
            Level level, int x, int y, TickManager tickManager, GameCamera camera, PlayerMob perspective) {
        super.addDrawables(list, tileList, topList, level, x, y, tickManager, camera, perspective);
        GameLight light = level.getLightLevel(getTileCoordinate(x), getTileCoordinate(y));
        int drawX = camera.getDrawX(x) - 22 - 10;
        int drawY = camera.getDrawY(y) - 44 - 7;
        int dir = getDir();
        Point sprite = getAnimSprite(x, y, dir);
        boolean inLiquid = inLiquid(x, y);
        if (inLiquid)
            sprite.x = 0;
        drawY += getBobbing(x, y);
        drawY += level.getTile(getTileCoordinate(x), getTileCoordinate(y)).getMobSinkingAmount((Mob) this);
        MaskShaderOptions swimMask = getSwimMaskShaderOptions(inLiquidFloat(x, y));
        HumanDrawOptions humanOptions = (new HumanDrawOptions(level, this.look, false)).sprite(sprite).mask(swimMask)
                .dir(dir).light(light).applyEnemyTracker((Mob) this, perspective);
        if (inLiquid) {
            humanOptions.armSprite(2);
        }
        if (this.helmet != null)
            humanOptions.helmet(this.helmet);
        if (this.chest != null) {
            humanOptions.chestplate(this.chest);
        } else {
            humanOptions.chestplate(ShirtArmorItem.addColorData(new InventoryItem("shirt"), this.look.getShirtColor()));
        }
        if (this.boots != null) {
            humanOptions.boots(this.boots);
        } else {
            humanOptions.boots(ShoesArmorItem.addColorData(new InventoryItem("shoes"), this.look.getShoesColor()));
        }
        setupAttackDraw(humanOptions);
        final DrawOptions drawOptions = humanOptions.pos(drawX, drawY);
        list.add(new MobDrawable() {
            public void draw(TickManager tickManager) {
                drawOptions.draw();
            }
        });
        addShadowDrawables(tileList, level, x, y, light, camera);
    }

    public DeathMessageTable getDeathMessages() {
        return getDeathMessages("void_cultist", 2);
    }

    public float getAttackingMovementModifier() {
        return 0.0F;
    }

    public ItemAttackSlot getCurrentSelectedAttackSlot() {
        return null;
    }

    public boolean hasValidSummonItem(Item item, CheckSlotType slotType) {
        return true;
    }
}
