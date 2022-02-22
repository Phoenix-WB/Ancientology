package io.github.darealturtywurty.ancientology.common.entities;

import io.github.darealturtywurty.ancientology.Ancientology;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Bunyip extends PathfinderMob implements Enemy, IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    public static final Tags.IOptionalNamedTag<Item> BUNYIP_EATS = ItemTags
            .createOptional(new ResourceLocation(Ancientology.MODID, "bunyip_eats"));
    public boolean isContent;

    public Bunyip(EntityType<? extends Bunyip> type, Level level) {
        super(type, level);
    }

    public void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new RandomStrollGoal(this, 0.7f));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
    }

    public SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.POLAR_BEAR_HURT;
    }

    public SoundEvent getDeathSound() {
        return SoundEvents.POLAR_BEAR_DEATH;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<Bunyip>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (this.isInWater())
            event.getController().setAnimation(new AnimationBuilder().addAnimation("swim", true));
        else if (this.getMoveControl().hasWanted())
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
        else
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }
}
