import axios from 'axios';

//persist url
const TODO_URL = '/todo/api/v1';
class TodoApi {
  //CREATE
  // /create
  todoApiCreate(todoDto) {
    console.log('apiye geldim');
    return axios.post(`${TODO_URL}/create`, todoDto);
  }

  // /list
  todoApiList() {
    return axios.get(`${TODO_URL}/list`);
  }

  // /update/{id}
  todoApiUpdate(id, todoDto) {
    console.log(todoDto);
    return axios.put(`${TODO_URL}/update/${id}`, todoDto);
  }

  // /delete/{id}
  todoApiDeleteById(id) {
    return axios.delete(`${TODO_URL}/delete/${id}`);
  }

  // /delete/all
  todoApiAllDelete() {
    // Tüm verileri silme işlemini burada gerçekleştirin
    return axios.delete(`${TODO_URL}/delete/all`);
  }
}

export default TodoApi;
