/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
    @NamedQuery(name = "Contacto.findById", query = "SELECT c FROM Contacto c WHERE c.contactoPK.id = :id"),
    @NamedQuery(name = "Contacto.findByNombre", query = "SELECT c FROM Contacto c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Contacto.findByApellido1", query = "SELECT c FROM Contacto c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Contacto.findByApellido2", query = "SELECT c FROM Contacto c WHERE c.apellido2 = :apellido2"),
    @NamedQuery(name = "Contacto.findByTelefono", query = "SELECT c FROM Contacto c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Contacto.findByEmail", query = "SELECT c FROM Contacto c WHERE c.email = :email"),
    @NamedQuery(name = "Contacto.findByLogin", query = "SELECT c FROM Contacto c WHERE c.contactoPK.login = :login")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ContactoPK contactoPK;
    @Size(max = 40)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 40)
    @Column(name = "APELLIDO1")
    private String apellido1;
    @Size(max = 40)
    @Column(name = "APELLIDO2")
    private String apellido2;
    @Column(name = "TELEFONO")
    private Long telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "GRUPO", referencedColumnName = "NOMBREGRUPO")
    @ManyToOne
    private Grupo grupo;

    public Contacto() {
    }

    public Contacto(ContactoPK contactoPK) {
        this.contactoPK = contactoPK;
    }

    public Contacto(int id, String login) {
        this.contactoPK = new ContactoPK(id, login);
    }

    public ContactoPK getContactoPK() {
        return contactoPK;
    }

    public void setContactoPK(ContactoPK contactoPK) {
        this.contactoPK = contactoPK;
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

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (contactoPK != null ? contactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.contactoPK == null && other.contactoPK != null) || (this.contactoPK != null && !this.contactoPK.equals(other.contactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servicios.Contacto[ contactoPK=" + contactoPK + " ]";
    }
    
}
