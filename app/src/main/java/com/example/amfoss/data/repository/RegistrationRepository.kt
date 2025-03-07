package com.example.amfoss.data.repository

import com.apollographql.apollo3.exception.ApolloException
import com.example.amfoss.data.network.ApolloClientProvider
import com.example.amfoss.data.graphql.CreateMemberMutation

class RegistrationRepository {
    private val apolloClient = ApolloClientProvider.client

    suspend fun registerMember(
        rollNo: String,
        name: String,
        email: String,
        sex: String,
        year: Int,
        hostel: String,
        groupId: String
    ): Boolean {
        return try {
            val response = apolloClient.mutation(
                CreateMemberMutation(
                    input = CreateMemberMutation.Input(
                        roll_no = rollNo,
                        name = name,
                        email = email,
                        sex = sex,
                        year = year,
                        hostel = hostel,
                        group_id = groupId
                    )
                )
            ).execute()

            response.data?.createMember != null
        } catch (e: ApolloException) {
            e.printStackTrace()
            false
        }
    }
}

