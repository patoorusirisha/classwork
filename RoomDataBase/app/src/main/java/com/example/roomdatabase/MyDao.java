package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
  @Insert
    public void  insertStudent(Student student);
   @Delete
  public  void deleteStudent(Student student);
   @Query("SELECT * FROM StudentInfo")
   public LiveData<List<Student>> readData();
   @Update
   public void updateStudent(Student student);
}
