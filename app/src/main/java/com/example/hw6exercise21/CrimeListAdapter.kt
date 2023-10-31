package com.example.hw6exercise21

import android.view.LayoutInflater
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.hw6exercise21.databinding.ListItemCrimeBinding
import com.example.hw6exercise21.databinding.ListItemCrimeNewBinding


class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    class PoliceHolder(

        private val binding: ListItemCrimeNewBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(crime: Crime) {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()

            binding.root.setOnClickListener {

                Toast.makeText(

                    binding.root.context,

                    "${crime.title} clicked!",

                    Toast.LENGTH_SHORT

                ).show()

            }



            binding.RequiresPolice.setOnClickListener {

                Toast.makeText(

                    binding.root.context,

                    // Make the entire toast capitalized to emphasize intensity

                    "POLICE CONTACTED REGARDING ${crime.title.uppercase()}!",

                    Toast.LENGTH_SHORT

                ).show()

            }

        }

    }
}

class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
}


class CrimeListAdapter2(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder.PoliceHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder.PoliceHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeNewBinding.inflate(inflater, parent, false)
        return CrimeHolder.PoliceHolder(binding)
    }

    override fun onBindViewHolder(holder: CrimeHolder.PoliceHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size
}
