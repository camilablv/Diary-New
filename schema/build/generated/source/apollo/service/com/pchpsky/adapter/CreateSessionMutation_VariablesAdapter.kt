//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.pchpsky.CreateSessionMutation
import kotlin.IllegalStateException
import kotlin.Unit

public object CreateSessionMutation_VariablesAdapter : Adapter<CreateSessionMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      CreateSessionMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: CreateSessionMutation,
  ): Unit {
    writer.name("email")
    StringAdapter.toJson(writer, customScalarAdapters, value.email)
    writer.name("password")
    StringAdapter.toJson(writer, customScalarAdapters, value.password)
  }
}
