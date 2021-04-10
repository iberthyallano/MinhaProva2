package pt.apt.minhaprova2.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PersonagemDao {
    @Insert
    fun inserir(personagem: Personagem): Long

    @Delete
    fun deletar(personagem: Personagem): Int

    @Update
    fun atualizar(personagem: Personagem)

    @Query("SELECT * FROM Personagem")
    fun listAll(): LiveData<List<Personagem>>

    @Query("SELECT * FROM Personagem WHERE id = :id")
    fun findById(id: Long): Personagem
}