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