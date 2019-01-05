package com.example.mink.tutorial3;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"망고 쥬스", "오렌지 쥬스", "포도 쥬스"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton  = (Button) findViewById(R.id.listButton);
        listButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("리스트");    //팝업창에 해당하는 리스트 제목
                builder.setItems(items, new DialogInterface.OnClickListener() { //팝업창에 해당하는 리스트 내용
                    @Override
                    public void onClick(DialogInterface dialog, int i) {    //리스트 안의 내용을 클릭했을 때에 대한 이벤트 처리
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show();   // 자신이 클릭한 내용을 Toast로 잠시 띄워. 인덱스를 받아서 인덱스에 해당하는 내용을 띄
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        Button exitButton  = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // Dialog 객체인 Builder를 만들고 내용은 MainActivity에 종속되도록 한다
                builder.setMessage("정말로 종료하시겠습니까?");
                builder.setTitle("종료 알림창")
                        .setCancelable(false)       //임의로 종료할 수 없
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();   //Dialog 객체를 builder에서 받아온다
                alert.setTitle("종료 알림창");              //Dialog의 제목을 정해준다.
                alert.show();
            }
        });
    }
}
