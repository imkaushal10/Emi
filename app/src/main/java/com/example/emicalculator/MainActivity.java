package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private EditText principal, rate, nofmi;
    private TextView emi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = (EditText) findViewById(R.id.principal);
        rate = (EditText) findViewById(R.id.rate);
        nofmi = (EditText) findViewById(R.id.nofmi);
        Button btncalc = (Button) findViewById(R.id.btncalc);
        emi = (TextView) findViewById(R.id.result);

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emi();
            }
        });
    }

    public void emi(){
        String emilabel = " ";
        double p = Integer.parseInt(principal.getText().toString());
        double r = (Integer.parseInt(rate.getText().toString()));
        double t = Integer.parseInt(nofmi.getText().toString());
        double ir = r/1200;
        double r1 = Math.pow(ir+1,t);

//        double result = (double) ((ir+(ir/(r1-1))) * p*ir);

        double result = (double) (p*ir*(r1/(r1-1)));

        emilabel =  getString(R.string.emi) + result;
        emi.setText(new DecimalFormat("##.##").format(emilabel));
    }
}
