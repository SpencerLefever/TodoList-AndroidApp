package com.example.common_libs

import javax.inject.Qualifier


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention
@Qualifier
annotation class MainDispatcher