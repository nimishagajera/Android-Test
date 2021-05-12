package com.app.test

fun generateAddress(street: String, suite: String, city: String): String {
    return street.plus(", $suite").plus(", $city")
}