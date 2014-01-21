/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package igenda;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diegoojedagarcia
 */
@Entity
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findByVersion", query = "SELECT u FROM Usuario u WHERE u.version = :version")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login")
    private Collection<Contacto> contactoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "login")
    private Collection<Grupo> grupoCollection;

    public Usuario() {
    }

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(String login, int version) {
        this.login = login;
        this.version = version;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public Collection<Contacto> getContactoCollection() {
        return contactoCollection;
    }

    public void setContactoCollection(Collection<Contacto> contactoCollection) {
        this.contactoCollection = contactoCollection;
    }

    @XmlTransient
    public Collection<Grupo> getGrupoCollection() {
        return grupoCollection;
    }

    public void setGrupoCollection(Collection<Grupo> grupoCollection) {
        this.grupoCollection = grupoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "igenda.Usuario[ login=" + login + " ]";
    }
    
}
