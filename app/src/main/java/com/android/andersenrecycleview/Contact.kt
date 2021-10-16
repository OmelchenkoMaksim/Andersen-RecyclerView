package com.android.andersenrecycleview

import java.util.*

data class Contact constructor(
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val imageUrl: String
) {
    val contactUID: UUID = UUID.randomUUID()

    fun getNameAndSurname() = "$name $surname"
}