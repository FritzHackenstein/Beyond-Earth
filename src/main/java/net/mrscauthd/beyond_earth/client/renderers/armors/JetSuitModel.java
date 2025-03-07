package net.mrscauthd.beyond_earth.client.renderers.armors;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.mrscauthd.beyond_earth.BeyondEarth;
import net.mrscauthd.beyond_earth.client.renderers.types.TranslucentArmorType;
import net.mrscauthd.beyond_earth.common.armors.JetSuit;
import net.mrscauthd.beyond_earth.common.util.Methods;

import java.util.HashMap;

@OnlyIn(Dist.CLIENT)
public class JetSuitModel {

    public static class JET_SUIT_P1<T extends LivingEntity> extends HumanoidModel<T> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BeyondEarth.MODID, "jet_suit_p1"), "main");

        private static final HashMap<String, ResourceLocation> TEXTURES = Maps.newHashMap();

        public LivingEntity entity;
        public ItemStack itemStack;

        public final ModelPart head;
        public final ModelPart body;
        public final ModelPart rightArm;
        public final ModelPart leftArm;
        public final ModelPart rightLeg;
        public final ModelPart leftLeg;

        public JET_SUIT_P1(ModelPart root) {
            super(new EntityRendererProvider.Context(Minecraft.getInstance().getEntityRenderDispatcher(), Minecraft.getInstance().getItemRenderer(), Minecraft.getInstance().getBlockRenderer(), Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer(), Minecraft.getInstance().getResourceManager(), Minecraft.getInstance().getEntityModels(), Minecraft.getInstance().font).bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
            this.head = root.getChild("head");
            this.body = root.getChild("body");
            this.rightArm = root.getChild("right_arm");
            this.leftArm = root.getChild("left_arm");
            this.rightLeg = root.getChild("right_leg");
            this.leftLeg = root.getChild("left_leg");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F))
                    .texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.75F))
                    .texOffs(0, 32).addBox(3.0F, -13.0F, 1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0175F, 0.0873F, 0.0F));

            PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                    .texOffs(28, 28).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F))
                    .texOffs(50, 29).addBox(-3.0F, 5.0F, -2.5F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.25F))
                    .texOffs(0, 55).addBox(-2.5F, 1.0F, 2.75F, 5.0F, 8.0F, 1.0F, new CubeDeformation(0.75F)), PartPose.offset(0.0F, 0.0F, 0.0F));

            PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(32, 31).addBox(-2.0F, -5.0F, 0.75F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.0F, -0.3491F, 0.0F));

            PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(32, 31).addBox(2.0F, -5.0F, 0.75F, 0.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 2.0F, 0.0F, 0.3491F, 0.0F));

            PartDefinition rightArm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(20, 44).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(48, 8).addBox(-3.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

            PartDefinition leftArm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.26F)).texOffs(48, 0).addBox(-1.0F, 6.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(5.0F, 2.0F, 0.0F));

            PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(48, 44).addBox(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F))
                    .texOffs(48, 54).addBox(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.27F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

            PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(48, 44).addBox(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F))
                    .texOffs(48, 54).addBox(-2.0F, 5.7F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.27F)), PartPose.offset(2.0F, 12.0F, 0.0F));

            return LayerDefinition.create(meshdefinition, 64, 64);
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            HumanoidModel livingModel = (HumanoidModel<LivingEntity>) ((LivingEntityRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(entity)).getModel();

            this.attackTime = livingModel.attackTime;
            this.riding = livingModel.riding;
            this.young = livingModel.young;
            this.leftArmPose = livingModel.leftArmPose;
            this.rightArmPose = livingModel.rightArmPose;
            this.crouching = livingModel.crouching;
            this.head.copyFrom(livingModel.head);
            this.body.copyFrom(livingModel.body);
            this.rightArm.copyFrom(livingModel.rightArm);
            this.leftArm.copyFrom(livingModel.leftArm);
            this.rightLeg.copyFrom(livingModel.rightLeg);
            this.leftLeg.copyFrom(livingModel.leftLeg);

            poseStack.pushPose();
            if (this.young) {
                poseStack.scale(0.5f, 0.5f, 0.5f);
                poseStack.translate(0, 1.5f, 0);
            }

            String loc = itemStack.getItem().getArmorTexture(itemStack, entity, itemStack.getEquipmentSlot(), null);
            ResourceLocation texture = TEXTURES.get(loc);
            if (texture == null) {
                texture = new ResourceLocation(loc);
                TEXTURES.put(loc, texture);
            }

            VertexConsumer vertex = this.getVertex(TranslucentArmorType.translucentArmor(texture), false, itemStack.isEnchanted());

            this.head.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.body.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.rightArm.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.leftArm.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.rightLeg.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.leftLeg.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            poseStack.popPose();

            /** RENDER FIRE */
            if (Methods.isLivingInJetSuit(entity)) {
                ItemStack itemStack = entity.getItemBySlot(EquipmentSlot.CHEST);
                JetSuit.Suit item = (JetSuit.Suit) itemStack.getItem();

                if (entity instanceof LocalPlayer) {
                    if (item.spacePressTime > 0) {
                        this.renderFireOnHandsAndFeeds(poseStack, item);
                    }
                }
            }
        }

        public void renderFireOnHandsAndFeeds(PoseStack poseStack, JetSuit.Suit item) {
            this.renderFire(poseStack, this.rightArm, item, 0.2F, -0.75F, 2.55F, -0.49F);
            this.renderFire(poseStack, this.leftArm, item, 0.2F, -0.25F, 2.55F, -0.5F);

            this.renderFire(poseStack, this.rightLeg, item, 0.2F, -0.55F, 3.0F, -0.49F);
            this.renderFire(poseStack, this.leftLeg, item, 0.2F, -0.45F, 3.0F, -0.5F);
        }

        public void renderFire(PoseStack poseStack, ModelPart modelPart, JetSuit.Suit item, float scale, float x, float y, float z) {
            Minecraft mc = Minecraft.getInstance();
            BlockRenderDispatcher blockRenderer = mc.getBlockRenderer();
            MultiBufferSource.BufferSource bufferSource = mc.renderBuffers().bufferSource();

            float speed = Mth.clamp(item.spacePressTime, 0.0F, 3.8F);

            poseStack.pushPose();
            poseStack.translate(modelPart.x / 16.0F, modelPart.y / 16.0F, modelPart.z / 16.0F);

            poseStack.scale(scale, scale, scale);

            poseStack.mulPose(Vector3f.ZP.rotation(modelPart.zRot));
            poseStack.mulPose(Vector3f.YP.rotation(modelPart.yRot));
            poseStack.mulPose(Vector3f.XP.rotation(modelPart.xRot));

            poseStack.translate(x, y, z);

            poseStack.scale(1, 1 + speed, 1);
            blockRenderer.renderSingleBlock(Blocks.SOUL_FIRE.defaultBlockState(), poseStack, bufferSource, 15728880, OverlayTexture.NO_OVERLAY);

            poseStack.popPose();
        }

        public VertexConsumer getVertex(RenderType p_115186_, boolean p_115187_, boolean p_115188_) {
            MultiBufferSource p_115185_ = Minecraft.getInstance().renderBuffers().bufferSource();
            return p_115188_ ? VertexMultiConsumer.create(p_115185_.getBuffer(p_115187_ ? RenderType.armorGlint() : RenderType.armorEntityGlint()), p_115185_.getBuffer(p_115186_)) : p_115185_.getBuffer(p_115186_);
        }
    }

    public static class JET_SUIT_P2<T extends LivingEntity> extends HumanoidModel<T> {

        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BeyondEarth.MODID, "jet_suit_p2"), "main");

        private static final HashMap<String, ResourceLocation> TEXTURES = Maps.newHashMap();

        public LivingEntity entity;
        public ItemStack itemStack;

        public final ModelPart rightLeg;
        public final ModelPart leftLeg;

        public JET_SUIT_P2(ModelPart root) {
            super(new EntityRendererProvider.Context(Minecraft.getInstance().getEntityRenderDispatcher(), Minecraft.getInstance().getItemRenderer(), Minecraft.getInstance().getBlockRenderer(), Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer(), Minecraft.getInstance().getResourceManager(), Minecraft.getInstance().getEntityModels(), Minecraft.getInstance().font).bakeLayer(ModelLayers.PLAYER_INNER_ARMOR));
            this.rightLeg = root.getChild("right_leg");
            this.leftLeg = root.getChild("left_leg");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition rightLeg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

            PartDefinition leftLeg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.6F)).mirror(false), PartPose.offset(1.9F, 12.0F, 0.0F));

            return LayerDefinition.create(meshdefinition, 64, 32);
        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            HumanoidModel livingModel = (HumanoidModel<LivingEntity>) ((LivingEntityRenderer) Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(entity)).getModel();

            this.attackTime = livingModel.attackTime;
            this.riding = livingModel.riding;
            this.young = livingModel.young;
            this.leftArmPose = livingModel.leftArmPose;
            this.rightArmPose = livingModel.rightArmPose;
            this.crouching = livingModel.crouching;
            this.head.copyFrom(livingModel.head);
            this.body.copyFrom(livingModel.body);
            this.rightArm.copyFrom(livingModel.rightArm);
            this.leftArm.copyFrom(livingModel.leftArm);
            this.rightLeg.copyFrom(livingModel.rightLeg);
            this.leftLeg.copyFrom(livingModel.leftLeg);

            poseStack.pushPose();
            if (this.young) {
                poseStack.scale(0.5f, 0.5f, 0.5f);
                poseStack.translate(0, 1.5f, 0);
            }

            String loc = itemStack.getItem().getArmorTexture(itemStack, entity, itemStack.getEquipmentSlot(), null);
            ResourceLocation texture = TEXTURES.get(loc);
            if (texture == null) {
                texture = new ResourceLocation(loc);
                TEXTURES.put(loc, texture);
            }

            VertexConsumer vertex = this.getVertex(TranslucentArmorType.translucentArmor(texture), false, itemStack.isEnchanted());

            this.rightLeg.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            this.leftLeg.render(poseStack, vertex, packedLight, packedOverlay, red, green, blue, alpha);
            poseStack.popPose();
        }

        public VertexConsumer getVertex(RenderType p_115186_, boolean p_115187_, boolean p_115188_) {
            MultiBufferSource p_115185_ = Minecraft.getInstance().renderBuffers().bufferSource();
            return p_115188_ ? VertexMultiConsumer.create(p_115185_.getBuffer(p_115187_ ? RenderType.armorGlint() : RenderType.armorEntityGlint()), p_115185_.getBuffer(p_115186_)) : p_115185_.getBuffer(p_115186_);
        }
    }
}
