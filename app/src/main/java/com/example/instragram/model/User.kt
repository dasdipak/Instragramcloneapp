package com.example.instragram.model

import android.os.Parcel
import android.os.Parcelable

class User(
    val userId: Int? = null,
    val fname: String? = null,
    val lname: String? = null,
    val username: String? = null,
    val password: String? = null,
    val batchName: String? = null,
    val profilePicture: String? = null
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(fname)
        parcel.writeString(lname)
        parcel.writeString(username)
        parcel.writeString(password)
        parcel.writeString(batchName)
        parcel.writeString(profilePicture)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}