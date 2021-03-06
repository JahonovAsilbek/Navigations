package uz.revolution.navigationumsapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_tarif.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.models.Daqiqa
import uz.revolution.navigationumsapp.models.Sms
import uz.revolution.navigationumsapp.models.Tarif

class SmsAdapter(var data:ArrayList<Sms>):RecyclerView.Adapter<SmsAdapter.VH>() {

    private var onItemClickListener: OnItemClickListener? = null

    inner class VH(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(sms: Sms) {

            itemView.name.text=sms.name
            itemView.code.text=sms.code
            itemView.description.text=sms.description

            itemView.setOnClickListener {
                if (onItemClickListener != null) {
                    onItemClickListener?.onClick(sms)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_sms, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface OnItemClickListener {
        fun onClick(sms: Sms)
    }

    fun setOnClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }
}