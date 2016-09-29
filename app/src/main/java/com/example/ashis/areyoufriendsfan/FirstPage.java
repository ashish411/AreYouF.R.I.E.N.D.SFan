package com.example.ashis.areyoufriendsfan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class FirstPage extends AppCompatActivity {
    int correctNo;
    RadioGroup rg1, rg3, rg4, rg6;
    RadioButton rb1;
    Button button, button_text;
    EditText eq2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        rg1 = (RadioGroup) findViewById(R.id.radiogroup_q1);
        button_text = (Button) findViewById(R.id.button_text);
        button = (Button) findViewById(R.id.button_Submit);
        rg3 = (RadioGroup) findViewById(R.id.radiogroup_q3);
        rg4 = (RadioGroup) findViewById(R.id.radiogroup_q4);
        rg6 = (RadioGroup) findViewById(R.id.radiogroup_q6);
        eq2 = (EditText) findViewById(R.id.editText_q2);
        radioButton_show();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox_show();
                Intent intent = new Intent(getApplicationContext(), Second_Activity.class);
                intent.putExtra("correct answers", correctNo);
                startActivity(intent);
                finish();
            }
        });

        button_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getText = eq2.getText().toString();
                if (getText.equalsIgnoreCase("joey")) {
                    correctNo++;
                }
                eq2.setEnabled(false);

            }
        });


    }

    private void checkBox_show() {
        CheckBox ca, cb, cc, cd, ce, cf;
        ca = (CheckBox) findViewById(R.id.checkBox_a);
        cb = (CheckBox) findViewById(R.id.checkBox_b);
        cc = (CheckBox) findViewById(R.id.checkBox_c);
        cd = (CheckBox) findViewById(R.id.checkBox_d);
        ce = (CheckBox) findViewById(R.id.checkBox_e);
        cf = (CheckBox) findViewById(R.id.checkBox_f);
        if (cb.isChecked() && cc.isChecked() && cd.isChecked() && ce.isChecked() && cf.isChecked() && !ca.isChecked()) {
            correctNo++;
        }

    }


    private void radioButton_show() {
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rq1a, rq1b, rq1c, rq1d;
                rq1a = (RadioButton) findViewById(R.id.radioButton_q1_a);
                rq1b = (RadioButton) findViewById(R.id.radioButton_q1_b);
                rq1c = (RadioButton) findViewById(R.id.radioButton_q1_c);
                rq1d = (RadioButton) findViewById(R.id.radioButton_q1_d);

                rb1 = (RadioButton) findViewById(checkedId);

                if (rb1.getText().toString().equals("Courteney Cox Arquette")) {
                    correctNo++;



                }

                rq1a.setEnabled(false);
                rq1b.setEnabled(false);
                rq1c.setEnabled(false);
                rq1d.setEnabled(false);


            }
        });
        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rq3a, rq3b, rq3c;
                rq3a = (RadioButton) findViewById(R.id.radioButton_q3_a);
                rq3b = (RadioButton) findViewById(R.id.radioButton_q3_b);
                rq3c = (RadioButton) findViewById(R.id.radioButton_q3_c);
                rb1 = (RadioButton) findViewById(checkedId);

                if (rb1.getText().toString().equals("Barry")) {
                    correctNo++;

                }
                rq3a.setEnabled(false);
                rq3b.setEnabled(false);
                rq3c.setEnabled(false);
            }
        });

        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rq4a, rq4b, rq4c;
                rq4a = (RadioButton) findViewById(R.id.radioButton_q4_a);
                rq4b = (RadioButton) findViewById(R.id.radioButton_q4_b);
                rq4c = (RadioButton) findViewById(R.id.radioButton_q4_c);

                rb1 = (RadioButton) findViewById(checkedId);


                if (rb1.getText().toString().equals("The Rembrandts")) {
                    correctNo++;
                }
                rq4a.setEnabled(false);
                rq4b.setEnabled(false);
                rq4c.setEnabled(false);

            }
        });

        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rq6a, rq6b, rq6c;
                rq6a = (RadioButton) findViewById(R.id.radioButton_q6_a);
                rq6b = (RadioButton) findViewById(R.id.radioButton_q6_b);
                rq6c = (RadioButton) findViewById(R.id.radioButton_q6_c);

                rb1 = (RadioButton) findViewById(checkedId);

                if (rb1.getText().toString().equals("Janice")) {
                    correctNo++;
                }
                rq6a.setEnabled(false);
                rq6b.setEnabled(false);
                rq6c.setEnabled(false);
            }
        });


    }

    public void playVoice(View view) {
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.janice);
        mp.start();

    }

}
