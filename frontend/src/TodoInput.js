import React, { useState } from 'react';
import './App.css';
import TodoApi from './services/TodoApi';

function TodoInput({ tasks, setTasks }) {
  const [newTask, setNewTask] = useState('');
  const [error, setError] = useState(null);

  const TaskOnChange = (event) => {
    setNewTask(event.target.value);
  };

  const addTask = async (event) => {
    event.preventDefault();

    setError(null);

    try {
      const todoApi = new TodoApi();
      const response = await todoApi.todoApiCreate({ todoContent: newTask }); // Veriyi doğru bir şekilde gönderin
      setTasks([...tasks, response.data]); // Yeni görevi state'e ekleyin
      setNewTask(''); // Girdiyi temizleyin

      // Sayfayı yenile
      window.location.reload();
    } catch (err) {
      setError(err.response?.data?.validationErrors || 'Bir hata oluştu');
    }
  };

  return (
    <div className='App'>
      <h1>TodoInput</h1>
      <div className='border border-secondary todoInput bg-primary d-flex flex-column justify-content-center align-items-center'>
        <input
          type='text'
          className='form-control'
          placeholder={'Enter a todo'}
          value={newTask} // value'yu ekleyin
          onChange={TaskOnChange}
        />
        <button type='button' className='btn btn-success w-full mt-2' onClick={addTask}>
          Add New Task
        </button>
      </div>
      {error && <div className='text-danger'>{error}</div>}
    </div>
  );
}

export default TodoInput;
