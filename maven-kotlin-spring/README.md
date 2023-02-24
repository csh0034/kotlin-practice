# maven-kotlin-spring

## [Kotest](https://kotest.io/)

코틀린 진영에서 가장 많이 사용되는 테스트 프레임워크.
코틀린 DSL 을 활용해 테스트 코드를 작성할 수 있으며 아래와 같은 기능들 포함

- 다양한 테스트 레이아웃(String Spec, Describe Spec, Behavior Spec 등) 제공
- Kotlin DSL 스타일의 Assertion 기능 제공

### Kotest with @SpringBootTest

```kotlin
// constructor 를 통한 테스트 작성시 사용, 리프 테스트에서만 테스트 컨텍스트를 설정하고 해제
extensions(SpringExtension)

// 루트 테스트 전후에만 테스트 컨텍스트를 설정하고 해제
extensions(SpringTestExtension(SpringTestLifecycleMode.Root))

// init 을 통한 테스트 작성시 사용
override fun extensions() = listOf(SpringExtension)
```

[Nested Test spec 에서의 context 생명주기 및 트랜잭션](https://kth990303.tistory.com/374)

## 참조

- [Kotlin MockK](https://www.devkuma.com/docs/kotlin/kotlin-mockk-%EC%82%AC%EC%9A%A9%EB%B2%95/)
