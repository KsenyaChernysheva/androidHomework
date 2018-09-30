package com.example.xenya.navigationdrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class ProfileFragment extends Fragment {

    private static final int SEND_REQUEST_CODE = 1;

    private Button btnUpdate;
    private Button btnSend;

    private TextView tName;
    private TextView tPhone;
    private TextView tMail;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false) ;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnSend = view.findViewById(R.id.btn_send);
        btnUpdate = view.findViewById(R.id.btn_update);
        tName = view.findViewById(R.id.text_name);
        tPhone = view.findViewById(R.id.text_phone);
        tMail = view.findViewById(R.id.text_email);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDialogFragment updateDialogFragment = UpdateDialogFragment.newInstance(
                        tName.getText().toString(),
                        tPhone.getText().toString(),
                        tMail.getText().toString());
                updateDialogFragment.setListener(new UpdateDialogFragment.Listener() {
                    @Override
                    public void onCancelClick() {
                        Toast.makeText(getContext(), "Canceled", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onUpdate(String name, String phone, String mail) {
                        tName.setText(name);
                        tPhone.setText(phone);
                        tMail.setText(mail);
                        if(getActivity() instanceof NavDrawableTitleChangable) {
                            ((NavDrawableTitleChangable) getActivity()).setTitles(name, mail);
                        }
                    }
                });
                updateDialogFragment.show(getChildFragmentManager(), "");
            }
        };

        btnUpdate.setOnClickListener(ocl);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, tName.getText().toString() + tPhone.getText().toString() + tMail.getText().toString());
                startActivityForResult(intent, SEND_REQUEST_CODE);
            }
        };

        btnSend.setOnClickListener(onClickListener);

        Intent intent = getActivity().getIntent();
        switch (intent.getAction()) {
            case Intent.ACTION_SEND:
                Toast.makeText(getContext(), intent.getStringExtra(Intent.EXTRA_TEXT), Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_VIEW:
                Toast.makeText(getContext(), intent.getDataString(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == SEND_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(getContext(), "Sent", Toast.LENGTH_SHORT).show();
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(getContext(), "Canceled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Smt wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
