package edu.osucascades.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mNounEditText;
    private EditText mVerbEditText;
    private EditText mAdjectiveEditText;
    private Button mGenerateMadLibButton;

    private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNounEditText = (EditText) findViewById(R.id.noun_text_id);
        mVerbEditText = (EditText) findViewById(R.id.verb_text_id);
        mAdjectiveEditText = (EditText) findViewById(R.id.adjective_text_id);

        mGenerateMadLibButton = (Button) findViewById(R.id.generate_mad_lib_button);
        mGenerateMadLibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mNounEditText.length() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                } else if (mVerbEditText.length() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                } else if (mAdjectiveEditText.length() <= 0) {
                    Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MadLibActivity.class);
                    intent.putExtra("Noun", mNounEditText.getText().toString());
                    intent.putExtra("Verb", mVerbEditText.getText().toString());
                    intent.putExtra("Adjective", mAdjectiveEditText.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        } else {
            if (requestCode == REQUEST_CODE) {
                if (data == null) {
                    return;
                }
            }
        }
        mNounEditText.setText("");
        mVerbEditText.setText("");
        mAdjectiveEditText.setText("");
    }

}
