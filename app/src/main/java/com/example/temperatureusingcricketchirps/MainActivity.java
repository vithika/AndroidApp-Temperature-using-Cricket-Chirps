package com.example.temperatureusingcricketchirps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText eTChirps;
    Button btncalculate;
    TextView tvTemp;
    DecimalFormat Formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        eTChirps = findViewById(R.id.eTChirps);
        btncalculate=findViewById(R.id.btncalculate);
        tvTemp=findViewById(R.id.tvTemp);

        tvTemp.setVisibility(View.GONE);

        Formatter=new DecimalFormat("#0.0");
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eTChirps.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields",Toast.LENGTH_SHORT).show();
                    tvTemp.setVisibility(View.GONE);
                }
                else
                {
                    int chirps=Integer.parseInt(eTChirps.getText().toString().trim());

                    double temp=(chirps / 3.0)+4;

                    String results="The approximate temperature outside is "+ Formatter.format(temp)+  "  degrees Celcius";

                    tvTemp.setText(results);
                    tvTemp.setVisibility(View.VISIBLE);

                }
            }
        });
    }
}
