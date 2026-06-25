package com.icomm.im.config.trace;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.observation.ServerRequestObservationContext;
import org.springframework.stereotype.Component;

@Component
public class TracingObservationFilter implements ObservationFilter {

    @Override
    public Observation.Context map(Observation.Context context) {
        // Check if the current observation context represents an HTTP server request
        if (context instanceof ServerRequestObservationContext serverContext) {
            HttpServletRequest request = serverContext.getCarrier();

            if (request != null) {
                String callerIp = getClientIp(request);
                // "client.address" maps natively to OTel semantic conventions
                context.addHighCardinalityKeyValue(KeyValue.of("client.address", callerIp));
            }
        }
        return context;
    }

    private String getClientIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isBlank()) {
            // Return the first IP in the chain (original client)
            return xForwardedFor.split(",")[0].trim();
        }
        return request.getRemoteAddr();
    }
}
