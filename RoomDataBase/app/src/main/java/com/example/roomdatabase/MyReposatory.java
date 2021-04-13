package com.example.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MyReposatory {
    LiveData<List<Student>> readData;
    MyDataBase myDataBase;

    public MyReposatory(Application application) {
        myDataBase=MyDataBase.getDataBase(application);
        readData=myDataBase.myDao().readData();
    }

   public void insert(Student student){
        new Inserttask().execute(student);
   }
    class Inserttask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            myDataBase.myDao().insertStudent(students[0]);
            return null;
        }
        public void delete(Student student){
            new Deletetask().execute(student);
        }
    }
    class Deletetask extends AsyncTask<Student,Void,Void>{

        @Override
        protected Void doInBackground(Student... students) {
            myDataBase.myDao().deleteStudent(students[0]);
            return null;
        }
    }
    public LiveData<List<Student>>readAallData(){
        return readData;
    }
}
