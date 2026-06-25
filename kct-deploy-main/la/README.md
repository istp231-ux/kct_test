# Log Aggregator

* i-Monitor Log Aggregater (Node 마다 설치)


## grafana alloy

* grafana promtail 에서 alloy 로 변경 
   * promtail 은 EOS 되었음
* Node 마다 설치해야 함


## Register service
```sh
cd service
./register.sh
```

* alloy-service.json
   * consul 에 등록할 log aggregatter service 정보 
* register.sh
   * service 등록을 위한 script
   * 좀 더 자동화 필요
