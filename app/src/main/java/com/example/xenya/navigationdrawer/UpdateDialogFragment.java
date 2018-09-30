package com.example.xenya.navigationdrawer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class UpdateDialogFragment extends DialogFragment {
    private static final String KEY_NAME = "NAME";
    private static final String KEY_PHONE = "PHONE";
    private static final String KEY_MAIL = "MAIL";
    private Button btnUpdate;
    private Button btnCancel;
    private EditText etName;
    private EditText etPhone;
    private EditText etMail;
    private Listener listener;

    public static UpdateDialogFragment newInstance(String name, String phone, String mail) {
        Bundle args = new Bundle();
        args.putString(KEY_NAME, name);
        args.putString(KEY_PHONE, phone);
        args.putString(KEY_MAIL, mail);
        UpdateDialogFragment fragment = new UpdateDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnUpdate = view.findViewById(R.id.btn_update);
        btnCancel = view.findViewById(R.id.btn_cancel);
        etName = view.findViewById(R.id.et_name);
        etPhone = view.findViewById(R.id.et_phone);
        etMail = view.findViewById(R.id.et_email);

        etName.setText(getArguments().getString(KEY_NAME, ""));
        etPhone.setText(getArguments().getString(KEY_PHONE, ""));
        etMail.setText(getArguments().getString(KEY_MAIL, ""));

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onCancelClick();
                }
                dismiss();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onUpdate(
                            etName.getText().toString(),
                            etPhone.getText().toString(),
                            etMail.getText().toString()
                    );
                }
                dismiss();
            }
        });
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener {
        void onCancelClick();
        void onUpdate(String name, String phone, String mail);
    }
}
