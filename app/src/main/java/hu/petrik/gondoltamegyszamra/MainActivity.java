package hu.petrik.gondoltamegyszamra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView hp1, hp2, hp3, hp4;
private Button buttonMinusz, buttonPlusz, buttonTipp;
private TextView textViewSzam;
private int tippeltSzam;
private Random random;
private int gondoltSzam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippeltSzam == 0){
                    // TODO: Felugró ablak fog jönni
                }
                else{
                    tippeltSzam--;
                    textViewSzam.setText(String.valueOf(tippeltSzam));
                }
            }
        });
        buttonPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippeltSzam >= 10){
                    // TODO: Felugró ablak fog jönni
                }
                else{
                    tippeltSzam++;
                    textViewSzam.setText(String.valueOf(tippeltSzam));
                }
            }
        });
    }

    public void init(){
        tippeltSzam = 1;
        random = new Random();
        gondoltSzam = random.nextInt(10)+1;
        hp1 = findViewById(R.id.imageViewHp1);
        hp2 = findViewById(R.id.imageViewHp2);
        hp3 = findViewById(R.id.imageViewHp3);
        hp4 = findViewById(R.id.imageViewHp4);
        buttonMinusz = findViewById(R.id.buttonMinusz);
        buttonPlusz = findViewById(R.id.buttonPlusz);
        buttonTipp = findViewById(R.id.buttonTipp);
        textViewSzam = findViewById(R.id.textViewSzam);
    }
}
