/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBDD;

import classDS.AlumnosDS;
import conexion.Conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AlumnosBDD {
   public static String registrarAlumno(AlumnosDS alumnoDS) {
        String result = null, last = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO alumnos VALUES(null,?,?,?,?,?,?,?,?)";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, alumnoDS.getCedula_alu());
                pst.setString(2, alumnoDS.getNombre_alu());
                pst.setString(3, alumnoDS.getFechaNac_alu());
                pst.setString(4, alumnoDS.getDireccion_alu());
                pst.setString(5, alumnoDS.getEmail_alu());
                pst.setString(6, alumnoDS.getCelular_alu());
                pst.setString(7, alumnoDS.getObservaciones_alu());
                pst.setInt(8, alumnoDS.getId_escuela());
                pst.executeUpdate();
                pst = cn.prepareStatement("SELECT MAX(id_alu) AS id FROM alumnos");
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    last = rs.getString(1);
                }
                result = "Alumno registrado con exito, ID: " + last;
            }
        } catch (SQLException e) {
            result = "Error durante el registro: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
    }

    public static String actualizarAlumnos(AlumnosDS alumnosDS) {
        String result = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE alumnos SET cedula_alu=?, nombre_alu=?, fechaNac_alu=?, direccion_alu=?, email_alu=?, celular_alu=?, observaciones_alu=?, id_escuela=? WHERE id_alu=?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setString(1, alumnosDS.getCedula_alu());
                pst.setString(2, alumnosDS.getNombre_alu());
                pst.setString(3, alumnosDS.getFechaNac_alu());
                pst.setString(4, alumnosDS.getDireccion_alu());
                pst.setString(5, alumnosDS.getEmail_alu());
                pst.setString(6, alumnosDS.getCelular_alu());
                pst.setString(7, alumnosDS.getObservaciones_alu());
                pst.setInt(8, alumnosDS.getId_escuela());
                pst.setInt(9, alumnosDS.getId_alu());
                pst.executeUpdate();
                result = "Alumno Actualizado con exito, ID: " + alumnosDS.getId_alu();
            }
        } catch (SQLException e) {
            result = "Error durante el registro: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
    }

    public static AlumnosDS buscarAlumno(String clave) {
        AlumnosDS alumnoDS = new AlumnosDS();
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM alumnos WHERE id_alu = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    alumnoDS.setId_alu(Integer.parseInt(rs.getString(1)));
                    alumnoDS.setCedula_alu(rs.getString(2));
                    alumnoDS.setNombre_alu(rs.getString(3));
                    alumnoDS.setFechaNac_alu(rs.getString(4));
                    alumnoDS.setDireccion_alu(rs.getString(5));
                    alumnoDS.setEmail_alu(rs.getString(6));
                    alumnoDS.setCelular_alu(rs.getString(7));
                    alumnoDS.setObservaciones_alu(rs.getString(8));
                    alumnoDS.setId_escuela(Integer.parseInt(rs.getString(9)));
                }
                alumnoDS.setResultado("Busqueda exitosa");
            }
        } catch (SQLException e) {
            alumnoDS.setResultado("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                alumnoDS.setResultado("Error " + e);
            }
        }
        return alumnoDS;
    }
    
    public static String eliminarAlumno(String clave) {
        String result = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM alumnos WHERE id_alu = ?";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(clave));
                pst.executeUpdate();
                result = "Alumno eliminado con exito";
            }
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error " + e;
            }
        }
        return result;
    }
    
    public static ArrayList<AlumnosDS> getListAlumnos(){
        ArrayList<AlumnosDS> arrAlumnos = new ArrayList<AlumnosDS>();
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        AlumnosDS alumnosDS = null;
        String sql = "SELECT * FROM alumnos";
        try {
            if (cn != null) {
                pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs.next()) {
                    alumnosDS = new AlumnosDS();
                    alumnosDS.setId_alu(Integer.parseInt(rs.getString(1)));
                    alumnosDS.setCedula_alu(rs.getString(2));
                    alumnosDS.setNombre_alu(rs.getString(3));
                    alumnosDS.setFechaNac_alu(rs.getString(4));
                    alumnosDS.setDireccion_alu(rs.getString(5));
                    alumnosDS.setEmail_alu(rs.getString(6));
                    alumnosDS.setCelular_alu(rs.getString(7));
                    alumnosDS.setObservaciones_alu(rs.getString(8));
                    arrAlumnos.add(alumnosDS);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        return arrAlumnos;
    }
}
