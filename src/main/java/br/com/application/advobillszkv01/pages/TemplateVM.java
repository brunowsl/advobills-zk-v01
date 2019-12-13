package br.com.application.advobillszkv01.pages;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;

import br.com.application.advobillszkv01.model.User;
import lombok.Data;

@Data
@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TemplateVM {
	
	private User user;
	
	@AfterCompose
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		
		user = (User) Sessions.getCurrent().getAttribute("userInSessions");
		if(user == null) {
			System.out.println("ssssssssssssssssssss");
			Executions.sendRedirect("/zkau/web/login.zul");
		}
	}

}
