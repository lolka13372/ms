package net.minecraft.network.protocol.game;

import net.minecraft.network.ConnectionProtocol;
import net.minecraft.network.ProtocolInfo;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.protocol.ProtocolInfoBuilder;

public class GameProtocols {
    public static final ProtocolInfo.Unbound<ServerGamePacketListener, RegistryFriendlyByteBuf> SERVERBOUND = ProtocolInfoBuilder.serverboundProtocolUnbound(
        ConnectionProtocol.PLAY,
        p_329121_ -> p_329121_.addPacket(GamePacketTypes.SERVERBOUND_ACCEPT_TELEPORTATION, ServerboundAcceptTeleportationPacket.STREAM_CODEC)
                .addPacket(GamePacketTypes.SERVERBOUND_BLOCK_ENTITY_TAG_QUERY, ServerboundBlockEntityTagQueryPacket.STREAM_CODEC)
    );
    public static final ProtocolInfo.Unbound<ClientGamePacketListener, RegistryFriendlyByteBuf> CLIENTBOUND = ProtocolInfoBuilder.clientboundProtocolUnbound(
        ConnectionProtocol.PLAY,
        p_332342_ -> p_332342_.withBundlePacket(GamePacketTypes.CLIENTBOUND_BUNDLE, ClientboundBundlePacket::new, new ClientboundBundleDelimiterPacket())
                .addPacket(GamePacketTypes.CLIENTBOUND_ADD_ENTITY, ClientboundAddEntityPacket.STREAM_CODEC)
    );
}