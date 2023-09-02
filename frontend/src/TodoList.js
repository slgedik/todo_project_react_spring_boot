import React, { useState, useEffect } from 'react';
import TodoApi from './services/TodoApi';

const todoApi = new TodoApi();

function TodoList({ filter }) {
  const [tasks, setTasks] = useState([]);
  const [editingIndex, setEditingIndex] = useState(-1);
  const [editedText, setEditedText] = useState('');

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Verileri API'den çekme
    todoApi
      .todoApiList()
      .then((response) => {
        setTasks(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error('Veri yükleme hatası:', error);
        setLoading(false);
      });
  }, []); // ilk yüklendiğinde çalışır

  const toggleTask = (index) => {
    const updatedTasks = [...tasks];
    updatedTasks[index].done = !updatedTasks[index].done;

    const updatedTaskData = {
      done: updatedTasks[index].done,
      todoContent: updatedTasks[index].todoContent,
    };

    //Güncelleme işlemi
    todoApi
      .todoApiUpdate(updatedTasks[index].id, updatedTaskData)
      .then(() => {
        setTasks(updatedTasks);
      })
      .catch((error) => {
        console.error('Görev güncelleme hatası:', error);
      });
  };

  const startEditing = (index, text) => {
    setEditingIndex(index);
    setEditedText(text);
  };

  const saveEditedTask = (index, newText) => {
    if (newText.trim() !== '') {
      const updatedTasks = [...tasks];
      updatedTasks[index].todoContent = newText;

      // API'ye güncellenmiş görevi göndermek için PUT isteği gönderin
      todoApi
        .todoApiUpdate(updatedTasks[index].id, { todoContent: newText })
        .then(() => {
          setTasks(updatedTasks);
          setEditingIndex(-1);
          setEditedText('');
        })
        .catch((error) => {
          console.error('Görev güncelleme hatası:', error);
        });
    }
  };

  const cancelEditing = () => {
    setEditingIndex(-1);
    setEditedText('');
  };

  const deleteTask = (index) => {
    const taskIdToDelete = tasks[index].id;

    // API'ye görevi silmek için DELETE isteği gönderin
    todoApi
      .todoApiDeleteById(taskIdToDelete)
      .then(() => {
        const updatedTasks = tasks.filter((_, i) => i !== index);
        setTasks(updatedTasks);
      })
      .catch((error) => {
        console.error('Görev silme hatası:', error);
      });
  };

  /*const filteredTasks = tasks.filter((task) => {
    if (filter === 'Done') {
      return task.done;
    } else if (filter === 'Todo') {
      return !task.done;
    } else {
      return true; // Show all tasks when the filter is 'All'
    }
  });*/

  return (
    <div className='mt-4'>
      {tasks.map((task, index) => (
        <div className='inputClass border border-secondary mt-2 mb-2' key={task.id}>
          {editingIndex === index ? (
            <>
              <input className='mt-2' type='text' value={editedText} onChange={(e) => setEditedText(e.target.value)} />
              <button class='btn btn-success listBtn ml-2' onClick={() => saveEditedTask(index, editedText)}>
                Save
              </button>
              <button class='btn btn-danger listBtn ml-2  ' onClick={cancelEditing}>
                Cancel
              </button>
            </>
          ) : (
            <div className='d-flex'>
              <div className=' p-2 flex-grow-1'>
                <span style={{ textDecoration: task.done ? 'line-through' : 'none' }}>{task.todoContent}</span>
              </div>

              <div className='p-2 '>
                <input type='checkbox' checked={task.done} onChange={() => toggleTask(index)} />
                <button class='btn btn-warning listBtn ml-2' onClick={() => startEditing(index, task.todoContent)}>
                  Edit
                </button>
                <button class='btn btn-danger listBtn ml-2  ' onClick={() => deleteTask(index)}>
                  Delete
                </button>
              </div>
            </div>
          )}
        </div>
      ))}
    </div>
  );
}

export default TodoList;
