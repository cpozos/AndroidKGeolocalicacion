package com.example.geolocation

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapasAdapter (private val mContext : AppCompatActivity)
    : RecyclerView.Adapter<MapasAdapter.MyViewHolder>(){


    private var arrayList : ArrayList<Model> = ArrayList()

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val latLng = LatLng(arrayList[position].latitude, arrayList[position].longitude)

        holder.mapView.onCreate(null)
        holder.mapView.getMapAsync(OnMapReadyCallback {
            it.addMarker(MarkerOptions()
                .title(arrayList[position].username)
                .position(latLng))

            val cameraPosition = CameraPosition.builder().target(latLng).zoom(17f).build()

            it.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.custom_view, parent, false)
        return MyViewHolder(view)
    }

    fun addItem(model:Model){
        this.arrayList.add(model)
        notifyDataSetChanged()

    }

    inner class MyViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView){
        val mapView:MapView  = itemView.findViewById(R.id.map)

    }
}
