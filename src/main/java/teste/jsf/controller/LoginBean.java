/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste.jsf.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Klaus Boeing
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private String usuario;
    
    private String senha;

    public String getSenha() {
        return senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String login(){
        if(usuario == null){
            FacesMessage message = new FacesMessage("O usuário deve ser definido.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }

        //Estamos fazendo uma verificação estática, porém poderiamos validar se o usuário é válido com uma consulta a uma tabela em um banco de dados por exemplo.
        if(!"admin".equals(usuario) || !"123".equals(senha)){
            FacesMessage message = new FacesMessage("O usuário não existe ou a senha é inválida.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return null;
        }
        
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
        
        return "lista-contatos?faces-redirect=true";
    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }
}