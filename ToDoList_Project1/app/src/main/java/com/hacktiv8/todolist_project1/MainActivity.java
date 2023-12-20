package com.hacktiv8.todolist_project1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addButton;
    private RecyclerView ToDoListRv;

    SQLiteDatabaseHandler db;
    private List<ToDoList> toDoListList;
    private ToDoListAdapter toDoListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.add_ToDolist);
        ToDoListRv = findViewById(R.id.TodoList_rv);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showForm();
            }
        });

        db = new SQLiteDatabaseHandler(this);
        loadDataTodolist();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ToDoListRv.setLayoutManager(layoutManager);
    }

        private void loadDataTodolist(){
            toDoListList = db.getAllToDoList();
            toDoListAdapter = new ToDoListAdapter(this,toDoListList);

            ToDoListRv.setAdapter(toDoListAdapter);
        }

    private void showForm() {
        AlertDialog.Builder formBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.form_todolist, null);

        formBuilder.setView(view);

        AlertDialog popup = formBuilder.create();
        popup.show();

        EditText todolistNameInput = view.findViewById(R.id.input_toDolist);
        Button saveButton = view.findViewById(R.id.save_list);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //SAVE DATA ke SQL
                String toDoListName = todolistNameInput.getText().toString();

                ToDoList toDoList = new ToDoList(toDoListName);
                db.addToDoList(toDoList);
                loadDataTodolist();

                popup.dismiss();
            }
        });

    }
}