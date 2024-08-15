/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classDS;

/**
 *
 * @author SafeComputer
 */
public class AlumnosDS {
    
    private Integer id_alu;
    private String nombre_alu;
    private String cedula_alu;
    private String fechaNac_alu;
    private String direccion_alu;
    private String email_alu;
    private String celular_alu;
    private String observaciones_alu;
    private Integer id_escuela;
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getId_alu() {
        return id_alu;
    }

    public void setId_alu(Integer id_alu) {
        this.id_alu = id_alu;
    }

    public String getNombre_alu() {
        return nombre_alu;
    }

    public void setNombre_alu(String nombre_alu) {
        this.nombre_alu = nombre_alu;
    }

    public String getCedula_alu() {
        return cedula_alu;
    }

    public void setCedula_alu(String cedula_alu) {
        this.cedula_alu = cedula_alu;
    }

    public String getFechaNac_alu() {
        return fechaNac_alu;
    }

    public void setFechaNac_alu(String fechaNac_alu) {
        this.fechaNac_alu = fechaNac_alu;
    }

    public String getDireccion_alu() {
        return direccion_alu;
    }

    public void setDireccion_alu(String direccion_alu) {
        this.direccion_alu = direccion_alu;
    }

    public String getEmail_alu() {
        return email_alu;
    }

    public void setEmail_alu(String email_alu) {
        this.email_alu = email_alu;
    }

    public String getCelular_alu() {
        return celular_alu;
    }

    public void setCelular_alu(String celular_alu) {
        this.celular_alu = celular_alu;
    }

    public String getObservaciones_alu() {
        return observaciones_alu;
    }

    public void setObservaciones_alu(String observaciones_alu) {
        this.observaciones_alu = observaciones_alu;
    }

    public Integer getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(Integer id_escuela) {
        this.id_escuela = id_escuela;
    }

    @Override
    public String toString() {
        return "AlumnosDS{" + "nombre_alu=" + nombre_alu + '}';
    }
    
}
