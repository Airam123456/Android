package com.example.airam_examen;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Dialogo_Login extends DialogFragment {

    private EditText user, pass;

    //Interfaz de comunicación
    OnDialogoConfirmacionListener listener;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (OnDialogoConfirmacionListener)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "no Implemento OnDialogoConfirmacionListener");
        }
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        android.app.AlertDialog.Builder builder =new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.activity_dialogo_login, null);
        builder.setView(dialogView)
                .setPositiveButton("Aceptar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onPossitiveButtonClick();
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onNegativeButtonClick();
                        dialog.cancel();
                    }
                });

        user = dialogView.findViewById(R.id.txtUser);
        pass = dialogView.findViewById(R.id.txtPass);


        Dialog dialog =  builder.create();

        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    public EditText getUser() {
        return user;
    }

    public EditText getPass() {
        return pass;
    }

    public interface OnDialogoConfirmacionListener {
        void onPossitiveButtonClick();
        void onNegativeButtonClick();
    }

}