package com.example.retrofitdemonstartion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= "MainActivity";
    APiInterface aPiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aPiInterface = ApiClient.getClient().create(APiInterface.class);
    }

    public void getTodos(View view){
        Call<List<ToDo>> call =aPiInterface.getTodos();

        call.enqueue(new Callback<List<ToDo>>() {
            @Override
            public void onResponse(Call<List<ToDo>> call, Response<List<ToDo>> response) {
                Log.e(TAG, "On response"+ response.body());
            }

            @Override
            public void onFailure(Call<List<ToDo>> call, Throwable t) {
                Log.e(TAG, "OnFailure"+ t.getLocalizedMessage());
            }
        });
    }

    public void getTodoId(View view){
        Call<ToDo> call =aPiInterface.getTodo(3);

        call.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                Log.e(TAG, "On response"+ response.body());
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Log.e(TAG, "OnFailure"+ t.getLocalizedMessage());
            }
        });
    }

    public void getTodoWithQuery(View view){
        Call<ToDo> call =aPiInterface.getTodosusingQuery(3, false);
        call.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                Log.e(TAG, "On response"+ response.body());
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Log.e(TAG, "OnFailure"+ t.getLocalizedMessage());
            }
        });
    }

    public void postTodo(View view){
        ToDo todo = new ToDo(100, 256, "Vanier is cold tody", true);
        Call<ToDo> toDoCall = aPiInterface.postTod(todo);

        toDoCall.enqueue(new Callback<ToDo>() {
            @Override
            public void onResponse(Call<ToDo> call, Response<ToDo> response) {
                Log.e(TAG, "On response"+ response.body());
            }

            @Override
            public void onFailure(Call<ToDo> call, Throwable t) {
                Log.e(TAG, "OnFailure"+ t.getLocalizedMessage());
            }
        });
    }
}