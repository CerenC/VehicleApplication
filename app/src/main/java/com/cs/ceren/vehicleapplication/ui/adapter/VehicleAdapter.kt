package com.cs.ceren.vehicleapplication.ui.adapter

import android.content.Context
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cs.ceren.vehicleapplication.R
import com.cs.ceren.vehicleapplication.data.remote.model.Vehicle
import com.cs.ceren.vehicleapplication.ui.util.VehicleDiffUtil
import kotlinx.android.synthetic.main.list_item_vehicle.view.*

class VehicleAdapter(context: Context) : RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder>() {
    private val list: ArrayList<Vehicle> = ArrayList()
    internal var listener: ItemTouchListener

    init {
        listener = context as ItemTouchListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, view: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_vehicle, parent, false)
        return VehicleViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun setList(newList: List<Vehicle>) {
        val diffResult = DiffUtil.calculateDiff(VehicleDiffUtil(newList, list))
        diffResult.dispatchUpdatesTo(this)
        list.clear()
        list.addAll(newList)
    }

    inner class VehicleViewHolder(itemView: View, listener: ItemTouchListener) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Vehicle) {
            itemView.setOnClickListener { listener.onItemClick(item) }
            itemView.vehicleName.text = item.vrn
        }
    }

    interface ItemTouchListener {
        fun onItemClick(item: Vehicle)
    }

}