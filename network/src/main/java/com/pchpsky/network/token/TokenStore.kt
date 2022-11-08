package com.pchpsky.network.token

class TokenStore {

    var token: String?
        get() = TokenStore.token
        set(value) {
            TokenStore.token = value
        }

    companion object {
        private var token: String? =
            "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJkaWFyeSIsImV4cCI6MTY2NzgyMDc1MSwiaWF0IjoxNjY3NTYxNTUxLCJpc3MiOiJkaWFyeSIsImp0aSI6IjFmODRmN2UzLTlkZTgtNDZhYi05YzM5LTMwYTgzYjNhN2Q1ZCIsIm5iZiI6MTY2NzU2MTU1MCwic3ViIjoiNDMiLCJ0eXAiOiJhY2Nlc3MifQ.2K7M1WKPWWx9wWbDMIzcqOF8kvm1Nm0QzfcPAAGHxlx-o41ezMPhyO9sL6hI39vjmzBtUkzTCMYAZomrhFO3UQ"
    }
}