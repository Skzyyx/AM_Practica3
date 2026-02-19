package mx.edu.itson.practica3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductsActivity : AppCompatActivity() {

    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        // 1. Obtener el tipo de menú enviado por el Intent
        val menuOption: String? = intent.getStringExtra("menuType")

        // 2. Referenciar el ImageView del encabezado y el ListView
        val imageHeader: ImageView = findViewById(R.id.title)
        val listview: ListView = findViewById(R.id.list_view)

        // 3. Cambiar la imagen del cartel/encabezado dinámicamente
        when (menuOption) {
            "Antojitos" -> imageHeader.setImageResource(R.drawable.antojitos)
            "Especialidades" -> imageHeader.setImageResource(R.drawable.especialidades)
            "Combinaciones" -> imageHeader.setImageResource(R.drawable.combinations)
            "Tortas" -> imageHeader.setImageResource(R.drawable.tortas)
            "Sopas" -> imageHeader.setImageResource(R.drawable.sopas)
            "Bebidas" -> imageHeader.setImageResource(R.drawable.drinks)
        }

        // 4. Llenar la lista de productos y configurar el adaptador
        addProducts(menuOption)
        val adaptador: AdaptadorProductos = AdaptadorProductos(this, menu)
        listview.adapter = adaptador

        // Configuración de Insets para el diseño Edge-to-Edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun addProducts(option: String?) {
        when (option) {
            "Antojitos" -> {
                menu.add(Product("Quesadillas", R.drawable.quesadillas, "Rellenas con su carne favorita, servidas con ensalada.", 6.29))
                menu.add(Product("Huaraches", R.drawable.huaraches, "Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema.", 11.49))
                menu.add(Product("Gringas", R.drawable.gringas, "Tortilla de harina con queso, carne al pastor y piña.", 8.39))
                menu.add(Product("Sincronizada", R.drawable.sincronizadas, "Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole.", 7.99))
                menu.add(Product("Sopes", R.drawable.sopes, "Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema.", 3.99))
                menu.add(Product("Tostadas", R.drawable.tostadas, "Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate.", 4.59))
            }
            "Especialidades" -> {
                menu.add(Product("Mojarra Frita", R.drawable.mojarra, "Tilapia frita servida con lechuga, cebolla, jitomate, aguacate y tortillas.", 17.99))
                menu.add(Product("Ceviche", R.drawable.ceviche, "Tilapia, camarones, aguacate y pico de gallo servido con chips.", 6.99))
                menu.add(Product("Botana De Camarones Al Mojo de Ajo", R.drawable.botanacamarones, "", 19.99))
                menu.add(Product("Coctel de Camarón", R.drawable.coctel, "Camarón,pulpo, pico de gallo, aguacate, limón and salsa de coctel. Servida fría.", 17.99))
            }
            "Combinaciones" -> {
                menu.add(Product("Traditional Taco Combo", R.drawable.combinationtaco, "Tortilla de maíz y tu carne favorita. Servido con arroz y frijoles.", 6.99))
                menu.add(Product("Mexican Burritos", R.drawable.cominationburros, "Tu carne favorita en una tortilla grande de harina rellena con cebolla frita, pico de gallo, sour cream, frijoles y acompañado de arroz.", 13.69))
                menu.add(Product("Los Portales Burrito", R.drawable.burritosportales, "Large flour tortilla filled with grilled cactus, steak, pastor (seasoned pork), grilled onions, rice and beans.", 14.59))
                menu.add(Product("Cinco", R.drawable.cinco, "One hard sell taco with your choice of meat, lettuce and cheese.", 10.99))
                menu.add(Product("Dos Amigos", R.drawable.dosamigos, "Two hard shell tacos with your choice of meat topped with lettuce and shredded cheese.", 10.99))
                menu.add(Product("Burrito Pepe", R.drawable.burritopepe, "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo.", 10.99))
                menu.add(Product("Fajita Quesadilla", R.drawable.fajitaquesadilla, "Flour tortilla filled with your choice of meat with beans, lettuce, sour cream, guacamole and pico de gallo.", 10.99))
            }
            "Tortas" -> {
                menu.add(Product("Torta Regular", R.drawable.torta, "All tortas come with lettuce, onions, tomatoes, avocado, sour cream, jalapeno pepper and your choice of meat.", 13.39))
                menu.add(Product("Milanesa de Pollo Torta", R.drawable.tortamilanesa, "Chicken", 13.99))
                menu.add(Product("Torta Cubana", R.drawable.tortacubana, "Chorizo, asada, jamon, pastor y queso.", 14.49))
                menu.add(Product("Torta Mixta", R.drawable.tortamixta, "Chorizo, asada, y pastor.", 13.99))
                menu.add(Product("Small Mexican Torta", R.drawable.smallmexican, "Chorizo, asada, y pastor.", 13.99))
            }
            "Sopas" -> {
                menu.add(Product("Caldo de Res", R.drawable.caldores, "Beef ribs and chuck stew with corn, potato, chayote (squash family), cabage, cilantro, onion, zuccini, carrots, lime, and tortillas.", 8.39))
                menu.add(Product("Pozole", R.drawable.pozole, "Pork ribs and bonston butt stew with homminy and oregano.", 7.99))
                menu.add(Product("Menudo", R.drawable.menudo, "Ancestral broth, silky tripe, come together in a bowl that tastes like Sunday mornings, family kitchens, and stories passed down through generations.", 13.99))
                menu.add(Product("Caldo de Camarón", R.drawable.caldocamaron, "Shrimp soup.", 13.99))
                menu.add(Product("Sopa de Mariscos", R.drawable.sopamariscos, "Seafood soup.", 13.99))
            }
            "Bebidas" -> {
                menu.add(Product("Jarritos", R.drawable.jarritos, "", 2.75))
                menu.add(Product("Cerveza", R.drawable.domesticbeer, "", 5.49))
                menu.add(Product("Caguama", R.drawable.caguama, "", 5.49))
                menu.add(Product("Caguama Michelada", R.drawable.caguamamichelada, "", 5.49))
                menu.add(Product("Sodas", R.drawable.sodas, "", 2.49))
                menu.add(Product("Michelada", R.drawable.michelada, "", 5.49))
                menu.add(Product("Cubetazo", R.drawable.cubetazo, "", 5.49))
                menu.add(Product("Cubeta Six", R.drawable.cubetasix, "", 5.49))
            }
        }
    }

    private class AdaptadorProductos(var contexto: Context, var productos: ArrayList<Product>) : BaseAdapter() {

        override fun getCount(): Int = productos.size

        override fun getItem(position: Int): Any = productos[position]

        override fun getItemId(position: Int): Long = position.toLong()

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val producto = productos[position]
            val inflador = LayoutInflater.from(contexto)
            val vista = convertView ?: inflador.inflate(R.layout.product_view, parent, false)

            val imagen = vista.findViewById<ImageView>(R.id.product_img)
            val nombre = vista.findViewById<TextView>(R.id.product_name)
            val desc = vista.findViewById<TextView>(R.id.product_description)
            val precio = vista.findViewById<TextView>(R.id.product_price)

            imagen.setImageResource(producto.image)
            nombre.text = producto.name
            desc.text = producto.description
            precio.text = "$${producto.price}"

            return vista
        }
    }
}