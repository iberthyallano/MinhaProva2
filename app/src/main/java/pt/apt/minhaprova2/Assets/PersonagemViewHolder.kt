package pt.apt.minhaprova2.Assets

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.apt.minhaprova2.R

class PersonagemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val textViewNomePersonagem:TextView;

    init {
        textViewNomePersonagem = view.findViewById(R.id.nomePersonagem);
    }

}