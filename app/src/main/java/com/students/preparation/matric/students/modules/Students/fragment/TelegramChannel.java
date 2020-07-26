package com.students.preparation.matric.students.modules.Students.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.students.preparation.matric.students.R;


public class TelegramChannel extends Fragment {


    private LinearLayout telegramLayout;
    private TextView opened;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_telegram_channel, container, false);
        telegramLayout = view.findViewById(R.id.telegramLayout);
        opened = view.findViewById(R.id.opened);
        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        intentMessageTelegram();
                        telegramLayout.setVisibility(View.GONE);
                        opened.setVisibility(View.VISIBLE);
                    }
                },
                3000);
        return view;
    }

    public void intentMessageTelegram() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("tg://resolve?domain=ethiobraves"));
        startActivity(intent);

    }

}