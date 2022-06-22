package edu.info.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // declararea elementelor din aplicatie
    int raspuns;
    private TextView result;
    private EditText numar1, numar2;
    private Button adunare, scadere, multiply, divide, mod, pow, clear, egal, sqrt;
    private Button feedback;
    String text = "Campurile nu pot fi goale!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gasirea elementelor din aplicatie dupa id
        result = (TextView) findViewById(R.id.result);
        numar1 = (EditText) findViewById(R.id.number1);
        numar2 = (EditText) findViewById(R.id.number2);
        adunare = (Button) findViewById(R.id.buttonAdunare);
        scadere = (Button) findViewById(R.id.buttonScadere);
        multiply = (Button) findViewById(R.id.buttonInmultire);
        divide = (Button) findViewById(R.id.buttonImpartire);
        mod = (Button) findViewById(R.id.buttonMod);
        pow = (Button) findViewById(R.id.buttonPutere);
        clear = (Button) findViewById(R.id.buttonClear);
        egal = (Button) findViewById(R.id.buttonEgal);
        feedback = (Button) findViewById(R.id.buttonFeedback);

        // functia pentru trimiterea unui email ca feedback
        final Intent[] intent = {null};
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent[0] = new Intent(Intent.ACTION_SEND);
                intent[0].setType("text/plain");
                startActivity(intent[0]);
            }
        });

        // functia de adunare
        adunare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int n = Integer.parseInt(numar1.getText().toString());
                    int m = Integer.parseInt(numar2.getText().toString());
                    raspuns = n + m;
            }
        });

        // functia de scadere
        scadere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n = Integer.parseInt(numar1.getText().toString());
                int m = Integer.parseInt(numar2.getText().toString());
                raspuns = n - m;
            }
        });

        //functia de inmultire
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int n = Integer.parseInt(numar1.getText().toString());
                    int m = Integer.parseInt(numar2.getText().toString());
                    raspuns = n * m;
            }
        });

        //functia de impartire
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int n = Integer.parseInt(numar1.getText().toString());
                    int m = Integer.parseInt(numar2.getText().toString());
                    raspuns = n / m;
            }
        });

        // functia pentru rest / mod
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int n = Integer.parseInt(numar1.getText().toString());
                    int m = Integer.parseInt(numar2.getText().toString());
                    raspuns = n % m;
            }
        });

        // functia pentru ridicarea la putere
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    int n = Integer.parseInt(numar1.getText().toString());
                    int m = Integer.parseInt(numar2.getText().toString());
                    int p = m;
                    raspuns = 1;

                    for (int i = 0; i < p; i++)
                        raspuns *= n;
            }
        });

        // functia clear care goleste campurile
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numar1String = "";
                String numar2String = "";
                String res = "";
                numar1.setText(numar1String);
                numar2.setText(numar2String);
                result.setText(res);
            }
        });

        // functia ce afiseaza rezultatul
        egal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numar1String = numar1.getText().toString();
                String numar2String = numar2.getText().toString();

                if (numar1String.isEmpty() || numar2String.isEmpty()) {
                    result.setText("");
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                }

                String rasp = String.valueOf(raspuns);
                result.setText(rasp);
            }
        });
    }
}