package com.example.mytodolist.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytodolist.R;
import com.example.mytodolist.models.TodoItem;

import java.util.ArrayList;
import java.util.Calendar;

public class TodoAdapter2 extends RecyclerView.Adapter<TodoAdapter2.VH>{

    private Activity context;
    private ArrayList<TodoItem> todos;

    public TodoAdapter2(Activity context, ArrayList<TodoItem> todos) {
        this.context = context;
        this.todos = todos;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item2,parent,false);
        return new VH(itemView,context);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        TodoItem todo = todos.get(position);
        holder.rootView.setTag(todo);
        holder.tvTitle.setText(todo.getTitle());
        holder.tvBody.setText(todo.getBody());
        holder.tvDate.setText(todo.getDueDate());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class VH extends RecyclerView.ViewHolder{

        final View rootView;
        final TextView tvTitle;
        final TextView tvBody;
        final TextView tvDate;


        public VH(@NonNull View itemView, Context context) {
            super(itemView);
            rootView = itemView;
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle2);
            tvBody = (TextView) itemView.findViewById(R.id.tvBody2);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate2);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final TodoItem item = (TodoItem) v.getTag();

                    AlertDialog.Builder adBuilder = new AlertDialog.Builder(context);
                    adBuilder.setMessage("What do you want bro?");
                    adBuilder.setCancelable(true);

                    final Context context = adBuilder.getContext();
                    final LayoutInflater inflater = LayoutInflater.from(context);
                    final  View view = inflater.inflate(R.layout.add_task,null,false);

                    EditText name = view.findViewById(R.id.edtTxtName);
                    EditText body = view.findViewById(R.id.edtTxtBody);
                    EditText date = view.findViewById(R.id.editTextDate);

                    name.setText(item.getTitle());
                    body.setText(item.getBody());
                    date.setText(item.getDueDate());

                    adBuilder.setView(view);
                    date.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            final Calendar c = Calendar.getInstance();
                            int mYear = c.get(Calendar.YEAR);
                            int mMonth = c.get(Calendar.MONTH);
                            int mDay = c.get(Calendar.DAY_OF_MONTH);

                            DatePickerDialog datePickerDialog = new DatePickerDialog(context,
                                    new DatePickerDialog.OnDateSetListener() {
                                        @Override
                                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                            //date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                            date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                                        }
                                    }, mYear, mMonth, mDay);
                            datePickerDialog.show();
                        }
                    });
                    adBuilder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (!name.getText().toString().equals("") && !body.getText().toString().equals("") && !date.getText().toString().equals("")){
                                item.setTitle(name.getText().toString());
                                item.setBody(body.getText().toString());
                                item.setDueDate(date.getText().toString());
                                TodoAdapter2.this.notifyDataSetChanged();
                            }
                            dialogInterface.dismiss();

                        }
                    });

                    adBuilder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            todos.remove(item);
                            TodoAdapter2.this.notifyDataSetChanged();
                            dialogInterface.dismiss();
                        }
                    });

                    adBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });

                    AlertDialog alert = adBuilder.create();
                    alert.show();
                }
            });
        }
    }
}
