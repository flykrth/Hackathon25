package com.example.amfoss.data.repository

import com.example.amfoss.GetUserDataQuery
import com.example.amfoss.data.GraphQLClient
import com.example.amfoss.data.model.User

class UserRepository {
    private val apolloClient = GraphQLClient.apolloClient

    suspend fun fetchUserData(email: String): User? {
        val response = apolloClient.query(GetUserDataQuery(email)).execute()
        val user = response.data?.user

        return user?.let {
            User(
                rollNo = it.roll_no ?: "",
                name = it.name ?: "",
                email = it.email ?: "",
                sex = it.sex ?: "",
                year = it.year ?: 0,
                hostel = it.hostel ?: "",
                groupId = it.group_id ?: ""
            )
        }
    }
}

