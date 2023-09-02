import React from 'react';

function TodoMenu({ filter, setFilter }) {
  return (
    <div className='todo-menu'>
      <button class='btn btn-success ' onClick={() => setFilter('All')}>
        All
      </button>
      <button class='btn btn-success' onClick={() => setFilter('Done')}>
        Done
      </button>
      <button class='btn btn-success' onClick={() => setFilter('Todo')}>
        Todo
      </button>
    </div>
  );
}

export default TodoMenu;
