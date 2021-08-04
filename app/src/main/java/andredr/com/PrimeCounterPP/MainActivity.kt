package andredr.com.PrimeCounterPP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import andredr.com.PrimeCounterPP.databinding.ActivityMainBinding
import android.view.View
import android.widget.Button
import android.widget.EditText



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var button: Button
    private lateinit var result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        result = findViewById(R.id.result)

        button = findViewById(R.id.buttonCalc)
        button.setOnClickListener {
            calculateSieve(it)
        }



    }


    fun calculateSieve(view: View) {
        val numberSelect = findViewById<EditText>(R.id.numberLimit)
        val limit =  numberSelect.text.toString().toLongOrNull()

        if (limit == null) {
            result.text = "Value too large for long."
            result.visibility = View.VISIBLE
            return
        }



        val count = sieve(limit)
        if (count == -1) {
            result.text = "Error on malloc (no sufficient memory)."
            result.visibility = View.VISIBLE
            return
        }




        //result.text = stringFromJNI()
        result.text = "There are: $count Primes."
        result.visibility = View.VISIBLE

    }

    /**
     * A native method that is implemented by the 'cpptestapplication' native library,
     * which is packaged with this application.
     */
    external fun sieve(limit: Long): Int

    companion object {
        // Used to load the 'cpptestapplication' library on application startup.
        init {
            System.loadLibrary("primecpp")
        }
    }
}