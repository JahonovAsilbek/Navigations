package uz.revolution.navigationumsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarif.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Daqiqa
import uz.revolution.navigationumsapp.models.Tarif

class DaqiqaAdapter(var data:ArrayList<Daqiqa>):RecyclerView.Adapter<DaqiqaAdapter.VH>() {

    private var onItemClickListener: OnItemClickListener? = null

    inner class VH(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(daqiqa: Daqiqa) {

            itemView.name.text=daqiqa.name
            itemView.code.text=daqiqa.code
            itemView.description.text=daqiqa.description

            itemView.setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener?.onClick(daqiqa)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_daqiqa, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener {
        fun onClick(daqiqa: Daqiqa)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}