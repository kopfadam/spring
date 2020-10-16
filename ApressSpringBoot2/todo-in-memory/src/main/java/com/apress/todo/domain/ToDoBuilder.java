package com.apress.todo.domain;

public class ToDoBuilder {

    private static ToDoBuilder builder = new ToDoBuilder();
    private String id = null;
    private String description = "";

    private ToDoBuilder(){};

    public static ToDoBuilder create(){

        return builder;
    }

    public ToDoBuilder withDescription(String description){

        this.description = description;
        return builder;
    }

    public ToDoBuilder withId(String id){

        this.id = id;
        return builder;
    }

    public ToDo build(){

        ToDo result = new ToDo(this.description);

        if (id != null){
            result.setId(id);

        }

        return result;
    }

}
