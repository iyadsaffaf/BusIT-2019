package cz.mendelu.busitweek2019;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class FinalResultActivity extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    private RecyclerView recyclerView;

    private ResultatAdaptor resultatAdaptor;

    private List<Player> players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("players");
        recyclerView = findViewById(R.id.results);
        initilaizeTheList();
        myRef = database.getReference("players");

        players = new ArrayList<>();


        initilaizeTheList();

        ChildEventListener childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                // A new comment has been added, add it to the displayed list
                Player player = dataSnapshot.getValue(Player.class);
                players.add(player);

                if (resultatAdaptor != null)
                    resultatAdaptor.notifyDataSetChanged();
                Toast.makeText(FinalResultActivity.this, "" + player.getTime(),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String previousChildName) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {


            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String previousChildName) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        myRef.addChildEventListener(childEventListener);

//       initilaizeTheList();

    }


    private void initilaizeTheList() {


        resultatAdaptor = new ResultatAdaptor(players, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(resultatAdaptor);
    }
}
