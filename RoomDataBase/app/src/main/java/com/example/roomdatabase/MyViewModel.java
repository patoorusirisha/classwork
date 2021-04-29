package com.example.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    MyReposatory reposatory;
    LiveData<List<Student>> readData;

    public MyViewModel(@NonNull Application application) {
        super(application);
        reposatory = new MyReposatory(application);
        readData = reposatory.readAallData();
    }
    public void insert(Student student){
        reposatory.insert(student);
    }
   public void delete(Student student){
        reposatory.delete(student);
   }
   public LiveData<List<Student>> readData(){
        return readData;
   }
}
