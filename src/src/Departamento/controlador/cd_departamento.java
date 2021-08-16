package Departamento.controlador;

import BD.Coneccion;
import Entidad.EntidadDepartamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel Jazmany Villano Escobar
 * @correo danielvillanoescobar@outlook.com
 * @fecha 14 ago. 2021
 * @version 1.0v
 */
public class cd_departamento {

    final String jdbc_driver = "org.postgresql.Driver";

    /**
     * @param e EntidadDepartamento objeto Metodo para insertar a partir de un
     * objeto Nota: en caso de usar un dato autoincrementable o serial en el
     * apartado de values utilizar el siguiente comando
     * VALUES(departamento_SEQ.NEXTVAL, el cual rediccionara al siguiente valor
     * a ser ingresado.
     */
    public void insertarDepartamento(EntidadDepartamento e) {
        try {
            try ( Connection con = Coneccion.initConnection()) {
                Class.forName(jdbc_driver);
                try ( PreparedStatement st = con.prepareStatement("INSERT INTO departamento (codigo,nombre,presupuesto,gastos) " + "VALUES(?,?,?,?)")) {
                    //los set acontinuacion dependen de los tipos de datos de la Base de datos
                    st.setInt(1, e.getCodigo_departamento());
                    st.setString(2, e.getNombre());
                    st.setInt(3, e.getPresupuesto());
                    st.setInt(4, e.getGasto());
                    st.executeUpdate();
                    st.close();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cd_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarDepartamento(EntidadDepartamento e) {
        try {
            try ( Connection con = Coneccion.initConnection()) {
                Class.forName(jdbc_driver);
                try ( PreparedStatement st = con.prepareStatement("UPDATE departamento  SET codigo = ?, nombre=?,presupuesto=?,gastos =? WHERE departamento.codigo = ?")) {
                    //los set acontinuacion dependen de los tipos de datos de la Base de datos
                    st.setInt(1, e.getCodigo_departamento());
                    st.setString(2, e.getNombre());
                    st.setInt(3, e.getPresupuesto());
                    st.setInt(4, e.getGasto());
                    st.setInt(5, e.getCodigo_departamento());
                    st.execute();
                    st.close();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cd_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void EliminarDepartamento(int codigo) {
        try {
            try ( Connection con = Coneccion.initConnection()) {
                Class.forName(jdbc_driver);
                try ( PreparedStatement st = con.prepareStatement("DELETE FROM departamento WHERE codigo = ?")) {
                    //los set acontinuacion dependen de los tipos de datos de la Base de datos
                    st.setInt(1, codigo);
                    st.executeUpdate();
                    st.close();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(cd_departamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * Metodo de tipo void: para listar los datos de una tabla de una Base de
     * datos
     */
    private List<EntidadDepartamento> listar_departamento() {
        //Informacion sobre la base de datos

        List<EntidadDepartamento> lista = null;
        try {
            Connection con = Coneccion.initConnection(); // metodo initConnection -> conecta con la base de datos
            Class.forName(jdbc_driver);
            PreparedStatement st = con.prepareStatement("SELECT * FROM departamento order by codigo"); //se ingrese la sentencia a ejecutar
            ResultSet rs = st.executeQuery(); //ResultSet almacena la informacion , execute query ejecuta la sentencia SQL
            lista = new ArrayList();
            while (rs.next()) {
                EntidadDepartamento ed = new EntidadDepartamento();
                ed.setCodigo_departamento(rs.getInt("codigo"));
                ed.setNombre(rs.getString("nombre"));
                ed.setPresupuesto(rs.getInt("presupuesto"));
                ed.setGasto(rs.getInt("gastos"));
                lista.add(ed);
            }
            st.close();
            st.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    /**
     * @return devuelve un modelo para un JTable
     */
    public DefaultTableModel tabla_departamento() {
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Object> nombre_columna = new ArrayList<>();
        //nombre de las columnas de la tabla
        nombre_columna.add("Codigo");
        nombre_columna.add("Nombre");
        nombre_columna.add("Presupuesto");
        nombre_columna.add("Gastos");
        nombre_columna.forEach(object -> {
            modelo.addColumn(object);
        });
        List<EntidadDepartamento> list = listar_departamento();
        for (int i = 0; i < list.size(); i++) {
            modelo.addRow(new Object[]{
                list.get(i).getCodigo_departamento(),
                list.get(i).getNombre(),
                list.get(i).getPresupuesto(),
                list.get(i).getGasto()
            });
        }
        return modelo;
    }
}
