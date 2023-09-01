import React, { useState, useEffect } from 'react';
import TodoApi from './services/TodoApi';

const todoApi = new TodoApi();

function TodoList() {
  const [tasks, setTasks] = useState([]);
  const [editingIndex, setEditingIndex] = useState(-1);
  const [editedText, setEditedText] = useState('');
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    // Verileri API'den çekmek için useEffect kullanın
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
  }, []); // Boş bağımlılık dizisi, yalnızca bileşen ilk yüklendiğinde çalışır

  const toggleTask = (index) => {
    const updatedTasks = [...tasks];
    updatedTasks[index].done = !updatedTasks[index].done;

    // API'ye güncellenmiş görevi göndermek için PUT isteği gönderin
    todoApi
      .todoApiUpdate(updatedTasks[index].id, { done: updatedTasks[index].done })
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

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className='mt-4'>
      {tasks.map((task, index) => (
        <div className='inputClass border border-secondary mt-2' key={task.id}>
          {editingIndex === index ? (
            <>
              <input type='text' value={editedText} onChange={(e) => setEditedText(e.target.value)} />
              <button onClick={() => saveEditedTask(index, editedText)}>Save</button>
              <button onClick={cancelEditing}>Cancel</button>
            </>
          ) : (
            <div className='d-flex'>
              <div className='mr-auto p-2'>
                <span style={{ textDecoration: task.done ? 'line-through' : 'none' }}>{task.todoContent}</span>
              </div>

              <div className='p-2'>
                <input type='checkbox' checked={task.done} onChange={() => toggleTask(index)} />
                <button onClick={() => startEditing(index, task.todoContent)}>Edit</button>
                <button onClick={() => deleteTask(index)}>Delete</button>
              </div>
            </div>
          )}
        </div>
      ))}
    </div>
  );
}

export default TodoList;
