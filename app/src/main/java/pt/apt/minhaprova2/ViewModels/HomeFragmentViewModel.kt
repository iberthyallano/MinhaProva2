package pt.apt.minhaprova2.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import pt.apt.minhaprova2.DataBase.AppDatabase
import pt.apt.minhaprova2.DataBase.Personagem

class HomeFragmentViewModel(application: Application): AndroidViewModel(application) {
    var lista:LiveData<List<Personagem>> ?= null;

    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "Personagem.sqlite")
                .allowMainThreadQueries()
                .build()
        }
//        db.personagemDao().inserir(Personagem("teste" , "teste", "teste", "teste"));
        lista = db.personagemDao().listAll();
    }
}