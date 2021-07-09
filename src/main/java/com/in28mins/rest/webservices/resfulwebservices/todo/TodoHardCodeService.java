package com.in28mins.rest.webservices.resfulwebservices.todo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service  //this is a service control
public class TodoHardCodeService {
    private static List<Todo> todos=new ArrayList<Todo>();
    private static int idCounter =0;
    static{
        todos.add(new Todo(++idCounter, "in28mins", "Learn To Dance", new Date(), false));
        todos.add(new Todo(++idCounter, "in28mins", "Learn React", new Date(), false));
        todos.add(new Todo(++idCounter, "in28mins", "Learn Algo", new Date(), false));
    }
    public List<Todo> findAll(){
        return todos;
    }
    public Todo save(Todo todo){

        if(todo.getId()==-1|| todo.getId()==0){
            todo.setId(++idCounter);
            todos.add(todo);
        }else{
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }
    public Todo deleteById(long id) {
        Todo todo = findByID(id);
        if (todo == null) return null;
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }
    public Todo findByID(long id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
