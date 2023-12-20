package com.hacktiv8.todolist_project1;

public class ToDoList {
    int id;
    String ToDolistName;

    public ToDoList(){
        super();
    }

    public ToDoList(int id, String ToDoListName){
        super();
        this.id = id;
        this.ToDolistName = ToDoListName;

    }

    public ToDoList(String ToDoListName){
        this.ToDolistName = ToDoListName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToDolistName() {
        return ToDolistName;
    }

    public void setToDolistName(String toDolistName) {
        ToDolistName = toDolistName;
    }
}
