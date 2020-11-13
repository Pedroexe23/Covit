package cl.inacap.Covit.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.Covit.dto.Paciente;
import cl.inacap.Covit.helper.PacienteSqlitehelper;

public class PacienteDAOSqlite implements PacienteDAO {
    private PacienteSqlitehelper pachelper;

    public PacienteDAOSqlite(Context context){
        this.pachelper=new PacienteSqlitehelper(context, "DBPaciente", null, 7);
    }

    @Override
    public List<Paciente> getAll() {
        SQLiteDatabase reader= this.pachelper.getReadableDatabase();
        List<Paciente>pacientes= new ArrayList<>();
        try {
            if (reader!= null){
                Cursor c= reader.rawQuery("SELECT rut, nombre" +
                        ", apellido, fecha, area, covit, temperatura, tos, presion " +
                        "FROM paciente", null);
                if (c.moveToFirst()){
                    do {
                        Paciente p = new Paciente();
                        p.setRut_paciente(c.getString(0));
                        p.setNombre(c.getString(1));
                        p.setApellido(c.getString(2));
                        p.setFecha_Examen(c.getString(3));
                        p.setArea_Trabajo(c.getString(4));
                        p.setCovit(c.getString(5));
                        p.setTemperatura(c.getDouble(6));
                        p.setTos(c.getString(7));
                        p.setPresion_Arterial(c.getInt(8));
                        pacientes.add(p);
                    }while (c.moveToNext());
                }
                reader.close();
            }
        }catch (Exception ex){
            pacientes=null;
        }
        return pacientes;
    }


    @Override
    public Paciente Save(Paciente p) {
        SQLiteDatabase writer = this.pachelper.getWritableDatabase();

        String sql= String.format( "INSERT INTO (" +
                        "rut" +
                        ", nombre" +
                        ", apellido" +
                        ", fecha" +
                        ", area" +
                        ", covit" +
                        ", temperatura" +
                        ", tos" +
                        ", presion )" +
                "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%d', '%s', '%f')",p.getRut_paciente()
                , p.getNombre(), p.getApellido(),
                p.getFecha_Examen(), p.getArea_Trabajo(),
                p.getCovit(), p.getTemperatura(),
                p.getTos(), p.getPresion_Arterial());


        writer.execSQL(sql);



        writer.close();

        return p;
    }
}
