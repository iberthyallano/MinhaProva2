package pt.apt.minhaprova2.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Personagem(
        var nome: String,
        var interprete: String,
        var filme: String,
        var descricao: String) {

    @PrimaryKey(autoGenerate = true)
    var id = 0;
    var imagem: ByteArray? = null;
}