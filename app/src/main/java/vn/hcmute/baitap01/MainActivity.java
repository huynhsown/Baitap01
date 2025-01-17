package vn.hcmute.baitap01;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button hideTitleButton = findViewById(R.id.hide_title_button);
        Button evenOddButton = findViewById(R.id.even_odd_button);
        Button reverseButton = findViewById(R.id.reverse_button);

        hideTitleButton.setOnClickListener(v -> {
            if (getSupportActionBar() != null) {
                getSupportActionBar().hide();
            }
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        });

        evenOddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int n = random.nextInt(11) + 10;

                ArrayList<Integer> numberList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int randomNumber = random.nextInt(100) + 1;
                    numberList.add(randomNumber);
                }

                StringBuilder evenNumbers = new StringBuilder("Số chẵn: ");
                StringBuilder oddNumbers = new StringBuilder("Số lẻ: ");

                for (int num : numberList) {
                    if (num % 2 == 0) {
                        evenNumbers.append(num).append(" ");
                    } else {
                        oddNumbers.append(num).append(" ");
                    }
                }

                Log.d(TAG, evenNumbers.toString());
                Log.d(TAG, oddNumbers.toString());

            }
        });

        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ReverseActivity.class);
                startActivity(intent);
            }
        });

    }
}