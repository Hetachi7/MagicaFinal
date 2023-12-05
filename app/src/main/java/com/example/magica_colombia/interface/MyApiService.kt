package com.example.magica_colombia.`interface`

    import com.example.magica_colombia.respons.RespuestaDatos
    import retrofit2.Call
    import retrofit2.http.Field
    import retrofit2.http.FormUrlEncoded
    import retrofit2.http.POST

    interface MyApiService {

        @FormUrlEncoded
        @POST("/api/register") // Reemplaza con la ruta correcta de tu API para el registro
        fun signUp(
            @Field("user") user: String,
            @Field("email") email: String,
            @Field("password") password: String,
            @Field("passwordConfirm") passwordConfirm: String
        ): Call<RespuestaDatos> // Reemplaza ApiResponse con tu modelo de respuesta real
    }

