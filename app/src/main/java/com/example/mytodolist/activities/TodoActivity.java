package com.example.mytodolist.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import com.example.mytodolist.R;
import com.example.mytodolist.adapters.TodoAdapter2;
import com.example.mytodolist.models.TodoItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {

    private ArrayList<TodoItem> todoList = new ArrayList<>();
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        fab = findViewById(R.id.floatingActionButton3);

        RecyclerView list = findViewById(R.id.rvList);
        fillTodoList();
        list.setLayoutManager(new LinearLayoutManager(this));
        TodoAdapter2 adapter = new TodoAdapter2(this,todoList);
        list.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(TodoActivity.this);
                dialog.setMessage("What do you want bro?");
                LayoutInflater inflater = LayoutInflater.from(dialog.getContext());
                View view = inflater.inflate(R.layout.add_task, null, false);
                dialog.setView(view);

                dialog.setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText name = view.findViewById(R.id.edtTxtName);
                        EditText body = view.findViewById(R.id.edtTxtBody);
                        EditText date = view.findViewById(R.id.editTextDate);

                        todoList.add(new TodoItem(name.getText().toString(),body.getText().toString(),0,date.getText().toString(),0));
                        adapter.notifyDataSetChanged();
                    }
                });

                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                AlertDialog alert = dialog.create();
                alert.show();
            }
        });

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