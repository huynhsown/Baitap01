package vn.hcmute.baitap01;

import static android.content.ContentValues.TAG;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class ReverseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reverse);

        EditText editText = findViewById(R.id.edit_text);
        Button reverseButton = findViewById(R.id.reverse_button);
        TextView initialTextView = findViewById(R.id.initial_text_view);
        TextView resultTextView = findViewById(R.id.result_text_view);

        boolean hideActionBar = getIntent().getBooleanExtra("hideActionBar", false);
        if (hideActionBar) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
        }


        Log.d(TAG, String.valueOf(hideActionBar));

        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editText.getText().toString();
                initialTextView.setText(inputText);
                String reversedText = reverseText(inputText);
                resultTextView.setText(reversedText);
                editText.setText("");
            }
        });

    }

    private String reverseText(String text) {
        String[] words = text.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        return reversed.toString().trim();
    }

}
