package com.example.dialogosmenus;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class DialogFramentActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_frament);
    }

    public void showDialogFragment(View view) {
        DialogFragment newFragment = new Dialog1Fragment();
        newFragment.show(getSupportFragmentManager(), "dialog1");
    }
}