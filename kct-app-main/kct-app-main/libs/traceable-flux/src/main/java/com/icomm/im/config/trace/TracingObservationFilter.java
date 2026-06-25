package com.icomm.im.config.trace;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.observation.ServerRequestObservationContext;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
import java.util.List;

@Component
public class TracingObservationFilter implements ObservationFilter {

    @Override
    public Observation.Context map(Observation.Context context) {
        // Check if the current observation context represents an HTTP server request
        if (context instanceof ServerRequestObservationContext serverContext) {
            ServerHttpRequest request = serverContext.getCarrier();

            if (request != null) {
                String callerIp = getClientIp(request);
                // "client.address" maps natively to OTel semantic conventions
                context.addHighCardinalityKeyValue(KeyValue.of("client.address", callerIp));
            }
        }
        return context;
    }

    private String getClientIp(ServerHttpRequest request) {
        List<String> Ips = request.getHeaders().get("X-Forwarded-For");
        if (Ips != null && !Ips.isEmpty()) {
            // Return the first IP in the chain (original client)
            return Ips.getFirst().split(",")[0].trim();
        }
        InetSocketAddress socketAddress = request.getRemoteAddress();
        return socketAddress != null ? socketAddress.toString() : "unknown";
    }
}
