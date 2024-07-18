# 웹소켓 프로젝트 스터디 주제
1. WebSocket의 원리와 작동을 이해하고 사용할 줄 안다.
2. STOMP의 원리와 작동을 이해하고 사용할 줄 안다.
3. Redis를 사용하여 동시 트래픽을 감당하는 서비스를 구성한다.
4. MongoDB와 MySQL을 사용하여 실시간으로 누적되는 데이터를 처리한다.
5. 모니터링을 통해 안정성있는 트래픽 관리를 할 줄 안다.
<br>
<br>
<br>

# 개발 예상 일정
     일정은 진도에 따라 변동될 수 있습니다! 
- 1주차
    - 기본 개념 습득 및 레퍼런스 참고 문서 채택
- 2주차
    - Websocket,STOMP를 사용한 채팅 구현
    - Redis를 사용한 Pub/Sub 메세지 파이프 라인 구현
    - MongoDB에 채팅기록을 저장, MySQL에 채팅방 목록 저장
- 3주차
    - Mornitoring을 통한 트래픽 지표 시각화(Grafana)
    - 검색 기능 개선 수행(QueryDSL, ElasticSearch)
<br>
<br>
<br>

# 웹소켓 프로젝트 스터디 스택 정리

## Back-end
- **Java 17**: 최신 기능과 성능 향상을 제공하는 안정적인 버전.
- **SpringBoot 3.x**: 신속한 개발을 위한 프레임워크로, 웹 애플리케이션 구축에 유용.
- **Websocket**: 양방향 통신을 위한 프로토콜.
- **STOMP**: Websocket 통신을 위한 메시징 프로토콜.
- **JPA**: 객체-관계 매핑을 위한 표준 자바 API.
- **QueryDSL** : 검색 기능 개선 수행

## Search
- **ElasticSearch** : 검색 기능 개선 수행

## Data PipeLine
- **Redis**: 인메모리 데이터 구조 저장소로, 캐시 및 메시지 브로커로 사용.

## Database
- **MongoDB**: NoSQL 데이터베이스로, JSON과 유사한 문서 형식의 데이터 저장.
- **MySQL**: 널리 사용되는 관계형 데이터베이스 관리 시스템.

## Front-end
- **React**: 사용자 인터페이스 구축을 위한 JavaScript 라이브러리.
- **Thymeleaf**: 서버사이드 Java 템플릿 엔진으로, HTML을 XML 양식으로 처리.

## Mornitoring
- **Grafana** : 스템 관점에서 CPU 메모리, 디스크 IO 사용율과 같은 지표를 시각화 하는데 특화

## Communication
- **Slack**: 팀 협업 및 소통을 위한 플랫폼.
- **Discord**: 게이머를 위한 음성, 영상, 텍스트 채팅 플랫폼이지만 팀 협업에도 유용.

## CI/CD
- **Github Action** :  GitHub에 push, PR 이벤트가 발생할 때 자동 테스트, 배포가 쉽게 이루어지기 때문에 개발에 몰두할 수 있음
<br>
<br>


# Architecture
    아키텍처는 차후 변경될 수 있습니다 고려해주세요 :)
![ChatArchitecture](https://github.com/god-kao-talk/chat-challenge-BE/assets/132982907/d1868b7b-a616-4166-97a6-bee94cbbfc65)

# Deploy & Test

## Build and Run Redis, Kafka
- 프로젝트 최상위에서 cmd를 열어 수행
- 현재 docker-compose에는 redis와 kafka를 모두 build하도록 되어 있음
```
docker-composeup -d
```
- 정상적인 Image pull, container 생성 과정
![image](https://github.com/Sunro1994/Redis-kafk-chatting/assets/132982907/72fee16a-afce-4475-9ee9-a6a4620d812d)
    현재 프로젝트에는 redis와 kafka 설정이 함께 설정되어 있습니다. 구분하여 테스트 할 경우 redis 또는 Kafak의관련 어노테이션(@Component, @Configuratoin) 및 설정 파일(.yml)을 주석처리하거나 제거하여 사용해주세요.
![image](https://github.com/Sunro1994/Redis-kafk-chatting/assets/132982907/3e66a739-f505-4b53-8b6b-6d351b43e89a)

## Build Project

-  **application.yml,build.gradle 파일** 에서 번걸아가며 주석을 풀고 빌드해야한다. 첫 번째로 group-id가 boo인 상태로 build한다.
두 번째로 group-id가 foo인 상태로 build한다.
```
gradlew bootJar
```
- 결과로 두 개의 build 결과물이 /build/libs 아래에 생긴걸 볼 수 있다.
![image](https://github.com/Sunro1994/Redis-kafk-chatting/assets/132982907/fb7c5a8c-f597-4dfb-908e-d748c2be92c1)

## Run Project
- libs 디렉터리에서 build된 Jar파일을 각각의 cmd에서 실행한다.
- 채팅을 수행해야 하기 때문에 각각 다른 포트로 생성해야 하며 foo2개 boo2개를 실행시킨다.
![image](https://github.com/Sunro1994/Redis-kafk-chatting/assets/132982907/1b44cf63-a28b-4e6f-a099-f3bd0cabb369)
```
java -jar chatdemo-foo.jar --server.port=8080
java -jar chatdemo-foo.jar --server.port=8081
java -jar chatdemo-boo.jar --server.port=8082
java -jar chatdemo-boo.jar --server.port=8083

```

## Test
localhost:[각자 포트번호]/chat/room 으로 웹을 열어 채팅방 개설후 채팅


# Refrence

## 기초 다지기
1. [web socket 기초 개념 따라하기](https://www.daddyprogrammer.org/post/4077/spring-websocket-chatting)

2. [redis, kafka 채팅 구현하기](https://hi-june.github.io/rualone/RUAlone05/#reference)

3. [kafka로 구현한 채팅 레포지터리(참고용)](https://github.com/god-kao-talk/chat-challenge-BE/tree/dev/src/main/java/com/challenge/chat/domain/member)

## 최종 목표!
3. [websocket, redis, mongoDB을 이용해서 채팅 구현, 내용 저장하기](https://nebulaisme.tistory.com/147)
<br>
<br>
<br>