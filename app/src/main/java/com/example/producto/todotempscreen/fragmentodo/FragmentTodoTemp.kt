package com.example.producto.todotempscreen.fragmentodo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.producto.MainActivityVM
import com.example.producto.MainActivityVMF
import com.example.producto.R
import com.example.producto.database.ProductoDB
import com.example.producto.database.RepositoryProducto
import com.example.producto.databinding.FragmentTodoTempBinding
import com.example.producto.todotempscreen.adddialog.DialogFragment_Add


class FragmentTodoTemp : Fragment(R.layout.fragment_todo_temp) {
    private lateinit var binding: FragmentTodoTempBinding
    private lateinit var dialogBox_Add: DialogFragment_Add
    private lateinit var viewModel:FragmentTodoTempVM
    private lateinit var viewModelFactory: FragmentTodoTempVMF
    private lateinit var adapter: TodoRCV
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoTempBinding.inflate(inflater,container, false)
        binding.floatingActionButton.setOnClickListener{
            dialogBox_Add =
                DialogFragment_Add()
//            dialogBox_Add.show(getFragmentManager()!!,"My Tag")
            dialogBox_Add.show(fragmentManager!!,"My Tag")
        }
        //Database Initialise
        val application = requireNotNull(activity).application
        val datebase = ProductoDB.getInstance(application)
        val repository = RepositoryProducto(datebase)
        //View Model
        viewModelFactory = FragmentTodoTempVMF(repository)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(FragmentTodoTempVM::class.java)
       //Recycler View
        adapter = TodoRCV()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //Live DAta Observation
        viewModel.getalltodos().observe(this, Observer {
            adapter.dataTrigger(it)
        })
        return binding.root
    }



}