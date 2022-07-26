package com.ask.webfluxcoroutines.aspect

import com.ask.webfluxcoroutines.util.logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.core.KotlinDetector
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import java.util.*

@Component
@Aspect
class CoroutineLoggingAspect {

  private val log = logger()

  @Around("@annotation(CoroutineLogging)") // @annotation(CoroutineLogging) && args(.., kotlin.coroutines.Continuation)
  fun logResult(pjp: ProceedingJoinPoint): Any? {
    val signature = pjp.signature as MethodSignature

    return if (KotlinDetector.isSuspendingFunction(signature.method)) {
      log.info("1. args: ${Arrays.toString(pjp.args)}")
      log.info("2. name: ${pjp.signature.name}")

      val stopWatch = StopWatch()
      stopWatch.start()

      val proceed = pjp.proceed()

      stopWatch.stop()

      log.info("elapsed time: ${stopWatch.totalTimeMillis} ms");

      proceed
    } else {
      log.warn("not suspending function...")
      pjp.proceed()
    }
  }

}
