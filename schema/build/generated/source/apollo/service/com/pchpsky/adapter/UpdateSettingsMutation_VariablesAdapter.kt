//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.pchpsky.UpdateSettingsMutation
import com.pchpsky.type.adapter.SettingsInput_InputAdapter
import kotlin.IllegalStateException
import kotlin.Unit

public object UpdateSettingsMutation_VariablesAdapter : Adapter<UpdateSettingsMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      UpdateSettingsMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: UpdateSettingsMutation,
  ): Unit {
    writer.name("settingsInput")
    SettingsInput_InputAdapter.obj().toJson(writer, customScalarAdapters, value.settingsInput)
  }
}
