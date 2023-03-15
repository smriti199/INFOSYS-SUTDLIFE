package com.marcs.sutdlife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.marcs.mytestfirebaseapplication.R;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {

    TextView textViewMsg;

    final String node = "current_msg";
    DatabaseReference mRootDatabaseRef;
    DatabaseReference mNodeRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        textViewMsg = findViewById(R.id.textViewMsg);
        mRootDatabaseRef = FirebaseDatabase.getInstance().getReference();
        mNodeRef = mRootDatabaseRef.child(node);


        mNodeRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String change = snapshot.getValue(String.class);
                textViewMsg.setText(change);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}