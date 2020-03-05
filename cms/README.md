# 인하대병원 관리자 프로젝트 - cms

이 프로젝트는 2개의 서브프로젝트로 구성

- [frontend](./frontend) : vue.js
- [backend](./backend) : spring boot


## app 구동 방법

현재 디렉토리(/imc/cms) 에서 다음 명령어를 실행
```
mvn clean install
```

Rest API 서버용 Spring Boot App 구동:

```
mvn --projects backend spring-boot:run
```

이제 http://localhost:8088/ 으로 이동하면 화면이 나옵니다.

## webpack-dev-server 으로 빠른 피드백 받기
[frontend](./frontend) 프로젝트 디렉토리로 이동하여 다음 명령어를 실행하면, webpack-dev-server 가 구동되면서 javascript build-chain 에 있는 모든 수정사항이 즉각 반영되게 됩니다.

```
npm run serve
```

test webhook
