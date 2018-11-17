package me.mobapde.edu.ph.rvas;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SysHolder extends RecyclerView.ViewHolder {

    private EditText text, time;
    private Button sendBtn;
    private MainActivity activity;

    public SysHolder(View itemView) {
        super(itemView);

        text = itemView.findViewById(R.id.msg);
        time = itemView.findViewById(R.id.time);
        sendBtn = itemView.findViewById(R.id.sendBtn);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("onClick", "received");
                Intent intent = new Intent(MainActivity.UI_UPDATE_TAG);
                intent.putExtra("msg", text.getText().toString());
                intent.putExtra("ID", MainActivity.JOB_ID);

                int ttime = 1000 * Integer.parseInt(time.getText().toString());

                PendingIntent pendingIntent = PendingIntent.getBroadcast(activity, MainActivity.JOB_ID, intent, 0);
                MainActivity.JOB_ID++;

                AlarmManager alarmManager = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + ttime, pendingIntent);

            }
        });
    }

    public void setText(String text) {
        this.text.setText(text);
    }

    public void setTime(String time) {
        this.time.setText(time);
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
