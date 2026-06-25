package com.icomm.im.consul.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/${application.api.version}")
public class EchoController {

  @Operation(summary = "Echo Message", description = """
  전달된 메시지를 그대로 리턴한다.
  """)
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class))),
  })
  @PostMapping(value = "/echo", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
  public Object echo(
    @RequestBody
    @Parameter(description = "Message", required = true) String message
  ) {
    log.info("echo message: {}", message);
    return message;
  }

  @Operation(summary = "Ping Pong", description = """
  항상 'pong' 만 리턴한다.
  """)
  @ApiResponses(value = {
    @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = String.class))),
  })
  @GetMapping(value ="/ping", produces = MediaType.TEXT_PLAIN_VALUE)
  public Object pingPong(
  ) {
    log.info("ping pong message");
    return "pong";
  }
}
