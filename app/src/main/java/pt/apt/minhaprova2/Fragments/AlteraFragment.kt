package pt.apt.minhaprova2.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import pt.apt.minhaprova2.DataBase.Personagem
import pt.apt.minhaprova2.R
import pt.apt.minhaprova2.ViewModels.AlteraFragmentViewModel
import pt.apt.minhaprova2.ViewModels.CadastraFragmentViewModel
import pt.apt.minhaprova2.databinding.FragmentAlteraBinding
import pt.apt.minhaprova2.databinding.FragmentCadastraBinding


class AlteraFragment : Fragment() {

    lateinit var binding: FragmentAlteraBinding;
    lateinit var alteraFragmentViewModel: AlteraFragmentViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false);
        alteraFragmentViewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java);

        val args:AlteraFragmentArgs by navArgs();
        alteraFragmentViewModel.setDados(args.id);

        binding.apply{
            editTextTextNome.setText(alteraFragmentViewModel.nome);
            editTextTextInterprete.setText(alteraFragmentViewModel.interprete);
            editTextTextFilme.setText(alteraFragmentViewModel.filme)
            editTextTextDescricao.setText(alteraFragmentViewModel.descricao);
        }

        binding.buttonCadastrar.setOnClickListener {
            alteraFragmentViewModel.nome = binding.editTextTextNome.text.toString();
            alteraFragmentViewModel.interprete = binding.editTextTextInterprete.text.toString();
            alteraFragmentViewModel.filme = binding.editTextTextFilme.text.toString();
            alteraFragmentViewModel.descricao = binding.editTextTextDescricao.text.toString();
            var personagem = Personagem(alteraFragmentViewModel.nome, alteraFragmentViewModel.interprete, alteraFragmentViewModel.filme, alteraFragmentViewModel.descricao);
            personagem.id = args.id.toInt();
            personagem.imagem = null;
            alteraFragmentViewModel.AlteraDados(personagem);
            Navigation.findNavController(it).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment());
        }

        binding.imageView.setOnClickListener {
            Toast.makeText(context, "ainda implementando o inserir imagens", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true);

        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.optionsmenus, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
    
}