package cl.inacap.Covit.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import cl.inacap.Covit.R;
import cl.inacap.Covit.dto.Paciente;

public class PacienteArrayAdapter extends ArrayAdapter<Paciente> {

    private Activity activity;
    private List<Paciente>pacientes;


    public PacienteArrayAdapter(@NonNull Activity context, int resource, @NonNull List<Paciente> objects) {
        super(context, resource, objects);
        this.activity=context;
        this.pacientes=objects;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= this.activity.getLayoutInflater();
        View fila= inflater.inflate(R.layout.paciente_list, null, true);
        TextView nombreTV= fila.findViewById(R.id.nombre_pac_lv);
        TextView apellidoTV= fila.findViewById(R.id.apellido_pac_lv);
        ImageView imagepac=fila.findViewById(R.id.image_prod_lv);
        Paciente pacactual= pacientes.get(position);
        nombreTV.setText(pacactual.getNombre());
        apellidoTV.setText(pacactual.getApellido());
        if (pacactual.getCovit().equalsIgnoreCase("si")|| pacactual.getCovit().equalsIgnoreCase("true")){
            imagepac.setImageResource(R.drawable.ic_virus);
        }
        else {
            imagepac.setImageResource(R.drawable.ic_sin_virus);
        }
        //imagepac.setImageResource(pacactual.getFoto());

        return fila;
    }



}
