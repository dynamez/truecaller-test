package com.example.designkit.commons

@Target(AnnotationTarget.FUNCTION,)
@MustBeDocumented
annotation class NotInDS

@Target(AnnotationTarget.FUNCTION,)
@MustBeDocumented
annotation class NotAccessible(val reason: String)
