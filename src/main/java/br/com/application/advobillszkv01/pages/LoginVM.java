package br.com.application.advobillszkv01.pages;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import br.com.application.advobillszkv01.model.User;
import br.com.application.advobillszkv01.repository.UserRepository;
import lombok.Data;

@Data
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginVM {

	private User user;
	private String loginTyped = null;
	private String passwordTyped = null;

	@WireVariable
	private UserRepository userRepository;

	@AfterCompose
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		loginTyped = "brunowsl123@gmail.com";
		passwordTyped = "fox10000";
	}

	@Command
	public void login() {
		if (validaLoginForm()) {
			user = userRepository.findByEmail(loginTyped);
			if (user != null) {
				if (this.user.getPassword().equalsIgnoreCase(passwordTyped)) {
					Sessions.getCurrent().setAttribute("userInSessions", user);
					Executions.getCurrent().sendRedirect("/zkau/web/template.zul");
				} else {
					passwordTyped = "";
					Clients.showNotification("Senha incorreta!", Clients.NOTIFICATION_TYPE_WARNING, null,
							"middle_center", 500);
				}
			} else {
				loginTyped = "";
				Clients.showNotification("Login incorreto!", Clients.NOTIFICATION_TYPE_WARNING, null, "middle_center",
						500);
			}
		}

	}

	public boolean validaLoginForm() {
		if (loginTyped == null || loginTyped.isEmpty()) {
			Clients.showNotification("O campo do login não foi preenchido!", Clients.NOTIFICATION_TYPE_WARNING, null,
					"middle_center", 500);
			return false;
		} else if (passwordTyped == null || passwordTyped.isEmpty()) {
			Clients.showNotification("O campo da senha não foi preenchido!", Clients.NOTIFICATION_TYPE_WARNING, null,
					"middle_center", 500);
			return false;
		} else {
			return true;
		}
	}

}
