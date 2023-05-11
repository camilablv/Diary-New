package com.pchpsky.network.interceptor

import com.pchpsky.network.token.TokenStore
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(private val tokenStore: TokenStore) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request().newBuilder()
        request.addHeader(
            "Authorization", "Bearer ${tokenStore.token}"
        )

        return chain.proceed(request.build())
    }
}