package cl.inacap.Covit.dto;

public class Paciente {
    private String Rut_paciente;
    private String Nombre;
    private String Apellido;
    private String Fecha_Examen;
    private String Area_Trabajo;
    private String Covit;
    private double Temperatura;
    private String Tos;
    private int Presion_Arterial;
    private int foto;

    public String getRut_paciente() {
        return Rut_paciente;
    }

    public void setRut_paciente(String rut_paciente) {
        Rut_paciente = rut_paciente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getFecha_Examen() {
        return Fecha_Examen;
    }

    public void setFecha_Examen(String fecha_Examen) {
        Fecha_Examen = fecha_Examen;
    }

    public String getArea_Trabajo() {
        return Area_Trabajo;
    }

    public void setArea_Trabajo(String area_Trabajo) {
        Area_Trabajo = area_Trabajo;
    }

    public String getCovit() {
        return Covit;
    }

    public void setCovit(String covit) {
        Covit = covit;
    }

    public double getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(double temperatura) {
        Temperatura = temperatura;
    }

    public String getTos() {
        return Tos;
    }

    public void setTos(String tos) {
        Tos = tos;
    }

    public int getPresion_Arterial() {
        return Presion_Arterial;
    }

    public void setPresion_Arterial(int presion_Arterial) {
        Presion_Arterial = presion_Arterial;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}