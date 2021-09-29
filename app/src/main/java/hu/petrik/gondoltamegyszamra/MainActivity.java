package hu.petrik.gondoltamegyszamra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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
private int elet;


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
        buttonTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippeltSzam == gondoltSzam){
                    //TODO: Felugró ablak fog jönni, "Nyertél!" felirattal
                }
                else if(tippeltSzam < gondoltSzam){
                    //TODO: Felugró ablak (nagyobb szám)
                    elet--;
                    eletMinusz();
                }
                else{
                    //TODO: Felugró ablak jön (kisebb szám)
                }
            }
        });
    }

    public void eletMinusz(){
        switch (elet){
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp2.setImageResource(R.drawable.heart1);
                //TODO: felugró ablak: game over
                break;
        }
    }

    public void init(){
        elet = 4;
        tippeltSzam = 1;
        random = new Random();
        gondoltSzam = random.nextInt(10)+1;
        //Tesztelésekre: Log.d("gondoltSzam", String.valueOf(gondoltSzam));
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
