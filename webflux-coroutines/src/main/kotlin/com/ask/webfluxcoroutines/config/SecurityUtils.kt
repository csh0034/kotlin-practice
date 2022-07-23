package com.ask.webfluxcoroutines.config

import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.ReactiveSecurityContextHolder

suspend fun getAuthenticationOrNull() = ReactiveSecurityContextHolder.getContext().awaitFirstOrNull()?.authentication

suspend fun getAuthentication(): Authentication = ReactiveSecurityContextHolder.getContext().awaitFirst().authentication

