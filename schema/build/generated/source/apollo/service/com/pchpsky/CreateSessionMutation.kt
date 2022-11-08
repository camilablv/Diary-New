//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.6.2'.
//
package com.pchpsky

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.pchpsky.adapter.CreateSessionMutation_ResponseAdapter
import com.pchpsky.adapter.CreateSessionMutation_VariablesAdapter
import com.pchpsky.selections.CreateSessionMutationSelections
import com.pchpsky.type.RootMutationType
import kotlin.String
import kotlin.Unit

public data class CreateSessionMutation(
  public val email: String,
  public val password: String,
) : Mutation<CreateSessionMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    CreateSessionMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = CreateSessionMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = RootMutationType.type
  )
  .selections(selections = CreateSessionMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(CreateSessionMutation_ResponseAdapter.Data::class)
  public data class Data(
    /**
     * login with the params
     */
    public val session: Session?,
  ) : Mutation.Data

  public data class Session(
    public val token: String?,
    public val user: User?,
  )

  public data class User(
    public val email: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "97f807f6eee876013296e71b58abad15e9c2aa5d04afd05faf774fee9c8915ab"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation CreateSession($email: String!, $password: String!) {
     *   session: createSession(email: $email, password: $password) {
     *     token
     *     user {
     *       email
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation CreateSession(${'$'}email: String!, ${'$'}password: String!) { session: createSession(email: ${'$'}email, password: ${'$'}password) { token user { email } } }"

    public const val OPERATION_NAME: String = "CreateSession"
  }
}
