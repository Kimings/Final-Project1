package com.hacktiv8.todolist_project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "DB_TODOLIST";
    private static final int DATABASE_VERSION =1;
    private static final String TABLE_TODOLIST = "TODOLIST";
    private static final String KEY_ID ="id";
    private static final String LIST_TODOLIST = "list_toDoList";

    public SQLiteDatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tableCreateSql = " CREATE TABLE " + TABLE_TODOLIST+ "("+
                KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LIST_TODOLIST + "TEXT )";
        System.out.println("create Table : " +tableCreateSql);
        db.execSQL(tableCreateSql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOLIST);
        onCreate(db);
    }

        public void addToDoList(ToDoList toDoList){
        SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(LIST_TODOLIST, toDoList.getToDolistName());
            db.close();
        }

        public List<ToDoList> getAllToDoList(){
        List<ToDoList> toDoListList = new ArrayList<>();
        //
            String queryAll = "SELECT * FROM " + TABLE_TODOLIST;
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery(queryAll, null);

            if (cursor.moveToFirst()) {
                do {
                    ToDoList toDoList = new ToDoList();
                    toDoList.setId(Integer.parseInt(cursor.getString(0)));
                    toDoList.setToDolistName(cursor.getString(1));

                    toDoListList.add(toDoList);
                }
                while (cursor.moveToNext());
            }

            //
        return toDoListList;
        }
}
