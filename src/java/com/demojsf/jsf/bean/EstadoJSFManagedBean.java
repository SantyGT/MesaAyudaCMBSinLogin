
package com.demojsf.jsf.bean;

import com.demojsf.dao.DaoEstado;
import com.demojsf.impl.DaoEstadoImpl;
import com.demojsf.model.Estado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named(value = "estadoBean")
@ViewScoped

public class EstadoJSFManagedBean implements Serializable {
    
    private Estado estado = new Estado();
    private List<Estado> lista = new ArrayList<>();
    private DaoEstado dao = new DaoEstadoImpl();
    private boolean modoInsert = false;
    private boolean modoEdit = true;

    public boolean isModoInsert() {
        return modoInsert;
    }

    public void setModoInsert(boolean modoInsert) {
        this.modoInsert = modoInsert;
    }

    public boolean isModoEdit() {
        return modoEdit;
    }

    public void setModoEdit(boolean modoEdit) {
        this.modoEdit = modoEdit;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @PostConstruct
    public void iniciar() {
        lista = dao.getEstado();
        estado.setId_estado(lista.size() + 1);
    }

    public List<Estado> getLista() {
        return lista;
    }

    public void setLista(List<Estado> lista) {
        this.lista = lista;       
    }
    
    public Estado getEstado() {
        return estado;
    }

    public EstadoJSFManagedBean() {
    }

    public void save() {

        dao.save(estado);
        lista = dao.getEstado();
        estado = new Estado();
        estado.setId_estado(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }
    
    public void delete() {

        dao.delete(estado);
        lista = dao.getEstado();
        estado = new Estado();
        estado.setId_estado(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void update() {

        dao.update(estado);
        lista = dao.getEstado();
        estado = new Estado();
        estado.setId_estado(lista.size() + 1);
        modoEdit = true;
        modoInsert = false;
    }

    public void changeMode() {
        modoEdit = false;
        modoInsert = true;
    }
    
}
