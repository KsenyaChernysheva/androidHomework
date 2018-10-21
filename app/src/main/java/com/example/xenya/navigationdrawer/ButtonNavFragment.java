package com.example.xenya.navigationdrawer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ButtonNavFragment extends Fragment {

    public static final int REQUEST_CODE = 173;

    private PendingIntent pendingIntent;
    private int mHourOfDay = 0;
    private int mMinute = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottom_nav_content, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView tvClock = view.findViewById(R.id.tv_clock);
        tvClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mHourOfDay = hourOfDay;
                        mMinute = minute;
                        tvClock.setText(hourOfDay + ":" + minute);
                    }
                };
                TimePickerDialog dialog = new TimePickerDialog(getContext(), onTimeSetListener, mHourOfDay, mMinute, true);
                dialog.show();
            }
        });

        Button btnStart = view.findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, mHourOfDay);
                calendar.set(Calendar.MINUTE, mMinute);

                Intent intent = new Intent(getContext(), AlarmBroadcastReciever.class);
                pendingIntent = PendingIntent.getBroadcast(getContext(), REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(calendar.getTimeInMillis(), pendingIntent), pendingIntent);
            }
        });

        Button btnStop = view.findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pendingIntent != null) {
                    AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                    alarmManager.cancel(pendingIntent);
                }
            }
        });
    }
}
