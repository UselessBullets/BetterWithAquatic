package baguchan.better_with_aquatic.mixin.client;

import baguchan.better_with_aquatic.block.ModBlocks;
import net.minecraft.client.render.ChunkRenderer;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.client.render.block.model.BlockModel;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.chunk.ChunkCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.HashSet;

@Mixin(value = ChunkRenderer.class, remap = false)
public class ChunkRendererMixin {
	@Inject(method = "updateRenderer", locals = LocalCapture.CAPTURE_FAILHARD, at = @At(value = "INVOKE", target = "Lnet/minecraft/core/block/Block;getRenderBlockPass()I", shift = At.Shift.AFTER))
	private void updateRenderer(CallbackInfo ci, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, HashSet lastSpecialTileEntities, int cacheRadius, ChunkCache chunkcache, RenderBlocks renderblocks, int renderPass, boolean needsMoreRenderPasses, boolean hasRenderedBlock, boolean hasStartedDrawing, int y, int z, int x, int blockId, Block block) {
		if (block.id == ModBlocks.sea_grass.id) {
			if (renderPass == 1) {
				BlockModel model = (BlockModel) BlockModelDispatcher.getInstance().getDispatch(Block.fluidWaterStill);

				model.render(Block.fluidWaterStill, x, y, z);
			}
		}
	}
}
