package net.csolorzano.clase6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.csolorzano.clase6.model.AgenteUIModel
import net.csolorzano.clase6.model.Genero
import net.csolorzano.clase6.model.Raza

class MainActivity : AppCompatActivity() {
    private val recyclerView : RecyclerView by lazy { findViewById(R.id.rcvAgente) }
    private val adaptador : AgenteAdapter by lazy {
        AgenteAdapter(layoutInflater, GlideImageLoader(this),
            object :
            AgenteAdapter.OnClickListener{
                override fun onItemClick(datos: AgenteUIModel) {
                    mostrarSeleccion(datos)
                }
            }
        )
    }

    private fun mostrarSeleccion(datos: AgenteUIModel){
        AlertDialog.Builder(this)
            .setTitle("Agente Seleccionado")
            .setMessage("Usted selecciono al agente: ${datos.nombre}")
            .setPositiveButton("OK") {_, _ ->}
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = adaptador
        recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        )

        adaptador.enlazarDato(
            listOf<AgenteUIModel>(
                AgenteUIModel(
                    Genero.Masculino,
                    Raza.CurlAmericano,
                    "Pixie",
                    "Tierno pero letal",
                    "https://cdn2.thecatapi.com/images/85i.jpg"
                ),
                AgenteUIModel(
                    Genero.Femenino,
                    Raza.PeloCortoExotico,
                    "Lilo",
                    "Uñas escondidas",
                    "https://cdn2.thecatapi.com/images/txp85Eh2D.jpg"
                ),
                AgenteUIModel(
                    Genero.Desconocido,
                    Raza.JavaneseBalines,
                    "Ojos Claros",
                    "No se sabe mucho....",
                    "https://cdn2.thecatapi.com/images/68j.jpg"
                ),
                AgenteUIModel(
                    Genero.Masculino,
                    Raza.CurlAmericano,
                    "Pixie",
                    "Tierno pero letal",
                    "https://cdn2.thecatapi.com/images/85i.jpg"
                ),
                AgenteUIModel(
                    Genero.Femenino,
                    Raza.PeloCortoExotico,
                    "Lilo",
                    "Uñas escondidas",
                    "https://cdn2.thecatapi.com/images/txp85Eh2D.jpg"
                ),
                AgenteUIModel(
                    Genero.Desconocido,
                    Raza.JavaneseBalines,
                    "Ojos Claros",
                    "No se sabe mucho....",
                    "https://cdn2.thecatapi.com/images/68j.jpg"
                ),
                AgenteUIModel(
                    Genero.Masculino,
                    Raza.CurlAmericano,
                    "Pixie",
                    "Tierno pero letal",
                    "https://cdn2.thecatapi.com/images/85i.jpg"
                ),
                AgenteUIModel(
                    Genero.Femenino,
                    Raza.PeloCortoExotico,
                    "Lilo",
                    "Uñas escondidas",
                    "https://cdn2.thecatapi.com/images/txp85Eh2D.jpg"
                ),
                AgenteUIModel(
                    Genero.Desconocido,
                    Raza.JavaneseBalines,
                    "Ojos Claros",
                    "No se sabe mucho....",
                    "https://cdn2.thecatapi.com/images/68j.jpg"
                ),
                AgenteUIModel(
                    Genero.Masculino,
                    Raza.CurlAmericano,
                    "Pixie",
                    "Tierno pero letal",
                    "https://cdn2.thecatapi.com/images/85i.jpg"
                ),
                AgenteUIModel(
                    Genero.Femenino,
                    Raza.PeloCortoExotico,
                    "Lilo",
                    "Uñas escondidas",
                    "https://cdn2.thecatapi.com/images/txp85Eh2D.jpg"
                ),
                AgenteUIModel(
                    Genero.Desconocido,
                    Raza.JavaneseBalines,
                    "Ojos Claros",
                    "No se sabe mucho....",
                    "https://cdn2.thecatapi.com/images/68j.jpg"
                )
            )
        )
    }
}