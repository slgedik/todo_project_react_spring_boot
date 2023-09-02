import React, { useState } from 'react';
import './App.css';
import TodoInput from './TodoInput';
import TodoMenu from './TodoMenu';
import TodoList from './TodoList';

function App() {
  const [tasks, setTasks] = useState([]);
  const [filter, setFilter] = useState('all');

  return (
    <div className='App'>
      <div>
        <TodoInput tasks={tasks} setTasks={setTasks} />
        <TodoMenu filter={filter} setFilter={setFilter} />
      </div>

      <TodoList setFilter={filter} setTasks={setTasks} />
    </div>
  );
}

export default App;
