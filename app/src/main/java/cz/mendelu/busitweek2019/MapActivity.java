package cz.mendelu.busitweek2019;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.mapbox.android.core.location.LocationEngine;
import com.mapbox.android.core.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

import java.security.Permission;

import cz.mendelu.busItWeek.library.BeaconTask;
import cz.mendelu.busItWeek.library.ChoicePuzzle;
import cz.mendelu.busItWeek.library.CodeTask;
import cz.mendelu.busItWeek.library.GPSTask;
import cz.mendelu.busItWeek.library.ImageSelectPuzzle;
import cz.mendelu.busItWeek.library.Puzzle;
import cz.mendelu.busItWeek.library.SimplePuzzle;
import cz.mendelu.busItWeek.library.StoryLine;
import cz.mendelu.busItWeek.library.Task;
import cz.mendelu.busItWeek.library.beacons.BeaconDefinition;
import cz.mendelu.busItWeek.library.beacons.BeaconUtil;
import cz.mendelu.busItWeek.library.map.MapUtil;
import cz.mendelu.busItWeek.library.qrcode.QRCodeUtil;

public class  MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private MapView mapView;
    private MapboxMap mapboxMap;
    private PermissionsManager permissionsManager;
    private LocationEngine locationEngine;
    private LocationComponent locationComponent;

    private StoryLine storyLine;
    private Task currentTask;

    private Marker currentMarker;

    private BeaconUtil beaconUtil;

    private ImageButton qrCodeButton;
    private CardView beaconScanningCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this,"pk.eyJ1IjoiaXlhZDE5OTQiLCJhIjoiY2pyc3k3YWlhMG9sOTQzcXNibW1tcWx1NyJ9.FFN7ljzoLYGBXFjhxnvnmA");

        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mapView = findViewById(R.id.map_view);
        qrCodeButton = findViewById(R.id.qr_button);
        beaconScanningCard = findViewById(R.id.beacon_scanning);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        beaconUtil=new BeaconUtil(this);
        storyLine = StoryLine.open(this,BusITWeekDatabaseHelper.class);
        currentTask = storyLine.currentTask();

        qrCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QRCodeUtil.startQRScan(MapActivity.this);
            }
        });


    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.getUiSettings().setAllGesturesEnabled(true);
        initializeListeners();
        updateMarkers();

    }

    private void initializeListeners(){
       if(currentTask!=null){

           if(currentTask instanceof GPSTask){
               //todo scan for location
               qrCodeButton.setVisibility(View.GONE);
               beaconScanningCard.setVisibility(View.GONE);
           }

           if(currentTask instanceof CodeTask){
               qrCodeButton.setVisibility(View.VISIBLE);
               beaconScanningCard.setVisibility(View.VISIBLE);
           }

           if(currentTask instanceof BeaconTask){
               BeaconDefinition definition = new BeaconDefinition((BeaconTask) currentTask) {
                   @Override
                   public void execute() {
                       runPuzzleActivity(currentTask .getPuzzle());
                   }
               };

               beaconUtil.addBeacon(definition);
               beaconUtil.startRanging();
               qrCodeButton.setVisibility(View.GONE);
               beaconScanningCard.setVisibility(View.VISIBLE);
           }
       }
    }

    private void removeListeners(){


    }
    private void updateMarkers(){
        if(currentTask!=null && mapboxMap!=null){
            if(currentMarker != null){
                mapboxMap.removeMarker(currentMarker);

            }
            currentMarker = mapboxMap.addMarker(creatTaskMarker(this, currentTask));
        }
    }
    private void runPuzzleActivity(Puzzle puzzle){
        if(puzzle instanceof SimplePuzzle){

            startActivity(new Intent(this, SimplePuzzleActivity.class));
        }
        if(puzzle instanceof ChoicePuzzle){

            startActivity(new Intent(this, ChoicePuzzleActivity.class));
        }
        if(puzzle instanceof ImageSelectPuzzle){

            startActivity(new Intent(this, ImagePuzzleActivity.class));
        }

    }
    private MarkerOptions creatTaskMarker(Context context,Task task){



        int color = R.color.colorGPS;
        if(task instanceof BeaconTask){
            color =R.color.colorBeacon;
        }
        if(task instanceof CodeTask){

            color =R.color.colorQR;        }

            return new MarkerOptions().position(new LatLng(task.getLatitude(),task.getLongitude()))
                    .icon(MapUtil.createColoredCircleMarker(context,task.getName(),color));

    }

    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onStop();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mapView.onSaveInstanceState(outState);
    }
}
