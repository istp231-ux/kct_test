
# Echo Service

## 개요
Echo Service는 전달받은 메시지를 그대로 응답하는 간단한 Spring Boot 기반 서비스입니다.

주로 다음과 같은 용도로 사용할 수 있습니다.

- 서비스 연동 테스트
- API Gateway 또는 프록시 동작 확인
- 네트워크 요청/응답 확인
- 기능 시험용 엔드포인트 제공

## 실행 환경

- Java 25
- Spring Boot
- Spring MVC
- Gradle


## Configurations

| Property name             | Default value                                                                                     | Description           |
|---------------------------|---------------------------------------------------------------------------------------------------|-----------------------|
| `application.id`          | `${spring.application.name}-${application.node-id:00}-${application.instance-id:${random.value}}` | Application Unique ID |
| `application.node-id`     | `00`                                                                                              | Node ID               |
| `application.instance-id` | `random.value`                                                                                    | Instance ID           |

