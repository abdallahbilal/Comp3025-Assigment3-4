package ca.georgiancollege.assignment3

import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//This is the viewModel class

class TaskViewModel : ViewModel()
{
    private val dataManager = DataManager.instance()
    private val m_tasks = MutableLiveData<List<Task>>()
    val tasks: LiveData<List<Task>> get() = m_tasks
    private val m_task = MutableLiveData<Task?>()
    val task: LiveData<Task?> get() = m_task

    fun loadAllTasks() {
        viewModelScope.launch {
            m_tasks.value = dataManager.getAllTasks()
        }
    }

    fun loadTasksById(id: String) {
        viewModelScope.launch {
            m_task.value = dataManager.getTaskById(id)
        }
    }

    fun saveTask(task: Task) {
        viewModelScope.launch {
            if (task.id.isEmpty()) {
                dataManager.insert(task)
            } else {
                dataManager.update(task)
            }
            loadAllTasks()
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            dataManager.delete(task)
            loadAllTasks()
        }
    }
    }