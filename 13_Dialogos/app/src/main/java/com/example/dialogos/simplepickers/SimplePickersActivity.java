package com.example.dialogos.simplepickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.dialogos.R;

//https://developer.android.com/guide/topics/ui/controls/pickers

public class SimplePickersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_pickers);
    }

    public void seleccionarHora(View view) {
        TimerPickerFragment timerPickerFragment = new TimerPickerFragment();
        timerPickerFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void seleccionarFecha(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void abrirDialogo(View view) {
        MiDialogFragment miDialogFragment = new MiDialogFragment();
        miDialogFragment.show(getSupportFragmentManager(), "miDialog");

    }

    public static class TimerPickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar fechaActual = Calendar.getInstance();
            int hora = fechaActual.get(Calendar.HOUR_OF_DAY);
            int minuto  = fechaActual.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(), this, hora, minuto, DateFormat.is24HourFormat(getActivity()));
        }

        @Override
        public void onTimeSet(TimePicker timePicker, int i, int i1) {
            Toast.makeText(getActivity(), "Selecciono " + i + ":" + i1, Toast.LENGTH_LONG).show();
        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            Calendar fechaActual = Calendar.getInstance();

            int anio = fechaActual.get(Calendar.YEAR);
            int mes = fechaActual.get(Calendar.MONTH);
            int dia = fechaActual.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(), this, anio, mes, dia);
        }

        @Override
        public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
            Toast.makeText(getActivity(), "Selecciono: " + dia + "/" + mes + "/" + anio, Toast.LENGTH_SHORT).show();
        }
    }

    public static class MiDialogFragment extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Qué lenguaje conoces?");
//            builder.setMessage("Si no guarda los cambios se perderán");

            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getActivity(), "Se guardo correctamente", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(getActivity(), "Operación cancelada", Toast.LENGTH_SHORT).show();
                }
            });

            // items
//            builder.setItems(R.array.planetas, new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    Toast.makeText(getActivity(), "Usted presionó " + i, Toast.LENGTH_SHORT).show();
//                }
//            });

            // Seleccion Multiple

            builder.setMultiChoiceItems(R.array.lenguajes, null, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    Toast.makeText(getActivity(), "Usted selecciono " + i + " " + b, Toast.LENGTH_SHORT).show();
                }
            });


            return builder.create();
        }

    }



}