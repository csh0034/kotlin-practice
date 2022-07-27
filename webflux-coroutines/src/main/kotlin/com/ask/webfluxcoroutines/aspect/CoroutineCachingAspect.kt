package com.ask.webfluxcoroutines.aspect

import com.ask.webfluxcoroutines.util.logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import kotlin.coroutines.Continuation
import kotlin.coroutines.intrinsics.startCoroutineUninterceptedOrReturn
import kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn

@Component
@Aspect
class CoroutineCachingAspect {

  private val cache = mutableMapOf<String, Any?>()
  private val log = logger()

  @Around("@annotation(CoroutineCaching) && args(.., kotlin.coroutines.Continuation)")
  fun logResult(pjp: ProceedingJoinPoint): Any? {
    log.info("CoroutineCachingAspect....")

    val signature = pjp.signature as MethodSignature
    val method = signature.method
    val annotation = method.getAnnotation(CoroutineCaching::class.java)
    val key = annotation.value

    log.info("key: $key")

    if (cache.containsKey(key)) {
      return cache[key]
    }

    val result = pjp.runCoroutine {
      val result = pjp.proceedCoroutine()
      log.info("in result: $result")

      cache.putIfAbsent(key, result)

      result
    }

    log.info("out result: $result")

    return result
  }

}

fun ProceedingJoinPoint.runCoroutine(
  block: suspend () -> Any?
): Any? = block.startCoroutineUninterceptedOrReturn(this.coroutineContinuation)

@Suppress("UNCHECKED_CAST")
val ProceedingJoinPoint.coroutineContinuation: Continuation<Any?>
  get() = this.args.last() as Continuation<Any?>

suspend fun ProceedingJoinPoint.proceedCoroutine(
  args: Array<Any?> = this.coroutineArgs
): Any? = suspendCoroutineUninterceptedOrReturn { continuation ->
  this.proceed(args + continuation)
}

val ProceedingJoinPoint.coroutineArgs: Array<Any?>
  get() = this.args.sliceArray(0 until this.args.size - 1)

