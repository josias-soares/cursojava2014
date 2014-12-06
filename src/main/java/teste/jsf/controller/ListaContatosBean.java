package teste.jsf.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import teste.model.Contato;
import teste.model.ContatoRepository;

@ViewScoped
@ManagedBean
public class ListaContatosBean implements Serializable {

    private ListaContatosDataModel dataModel;

    public ListaContatosDataModel getContatos() {
        if (dataModel == null) {
            dataModel = new ListaContatosDataModel();
        }

        return dataModel;
    }

    public String remove(Contato contato) {
        EntityManager em = getEntityManager();
        ContatoRepository repository = new ContatoRepository(em);

        repository.remove(contato);
        
        return "lista-contatos?faces-redirect=true";
    }

    private EntityManager getEntityManager() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
        EntityManager manager = (EntityManager) request.getAttribute("EntityManager");

        return manager;
    }

}
