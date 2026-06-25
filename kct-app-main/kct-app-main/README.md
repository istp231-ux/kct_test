# iComm i-Monitor (KCT)

## Site
### KCT
#### 목표
* 기 운영중인 Provisioning Service 대체

## Build

### gradle.properties
아이컴테크놀러지 Nexus Repository ID/PW 정보
```properties
#repository authentication
iCommNexusRepositoryUsername=<<ID>>
iCommNexusRepositoryPassword=<<PASSWORD>>

# disable gradle daemon
org.gradle.daemon=false
```


## Services
| Name           | Type    | Description                         |
|----------------|---------|-------------------------------------|
| traceable-flux | Library | Traceable configuration for WebFlux |
| traceable-web  | Library | Traceable configuration for WebMVC  |
| echo           | Service | Echo Service                        |
