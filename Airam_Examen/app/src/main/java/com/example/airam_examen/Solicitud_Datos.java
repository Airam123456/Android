package com.example.airam_examen;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Solicitud_Datos extends AppCompatActivity {

    private EditText nombre, fecha, provincia;
    private TextView selec;
    private RadioGroup radio;
    private CheckBox php, java, html, css;
    private Button evaluar, salir;
    private int recuento = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud_datos);

        nombre = (EditText) findViewById(R.id.etxtnombre);
        fecha = (EditText) findViewById(R.id.etxtFecha);
        provincia = (EditText) findViewById(R.id.etxtProvincia);
        radio = (RadioGroup) findViewById(R.id.radioGrupo);
        php = (CheckBox) findViewById(R.id.checkPHP);
        java = (CheckBox) findViewById(R.id.checkJava);
        html = (CheckBox) findViewById(R.id.checkHTML);
        css = (CheckBox) findViewById(R.id.checkCSS);
        selec = (TextView) findViewById(R.id.txtSelecionados);
        evaluar = (Button) findViewById(R.id.btnEvaluar);
        salir = (Button) findViewById(R.id.btnSalir);

        selec.setText(recuento);

        evaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = "", date = "", prov = "", sexo = "", cono = "";

                if(nombre.getText().toString().length() == 0)
                    name = "nombre vacio";
                else
                    name = nombre.getText().toString();

                if(fecha.getText().toString().length() == 0)
                    date = "fecha vacia";
                else
                    date = fecha.getText().toString();

                if(provincia.getText().toString().length() == 0)
                    prov = "nombre vacio";
                else
                    prov = provincia.getText().toString();

                if(radio.getCheckedRadioButtonId() == -1)
                    sexo = "No especificado";
                else{
                    RadioButton radioBtn = (RadioButton) findViewById(radio.getCheckedRadioButtonId());
                    sexo = radioBtn.getText().toString();
                }

                if(php.isChecked())
                    cono += "PHP ";
                if(java.isChecked())
                    cono += "JAVA ";
                if(html.isChecked())
                    cono += "HTML ";
                if(css.isChecked())
                    cono += "CSS ";

                Intent intent = new Intent(Solicitud_Datos.this, Registro_Datos.class);
                intent.putExtra("name", name);
                intent.putExtra("date", date);
                intent.putExtra("prov",prov);
                intent.putExtra("sexo", sexo);
                intent.putExtra("cono",cono);
                startActivityForResult(intent,12);

            }
        });


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==12 && resultCode==RESULT_OK)
        {
            recuento++;
            selec.setText(recuento);
        }
    }
}