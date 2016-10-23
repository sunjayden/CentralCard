package me.jaydensun.android.centralcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class GenratedCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_card);

        Switch toggle = (Switch) findViewById(R.id.switch1);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                View cardInfo = findViewById(R.id.cardInfo);
                View cardLogo = findViewById(R.id.cardLogo);
                View carName = findViewById(R.id.cardName);
                View imageView = findViewById(R.id.imageView);

                if (isChecked) {
                    cardInfo.setVisibility(View.GONE);
                    cardLogo.setVisibility(View.GONE);
                    carName.setVisibility(View.GONE);
                    imageView.setVisibility(View.GONE);
                } else {
                    cardInfo.setVisibility(View.VISIBLE);
                    cardLogo.setVisibility(View.VISIBLE);
                    carName.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        });

        Button addCard = (Button) findViewById(R.id.addCardButton);
        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(GenratedCardActivity.this, AddCardActivity.class);
                startActivity(numberIntent);
            }
        });


        Button viewCard = (Button) findViewById(R.id.viewCardButton);
        viewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(GenratedCardActivity.this, ListCardActivity.class);
                startActivity(numberIntent);
            }
        });
    }
}
