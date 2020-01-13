# Spring DI

DI 란 Dependency Injection의 줄임말로써 `의존성 주입`이라 부른다.

스프링의 핵심적인 특징이며, 객체간의 연결(결합)을 스프링 설정으로 하게 하는 것을 말한다.

- property : setter 메소드를 이용하여 주입할 때 사용한다.
	- 주입하지 않아도 실행은 되지만 null이므로 NullPointerException이 발생한다.
- constructor-args : 생성자를 이용하여 주입할 때 사용한다.
	- 주입하지 않으면 에러가 나기 때문에 강결합과 유사하게 된다.
	
```xml
<beans:bean id="memberDao" class="com.kh.sts06.beans.MemberDao"></beans:bean>
<beans:bean name="/list" class="com.kh.sts06.ListController">
	<beans:property name="memberDao" ref="memberDao"></beans:property>
</beans:bean>
```

컨트롤러에 dao를 주입하는 설정 형식은 위와 같다.


	