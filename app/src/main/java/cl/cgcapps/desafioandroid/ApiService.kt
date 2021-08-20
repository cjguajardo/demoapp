package cl.cgcapps.desafioandroid

import cl.cgcapps.desafioandroid.data.AllIndicatorsResponse
import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://www.mindicador.cl/"

interface ApiService {
    @GET("/api")
    suspend fun getAllIndicators() : Response<AllIndicatorsResponse>
}