package uz.revolution.navigationumsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarif.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Tarif

class TarifAdapter(var data:ArrayList<Tarif>):RecyclerView.Adapter<TarifAdapter.VH>() {

    private var onItemClickListener: OnItemClickListener? = null

    inner class VH(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(tarif: Tarif) {

            itemView.name.text=tarif.name
            itemView.code.text=tarif.code
            itemView.description.text=tarif.description

            itemView.setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener?.onClick(tarif)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_tarif, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener {
        fun onClick(tarif: Tarif)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}