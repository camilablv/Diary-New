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
import com.pchpsky.UpdateInsulinMutation
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdateInsulinMutation_VariablesAdapter : Adapter<UpdateInsulinMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdateInsulinMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdateInsulinMutation,
  ): Unit {
    writer.name("id")
    StringAdapter.toJson(writer, customScalarAdapters, value.id)
    writer.name("color")
    StringAdapter.toJson(writer, customScalarAdapters, value.color)
    writer.name("name")
    StringAdapter.toJson(writer, customScalarAdapters, value.name)
  }
}