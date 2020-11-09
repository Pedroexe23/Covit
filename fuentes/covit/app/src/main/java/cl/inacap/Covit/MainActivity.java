package cl.inacap.Covit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


import cl.inacap.Covit.dao.UsuarioDAO;
import cl.inacap.Covit.dto.Usuario;

public class MainActivity extends AppCompatActivity {
private Button ingresar;
private EditText Rut;
private EditText Contrasena;
private List<Usuario>usuarios=new UsuarioDAO().mostrarUsuario();
;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.Rut=findViewById(R.id.Rutxt);
        this.Contrasena=findViewById(R.id.contrasenatxt);
        this.ingresar=findViewById(R.id.ingresarbtn);
        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rut;
                int contrasena;
                rut=Rut.getText().toString().trim();
                contrasena=Integer.parseInt(Contrasena.getText().toString().trim());
                for (Usuario usuario:usuarios){
                    if (usuario.getRut().equalsIgnoreCase(rut) & contrasena==usuario.getContraseña()){
                        Intent Ingresar= new Intent(MainActivity.this, InicioSession.class );
                        startActivity(Ingresar);
                    }
                }


            }
        });
    }
}