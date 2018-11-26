package com.example.sm_pc.a2018wic;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class Map extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private static final int REQUEST_CODE_PERMISSIOINS = 1000;
    private boolean isExistURL[] = new boolean[6];
    View view;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode) {
            case REQUEST_CODE_PERMISSIOINS:
                if(ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager
                        .PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "현재 내 위치를 업데이트할 수 없습니다. 권한 허가가 필요합니다.", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getActivity(), "버튼을 누르면 현재 내 위치를 업데이트 할 수 있습니다.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getActivity());

        isExistURL[0] = false;
        isExistURL[1] = false;

        for(int i=2; i<6; i++)
            isExistURL[i] = true;
        onLastLocationButtonClicked(view);

        return view;
    }

    public void onLastLocationButtonClicked(View view) {
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(getActivity(),
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_PERMISSIOINS);
//                return ;
        }
        mFusedLocationProviderClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location != null) {
                    LatLng myLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions()
                            .position(myLocation)
                            .title("현재 내 위치")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(myLocation));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));
                }
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        Toast.makeText(getActivity(), "마커를 터치하면\n해당 병원 홈페이지로 이동합니다", Toast.LENGTH_SHORT).show();

        LatLng sm = new LatLng(37.546439, 126.964706);
        final LatLng hospital_1 = new LatLng(37.533706, 127.006745);
        LatLng hospital_2 = new LatLng(37.525544, 126.952715);
        LatLng hospital_3 = new LatLng(37.537170, 126.973205);
        LatLng hospital_4 = new LatLng(37.541370, 126.961022);
        LatLng hospital_5 = new LatLng(37.530490, 126.969543);
        LatLng hospital_6 = new LatLng(37.537055, 126.973056);

        googleMap.addMarker(new MarkerOptions().position(hospital_1).title("노만희정신과의원").snippet("02-793-0945"));
        googleMap.addMarker(new MarkerOptions().position(hospital_2).title("알콜정신전문병원").snippet("02-6953-3901"));
        googleMap.addMarker(new MarkerOptions().position(hospital_3).title("밝은희망가족상담센터").snippet("1522-7350"));
        googleMap.addMarker(new MarkerOptions().position(hospital_4).title("에브리마인드").snippet("02-704-7897"));
        googleMap.addMarker(new MarkerOptions().position(hospital_5).title("맑은샘심리상담연구소").snippet("02-385-6494"));
        googleMap.addMarker(new MarkerOptions().position(hospital_6).title("밝은희망 우울증 전문상담센터").snippet("1522-9563"));

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sm, 15));
        mMap = googleMap;

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(final Marker marker) {
                if(marker.getTitle().equals("노만희정신과의원") || marker.getTitle().equals("알콜정신전문병원")) {
                    Toast.makeText(getActivity(), "해당 병원은 홈페이지가 존재하지 않습니다", Toast.LENGTH_SHORT).show();
                }

                else {
                    if(marker.getTitle().equals("밝은희망가족상담센터"))
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.brightfamily.co.kr/")));
                    else if(marker.getTitle().equals("에브리마인드"))
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.everymindhome.com/")));
                    else if(marker.getTitle().equals("맑은샘심리상담연구소"))
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.selffind.com/")));
                    else if(marker.getTitle().equals("밝은희망 우울증 전문상담센터"))
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://brightdepression.com/")));
                }
                return false;
            }
        });
    }
}
