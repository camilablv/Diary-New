package com.pchpsky.network.token

class TokenStore {

    var token: String?
        get() = TokenStore.token
        set(value) {
            TokenStore.token = value
        }

    companion object {
        private var token: String? =
            "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJkaWFyeSIsImV4cCI6MTY2ODgwMzcwOCwiaWF0IjoxNjY4NTQ0NTA4LCJpc3MiOiJkaWFyeSIsImp0aSI6ImFjYTE4ZjI5LWE5NDgtNDdhYi1hZDU3LTc5OTgzZjVlMjM3YSIsIm5iZiI6MTY2ODU0NDUwNywic3ViIjoiNDMiLCJ0eXAiOiJhY2Nlc3MifQ.pTnyyh_mIWowjA92_oA3LPz3xpwcPBUAQCgK5yh8j2SCgnDv_3ke9yyl2iAyPa9HxFguLxdOTrAozE5ruSRlXQ"
    }
}