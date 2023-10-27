# **코리아 IT 아카데미**
## JPA 수업정리

### ORM(Object Relational Mapping)
- 객체 진영과 RDB 진영을 자동으로 매핑하여 구조의 불일치를 개발자 대신 해결해주는 기술의 총칭이다. 객체지향 구조에서 프로그래밍 언어를 사용하여 RDB의 데이터를 조작하는 방법이다.
- ORM을 사용하면 개발자가 SQL문을 직접 작성하지 않아도 RDB와 상호작용할 수 있다.

### JPA(Java Persistence API)
- ORM을 사용하기 위 한 설계도(틀)이다.
- Java Application용 RDB 매핑 관리르 위한 인터페이스이며, DBMS 벤더사에 의존하지 않고 독립적으로 ORM을 사용할 수 있는 ORM 표준이다.
- 인터페이스이기 떄문에 구현되어 있지 않은 틀만 제공하며, 자체적인 작업을 수행하지 않는다.
- JPA에 설계된 구조에 맞춰서 각 메소드를 재정의하여 직접 ORM을 구현하여 사용해야 한다.
- JPA는 ORM을 사용할 수 있는 JAVA 인터페이스를 제공하는 ORM 접근 방식이며, 구현되지 않은 JPA를 ORM이라고 말하기는 어렵다.

### Hibernate Framework
- 모든 Java Application에 대해 객체 관계를 그대로 유지한 채 쿼리 서비스를 제공하는 오픈 소스(비용 없이 공개적으로 사용가능)의 경량 ORM이다.
- JPA를 구현한 구현체이며, 여러 구현체 중 가장 대표적인 구현체이다.

### Spring Data JPA
- JPA를 추상화한 Repository 인터페이스를 제공하여 JPA를 쓰기 편하게 다양한 기능을 지원한다.
- 내부적으로는 JPA를 사용한다. 그래서 JPA를 모르면 내부 구조를 이해하기 힘들 수 있다.

### JDK 설치 하기전
- Program Files 경로 삭제
- 환경변수 -> 11버전 jdk 경로 변경
- JPA 설정
```
#server
server:
  port: 10000

#jdbc
spring:
  datasource:
    driver-class-name: oracle.jdbc.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: hr
    password: hr

  #jpa
  jpa:
    hibernate:
      #ddl-auto: create -> DROP 후 CREATE
      #ddl-auto: create-drop -> DROP 후 CREATE 후 DROP, DML 사용 시 DROP
      #ddl-auto: update -> Entity와 DB 스키마 비교 후 수정 사항 반영(컬럼 추가) -> update를 먼저 써라
      #ddl-auto: validate -> Entity와 DB 스키마 비교 후 불칠치 시 오류

    #jpa format
    properties:
      hibernate:
        format_sql: true
    show-sql: true

  #log
  output:
    ansi:
      enabled: always
```

## QueryDSL
모든 절이 메소드로 구현되어 있다

### Page
페이지 단위가 필요할 때(공지사항, 문의, 관리자)

### Slice
페이지 단위가 필요 없을 때(클라, 카드배너, 썸네일)
```
PageImpl<>(content, pageable, count)
SliceImpl<>(content, pageable, hasNext)
```

### 엔티티
- 상속 관계
- 전략 3가지
1. SINGLE TABLE
2. JOINED
3. 연관관계
```
1:1
1:N : 단방향 쓰지 말아라! 반대 매핑
N:1 : 기본(default)
N:N : 제발 하지마라, N:1, 1:N로 풀어내라

단방향: 객체는 단방향밖에 없음
양방향: RDB에는 양방향 밖에 없음
해결: 객체에서 단방향 2개로 양방향을 만들자

양방향: 연관관계의 주인(FK를 추가, 수정할 수 있는 객체)
```

## Security
### 스프링 시큐리티
스프링 기반의 보안 프레임워크로서 애플리케이션에서 인증, 인가, 보안 등의 기능을 제공한다. <br>
시큐리티를 공부하기 위해서는 기본적인 스프링 프레임워크를 이해하고 넘어가자.
- 스프링은 스레드로 나눠져 있으므로 해당 요청의 context는 개별적인 스레드로 분리 되어 있다.
- 자바의 상태 변수를 여러개의 스레드가 공유하게 되면 상태는 다른 스레드에 영향을 주게 된다.
- 동기화문제를 막기 위해서는 스레드에 안전하도록 상태를 불변하게 만들거나 함수형 프로그래밍으로 설계 또는 세마포어를 이용한다.
- 세마포어를 사용하면 스레드 간의 동기화를 구현하거나 스레드에 안전하게 바꿀 수 있다.

### JPA를 사용하기 위한 yaml 설정
```
spring:
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format_sql: true
      default_batch_fetch_size: 100 # in query 자동
```

### 컨트롤러 생성
```
@RestController
@RequiredArgsConstructor
public class HelloController {
    
    @GetMapping("/")
    public ResponseEntity<?> hello(){
        
    return ResponseEntity.ok().body("ok");
    }
}
```

### Yaml변경
yaml에서 시큐리티 패스워드를 변경할 수 있다
```
security:
    user:
      name: ssar
      password: 1234 # 패스워드
```

### 최초요청과 재요청
브라우저에는 쿠키에 저장되어 있으며 서버요청을 해야된다 <br>
서버요청에는 세션이 있다 -> 쿠키쪽에서 세션쪽에 요청을 할때 session id가 필요하다 <br> <br>
※ 문제점 <br>
다른 컴퓨터에서도 session이 계속 있어서 session 유지기간들을 놔둔다 ex) 은행앱

### 스프링 요청과 응답
<img src="https://github.com/README-wmoon/study-jpa/assets/129862668/9427ab57-5aac-4e8a-8802-83ec6e501fb9" style = "width: 80%; height : 480"><br>

```
Dispatcher sevlet에서 요청을 받기전 filter가 있다 즉 필터체인 ex)method.
Request을 받으면 filter를 거쳐서 Dispatcher sevlet로가서 interceptor쪽으로 간다 
interceptor쪽에서 controoler로 가기전에 실행될 것(preHandler)인지 
아니면 응답이 다 되고 실행(postHandler)되는지 정할 수가 있다.
사용자가 URL을 요청하였을때 인증이 되었는지와 권한이 있는지 검사한다
그래서 frame쪽에서 interceptor를 작업하며 요청을 해야된다
AOP는 controller를 가기전에 작업하는 소스이다
따라서 before는 controller를 작업하기 전 
그리고 controller를 작업이 끝나고 나면 after 어노테이션이 작동이된다
그러고 나서 postHandler가 오고 Response가 된다.
```

### 요청
