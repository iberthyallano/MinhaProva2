package pt.apt.minhaprova2.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import pt.apt.minhaprova2.DataBase.Personagem
import pt.apt.minhaprova2.R
import pt.apt.minhaprova2.ViewModels.CadastraFragmentViewModel
import pt.apt.minhaprova2.databinding.FragmentCadastraBinding

class CadastraFragment : Fragment() {

    lateinit var binding: FragmentCadastraBinding;
    lateinit var cadastraFragmentViewModel: CadastraFragmentViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false);
        cadastraFragmentViewModel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java);

        binding.buttonCadastrar.setOnClickListener {
            cadastraFragmentViewModel.nome = binding.editTextTextNome.text.toString();
            cadastraFragmentViewModel.interprete = binding.editTextTextInterprete.text.toString();
            cadastraFragmentViewModel.filme = binding.editTextTextFilme.text.toString();
            cadastraFragmentViewModel.descricao = binding.editTextTextDescricao.text.toString();
            cadastraFragmentViewModel.cadastraDados(Personagem(cadastraFragmentViewModel.nome, cadastraFragmentViewModel.interprete, cadastraFragmentViewModel.filme, cadastraFragmentViewModel.descricao));
            Navigation.findNavController(it).navigate(CadastraFragmentDirections.actionCadastraFragmentToHomeFragment());
        }

        binding.imageView.setOnClickListener {
            Toast.makeText(context, "ainda implementando o inserir imagens", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true);

        return binding.root;
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.cadastramenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}