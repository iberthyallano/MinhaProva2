package pt.apt.minhaprova2.Fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.content.DialogInterface

class MyDialogFragment(): DialogFragment(){
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Cadastro\n______________________________________")
            builder.setMessage("Para realizar o cadastro é bem simples:\n" +
                    "\nPrimeiro defina a imagem do seu personagem\n" +
                    "\nDepois diga seus dados como Nome, Poder, Ataque, Defesa.\n" +
                    "\nPor fim faça uma decriação sobre ele e clicki no botão de cadastrar.")
                    .setPositiveButton("Okay",
                            DialogInterface.OnClickListener { dialog, id -> })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}