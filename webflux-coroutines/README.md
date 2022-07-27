# Webflux Coroutines

## Dispatcher

### IO Dispatcher

- IO Dispatchers I/O 연산과 같이 쓰레드를 오랫동안 블로킹할 때 사용될 수 있도록 설계되었다.
- 이 쓰레드 풀의 추가적인 쓰레드는 필요에 따라 생성되고, 제거된다.
- 디스패처의 작업에서 사용되는 쓰레드의 수는 "kotlinx.coroutines.io.parallelism" 시스템 프로퍼티의 값에 따라 제한된다.
- 디폴트로는 64개의 쓰레드로 제한되어 있으며, 코어의 수가 그것보다 크면 코어의 수만큼 제한된다.
- Dispatchers.Default 와 쓰레드를 공유하기 때문에 withContext(Dispatchers.IO)를 사용해도 실제로 쓰레드 스위칭이 일어나진 않는다.


## Troubleshooting

### Coroutine @Transactional

코루틴을 사용하면서 DB 접근시 쓰레드가 블로킹 되지않도록 IO 작업에 대해선 하단과 같이 사용한다.

```kotlin
suspend fun update(serial: String) {
  withContext(Dispatchers.IO) {
    // DB 작업
  }
}
```

이때 `Dispatchers.IO` 의 경우 `DefaultDispatcher-worker` 쓰레드를 사용하므로  
리액터에서 요청을 처리하는 `reactor-http-nio` 와 다르기 때문에   
트랜잭션의 상태를 저장하는 ThreadLocal 의 값을 사용할수 없어서 `@Transaction` 을 사용해도 동작하지않는다.

따라서 변경감지 기능을 사용할수 없으며 명시적으로 `JpaRepository.save()` 를 호출해야한다.

### Coroutine Cache 적용

suspend function 의 경우 리턴타입이 `COROUTINE_SUSPENDED` 이므로 리턴타입 대한 캐싱이 안됨

따라서 별도 `startCoroutineUninterceptedOrReturn` 과 `suspendCoroutineUninterceptedOrReturn` 로 처리해야한다.

- [GitHub Issue, Spring AOP is not compatible with Kotlin Coroutines](https://github.com/spring-projects/spring-framework/issues/22462)

## 참조

- [Docs, Spring Coroutines](https://docs.spring.io/spring-framework/docs/current/reference/html/languages.html#coroutines)
