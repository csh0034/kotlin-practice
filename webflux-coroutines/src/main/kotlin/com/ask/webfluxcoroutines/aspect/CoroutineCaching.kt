package com.ask.webfluxcoroutines.aspect

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class CoroutineCaching(val value: String)
