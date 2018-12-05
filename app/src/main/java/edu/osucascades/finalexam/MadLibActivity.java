package edu.osucascades.finalexam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MadLibActivity extends AppCompatActivity {

    private Button mSendMadLibButton;
    private Button mAddPhotoButton;
    private Button mNewMadLibButton;
    private Button mResetButton;
    private TextView mMadLibTextView;

    private static final String NOUN = "noun";
    private static final String ADJECTIVE = "adjective";
    private static final String VERB = "verb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mad_lib);

        final String noun = getIntent().getStringExtra("Noun");
        final String verb = getIntent().getStringExtra("Verb");
        final String adjective = getIntent().getStringExtra("Adjective");

        String mabLib = "This " + " " + noun + "is something " + " " + verb + "something " + " " + adjective;

        mMadLibTextView = (TextView) findViewById(R.id.mad_lib_text_view);
        mMadLibTextView.setText(mabLib);

        //attempted to do the implicit intent portion
        //I know I am missing some pieces
        mSendMadLibButton = (Button) findViewById(R.id.send_mab_lib_button_id);
        mSendMadLibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                startActivity(i);
            }
        });
        mAddPhotoButton = (Button) findViewById(R.id.add_photo_button_id);

        mNewMadLibButton = (Button) findViewById(R.id.new_mad_lib_button_id);
        mNewMadLibButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mabLib = "What is this " + " " + noun + "no idea what " + " " + verb + "some tye of " + " " + adjective;
                mMadLibTextView.setText(mabLib);
            }
        });

        mResetButton = (Button) findViewById(R.id.reset_button_id);
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent();
                setResult(Activity.RESULT_OK, resetIntent);
                finish();
            }
        });

    }
}
