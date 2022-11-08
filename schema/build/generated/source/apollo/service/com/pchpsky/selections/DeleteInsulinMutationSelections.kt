//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky.selections

import com.apollographql.apollo3.api.CompiledArgument
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.CompiledVariable
import com.pchpsky.type.GraphQLID
import com.pchpsky.type.GraphQLString
import com.pchpsky.type.Insulin
import kotlin.collections.List

public object DeleteInsulinMutationSelections {
  private val __deleteInsulin: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "color",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "name",
          type = GraphQLString.type
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "deleteInsulin",
          type = Insulin.type
        ).alias("insulin")
        .arguments(listOf(
          CompiledArgument.Builder("id", CompiledVariable("id")).build()
        ))
        .selections(__deleteInsulin)
        .build()
      )
}
