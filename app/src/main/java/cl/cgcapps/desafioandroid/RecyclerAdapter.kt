package cl.cgcapps.desafioandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cl.cgcapps.desafioandroid.data.AllIndicatorsResponse

class RecyclerAdapter(private val indicatorList: List<AllIndicatorsResponse.Indicator>,
private val listener : OnItemClickListener
): RecyclerView.Adapter<RecyclerAdapter.IndicatorViewHolder>() {

    inner class IndicatorViewHolder (view: View?):RecyclerView.ViewHolder(view!!),
        View.OnClickListener {
        val name: TextView = view!!.findViewById(R.id.name)
        val value: TextView = view!!.findViewById(R.id.value)


        init {
            view?.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position:Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.indicator_layout,parent,false)
        return IndicatorViewHolder(view)
    }

    override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
        holder.name.text = indicatorList[position].nombre
        holder.value.text = indicatorList[position].valor.toString()
    }

    override fun getItemCount(): Int {
        return indicatorList.size
    }

}
