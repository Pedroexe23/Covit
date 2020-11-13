package cl.inacap.Covit;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cl.inacap.Covit.dao.PacienteDAO;
import cl.inacap.Covit.dao.PacienteDAOSqlite;
import cl.inacap.Covit.dto.Paciente;

public class Registrar_Paciente extends AppCompatActivity {
    private Button registrar;
    private int dia, mes, anio, Dia, Mes, Anio;
    static final int DATE_ID=1;
    Date d = new Date();
    Calendar C= Calendar.getInstance();
    private EditText rut;
    private EditText nombrepaciente;
    private EditText apellidopaciente;
    private EditText examens;
    private EditText temperatura;
    private EditText Presion;
    private Switch covit;
    private Switch tos;
    private Spinner area;
    private PacienteDAO pacDAO= new PacienteDAOSqlite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar__paciente);
        rut= findViewById(R.id.RutTXT);
        nombrepaciente= findViewById(R.id.NombreTxt);
        apellidopaciente=findViewById(R.id.ApellidoTxt);
        examens=findViewById(R.id.ExamenTxt);
        temperatura=findViewById(R.id.TemperaturaTxt);
        Presion=findViewById(R.id.PresionTxt);
        covit=findViewById(R.id.CovitSch);
        tos= findViewById(R.id.TosSch);
        registrar=findViewById(R.id.Registrarbtn);
        area=findViewById(R.id.TrabajoSP);

        String[] arrayArea={"Atención a publico", "Otro"};
        dia=C.get(Calendar.DAY_OF_MONTH);
        mes=C.get(Calendar.MONTH);
        anio=C.get(Calendar.YEAR);

        examens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DATE_ID);
            }
        });

        area.setAdapter((new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayArea)));

        area.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Log.d("area elegida:", parent.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> Errores= new ArrayList<>();
                boolean esValido=true;

                String Nombre=nombrepaciente.getText().toString().trim();
                if (Nombre.isEmpty()){
                    Errores.add("no se a ingresado el nombre o los nombres ingrese nuevamente");

                }

                String Apellido=apellidopaciente.getText().toString().trim();
                if (Apellido.isEmpty()){
                    Errores.add("no se a ingresado el o los apellido ingrese nuevamente");
                }

                String fechasC=examens.getText().toString().trim();
                if (fechasC.isEmpty()){
                    Errores.add("no se ha ingresado la fecha ");
                }

                int presion=0;
                double Temperatura=0;
                try {
                    presion= Integer.parseInt(Presion.getText().toString().trim());
                    Temperatura=Double.parseDouble(temperatura.getText().toString().trim());
                }catch (Exception e){
                    Errores.add("La presion esta mal indicada o la tempertura esta mal reingrese nuevamente");

                }



                String Areas=area.getSelectedItem().toString();

                String[] RutArr;

                String Rut=rut.getText().toString().trim();

                if (Rut.isEmpty()){
                    Errores.add("NO has ingresado el rut ingrese nuevamente");
                }

                RutArr=Rut.split("-");

                if (RutArr.length==2){
                    if ((RutArr[0].length()==7 ||RutArr[0].length()==8 ) && RutArr[1].length()==1 ){
                    boolean esNumero;
                    try{
                        Integer.parseInt(RutArr[0]);
                        esNumero= true;
                    }catch (Exception ex){
                        esNumero=false;
                        Errores.add("No esta bien escritos el rut intente nuevamente");
                        boolean esdigito= false;
                        if (RutArr[1].toLowerCase().equals("k")) {
                            esdigito=true;

                        }else {
                            try {
                                Integer.parseInt(RutArr[1]);
                                esdigito= true;
                            }catch (Exception ex1){
                                esdigito=false;
                                Errores.add("no es bien esctrio el digito");
                            }
                        }
                        if (esNumero && esdigito){
                            esValido = true;
                        }else {
                            esValido=false;
                        }
                    }
                    }

                    String Covits;

                    if (covit.isChecked()){
                        Covits= "si";
                    }else {
                        Covits="no";
                    }

                    String Toss;

                    if (tos.isChecked()){
                        Toss="si";
                    }else {
                        Toss="no";
                    }

                    if (Errores.isEmpty()){
                        Paciente p = new Paciente();
                        p.setRut_paciente(Rut);
                        p.setNombre(Nombre);
                        p.setApellido(Apellido);
                        p.setFecha_Examen(fechasC);
                        p.setArea_Trabajo(Areas);
                        p.setCovit(Covits);
                        p.setTemperatura(Temperatura);
                        p.setTos(Toss);
                        p.setPresion_Arterial(presion);
                        pacDAO.Save(p);
                        startActivity(new Intent(Registrar_Paciente.this, InicioSession.class));
                    }else {

                        AlertDialog.Builder alertas= new AlertDialog.Builder(Registrar_Paciente.this);

                        alertas.setMessage((CharSequence) Errores)
                                .setCancelable(true)
                                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int i) {

                                        dialog.cancel();
                                    }
                                });
                        AlertDialog titulo= alertas.create();
                        titulo.setTitle("Error");
                        titulo.show();
                    }


                }

            }
        });


        
    }

    private void colocarFecha(){
        examens.setText( Anio+"/"+(Mes+1)+"/"+Dia);
    }

    private  DatePickerDialog.OnDateSetListener onDateSetListener= new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int D, int M, int Y) {
        Dia=D;
        Mes=M;
        Anio=Y;
        colocarFecha();
        }
    };

    protected Dialog onCreateDialog(int id){
        switch(id){
            case  DATE_ID:
                return new DatePickerDialog(this, onDateSetListener, dia, mes, anio );
        }
        return null;
    }
}