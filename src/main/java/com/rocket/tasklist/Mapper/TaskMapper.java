package com.rocket.tasklist.Mapper;

import com.rocket.tasklist.Models.TaskModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface TaskMapper {

    // get all elements from tasks table
    @Select("SELECT * FROM tasks")
    List<TaskModel> findAll();

    // get a single element by its id from tasks table
    @Select("SELECT * FROM tasks WHERE id = #{id}")
    TaskModel findById(Long id);

    // create a new element into tasks table
    @Insert("INSERT INTO tasks(name, description, startDate, completed) VALUES(#{name}, #{description}, #{startDate}, #{completed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void create(TaskModel task);

    // update an existent element into tasks table
    @Update("UPDATE tasks SET name=#{name}, description=#{description}, startDate=#{startDate}, completed=#{completed} WHERE id=#{id}")
    void update(TaskModel task);

    // delete an element from tasks table
    @Delete("DELETE FROM tasks WHERE id = #{id}")
    void delete(Long id);

    // get elements from tasks table only if its property completed is true
    @Select("SELECT * FROM tasks WHERE completed = true")
    List<TaskModel> getCompleted();

}
