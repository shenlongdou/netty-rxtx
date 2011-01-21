package de.uniluebeck.itm.nettyrxtx.isense;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ISensePacketDecoder extends OneToOneDecoder {

	private static final Logger log = LoggerFactory.getLogger(ISensePacketDecoder.class);

	@Override
	protected Object decode(final ChannelHandlerContext ctx, final Channel channel, final Object msg) throws Exception {

		ChannelBuffer buffer = (ChannelBuffer) msg;
		ISensePacket iSensePacket = new ISensePacket(buffer);
		log.trace("[{}] Decoded ISensePacket: {}", ctx.getName(), iSensePacket);
		return iSensePacket;
	}
}