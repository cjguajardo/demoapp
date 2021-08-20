package cl.cgcapps.desafioandroid

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cl.cgcapps.desafioandroid.data.AllIndicatorsResponse
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class HomeActivity : AppCompatActivity(),
    RecyclerAdapter.OnItemClickListener {

    private lateinit var itemList: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var topAppBar: MaterialToolbar
    private lateinit var searchText: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var sharedPref: SharedPreferences

    private val indicatorList = mutableListOf<AllIndicatorsResponse.Indicator>()
    private val fullIndicatorList = mutableListOf<AllIndicatorsResponse.Indicator>()
    private lateinit var allIndicators: AllIndicatorsResponse

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val uname = intent.getStringExtra("UserName")

        topAppBar = findViewById(R.id.topAppBar)
        topAppBar.title = "Hola $uname!"
        topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.updateButton -> {
                    Log.d("Main", ">>> updateButton")
//                    getAllIndicators()
                    true
                }

                R.id.closeSession -> {
                    Log.d("Main", ">>> closeSession")
//                    logOut()
                    super.onBackPressed()
                    true
                }

                else -> false
            }
        }

        itemList = findViewById(R.id.itemList)
        recyclerAdapter = RecyclerAdapter(indicatorList, this)
        itemList.layoutManager = LinearLayoutManager(this)
        itemList.adapter = recyclerAdapter

        searchText = findViewById(R.id.searchText)
        searchButton = findViewById(R.id.searchButton)

        getAllIndicators()

        searchButton.setOnClickListener {
            Log.d("Main", ">>> setOnClickListener >> TEXT: "+this.searchText.text)
            filterIndicators(this.searchText.text.toString())
        }

        searchText.addTextChangedListener { object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterIndicators(searchText.text.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                filterIndicators(searchText.text.toString())
            }

        } }
    }

    private fun filterIndicators(text:String) {
        Log.d("Main", ">>> filterIndicators >> TEXT: $text")
        if (text.isEmpty()) {
            indicatorList.clear()
            indicatorList.addAll(fullIndicatorList.toList())
            recyclerAdapter.notifyDataSetChanged()
        }
        else {
            val l = fullIndicatorList.filter { text.contains(it.codigo) || it.codigo.contains(text) }
            indicatorList.clear()
            indicatorList.addAll(l.toList())
            recyclerAdapter.notifyDataSetChanged()
        }
    }

    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getAllIndicators() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = getRetrofit().create(ApiService::class.java).getAllIndicators()

                runOnUiThread {
                    if (call.isSuccessful) {
                        allIndicators = call.body()!!
                        indicatorList.clear()
                        fullIndicatorList.clear()
                        allIndicators.let {
                            fullIndicatorList.add(it.bitcoin)
                            fullIndicatorList.add(it.uf)
                            fullIndicatorList.add(it.ivp)
                            fullIndicatorList.add(it.dolar)
                            fullIndicatorList.add(it.dolarIntercambio)
                            fullIndicatorList.add(it.euro)
                            fullIndicatorList.add(it.ipc)
                            fullIndicatorList.add(it.utm)
                            fullIndicatorList.add(it.imacec)
                            fullIndicatorList.add(it.tpm)
                            fullIndicatorList.add(it.libraCobre)
                            fullIndicatorList.add(it.tasaDesempleo)
                        }
                        indicatorList.addAll(fullIndicatorList.toList())
                        recyclerAdapter.notifyDataSetChanged()
                    } else {
                        showError("Ha ocurrido un error")
                    }
                }
            }catch(e: Exception) {
                Log.e("Main", e.message.toString())
                runOnUiThread {
                    showError(e.message.toString())
                }
            }
        }
    }

    private fun showError(text:String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(position: Int) {
        val item = indicatorList[position]
        startActivity(
            Intent(
            this,
            DetailActivity::class.java
        ).apply{
            putExtra("indicator_codigo", item.codigo)
            putExtra("indicator_fecha", item.fecha)
            putExtra("indicator_nombre", item.nombre)
            putExtra("indicator_unidadMedida", item.unidadMedida)
            putExtra("indicator_valor", item.valor)
        })
    }

    private fun logOut() {
        sharedPref = getSharedPreferences("LOGIN_DB", MODE_PRIVATE)
        with(sharedPref) {
            edit().putBoolean("IsLogged", false).apply()
        }
    }
}