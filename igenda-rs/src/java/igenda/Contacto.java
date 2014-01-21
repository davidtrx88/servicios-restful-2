/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package igenda;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diegoojedagarcia
 */
@Entity
@Table(name = "CONTACTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c"),
    @NamedQuery(name = "Contacto.findByIdbd", query = "SELECT c FROM Contacto c WHERE c.idbd = :idbd"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByApellido1", query = "SELECT c FROM Contacto c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Contacto.findByApellido2", query = "SELECT c FROM Contacto c WHERE c.apellido2 = :apellido2"),
    @NamedQuery(name = "Contacto.findByTelefono", query = "SELECT c FROM Contacto c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email"),
    @NamedQuery(name = "Contacto.findByIdagenda", query = "SELECT c FROM Contacto c WHERE c.idagenda = :idagenda"),
    @NamedQuery(name = "Contacto.findByFavorito", query = "SELECT c FROM Contacto c WHERE c.favorito = :favorito")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "IDBD")
    private String idbd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 40)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 40)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TELEFONO")
    private long telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "IDAGENDA")
    private Integer idagenda;
    @Column(name = "FAVORITO")
    private Short favorito;
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN")
    @ManyToOne(optional = false)
    private Usuario login;
    @JoinColumn(name = "GRUPO", referencedColumnName = "IDGRUPO")
    @ManyToOne
    private Grupo grupo;

    public Contacto() {
    }

    public Contacto(String idbd) {
        this.idbd = idbd;
    }

    public Contacto(String idbd, String nombre, long telefono) {
        this.idbd = idbd;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getIdbd() {
        return idbd;
    }

    public void setIdbd(String idbd) {
        this.idbd = idbd;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(Integer idagenda) {
        this.idagenda = idagenda;
    }

    public Short getFavorito() {
        return favorito;
    }

    public void setFavorito(Short favorito) {
        this.favorito = favorito;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbd != null ? idbd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idbd == null && other.idbd != null) || (this.idbd != null && !this.idbd.equals(other.idbd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "igenda.Contacto[ idbd=" + idbd + " ]";
    }
    
}
