package com.android.andersenrecycleview

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.android.andersenfragments.R
import com.android.andersenfragments.databinding.FragmentListBinding

const val UID_EXTRA = "UID_EXTRA"

class ListFragment : Fragment() {

    interface OnListItemClickListener {
        fun onItemClicked(contact: Contact)
    }

    private lateinit var onListItemClickListener: OnListItemClickListener

    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding
        get() = _binding!!

    private lateinit var adapter: ContactAdapter
    private var searchRequest: String = ""

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onListItemClickListener = context as OnListItemClickListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ContactAdapter(
            DataBase.getContacts(),
            requireContext(), {
                onListItemClickListener.onItemClicked(it)
            })

        setHasOptionsMenu(true)

        Log.d("afteradapter", searchRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_view_layout, menu)

        val searchItem: MenuItem = menu.findItem(R.id.menu_item_search)
        val searchView = searchItem.actionView as SearchView

        searchView.apply {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(queryText: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(queryText: String): Boolean {
                    val filteredData = DataBase.getContactsByQuery(queryText)
                    adapter.setContacts(filteredData)
                    return true
                }
            })
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBinding.inflate(inflater, container, false).also {
            _binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
            recyclerView.adapter = adapter

            // ну что же сеточку я нарисовал
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    GridLayoutManager.HORIZONTAL
                )
            )
            recyclerView.addItemDecoration(
                DividerItemDecoration(
                    recyclerView.context,
                    GridLayoutManager.VERTICAL
                )
            )
        }
    }

    companion object {
        fun newInstance() = ListFragment()
    }
}