package com.example.ashis.areyoufriendsfan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Second_Activity extends AppCompatActivity {
    ImageView imageView;
    TextView textView_h_or_s,result;
    Button button_play_again,button_exit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_);
        Intent intent = getIntent();
        int getResult = intent.getIntExtra("correct answers",0);
        imageView=(ImageView) findViewById(R.id.imageView_h_or_S);
        textView_h_or_s=(TextView) findViewById(R.id.textView_happy_or_sad);
        result=(TextView) findViewById(R.id.textView_result);

        result.setText("You Got "+ getResult + " correct out of 6");
        Toast.makeText(this,"You Got "+ getResult + " correct out of 6",Toast.LENGTH_SHORT).show();
        if (getResult>3)
        {
            textView_h_or_s.setText("Congrats!");
            imageView.setImageResource(R.drawable.happy_result);
        }
        else
        {
            textView_h_or_s.setText("You Better go back and watch F.R.I.E.N.D.S");
            imageView.setImageResource(R.drawable.motivational_quote);
        }

        button_play_again = (Button)findViewById(R.id.button_play_again);

        button_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FirstPage.class);
                startActivity(intent);
                finish();
            }
        });

        button_exit=(Button) findViewById(R.id.button_exit);
        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
