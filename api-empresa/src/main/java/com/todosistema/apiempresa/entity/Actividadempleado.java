package com.todosistema.apiempresa.entity;

import java.io.Serializable;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Andres Cortina
 */
@Entity
@Table(name = "actividadempleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividadempleado.findAll", query = "SELECT a FROM Actividadempleado a"),
    @NamedQuery(name = "Actividadempleado.findByIdactividad", query = "SELECT a FROM Actividadempleado a WHERE a.actividadempleadoPK.idactividad = :idactividad"),
    @NamedQuery(name = "Actividadempleado.findByIdempleado", query = "SELECT a FROM Actividadempleado a WHERE a.actividadempleadoPK.idempleado = :idempleado")})
public class Actividadempleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActividadempleadoPK actividadempleadoPK;
    @JoinColumn(name = "idactividad", referencedColumnName = "idactividad", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Actividad actividad;
    @JoinColumn(name = "idempleado", referencedColumnName = "idempleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;

    public Actividadempleado() {
    }

    public Actividadempleado(ActividadempleadoPK actividadempleadoPK) {
        this.actividadempleadoPK = actividadempleadoPK;
    }

    public Actividadempleado(int idactividad, int idempleado) {
        this.actividadempleadoPK = new ActividadempleadoPK(idactividad, idempleado);
    }

    public ActividadempleadoPK getActividadempleadoPK() {
        return actividadempleadoPK;
    }

    public void setActividadempleadoPK(ActividadempleadoPK actividadempleadoPK) {
        this.actividadempleadoPK = actividadempleadoPK;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actividadempleadoPK != null ? actividadempleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividadempleado)) {
            return false;
        }
        Actividadempleado other = (Actividadempleado) object;
        if ((this.actividadempleadoPK == null && other.actividadempleadoPK != null) || (this.actividadempleadoPK != null && !this.actividadempleadoPK.equals(other.actividadempleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "superintendencia.com.prueba.vo.Actividadempleado[ actividadempleadoPK=" + actividadempleadoPK + " ]";
    }
    
}