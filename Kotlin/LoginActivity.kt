package aliensoft.cl.codesnippets

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private var sharedPrefs: SharedPrefs? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //instantiate shared prefs
        sharedPrefs = SharedPrefs(this)

        //References to views
        var editTextUsername = findViewById<EditText>(R.id.et_user_name)
        var editTextPassword = findViewById<EditText>(R.id.et_password)
        var btnReset = findViewById<Button>(R.id.btn_reset)
        var btnSubmit = findViewById<Button>(R.id.btn_submit)

        btnReset.setOnClickListener {

            //Reset username and pass after reset click button
            editTextUsername.setText("")
            editTextPassword.setText("")

        }

        // Submit button onclick listener
        btnSubmit.setOnClickListener {

            val username: String = editTextUsername.text.toString()
            val password: String = editTextPassword.text.toString()

            Toast.makeText(this@LoginActivity, "Logging... " + username, Toast.LENGTH_LONG).show()

            //verify user and pass, here we can use db or endpoint
            if(username.equals("juanlabrin") && password.equals("password")){

                //Is validation is ok, set session variable in sharedpref file and init new activity or fragment
                sharedPrefs!!.username = username
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                //Wrong credentials
                Toast.makeText(this@LoginActivity, "Wrong credentials!", Toast.LENGTH_LONG).show()

            }

        }

    }
}
