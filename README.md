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
