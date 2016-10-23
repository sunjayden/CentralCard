package me.jaydensun.android.centralcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddCardActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    private EditText editTextName, editTextCardNum, editTextCVV, editTextExp1, editTextExp2;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_add_card);

        buttonSave = (Button) findViewById(R.id.card_submit);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        editTextName = (EditText) findViewById(R.id.card_name);
        editTextCardNum = (EditText) findViewById(R.id.card_number);
        editTextCVV = (EditText) findViewById(R.id.card_cvv);
        editTextExp1 = (EditText) findViewById(R.id.card_exp1);
        editTextExp2 = (EditText) findViewById(R.id.card_exp2);

        buttonSave.setOnClickListener(this);

        Button logOn = (Button)findViewById(R.id.card_submit);
        logOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(AddCardActivity.this, GenratedCardActivity.class);
                startActivity(numberIntent);
            }
        });
    }

    private void saveInfo() {
        String name = editTextName.getText().toString().trim();
        String num = editTextCardNum.getText().toString().trim();
        String exp1 = editTextExp1.getText().toString().trim();
        String exp2 = editTextExp2.getText().toString().trim();
        String cvv = editTextCVV.getText().toString().trim();

        CardInfo cardInfo = new CardInfo(name, num, exp1, exp2, cvv);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(cardInfo);

        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSave) {
            saveInfo();
        }

    }
}
