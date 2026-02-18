package mx.edu.itson.practica3

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var listView: ListView = findViewById(R.id.litview) as ListView

        var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listView.adapter = adaptador

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private class AdaptadorProductos: BaseAdapter {
        var productos = ArrayList<Product>()
        var contexto: Context?= null

        constructor(contexto: Context, productos: ArrayList<Product>) {
            this.productos = productos
            this.contexto = contexto
        }

        override fun getCount(): Int {
            return productos.size
        }

        override fun getItem(position: Int): Any? {
            return productos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {

            var prod = productos[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.producto_view, null)

            var imagen = vista.findViewById(R.id.producto_img) as ImageView
            var nombre = vista.findViewById(R.id.producto_nombre) as TextView
            var desc = vista.findViewById(R.id.producto_desc) as TextView
            var precio = vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
    fun agregarProductos(option:String?) {

        when(option) {

            "Anotojitos" -> {
                menu.add(Product(
                    name = "Quesadillas",
                    image = R.drawable.quesadillas,
                    description = "Rellenas con su carne favorita, servidas con ensalada.",
                    price = 5.99
                ))
                menu.add(Product(
                    name = "Huaraches",
                    image = R.drawable.huaraches,
                    description = "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema.",
                    price = 10.99
                ))
                menu.add(Product(
                    name = "Gringas",
                    image = R.drawable.gringas,
                    description = "Tortilla de harina con queso, carne al pastor y piña.",
                    price = 7.99
                ))
                menu.add(Product(
                    name = "Sincronizadas",
                    image = R.drawable.sincronizadas,
                    description = "Tortilla de harina rellena con queso y jamón, acompañada de lechuga, crema y guacamole.",
                    price = 7.99
                ))
                menu.add(Product(
                    name = "Sopes",
                    image = R.drawable.sopes,
                    description = "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema.",
                    price = 3.79
                ))
                menu.add(Product(
                    name = "Tostadas",
                    image = R.drawable.tostadas,
                    description = "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate.",
                    price = 4.59
                ))
            }

            "Especialidades" -> {

            }
        }

    }

}