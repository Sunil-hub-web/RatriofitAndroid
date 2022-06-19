package com.example.ratriofitandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Api api = RetrofitClient.getClient().create(Api.class);

                Map<String,String> params = new HashMap<>();
                params.put("id","2");
                params.put("plan",editText1.getText().toString().trim());
                params.put("result",editText2.getText().toString().trim());
                params.put("remarks",editText3.getText().toString().trim());

                String credentials = "mobility"+":"+"admin@123";
                String auth_params = "Basic "+ Base64.encodeToString(credentials.getBytes(),Base64.NO_WRAP);

                Call<Example> response = api.createUser(params,auth_params);

                response.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {

                        if(response.isSuccessful()){

                            String message = response.body().getMessage();
                            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                        }else{

                            Toast.makeText(MainActivity.this, "Data Not Store", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {

                        call.cancel();
                    }
                });

            }
        });

    }
}