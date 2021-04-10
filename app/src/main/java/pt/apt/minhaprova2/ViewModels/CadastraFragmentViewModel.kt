package pt.apt.minhaprova2.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import pt.apt.minhaprova2.DataBase.AppDatabase
import pt.apt.minhaprova2.DataBase.Personagem

class CadastraFragmentViewModel(application: Application): AndroidViewModel(application) {

    var imagem: ByteArray? = null;
    var nome: String = "";
    var interprete: String = "";
    var filme: String = "";
    var descricao: String = "";


    val db: AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "Personagem.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    fun cadastraDados(personagem:Personagem){
        db.personagemDao().inserir(personagem);
    }

}