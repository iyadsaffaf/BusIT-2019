package cz.mendelu.busitweek2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private ImageView imageButton;
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = findViewById(R.id.userName);

        button = findViewById(R.id.logInButton);
        imageButton = findViewById(R.id.image);
        Button button = findViewById(R.id.logInButton);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("players");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                if (!userName.equals("")) {
                    Player player = Player.getPlayer();
                    player.setName(userName);
                    String key = myRef.push().getKey();
                    player.setKey(key);
                    myRef.child(key).setValue(player);

                    Intent intent = new Intent(MainActivity.this, StartActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Name is required.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
