package com.tolliam.todos;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }

    public void saveItem(View view){
        Intent resultIntent = new Intent();
        EditText editText = (EditText) findViewById(R.id.new_item);
        String newItem = editText.getText().toString();
        resultIntent.putExtra("newItem", newItem);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
