package cl.cgcapps.desafioandroid

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var userName: EditText
    private lateinit var userPassword: EditText
    private lateinit var enterButton: Button
    private lateinit var sharedPref: SharedPreferences

    private val dbName: String = "LOGIN_DB"
    private val dbUserName:String = "UserName"
    private val dbUserPass:String = "UserPass"
    private val dbIsLogged:String = "IsLogged"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.userName)
        userPassword = findViewById(R.id.userPassword)
        enterButton = findViewById(R.id.enterButton)

        userName.setText(getString(R.string.demo))
        userPassword.setText(getString(R.string.demo))

        initLoginData()

        enterButton.setOnClickListener {
            val uName = this.userName.text.toString()
            val uPass = this.userPassword.text.toString()
            if (this.checkLogin(uName, uPass)) {
                with(sharedPref) {
                    edit().putBoolean(dbIsLogged, true).apply()
                }
                startActivity(Intent(
                    this,
                    HomeActivity::class.java
                ).apply{
                    putExtra(dbUserName, uName)
                })
            }
            else {
                Toast.makeText(this,"Error de acceso",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkLogin(user:String, pass:String):Boolean {
        sharedPref = getSharedPreferences(dbName, MODE_PRIVATE)
        val uName = sharedPref.getString(dbUserName,"")
        val uPass = sharedPref.getString(dbUserPass,"")
        with(sharedPref) {
            edit().putBoolean(dbIsLogged, false).apply()
        }
        Log.d("Main", "$uName $uPass // $user $pass")

        return (user == uName && uPass == pass)
    }

    private fun initLoginData() {
        sharedPref = getSharedPreferences(dbName, MODE_PRIVATE)
        with(sharedPref) {
            edit().putString(dbUserName, "demo").apply()
            edit().putString(dbUserPass, "demo").apply()
            edit().putBoolean(dbIsLogged, false).apply()
        }
    }
}