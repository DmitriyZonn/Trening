package com.example.trening
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_item.view.*

class CountriesAdapter(private var countries: List<Country>, val navController: NavController): RecyclerView.Adapter<CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.country_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)

        holder.itemView.setOnClickListener {
            val action = CountriesFragmentDirections.actionCountriesFragmentToCountryDetailsFragment(country)
            navController.navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }

}
class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    fun bind(country: Country){
        itemView.countryNameTextView.text = country.country
        itemView.casesTextView.text = country.cases.toString()
    }
}