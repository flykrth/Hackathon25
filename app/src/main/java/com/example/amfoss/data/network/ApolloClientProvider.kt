package com.example.amfoss.data.network

import com.apollographql.apollo3.ApolloClient

object ApolloClientProvider {
    private const val BASE_URL = "https://root.amfoss.in/graphiql"

    val client: ApolloClient by lazy {
        ApolloClient.Builder()
            .serverUrl(BASE_URL)
            .build()
    }
}

