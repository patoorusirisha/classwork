package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    public abstract MyDao myDao();
    public  static  MyDataBase dataBase;
    public static synchronized MyDataBase getDataBase(Context ct){
        if (dataBase==null){
            dataBase= Room.databaseBuilder(ct,MyDataBase.class,"MyDb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return dataBase;
    }

}
