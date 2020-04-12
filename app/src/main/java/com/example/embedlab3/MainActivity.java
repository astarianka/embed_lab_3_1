package com.example.embedlab3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private TextView outRes;
    private Button buttonCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        inputNumber = (EditText) findViewById(R.id.inputNumber);
        buttonCalc = (Button) findViewById(R.id.calculateButton);
        outRes = (TextView) findViewById(R.id.output);

        buttonCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int [] result;
                int num;

                String value = inputNumber.getText().toString();
                inputNumber.setText("");
                try {
                    num=Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),""+value+" does not accepted!", Toast.LENGTH_LONG).show();
                    return;
                }
                result = FermatFactors(num);
                outRes.setText(""+num+" = "+result[0]+"*"+result[1]);
            }
        });
    }
    static int[] FermatFactors(int n)
    {
        int[] arr = new int [2];
        if(n <= 0)
        {
            arr[0]=n;
            arr[1]=1;
            return arr;
        }
        if((n & 1) == 0)
        {
            arr[0]=n/2;
            arr[1]=2;
            return arr;
        }

        int a = (int)Math.ceil(Math.sqrt(n)) ;

        if(a * a == n)
        {
            arr[0]=a;
            arr[1]=a;
            return arr;
        }
        int b;
        while(true)
        {
            int b1 = a * a - n ;
            b = (int)(Math.sqrt(b1)) ;
            if(b * b == b1)
                break;
            else
                a += 1;
        }
        arr[0]=a-b;
        arr[1]=a+b;
        return arr;
    }

}
