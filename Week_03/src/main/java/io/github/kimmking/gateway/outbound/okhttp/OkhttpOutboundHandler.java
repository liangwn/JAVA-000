package io.github.kimmking.gateway.outbound.okhttp;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class OkhttpOutboundHandler {

    private String backendUrl;

    public OkhttpOutboundHandler(String backendUrl) {
        this.backendUrl = backendUrl;
    }

    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        FullHttpResponse fullHttpResponse = null;
        final String url = this.backendUrl + fullRequest.uri();

        // 获取请求头
        HttpHeaders httpHeaders = fullRequest.headers();
        httpHeaders.add("nio","liangweining");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("User-Agent", httpHeaders.get("User-Agent"))
                .header("nio", httpHeaders.get("nio"))
                .header("Accept-Encoding", httpHeaders.get("Accept-Encoding"))
                .header("content-length", httpHeaders.get("content-length"))
                .header("Accept-Language", httpHeaders.get("Accept-Language"))
                .header("Sec-Fetch-Mode", httpHeaders.get("Sec-Fetch-Mode"))
                .header("Sec-Fetch-Site", httpHeaders.get("Sec-Fetch-Site"))
                .header("Cache-Control", httpHeaders.get("Cache-Control"))
                .header("Sec-Fetch-Dest", httpHeaders.get("Sec-Fetch-Dest"))
                .header("Host", httpHeaders.get("Host"))
                .header("Connection", httpHeaders.get("Connection"))
                .header("Accept", httpHeaders.get("Accept"))
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            byte[] body = response.body().string().getBytes();
            fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body));
            fullHttpResponse.headers().set("Content-Type", "application/json");
            fullHttpResponse.headers().set("Content-Length", response.body().contentLength());

        } catch (IOException e) {
            e.printStackTrace();
            fullHttpResponse = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(fullHttpResponse).addListener(ChannelFutureListener.CLOSE);
                } else {
                    ctx.write(fullHttpResponse);
                }
            }
            ctx.flush();
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
