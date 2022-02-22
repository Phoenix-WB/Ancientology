package io.github.darealturtywurty.ancientology.client.render.renderers;

import io.github.darealturtywurty.ancientology.client.render.models.BunyipModel;
import io.github.darealturtywurty.ancientology.common.entities.Bunyip;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BunyipRenderer extends GeoEntityRenderer<Bunyip> {
    public BunyipRenderer(Context renderManager) {
        super(renderManager, new BunyipModel());
        this.shadowRadius = 0.65f;
    }
}
