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
import pt.apt.minhaprova2.ViewModels.DetalhesFragmentViewModel
import pt.apt.minhaprova2.databinding.FragmentAlteraBinding
import pt.apt.minhaprova2.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {
    lateinit var binding: FragmentDetalhesBinding;

    lateinit var detalhesFragmentViewModel: DetalhesFragmentViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false);
        detalhesFragmentViewModel = ViewModelProvider(this).get(DetalhesFragmentViewModel::class.java);

        val args:AlteraFragmentArgs by navArgs();
        detalhesFragmentViewModel.setDados(args.id);

        binding.apply{
            textViewNomePersonagem.text = detalhesFragmentViewModel.nome;
            textViewInterpretePersonagem.text = detalhesFragmentViewModel.interprete;
            textViewFilmePersonagem.text = detalhesFragmentViewModel.filme;
            textViewDescricaoPersonagem.text = detalhesFragmentViewModel.descricao;
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