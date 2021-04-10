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
    var interprete: String = "";
    var filme: String = "";
    var descricao: String = "";

    fun setDados(id : Long){
        val personagem = db.personagemDao().findById(id);

        imagem = personagem.imagem;
        nome = personagem.nome;
        interprete = personagem.interprete;
        filme = personagem.filme;
        descricao  = personagem.descricao;
    }

}