package com.example.mytodolist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mytodolist.R;
import com.example.mytodolist.adapters.TodoAdapter2;
import com.example.mytodolist.models.TodoItem;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {

    private ArrayList<TodoItem> todoList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView list = findViewById(R.id.rvList);
        fillTodoList();
        list.setLayoutManager(new LinearLayoutManager(this));
        TodoAdapter2 adapter = new TodoAdapter2(this,todoList);
        list.setAdapter(adapter);
    }

    public void fillTodoList(){
        todoList.add(new TodoItem("Csinald","A dolgod",5,"MOST",1));
        todoList.add(new TodoItem("Shopping", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todoList.add(new TodoItem("Banking", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todoList.add(new TodoItem("Teaching", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todoList.add(new TodoItem("Skiing", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todoList.add(new TodoItem("Sleeping", "Nagy bevasarlas", 1, "2022.11.05", 0));
    }
}