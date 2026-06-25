package com.icomm.im.consul.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.extensions.ExtensionProperty;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@OpenAPIDefinition(
  info = @Info(
    title = "i-MONITOR Echo Server",
    description = """
      이 문서는 (주)아이컴테크놀러지가 저작권을 가지고 있다.
      이 문서에 기록된 모든 정보는 통보 없이 변경될 수 있으며 허가 없이 임의 수정, 배포 및 사용을 금지한다.

      ### Information
      * Project
         * Name: i-MONITOR Echo Server
         * API Version: v1
         * Application Version: ${git.build.version}
      * Source
         * Repository: ${git.remote.origin.url}
         * Branch: ${git.branch}
         * Commit Date: ${git.commit.time}
         * Commit ID: ${git.commit.id}
         * Commiter: ${git.commit.user.email}
      * Build
         * Host: ${git.build.host}
         * Builder: ${git.build.user.email}

      """,
    version = "v1 " + "${git.build.version:UNKNOWN} " + "${git.commit.id.abbrev:UNKNOWN} " + "${git.commit.time:UNKNOWN}",
    contact = @Contact(name = "rewriter", email = "rewriter@i-commtech.com"),
    license = @License(name = "Copyright (c) i-CommTech.", url = "https://i-commtech.com"),
    extensions = {
      @Extension(name = "Git", properties = {
        @ExtensionProperty(name = "Commit Time", value = "${git.commit.time:UNKNOWN}"),
        @ExtensionProperty(name = "Commit Id", value = "${git.commit.id.abbrev:UNKNOWN}"),
        @ExtensionProperty(name = "Commit User", value = "${git.commit.user.email:UNKNOWN}"),
        @ExtensionProperty(name = "Branch", value = "${git.branch:UNKNOWN}"),
        @ExtensionProperty(name = "Repository URL", value = "${git.remote.origin.url:UNKNOWN}"),
        @ExtensionProperty(name = "Build Host", value = "${git.build.host:UNKNOWN}")
      })
    }
  ),
  servers = {
    @Server(description = "local host", url = "/"),
  }
)
@Configuration
public class SwaggerConfig {
  @Bean
  public GroupedOpenApi echoApi() {
    String[] paths = {"/api/v1/**"};
    return GroupedOpenApi.builder().group("i-MONITOR Echo Server").pathsToMatch(paths)
      .build();
  }
}
