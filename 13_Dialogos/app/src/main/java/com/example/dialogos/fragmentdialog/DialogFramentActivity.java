package com.example.dialogos.fragmentdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.dialogos.R;

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

    public class Dialog1Fragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the Builder class for convenient dialog construction
            // Inicializamos el constructor
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            // Seteamos el mensaje
            builder.setMessage(R.string.dialog_message1)
                    .setPositiveButton(R.string.positive_button1, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getContext(), R.string.vale, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getContext(), R.string.cancelado, Toast.LENGTH_SHORT).show();
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}