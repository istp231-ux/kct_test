# traceable-web

`traceable-web`은 Spring WebMVC 기반 애플리케이션에서 요청 추적, 관측성 필터링, 제외 경로 관리 등을 제공하기 위한 웹 추적 설정 모듈입니다.

## Overview

이 모듈은 웹 요청 처리 과정에서 다음과 같은 기능을 제공하는 것을 목표로 합니다.

- HTTP 요청 단위의 tracing 지원
- Observation / tracing 대상에서 제외할 경로 관리
- 공통 WebMVC 필터 설정 제공
- 애플리케이션 전반에서 일관된 요청 추적 정책 적용

## Requirements

- Java 25
- Spring Boot 4.1.0
- Spring MVC

## Features

### Request Tracing

웹 요청이 애플리케이션에 진입했을 때 요청 흐름을 추적할 수 있도록 관련 필터 및 설정을 제공합니다.

### Exclusion Filter

Tracing 또는 Observation 대상에서 제외해야 하는 경로를 설정합니다.

- Health check endpoint
- Swagger / OpenAPI 문서
- Actuator endpoint
- Security Filter


## Usage

`traceable-web` 모듈을 의존성으로 추가한 뒤, 애플리케이션에서 제공되는 WebMVC tracing 설정을 활성화합니다.

Gradle 예시:
```
groovy
dependencies {
implementation project(":traceable-web")
}
```
또는 별도 라이브러리로 배포된 경우:
```
groovy
dependencies {
implementation "your.group:traceable-web:0.0.1"
}
```

## Properties

| Property | Description | Example |
| --- | --- | --- |
| `traceable.web.exclusions` | Tracing 또는 Observation 대상에서 제외할 URL 패턴 목록 | `/actuator/**` |
| `server.forward-headers-strategy` | Forwarded header 처리 전략 | `native` |

## Notes

- WebMVC 환경을 기준으로 설계된 모듈입니다.


