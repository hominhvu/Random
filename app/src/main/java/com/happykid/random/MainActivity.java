package com.happykid.random;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button btn;
    EditText edtText01, edtText02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ánh xạ
        Mapping();
        //sự kiện
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chuoi1 = edtText01.getText().toString().trim();//.trim() là bỏ ký tự space
                String chuoi2 = edtText02.getText().toString().trim();
                    //isEmpty() hoặc .length()==0 là kiểm tra có null không
                if(chuoi1.isEmpty() || chuoi2.length()==0){
                    Toast.makeText(MainActivity.this,"Vui lòng nhập đủ số !",Toast.LENGTH_SHORT).show();
                }else {
                    //ép chuỗi -> số
                    int min = Integer.parseInt(chuoi1);
                    int max = Integer.parseInt(chuoi2);
                    //tạo số ngẫu nhiên
                    Random random = new Random();
                    if(min>max){
                        Toast.makeText(MainActivity.this,"Min phải nhỏ hơn max", Toast.LENGTH_SHORT).show();
                    }else {
                        int number = random.nextInt(max - min + 1) + min;
                        //ép số -> chuỗi
                        txt.setText(String.valueOf(number));
                    }
                }

            }
        });
    }
    public  void Mapping(){
        txt = (TextView) findViewById(R.id.txtNumber);
        btn = (Button) findViewById(R.id.btnRandom);
        edtText01 = (EditText) findViewById(R.id.editText01);
        edtText02 = (EditText) findViewById(R.id.editText02);
    }
}