package managedbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import model.Usuario;
import relatoriosgraficos.SessionUtil;

@RequestScoped
@ManagedBean(name = "LoginMB")

public class LoginManagedBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private Usuario usuario = new Usuario();

	public String envia() {

		usuario = usuarioDAO.getUsuario(usuario.getNomeUsuario(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!!!", "Erro no Login!"));
			return null;
		} else {
			Object b = new Object();
			SessionUtil.setParam("usuarioLogado", b);
			return "graficos?faces-redirect=true";
		}

	}

	public String logout() {
		// SessionUtil.setParam("usuarioLogado", null);
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}