package com.hacktiv8.todolist_project1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ViewHolder> {

    private List<ToDoList> toDoListList;

    private Context context;

    public ToDoListAdapter(Context context, List<ToDoList> toDoListList){
        this.context = context;
        this.toDoListList = toDoListList;
    }

    @NonNull
    @Override
    public ToDoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoListAdapter.ViewHolder holder, int position) {
        ToDoList toDoList = toDoListList.get(position);

        holder.idToDoListTv.setText(String.valueOf(toDoList.getId()));
        holder.toDoListName.setText(toDoList.getToDolistName());

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idToDoListTv;
        private  TextView toDoListName;
        private Button editButton;
        private Button deleteButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idToDoListTv = itemView.findViewById(R.id.id_Todolist_tv);
            toDoListName = itemView.findViewById(R.id.list_nameTodolist_tv);

            editButton = itemView.findViewById(R.id.edit_button);
            deleteButton = itemView.findViewById(R.id.delete_button);
        }
    }
}
