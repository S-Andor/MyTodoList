package com.example.mytodolist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mytodolist.R;
import com.example.mytodolist.adapters.TodoAdapter;
import com.example.mytodolist.models.TodoItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TodoItem> items = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.todoListView);
        TodoAdapter adapter = new TodoAdapter(this, getTodoList());

        list.setAdapter(adapter);
    }

    public static ArrayList<TodoItem> getTodoList(){
        ArrayList<TodoItem> todos = new ArrayList<>();

        todos.add(new TodoItem("Csinald","A dolgod",5,"MOST",1));
        todos.add(new TodoItem("Shopping", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todos.add(new TodoItem("Banking", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todos.add(new TodoItem("Teaching", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todos.add(new TodoItem("Skiing", "Nagy bevasarlas", 1, "2022.11.05", 0));
        todos.add(new TodoItem("Sleeping", "Nagy bevasarlas", 1, "2022.11.05", 0));
        return todos;
    }
}