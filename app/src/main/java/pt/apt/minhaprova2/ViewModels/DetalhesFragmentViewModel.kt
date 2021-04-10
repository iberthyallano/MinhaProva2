package pt.apt.minhaprova2.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import pt.apt.minhaprova2.DataBase.AppDatabase
import pt.apt.minhaprova2.DataBase.Personagem

class DetalhesFragmentViewModel(application: Application): AndroidViewModel(application) {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "Personagem.sqlite")
            .allowMainThreadQueries()
            .build()
    }

    var imagem: ByteArray? = null;
    var nome: String = "";
    var poder: String = "";
    var ataque: Float = 0.0f;
    var defesa: Float = 0.0f;
    var heroi: Boolean? = null;
    var descricao: String = "";

    fun setDados(id : Long){
        val personagem = db.personagemDao().findById(id);

        imagem = personagem.imagem;
        nome = personagem.nome;
        poder = personagem.poder;
        ataque = personagem.ataque;
        defesa = personagem.defesa;
        heroi = personagem.heroi;
        descricao  = personagem.descricao;
    }

}