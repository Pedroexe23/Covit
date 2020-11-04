package cl.inacap.Covit.dto;

public class Paciente {
    private String Rpaciente;
    private String Nombre;
    private String Apellido;
    private String FExamen;
    private String ATrabajo;
    private String Covit;
    private int Temperatura;
    private String Tos;
    private int PArterial;

    public String getRpaciente() {
        return Rpaciente;
    }

    public void setRpaciente(String rpaciente) {
        Rpaciente = rpaciente;
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

    public String getFExamen() {
        return FExamen;
    }

    public void setFExamen(String FExamen) {
        this.FExamen = FExamen;
    }

    public String getATrabajo() {
        return ATrabajo;
    }

    public void setATrabajo(String ATrabajo) {
        this.ATrabajo = ATrabajo;
    }

    public String getCovit() {
        return Covit;
    }

    public void setCovit(String covit) {
        Covit = covit;
    }

    public int getTemperatura() {
        return Temperatura;
    }

    public void setTemperatura(int temperatura) {
        Temperatura = temperatura;
    }

    public String getTos() {
        return Tos;
    }

    public void setTos(String tos) {
        Tos = tos;
    }

    public int getPArterial() {
        return PArterial;
    }

    public void setPArterial(int PArterial) {
        this.PArterial = PArterial;
    }
}
