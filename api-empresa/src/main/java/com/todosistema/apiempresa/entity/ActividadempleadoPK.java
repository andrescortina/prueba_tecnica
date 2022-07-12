package com.todosistema.apiempresa.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Andres Cortina
 */
@Embeddable
public class ActividadempleadoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idactividad")
    private int idactividad;
    @Basic(optional = false)
    @Column(name = "idempleado")
    private int idempleado;

    public ActividadempleadoPK() {
    }

    public ActividadempleadoPK(int idactividad, int idempleado) {
        this.idactividad = idactividad;
        this.idempleado = idempleado;
    }

    public int getIdactividad() {
        return idactividad;
    }

    public void setIdactividad(int idactividad) {
        this.idactividad = idactividad;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idactividad;
        hash += (int) idempleado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadempleadoPK)) {
            return false;
        }
        ActividadempleadoPK other = (ActividadempleadoPK) object;
        if (this.idactividad != other.idactividad) {
            return false;
        }
        if (this.idempleado != other.idempleado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superintendencia.com.prueba.vo.ActividadempleadoPK[ idactividad=" + idactividad + ", idempleado=" + idempleado + " ]";
    }

}
