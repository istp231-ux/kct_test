package com.icomm.im.consul.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/** Git properties file loading.
 *
 */
@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:git.properties")
public class GitPropertyConfig {

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}
