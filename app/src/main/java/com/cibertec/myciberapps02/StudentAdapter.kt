package com.cibertec.myciberapps02

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class StudentAdapter(private val studentList: List<Student>) :
    RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(itemView)
    }

    override
    fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }

    override fun getItemCount() = studentList.size
}

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageViewPhoto: ImageView = itemView.findViewById(R.id.imgPhoto)
    val textViewName: TextView = itemView.findViewById(R.id.tvName)
    val textViewLastName: TextView = itemView.findViewById(R.id.tvLastName)

    fun bind(item: Student) {
        textViewName.text = item.name
        textViewLastName.text = item.lastName

        Glide.with(itemView.context)
            .load(item.photo)
            .into(imageViewPhoto)
    }
}