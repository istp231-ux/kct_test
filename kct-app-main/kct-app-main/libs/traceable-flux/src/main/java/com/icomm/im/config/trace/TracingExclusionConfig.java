package com.icomm.im.config.trace;

import io.micrometer.observation.ObservationPredicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.observation.ServerRequestObservationContext;

import java.util.Objects;

/** Trace 예외 조건 추가.
 *
 */
@Configuration
public class TracingExclusionConfig {

    @Value("${management.endpoints.web.base-path:/actuator}")
    private String actuatorUrl;

    /** Security filter 제외
     *  https://stackoverflow.com/questions/75143863/how-to-exclude-some-uri-to-be-observed-using-springboot3-micrometer
     */
    @Bean
    public ObservationPredicate securityNoise() {
        return (name, context) -> !name.startsWith("spring.security");
    }

    /** Actuator URL 제외.
     *  https://stackoverflow.com/questions/75143863/how-to-exclude-some-uri-to-be-observed-using-springboot3-micrometer
     */
    @Bean
    public ObservationPredicate noActuator() {
        return (name, context) -> {
            if (name.equals("http.server.requests") && context instanceof ServerRequestObservationContext srCtx) {
                return !Objects.requireNonNull(srCtx.getCarrier()).getURI().toString().contains(actuatorUrl + "/");
            }
            return true;
        };
    }

    /** Swagger URL 제외.
     *  https://stackoverflow.com/questions/75143863/how-to-exclude-some-uri-to-be-observed-using-springboot3-micrometer
     */
    @Bean
    public ObservationPredicate noSwagger() {
        return (name, context) -> {
            if (name.equals("http.server.requests") && context instanceof ServerRequestObservationContext srCtx) {
                return !Objects.requireNonNull(srCtx.getCarrier()).getURI().toString().contains("/swagger");
            }
            return true;
        };
    }

    /** api-docs URL 제외.
     *  https://stackoverflow.com/questions/75143863/how-to-exclude-some-uri-to-be-observed-using-springboot3-micrometer
     */
    @Bean
    public ObservationPredicate noApiDocs() {
        return (name, context) -> {
            if (name.equals("http.server.requests") && context instanceof ServerRequestObservationContext srCtx) {
                return !Objects.requireNonNull(srCtx.getCarrier()).getURI().toString().contains("/v3/api-docs");
            }
            return true;
        };
    }

}
