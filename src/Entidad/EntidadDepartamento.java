/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Daniel Jazmany Villano Escobar
 * @correo danielvillanoescobar@outlook.com
 * @fecha 13 ago. 2021
 * @version 1.0v
 */
public class EntidadDepartamento {

    private int codigo_departamento;
    private String nombre;
    private int presupuesto;
    private int gasto;

    public EntidadDepartamento() {

    }

    public EntidadDepartamento(int codigo_departamento, String nombre, int presupuesto, int gasto) {
        this.codigo_departamento = codigo_departamento;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.gasto = gasto;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
}
