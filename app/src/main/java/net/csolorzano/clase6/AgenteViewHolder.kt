package net.csolorzano.clase6

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.RecyclerView
import net.csolorzano.clase6.model.AgenteUIModel
import net.csolorzano.clase6.model.Genero
import net.csolorzano.clase6.model.Raza

private val SIMB_FEM by lazy {
    HtmlCompat.fromHtml("&#9793;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private val SIMB_MAS by lazy {
    HtmlCompat.fromHtml("&#9794;", HtmlCompat.FROM_HTML_MODE_LEGACY)
}

private const val SIMB_DESC = "?"

class AgenteViewHolder(itemView: View,
                       private val imageLoader: ImageLoader,
                       private val onClickListener: OnClickListener
) : RecyclerView.ViewHolder(itemView) {
    private val txtBio : TextView by lazy { itemView.findViewById(R.id.txtBio) }
    private val txtNombre: TextView by lazy { itemView.findViewById(R.id.txtNombre) }
    private val txtGenero: TextView by lazy { itemView.findViewById(R.id.txtGenero) }
    private val txtRaza: TextView by lazy { itemView.findViewById(R.id.txtRaza) }
    private val imvFoto: ImageView by lazy { itemView.findViewById(R.id.imvAgente) }

    fun enlazarDatos(datos: AgenteUIModel){
        itemView.setOnClickListener{ onClickListener.onClick(datos)}
        imageLoader.loadImage(datos.urlImagen, imvFoto)
        txtNombre.text = datos.nombre
        txtBio.text = datos.biografia
        txtRaza.text = when(datos.raza){
            Raza.JavaneseBalines -> "Javanes Balines"
            Raza.CurlAmericano -> "Curl Americano"
            Raza.PeloCortoExotico -> "Pelo Corto Exotico"
        }

        txtGenero.text = when(datos.genero){
            Genero.Femenino -> SIMB_FEM
            Genero.Masculino -> SIMB_MAS
            Genero.Desconocido -> SIMB_DESC
        }



    }

    interface OnClickListener {
        fun onClick(datos: AgenteUIModel)
    }
}