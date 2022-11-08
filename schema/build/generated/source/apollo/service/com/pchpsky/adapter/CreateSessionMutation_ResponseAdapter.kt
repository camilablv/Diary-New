//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import com.pchpsky.CreateSessionMutation
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public object CreateSessionMutation_ResponseAdapter {
  public object Data : Adapter<CreateSessionMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("session")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        CreateSessionMutation.Data {
      var _session: CreateSessionMutation.Session? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _session = Session.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return CreateSessionMutation.Data(
        session = _session
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: CreateSessionMutation.Data,
    ): Unit {
      writer.name("session")
      Session.obj().nullable().toJson(writer, customScalarAdapters, value.session)
    }
  }

  public object Session : Adapter<CreateSessionMutation.Session> {
    public val RESPONSE_NAMES: List<String> = listOf("token", "user")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        CreateSessionMutation.Session {
      var _token: String? = null
      var _user: CreateSessionMutation.User? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _token = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _user = User.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return CreateSessionMutation.Session(
        token = _token,
        user = _user
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: CreateSessionMutation.Session,
    ): Unit {
      writer.name("token")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.token)

      writer.name("user")
      User.obj().nullable().toJson(writer, customScalarAdapters, value.user)
    }
  }

  public object User : Adapter<CreateSessionMutation.User> {
    public val RESPONSE_NAMES: List<String> = listOf("email")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        CreateSessionMutation.User {
      var _email: String? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _email = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return CreateSessionMutation.User(
        email = _email
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: CreateSessionMutation.User,
    ): Unit {
      writer.name("email")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.email)
    }
  }
}
