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
public class EscuelasDS {
    private Integer id_escuela;
    private String nombre_escuela;
    private String telefono_escuela;
    private String direccion_escuela;
    private String email_escuela;
    private String resultado;

    public Integer getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(Integer id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getNombre_escuela() {
        return nombre_escuela;
    }

    public void setNombre_escuela(String nombre_escuela) {
        this.nombre_escuela = nombre_escuela;
    }

    public String getTelefono_escuela() {
        return telefono_escuela;
    }

    public void setTelefono_escuela(String telefono_escuela) {
        this.telefono_escuela = telefono_escuela;
    }

    public String getDireccion_escuela() {
        return direccion_escuela;
    }

    public void setDireccion_escuela(String direccion_escuela) {
        this.direccion_escuela = direccion_escuela;
    }

    public String getEmail_escuela() {
        return email_escuela;
    }

    public void setEmail_escuela(String email_escuela) {
        this.email_escuela = email_escuela;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    @Override
    public String toString() {
        return nombre_escuela;
    }
}
