package com.example.mytodolist.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mytodolist.R;
import com.example.mytodolist.adapters.TodoAdapter;
import com.example.mytodolist.models.TodoItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<TodoItem> items = new ArrayList<>();
    TodoAdapter adapter;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.todoListView);
        fillTodoList();
        adapter = new TodoAdapter(this, items);

        list.setAdapter(adapter);

        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
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

                        items.add(new TodoItem(name.getText().toString(),body.getText().toString(),0,date.getText().toString(),0));
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

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int index, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("What do you want bro?");
                LayoutInflater inflater = LayoutInflater.from(dialog.getContext());
                View view = inflater.inflate(R.layout.add_task, null, false);

                TodoItem currentitem = items.get(index);

                EditText name = view.findViewById(R.id.edtTxtName);
                EditText body = view.findViewById(R.id.edtTxtBody);
                EditText date = view.findViewById(R.id.editTextDate);

                name.setText(currentitem.getTitle());
                body.setText(currentitem.getBody());
                date.setText(currentitem.getDueDate());

                dialog.setView(view);

                dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TodoItem saveItem = new TodoItem(name.getText().toString(),body.getText().toString(),0,date.getText().toString(),0);
                        items.set(index,saveItem);
                    }
                });

                dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        items.remove(index);
                        adapter.notifyDataSetChanged();
                    }
                });

                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
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
        items.add(new TodoItem("Csinald","A dolgod",5,"MOST",1));
        items.add(new TodoItem("Shopping", "Nagy bevasarlas", 1, "2022.11.05", 0));
        items.add(new TodoItem("Banking", "Nagy bevasarlas", 1, "2022.11.05", 0));
        items.add(new TodoItem("Teaching", "Nagy bevasarlas", 1, "2022.11.05", 0));
        items.add(new TodoItem("Skiing", "Nagy bevasarlas", 1, "2022.11.05", 0));
        items.add(new TodoItem("Sleeping", "Nagy bevasarlas", 1, "2022.11.05", 0));
    }
}