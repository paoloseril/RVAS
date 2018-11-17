package me.mobapde.edu.ph.rvas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver receiver = new ToastReceiver();
    static final String UI_UPDATE_TAG = "ph.edu.mobapde.me.rvas";
    static int JOB_ID = 1000;
    RecyclerView.LayoutManager manager;
    RecyclerView recyclerView;
    SysAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new SysAdapter(this);
        manager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.recycler_area);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(UI_UPDATE_TAG);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
    }

    class ToastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("Br", "onReceive()");
            Toast.makeText(context, intent.getStringExtra("msg"), Toast.LENGTH_LONG).show();
        }
    }
}
