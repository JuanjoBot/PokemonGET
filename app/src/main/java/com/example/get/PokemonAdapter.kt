package com.example.get

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.get.databinding.ItemPokemonBinding
import org.json.JSONArray
import org.json.JSONObject

class PokemonAdapter (private val pokemons: JSONArray): RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): PokemonAdapter.PokemonHolder {
        val binding = ItemPokemonBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonHolder, position: Int) {
        holder.render(pokemons.getJSONObject(position))
    }

    override fun getItemCount(): Int = pokemons.length()

    class PokemonHolder (val binding: ItemPokemonBinding): RecyclerView.ViewHolder(binding.root){
        fun render(pokemon: JSONObject){
            binding.tvNomPokemon.setText(pokemon.getString("name"))
        }
    }

}