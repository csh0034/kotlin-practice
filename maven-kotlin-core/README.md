# maven-kotlin-practice

## 가시성 (visibility)
클래스와 인스턴스는 기본적으로 public 이다.

- private
  - 자신이 정의된 클래스 안에서만 볼 수 있다.
- protected
  - private + 서브 클래스에서 접근
- internal
  - 같은 모듈 안에서 볼수 있음
  - 모듈이란 한꺼번에 컴파일 되는 파일 묶음을 뜻한다.
- public
  - 어디서든 접근 가능, default

## [Scope functions](https://kotlinlang.org/docs/scope-functions.html)

### 코틀린에서 지원하는 scope function 사용 모범 사례

- apply
  - 수신 객체 람다 내부에서 수신 객체의 함수를 사용하지 않고 수신 객체 자신을 다시 반환 하려는 경우에 apply 를 사용
  - 수신 객체의 프로퍼티만을 사용하여 초기화를 수행할때
- also
  - 수신 객체 람다가 전달된 수신 객체를 전혀 사용 하지 않거나
  - 수신 객체의 속성을 변경하지 않고 사용하는 경우 also 를 사용
  - validation 체크, 로깅 등
- with
  - Non-nullable (Null 이 될수 없는) 수신 객체 이고 결과가 필요하지 않은 경우에만 with 를 사용
- let
  - 지정된 값이 null 이 아닌 경우에 코드를 실행해야 하는 경우
  - Nullable 객체를 다른 Nullable 객체로 변환하는 경우
  - 단일 지역 변수의 범위를 제한 하는 경우
- run
  - 어떤 값을 계산할 필요가 있거나 여러개의 지역 변수의 범위를 제한하려면 run 을 사용

```kotlin
inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    return receiver.block()
}
inline fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}
inline fun <T> T.apply(block: T.() -> Unit): T {
    block()
    return this
}
inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}
inline fun <T, R> T.run(block: T.() -> R): R {
    return block()
}
```

### 범위 지정 함수 중첩
범위 지정 함수가 중첩되면 코드의 가독성이 떨어지고 파악하기 어려워 진다.  
원칙적으로 중첩은 하지 않는 것이 좋다.

내부에서 this 를 사용하는 apply, run, with 은 중첩하지 않는것이 좋다.  
this 를 생략 할수 있으며 수신객체 이름을 변경 할 수 없기 때문에 중첩시에 혼동하기 쉽다.

also 와 let 을 중첩할 경우에는 내부에서 it 라는 이름을 사용하지 않고  
명시적으로 선언하여 사용한것이 좋다.

### 범위 지정 함수 체인
중첩과는 달리 범위 지정 기능을 호출 체인에 결합하면 코드의 가독성이 향상된다.

```kotlin
// Sample
private fun insert(user: User) = SqlBuilder().apply {
    append("INSERT INTO user (email, name, age) VALUES ")
    append("(?", user.email)
    append(",?", user.name)
    append(",?)", user.age)
}.also {
    print("Executing SQL update: $it.")
}.run {
    jdbc.update(this) > 0
}
```


