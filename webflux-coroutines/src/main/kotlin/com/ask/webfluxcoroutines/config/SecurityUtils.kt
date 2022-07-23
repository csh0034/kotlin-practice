package com.ask.webfluxcoroutines.config

import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.security.core.context.ReactiveSecurityContextHolder

suspend fun getSecurityContext() = ReactiveSecurityContextHolder.getContext().awaitFirstOrNull()
