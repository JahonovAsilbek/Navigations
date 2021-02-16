package uz.revolution.navigationumsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarif.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Daqiqa
import uz.revolution.navigationumsapp.models.Internet
import uz.revolution.navigationumsapp.models.Tarif

class InternetAdapter(var data:ArrayList<Internet>):RecyclerView.Adapter<InternetAdapter.VH>() {

    private var onItemClickListener: OnItemClickListener? = null

    inner class VH(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(internet: Internet) {

            itemView.name.text=internet.name
            itemView.code.text=internet.code
            itemView.description.text=internet.description

            itemView.setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener?.onClick(internet)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_internet, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener {
        fun onClick(internet: Internet)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}