package mx.edu.itson.practica3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnAntojitos : Button = findViewById<Button>(R.id.button_antojitos)
        val btnEspecialidades : Button = findViewById<Button>(R.id.button_especialidades)
        val btnCombinaciones : Button = findViewById<Button>(R.id.button_combinaciones)
        val btnTortas : Button = findViewById<Button>(R.id.button_tortas)
        val btnSopas : Button = findViewById<Button>(R.id.button_sopas)
        val btnBebidas : Button = findViewById<Button>(R.id.button_bebidas)

        btnAntojitos.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Antojitos")
            startActivity(intent)
        }

        btnEspecialidades.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Especialidades")
            startActivity(intent)
        }

        btnCombinaciones.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Combinaciones")
            startActivity(intent)
        }

        btnTortas.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Tortas")
            startActivity(intent)
        }

        btnSopas.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Sopas")
            startActivity(intent)
        }

        btnBebidas.setOnClickListener {
            val intent : Intent = Intent(this, ProductsActivity::class.java)
            intent.putExtra("menuType","Bebidas")
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}