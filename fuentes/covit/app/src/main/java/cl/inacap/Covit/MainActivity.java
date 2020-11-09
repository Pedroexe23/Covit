package cl.inacap.Covit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
               String rut, contrasena;
                int contrasenas=0;
                rut=Rut.getText().toString().trim();
                if (rut.isEmpty()){
                    Rut.setError("no sea ingresado el Rut");
                }
                contrasena=Contrasena.getText().toString().trim();
                try {
                    contrasenas=Integer.parseInt(contrasena);
                }catch (Exception ex){
                    Contrasena.setError("no se a ingresado correctamente la contraseña, ingresa nuevamente");
                }


                if (contrasenas<=999 ){
                    Contrasena.setError("no se a ingresado correctamente la contraseña, ingresa nuevamente");
                }

                for (Usuario usuario:usuarios){
                    if (usuario.getRut().equalsIgnoreCase(rut) & contrasenas==usuario.getContraseña()){
                        Intent Ingresar= new Intent(MainActivity.this, InicioSession.class );
                        startActivity(Ingresar);
                    }else {
                        AlertDialog.Builder alerta=new AlertDialog.Builder(MainActivity.this);

                        alerta.setMessage("el Rut y  la contraseña no coincide, ingresefs nuevamente")
                    .setCancelable(false)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {

                            dialog.cancel();
                        }
                    });
                        AlertDialog titulo= alerta.create();
                        titulo.setTitle("Error");
                        titulo.show();

                    }
                }


            }
        });
    }
}