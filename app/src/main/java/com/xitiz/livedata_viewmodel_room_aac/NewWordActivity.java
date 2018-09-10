package com.xitiz.livedata_viewmodel_room_aac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        Button button = findViewById(R.id.button_save);
        final EditText et_word = findViewById(R.id.edit_word);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(et_word.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String word = et_word.getText().toString();
                    replyIntent.putExtra("MESSAGE", word);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
