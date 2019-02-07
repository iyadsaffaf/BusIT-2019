package cz.mendelu.busitweek2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;

public class MainActivity extends AppCompatActivity {

    private TextView welcomeTextView;
    private TextView loginTextView;
    private EditText editText;
    private Button button;
    private ImageView imageButton;

    private StoryLine storyLine;
    private Task currentTask;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        welcomeTextView = findViewById(R.id.welcoming);
        loginTextView = findViewById(R.id.login);
        editText = findViewById(R.id.userName);
        button = findViewById(R.id.logInButton);
        imageButton = findViewById(R.id.image);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = editText.getText().toString();

                Toast.makeText(MainActivity.this, "You are singed in", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,MapActivity.class);
                startActivity(intent);
            }
        });

    }

}
