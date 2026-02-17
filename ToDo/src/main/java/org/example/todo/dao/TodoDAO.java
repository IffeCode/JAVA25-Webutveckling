package org.example.todo.dao;

import org.example.todo.model.Todo;

public class TodoDAO extends GenericDAO<Todo, Integer>{
    public TodoDAO() {
        super(Todo.class);
    }
}
