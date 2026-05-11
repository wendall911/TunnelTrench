package tunneltrench.network;

import org.jspecify.annotations.NonNull;

import io.netty.buffer.ByteBuf;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

import static tunneltrench.TunnelTrench.prefix;

public record BreakBlockPreview(BlockPos blockPos, int side) implements CustomPacketPayload {

    private static final StreamCodec<ByteBuf, BlockPos> BLOCKPOS = new StreamCodec<>() {

        @Override
        public void encode(@NonNull ByteBuf buf, @NonNull BlockPos blockPos) {
            FriendlyByteBuf.writeBlockPos(buf, blockPos);
        }

        @Override
        public @NonNull BlockPos decode(@NonNull ByteBuf byteBuf) {
            return FriendlyByteBuf.readBlockPos(byteBuf);
        }

    };
    public static final Type<BreakBlockPreview> TYPE = new Type<>(prefix("break_block_preview"));
    public static final StreamCodec<FriendlyByteBuf, BreakBlockPreview> STREAM_CODEC =
        StreamCodec.composite(
            BLOCKPOS,
            BreakBlockPreview::blockPos,
            ByteBufCodecs.INT,
            BreakBlockPreview::side,
            BreakBlockPreview::new
        );

    @Override
    public @NonNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

}
