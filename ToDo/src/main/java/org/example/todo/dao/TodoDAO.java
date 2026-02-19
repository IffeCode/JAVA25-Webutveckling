package org.example.todo.dao;

import org.example.todo.model.Todo;

public class TodoDAO extends GenericDAO<Todo, Integer>{
    public TodoDAO() {
        super(Todo.class);
    }

    public Todo findById(String sId){
        if (sId == null || sId.isEmpty()){
            return null;
        }

        int id;
        try {
            id = Integer.parseInt(sId);
        }catch (NumberFormatException e){
            return null;
        }

        return findById(id);
    }

}
