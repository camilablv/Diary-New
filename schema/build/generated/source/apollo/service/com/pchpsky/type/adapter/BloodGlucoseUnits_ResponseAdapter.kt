//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.pchpsky.type.BloodGlucoseUnits
import kotlin.Unit

public object BloodGlucoseUnits_ResponseAdapter : Adapter<BloodGlucoseUnits> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      BloodGlucoseUnits {
    val rawValue = reader.nextString()!!
    return BloodGlucoseUnits.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: BloodGlucoseUnits,
  ): Unit {
    writer.value(value.rawValue)
  }
}