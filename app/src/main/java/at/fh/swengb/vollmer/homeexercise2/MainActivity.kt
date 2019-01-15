package at.fh.swengb.vollmer.homeexercise2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSharedPreferences(packageName, Context.MODE_PRIVATE) // from within activity
        /*        val intent = Intent(this, UserDataActivity::class.java)
        startActivity(intent)
*/

    }
   /* var name = "Anonymous"
    var age = "noAge"
            if (name.text.isEmpty()){
            var name = "Anonymous"
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("MY_KEY_FOR_STRING", name).apply()
            sharedPreferences.edit().putString("MY_KEY_FOR_INT", age.text.toString()).apply()

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
        }
    */

    fun saveName(v:View){
            val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
            sharedPreferences.edit().putString("MY_KEY_FOR_STRING", name.text.toString()).apply()
            sharedPreferences.edit().putString("MY_KEY_FOR_INT", age.text.toString()).apply()

            val intent = Intent(this, NoteListActivity::class.java)
            startActivity(intent)
    }
}




