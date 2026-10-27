package com.example.petagram

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MascotaAdapter(
    private val mascotas: List<Mascota>,
    private val permitirLike: Boolean = true
) : RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>() {

    // ViewHolder
    class MascotaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fondoFoto: FrameLayout = itemView.findViewById(R.id.fondoFoto)
        val imgFoto: ImageView = itemView.findViewById(R.id.imgFoto)
        val tvNombre: TextView = itemView.findViewById(R.id.tvNombre)
        val tvRating: TextView = itemView.findViewById(R.id.tvRating)
        val btnLike: ImageButton = itemView.findViewById(R.id.btnLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaViewHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
        return MascotaViewHolder(vista)
    }

    override fun getItemCount(): Int = mascotas.size

    override fun onBindViewHolder(holder: MascotaViewHolder, position: Int) {
        val mascota = mascotas[position]
        holder.fondoFoto.setBackgroundColor(mascota.colorFondo)
        holder.imgFoto.setImageResource(mascota.foto)
        holder.tvNombre.text = mascota.nombre
        holder.tvRating.text = mascota.rating.toString()

        if (permitirLike) {
            holder.btnLike.setOnClickListener {
                mascota.rating++
                holder.tvRating.text = mascota.rating.toString()
            }
        } else {
            holder.btnLike.setOnClickListener(null)
        }
    }
}