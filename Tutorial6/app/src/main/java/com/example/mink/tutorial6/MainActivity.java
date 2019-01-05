package com.example.mink.tutorial6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = (EditText) findViewById(R.id.nameText);
        Button nameButton = (Button) findViewById(R.id.nameButton);

        nameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = nameText.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SubActivity.class); //새로운 창을 열기 위해 필요한 객체. subActivity 클래스를 실행할 수 있도록 한다.
                intent.putExtra("nameText", name);
                startActivity(intent);
            }

        });
    }
}
