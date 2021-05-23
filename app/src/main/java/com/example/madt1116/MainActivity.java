package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvContent;
    ListView lvCurrencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
    }

    public void onBtnDownloadClick(View view) {
        this.tvContent.setText(R.string.msgLoading);
        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                tvContent.setText(R.string.msgCurrencyList);
                String[] arrayCurrencies = result.split(String.valueOf(R.string.txtSplit));
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, arrayCurrencies);
                lvCurrencies = findViewById(R.id.lvCurrencies);
                lvCurrencies.setAdapter(adapter);
            }
        }.execute();
    }
}