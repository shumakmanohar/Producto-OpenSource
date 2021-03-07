package com.example.producto.todotempscreen.adddialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.producto.database.ProductoDB
import com.example.producto.database.RepositoryProducto
import com.example.producto.database.TodoEntity
import com.example.producto.databinding.AdddialogboxBinding

//Dialog BOX -> ADD
class DialogFragment_Add : DialogFragment() {
    private lateinit var binding: AdddialogboxBinding
    private lateinit var viewModel: DialogFragment_ViewModel
    private lateinit var viewModelFactory: DialogFragment_VMFactory
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AdddialogboxBinding.inflate(inflater, container, false)
        //Database Initialise
        val application = requireNotNull(this.activity).application
        val datebase = ProductoDB.getInstance(application)
        val repository = RepositoryProducto(datebase)
        //ViewModel Setup
        viewModelFactory = DialogFragment_VMFactory(repository)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(DialogFragment_ViewModel::class.java)
        //Event Listener for ADD BTN
        binding.addTodoBtn.setOnClickListener {
            if (checkText(binding.editTextTodoName.text.toString())) {
                //Create Todo_Entity
                var todo = TodoEntity(
                    0,
                    binding.editTextTodoName.text.toString(),
                    false,
                    "temp_category",
                    System.currentTimeMillis()
                )
                //Save Data to DB
                viewModel.insert(todo)
                this.dismiss()
                // Making Toast
                Toast.makeText(activity,"Todo Added",Toast.LENGTH_SHORT).show()
            }
        }

        //Event Listener for CancelBTN
        binding.cancelText.setOnClickListener{
            this.dismiss()
        }

        return binding.root
    }

    //Checks if Text is Empty or Not
    fun checkText(todo: String): Boolean {
        if (todo.isNullOrBlank())
            return false // When its Null
        return true
    }
}