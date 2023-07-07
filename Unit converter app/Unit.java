package com.example.unit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch switchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView3);
        editText = findViewById(R.id.editText);
        switchView = findViewById(R.id.switch1);
        switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
                if (isChecked){
                    textView.setText("Enter the value in pounds");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Hi click listner worked!", Toast.LENGTH_SHORT).show();
                            String s = editText.getText().toString();
                            int kg = Integer.parseInt(s);
                            double pound = 2.205 * kg;
                            textView.setText("The corresponding value in pounds is " + pound);
                        }
                    });
                } else {
                    textView.setText("Enter the value in Kgs");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "Hi click listner worked!", Toast.LENGTH_SHORT).show();
                            String s = editText.getText().toString();
                            int kg = Integer.parseInt(s);
                            double pound = kg / 2.205;
                            textView.setText("The corresponding value in kgs is " + pound);
                        }
                    });
                }
            }
        });
    }
}
