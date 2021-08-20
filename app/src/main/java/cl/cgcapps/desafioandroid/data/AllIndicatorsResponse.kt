package cl.cgcapps.desafioandroid.data


import com.google.gson.annotations.SerializedName

data class AllIndicatorsResponse(
    @SerializedName("autor")
    val autor: String,
    @SerializedName("bitcoin")
    val bitcoin: Indicator,
    @SerializedName("dolar")
    val dolar: Indicator,
    @SerializedName("dolar_intercambio")
    val dolarIntercambio: Indicator,
    @SerializedName("euro")
    val euro: Indicator,
    @SerializedName("fecha")
    val fecha: String,
    @SerializedName("imacec")
    val imacec: Indicator,
    @SerializedName("ipc")
    val ipc: Indicator,
    @SerializedName("ivp")
    val ivp: Indicator,
    @SerializedName("libra_cobre")
    val libraCobre: Indicator,
    @SerializedName("tasa_desempleo")
    val tasaDesempleo: Indicator,
    @SerializedName("tpm")
    val tpm: Indicator,
    @SerializedName("uf")
    val uf: Indicator,
    @SerializedName("utm")
    val utm: Indicator,
    @SerializedName("version")
    val version: String
) {
    data class Indicator(
        @SerializedName("codigo")
        val codigo: String,
        @SerializedName("fecha")
        val fecha: String,
        @SerializedName("nombre")
        val nombre: String,
        @SerializedName("unidad_medida")
        val unidadMedida: String,
        @SerializedName("valor")
        val valor: Double
    )
}