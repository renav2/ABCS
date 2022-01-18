package com.example.abcs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminPermissionHome extends AppCompatActivity {
Button ViewApprove, ViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_permission_home);

        ViewApprove= (Button)findViewById(R.id.aproveact);
        ViewApprove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewApp();
            }
        });
        ViewHistory= (Button)findViewById(R.id.viewact);
        ViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHistoryApp();
            }
        });
    }

    private void openViewApp() {
        Intent intent = new Intent(this, Admin_View_Application.class);
        startActivity(intent);
    }

    private void openHistoryApp() {
        Intent intent = new Intent(this, Admin_Application_History.class);
        startActivity(intent);
    }

}