package com.example.retrofitdemonstartion;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APiInterface
{
    @GET("/todos")
    Call<List<ToDo>> getTodos();

    @GET("/todos/{id}")
    Call<ToDo> getTodo(@Path("id")int id);

    @GET("/todos")
    Call<ToDo> getTodosusingQuery(@Query("userId")int userId,
                                  @Query("completed")boolean completed);

    @POST("/todos")
    Call<ToDo> postTod(@Body ToDo toDo);

}
