package com.sv.calorieintakeapps.feature_merchantlist.presentation

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sv.calorieintakeapps.core.common.util.loadImage
import com.sv.calorieintakeapps.databinding.ItemMerchantsBinding
import com.sv.calorieintakeapps.library_common.action.Actions
import com.sv.calorieintakeapps.library_database.domain.model.Merchant

class AdapterMerchant(
    private val activity: Activity,
) :
    RecyclerView.Adapter<AdapterMerchant.ViewHolder>() {
    private val listItem = ArrayList<Merchant>()
    private val listItemFiltered = ArrayList<Merchant>()
    var data: List<Merchant>?
        get() = listItem
        @SuppressLint("NotifyDataSetChanged")
        set(listItem) {
            this.listItem.clear()
            this.listItem.addAll(listItem!!)
            listItemFiltered.clear()
            listItemFiltered.addAll(listItem)
            notifyDataSetChanged()
        }

    var countryFilterList = listOf<Merchant>()

    init {
        countryFilterList = data!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMerchantsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = countryFilterList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Actions.openMerchantMenuIntent(
                    holder.itemView.context,
                    item.id
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return countryFilterList.size
    }

    class ViewHolder(
        itemView: View, private val binding: ItemMerchantsBinding
    ) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Merchant) {

            binding.apply {
                txtName.text = item.name
                imgBanner.loadImage("https://i.imgur.com/FSGh7aS.png")
            }
        }
    }

}