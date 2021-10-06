package hu.petrik.gondoltamegyszamra;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView hp1, hp2, hp3, hp4;
private Button buttonMinusz, buttonPlusz, buttonTipp;
private TextView textViewSzam;
private int tippeltSzam;
private Random random;
private int gondoltSzam;
private int elet;
private Toast customToast;
private AlertDialog.Builder alerBuilder;


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
                    //Felugró ablak (nagyobb szám)
                    elet--;
                    eletMinusz();
                    customToast.show();
                    Toast.makeText(getApplicationContext(), "Nagyobb számra gondoltam", Toast.LENGTH_SHORT).show();
                }
                else{
                    //Felugró ablak jön (kisebb szám)
                    eletMinusz();
                    customToast.show();
                    Toast.makeText(getApplicationContext(), "Kisebb számra gondoltam", Toast.LENGTH_SHORT).show();
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
        customToast = new Toast(getApplicationContext());
        CreateCustomToast();
        alerBuilder = new AlertDialog.Builder(getApplicationContext());
        CreateAlertDialog();
    }

    private void CreateAlertDialog() {
        alerBuilder.setMessage("Szeretnél-e új játékot?");
        alerBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alerBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ujJatek();
                closeContextMenu();
            }
        })
    }

    private void CreateCustomToast() {
        customToast.setDuration(Toast.LENGTH_SHORT);
        View view = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.customToast));
        customToast.setView(view);
        customToast.setGravity(Gravity.CENTER, 0, 0);
    }
}
