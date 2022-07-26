package net.csolorzano.clase6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.csolorzano.clase6.model.AgenteUIModel

class AgenteAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<AgenteViewHolder>() {

    private val datos = mutableListOf<AgenteUIModel>()

    fun enlazarDato(datosNuevos : List<AgenteUIModel>){
        datos.clear()
        datos.addAll(datosNuevos)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgenteViewHolder {
        val view = layoutInflater.inflate(R.layout.item_agente,parent, false)
        return AgenteViewHolder(view, imageLoader, object :
            AgenteViewHolder.OnClickListener{
            override fun onClick(datos: AgenteUIModel) {
                onClickListener.onItemClick(datos)
            }
            }
        )
    }

    override fun onBindViewHolder(holder: AgenteViewHolder, position: Int) {
        holder.enlazarDatos(datos[position])
    }

    override fun getItemCount(): Int {
        return datos.size
    }

    interface OnClickListener{
        fun onItemClick(datos: AgenteUIModel)
    }
}