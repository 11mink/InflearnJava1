package com.example.mink.tutorial5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"망고 쥬스", "토마토 쥬스", "포도 쥬스"};
        ListAdapter adapter = new imageAdapter(this,items);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id){
                        String item = String.valueOf(parent.getItemAtPosition(i));  //특정한 아이템을 클릭했을 때 그 아이템을 객체로 만들어줌
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show(); //LENGTH_SHORT는 짧게 출력
                    }
                }
        );
    }
}
