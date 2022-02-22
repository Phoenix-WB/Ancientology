package io.github.darealturtywurty.ancientology.client.render.models;

import io.github.darealturtywurty.ancientology.Ancientology;
import io.github.darealturtywurty.ancientology.common.entities.Bunyip;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BunyipModel extends AnimatedGeoModel<Bunyip> {
    @Override
    public ResourceLocation getAnimationFileLocation(Bunyip animatable) {
        return new ResourceLocation(Ancientology.MODID, "animations/entities/bunyip.animation.json");
    }

    @Override
    public ResourceLocation getModelLocation(Bunyip object) {
        return new ResourceLocation(Ancientology.MODID, "geo/entities/bunyip.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(Bunyip object) {
        return new ResourceLocation(Ancientology.MODID, "textures/entities/bunyip.png");
    }
}
