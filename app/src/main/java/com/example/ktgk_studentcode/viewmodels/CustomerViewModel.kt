package com.example.ktgk_studentcode.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktgk_studentcode.database.Customer
import com.example.ktgk_studentcode.database.CustomerDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CustomerViewModel @Inject constructor(application: Application) : AndroidViewModel(application) {
    private val customerDao = CustomerDB.getDatabase(application).customerDao()
    private val _customers = MutableStateFlow<List<Customer>>(emptyList())
    val customers: StateFlow<List<Customer>> = _customers

    init {
        fetchCustomers()
    }

    private fun fetchCustomers() {
        viewModelScope.launch {
            try {
                customerDao.getAllCustomer().collectLatest { customerList ->
                    _customers.value = customerList
                    Log.d("CustomerViewModel", "Fetched ${customerList.size} customers")
                }
            } catch (e: Exception) {
                Log.e("CustomerViewModel", "Error fetching customers", e)
            }
        }
    }


    fun insertCustomer(name: String, email: String, phone: String) {
        viewModelScope.launch {
            customerDao.insert(Customer(name = name, email = email, phoneNumber = phone))
            fetchCustomers()
        }
    }

    fun updateCustomer(customer: Customer) {
        viewModelScope.launch {
            customerDao.update(customer)
            fetchCustomers()
        }
    }

    fun deleteCustomer(customer: Customer) {
        viewModelScope.launch {
            customerDao.delete(customer)
            fetchCustomers()
        }
    }
}
