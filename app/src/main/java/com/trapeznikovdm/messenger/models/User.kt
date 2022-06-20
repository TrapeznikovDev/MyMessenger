package com.trapeznikovdm.messenger.models

data class User(
    var id: String = "",
    var username: String = "",
    var bio: String = "",
    var fullname: String = "",
    var status: String = "",
    var phone: String = "",
    var photourl: String = ""
)
