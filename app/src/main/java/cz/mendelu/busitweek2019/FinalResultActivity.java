package cz.mendelu.busitweek2019;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    private Player player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        player = Player.getPlayer();


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("players");
        recyclerView = findViewById(R.id.results);


        players = new ArrayList<>();
        initializeTheList();

        myRef.child(player.getKey()).setValue(player).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //

                ChildEventListener childEventListener = new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String previousChildName) {

                        // A new comment has been added, add it to the displayed list
                        Player player = dataSnapshot.getValue(Player.class);
                        if(player.getStars() > 0){
                            players.add(player);

                            if (resultatAdaptor != null)
                                resultatAdaptor.notifyDataSetChanged();
                        }

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

                //


            }
        });




    }


    private void initializeTheList() {


        resultatAdaptor = new ResultatAdaptor(players, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(resultatAdaptor);
    }

    private void getData() {
    }
}
