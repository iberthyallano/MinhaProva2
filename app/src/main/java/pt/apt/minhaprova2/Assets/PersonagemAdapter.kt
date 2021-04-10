package pt.apt.minhaprova2.Assets


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.apt.minhaprova2.DataBase.Personagem
import pt.apt.minhaprova2.R

class PersonagemAdapter : RecyclerView.Adapter<PersonagemViewHolder>() {

    var listaPersonagem: List<Personagem> = ArrayList();

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personagem, parent, false);
        val holder = PersonagemViewHolder(view);
        return holder;
    }

    override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
        val personagemEscolhido = listaPersonagem.get(position);

        holder.textViewNomePersonagem.text = personagemEscolhido.nome;
    }

    override fun getItemCount(): Int {
        return listaPersonagem.size
    }
}