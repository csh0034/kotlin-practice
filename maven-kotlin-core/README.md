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