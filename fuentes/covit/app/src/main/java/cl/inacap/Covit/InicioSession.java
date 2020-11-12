package cl.inacap.Covit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import cl.inacap.Covit.adapter.PacienteArrayAdapter;
import cl.inacap.Covit.dao.PacienteDAO;
import cl.inacap.Covit.dao.PacienteDAOSqlite;
import cl.inacap.Covit.dto.Paciente;

public class InicioSession extends AppCompatActivity {
    private FloatingActionButton RegistrarBtn;
    private ListView pacientelv;
    private List<Paciente> Pacientes;
    private PacienteArrayAdapter adaptador;
    private PacienteDAO pacientesDAO= new PacienteDAOSqlite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_session);
        this.RegistrarBtn=findViewById(R.id.AgregarPacienteBtn);
        this.RegistrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InicioSession.this, Registrar_Paciente.class));
            }
        });

    }
    protected void onResume(){
        super.onResume();
        Pacientes=pacientesDAO.getAll();
        adaptador= new PacienteArrayAdapter(this,
                R.layout.paciente_list, Pacientes);
        pacientelv= findViewById(R.id.PacientesLv);
        pacientelv.setAdapter(adaptador);


    }
}