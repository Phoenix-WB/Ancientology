package io.github.darealturtywurty.ancientology.core.init;

import io.github.darealturtywurty.ancientology.Ancientology;
import io.github.darealturtywurty.ancientology.common.entities.Bunyip;
import io.github.darealturtywurty.ancientology.core.util.registry.entity.EntityDeferredRegister;
import io.github.darealturtywurty.ancientology.core.util.registry.entity.EntityRegistryObject;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.TagEntry;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public final class EntityInit {

    public static final EntityDeferredRegister ENTITIES = EntityDeferredRegister.create(Ancientology.MODID,
            ItemInit.ITEMS);

    /*
     * public static final EntityRegistryObject<Chicken> TEST_CHICKEN =
     * ENTITIES.register("test", Chicken::new) .modifyAttributes(b ->
     * b.add(Attributes.ARMOR, 120)) .spawnEgg(i ->
     * i.lang("Chicken spawn egg").shapelessRecipe(1, r -> r.requires(Items.WHEAT,
     * 2))) .category(MobCategory.MONST
     * .withLootTable(LootTable.lootTable().withPool(LootPool.lootPool().setRolls(
     * ConstantValue.exactly(1.0F)) .add(LootItem.lootTableItem(Items.FEATHER)
     * .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
     * .apply(LootingEnchantFunction.lootingMultiplier(UniformGenerator.between(0.
     * 0F, 1.0F)))))) .modifyBuilder(b ->
     * b.fireImmune().setShouldReceiveVelocityUpdates(true)).build();
     */

    public static final EntityRegistryObject<Bunyip> BUNYIP = ENTITIES.register("bunyip", Bunyip::new)
            .modifyAttributes(builder -> builder.add(Attributes.MAX_HEALTH, 32.5D).add(Attributes.MOVEMENT_SPEED, 0.6f)
                    .add(Attributes.ATTACK_KNOCKBACK, 0.4f).add(Attributes.ATTACK_DAMAGE, 3.5D)
                    .add(Attributes.FOLLOW_RANGE, 2))
            .spawnEgg(egg -> egg.backgroundColor(0x592f0f).highlightColor(0x1c6327).lang("Bunyip Spawn Egg"))
            .category(MobCategory.MONSTER)
            .withLootTable(LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(2.0f))
                            .add(TagEntry.tagContents(Bunyip.BUNYIP_EATS)
                                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0f, 1.0f))))))
            .modifyBuilder(builder -> builder.canSpawnFarFromPlayer().setShouldReceiveVelocityUpdates(true)).build();

    private EntityInit() {
        throw new IllegalAccessError("Illegal access to hidden initialization class!");
    }
}
