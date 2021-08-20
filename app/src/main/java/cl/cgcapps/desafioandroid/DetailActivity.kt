package cl.cgcapps.desafioandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.ActivityNavigator
import com.google.android.material.appbar.MaterialToolbar

class DetailActivity : AppCompatActivity() {

    private lateinit var codigo: TextView
    private lateinit var fecha: TextView
    private lateinit var nombre: TextView
    private lateinit var unidadMedida: TextView
    private lateinit var valor: TextView
    private lateinit var topAppBar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.getStringExtra("user_name")
        val indicatorCodigo = intent.getStringExtra("indicator_codigo")
        val indicatorFecha = intent.getStringExtra("indicator_fecha")
        val indicatorNombre = intent.getStringExtra("indicator_nombre")
        val indicatorUnidadMedida = intent.getStringExtra("indicator_unidadMedida")
        val indicatorValor = intent.getDoubleExtra("indicator_valor",0.0)

        codigo = findViewById(R.id.codigo)
        fecha = findViewById(R.id.fecha)
        nombre = findViewById(R.id.nombre)
        unidadMedida = findViewById(R.id.unidadMedida)
        valor = findViewById(R.id.valor)
        topAppBar = findViewById(R.id.topAppBar)

        codigo.text = indicatorCodigo
        fecha.text = indicatorFecha
        nombre.text = indicatorNombre
        unidadMedida.text = indicatorUnidadMedida
        valor.text = indicatorValor.toString()

        topAppBar.title = indicatorNombre


        topAppBar.setNavigationOnClickListener {
            super.onBackPressed()
        }
    }
}