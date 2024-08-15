/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classBDD;

import classDS.EscuelasDS;
import conexion.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EscuelasBDD {
 public static String registrarEscuelas(EscuelasDS escu) {
        String result = null, last = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO escuelas values(null,?,?,?,?)";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, escu.getNombre_escuela());
            pst.setString(2, escu.getTelefono_escuela());
            pst.setString(3, escu.getDireccion_escuela());
            pst.setString(4, escu.getEmail_escuela());
            pst.execute();
            pst = cn.prepareStatement("SELECT MAX(id_escuela) AS id FROM escuelas");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                last = rs.getString(1);
            }
            result = "Escuela registrado con exito, ID:" + last;
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static String actualizarEscuelas(EscuelasDS escu) {
        String result = null, last = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE escuelas SET nombre_escuela=?, telefono_escuela=?, direccion_escuela=?, email_escuela=? WHERE id_escuela=?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, escu.getNombre_escuela());
            pst.setString(2, escu.getTelefono_escuela());
            pst.setString(3, escu.getDireccion_escuela());
            pst.setString(4, escu.getEmail_escuela());
            pst.setInt(5, escu.getId_escuela());
            pst.execute();

            result = "Escuela actualizado con exito, ID:" + escu.getId_escuela();
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static EscuelasDS buscarEscuelas(String clave) {
        EscuelasDS escu = new EscuelasDS();
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "SELECT * FROM escuelas WHERE id_escuela = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                escu.setId_escuela(Integer.parseInt(rs.getString(1)));
                escu.setNombre_escuela(rs.getString(2));
                escu.setTelefono_escuela(rs.getString(3));
                escu.setDireccion_escuela(rs.getString(4));
                escu.setEmail_escuela(rs.getString(5));
            }
            escu.setResultado("Busqueda exitosa");
        } catch (SQLException e) {
            escu.setResultado("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                escu.setResultado("Error: " + e);
            }
        }
        return escu;
    }

    public static String eliminarEscuelas(String clave) {
        String result = null;
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM escuelas WHERE id_escuela = ?";
        try {
            pst = cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Escuela eliminado con exito";
        } catch (SQLException e) {
            result = "Error en la consulta: " + e.getMessage();
        } finally {
            try {
                if (cn != null) {
                    cn.close();
                    pst.close();
                }
            } catch (Exception e) {
                result = "Error: " + e;
            }
        }
        return result;
    }

    public static ArrayList<EscuelasDS> getListEscuelas() {
        ArrayList<EscuelasDS> arrEscu = new ArrayList<EscuelasDS>();
        Conectar cc = new Conectar();
        Connection cn = cc.getConnection();
        PreparedStatement pst = null;
        EscuelasDS escu = null;
        String sql = "SELECT * FROM escuelas";
        try {
            pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                escu = new EscuelasDS();
                escu.setId_escuela(Integer.parseInt(rs.getString(1)));
                escu.setNombre_escuela(rs.getString(2));
                escu.setDireccion_escuela(rs.getString(3));
                escu.setEmail_escuela(rs.getString(4));
                if (arrEscu.isEmpty()) {
                    arrEscu.add(0, escu);
                } else {
                    arrEscu.add(escu);
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
                System.out.println("Error: " + e);
            }
        }
        return arrEscu;
    }   
}
