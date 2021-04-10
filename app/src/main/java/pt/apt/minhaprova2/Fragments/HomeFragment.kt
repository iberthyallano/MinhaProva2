package pt.apt.minhaprova2.Fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import pt.apt.minhaprova2.Assets.MyRecyclerViewClickListener
import pt.apt.minhaprova2.Assets.PersonagemAdapter
import pt.apt.minhaprova2.R
import pt.apt.minhaprova2.ViewModels.HomeFragmentViewModel
import pt.apt.minhaprova2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding;
    lateinit var homeFragmentViewModel: HomeFragmentViewModel;

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeFragmentViewModel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java);

        val personagemAdapter = PersonagemAdapter();
        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false);

        binding.recyclerView.adapter = personagemAdapter;
        binding.recyclerView.layoutManager = layout;

        setHasOptionsMenu(true);

        homeFragmentViewModel.lista?.observe(viewLifecycleOwner, {
            personagemAdapter.listaPersonagem = it;
            personagemAdapter.notifyDataSetChanged();
        });

        binding.recyclerView.addOnItemTouchListener(MyRecyclerViewClickListener(requireContext(),  binding.recyclerView,
                object : MyRecyclerViewClickListener.OnItemClickListener{
                    override fun onItemClick(view: View, position: Int) {
                       Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(personagemAdapter.listaPersonagem[position].id.toLong()));
                    }

                    override fun onItemLongClick(view: View, position: Int) {
                        Navigation.findNavController(view).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(personagemAdapter.listaPersonagem[position].id.toLong()));
                    }
                }))

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