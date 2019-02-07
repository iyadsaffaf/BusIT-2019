package cz.mendelu.busitweek2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        editText = findViewById(R.id.userName);
        button = findViewById(R.id.logInButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();
                if(!userName.equals("")){
                    Player player = Player.getPlayer();
                    player.setName(userName);
                    Intent intent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}
