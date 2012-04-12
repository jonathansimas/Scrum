package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("usuarioList")
public class UsuarioList extends EntityQuery<Usuario> {

	private static final String EJBQL = "select usuario from Usuario usuario";

	private static final String[] RESTRICTIONS = {
			"lower(usuario.nome) like lower(concat(#{usuarioList.usuario.nome},'%'))",
			"lower(usuario.login) like lower(concat(#{usuarioList.usuario.login},'%'))",
			"lower(usuario.senha) like lower(concat(#{usuarioList.usuario.senha},'%'))",
			"lower(usuario.email) like lower(concat(#{usuarioList.usuario.email},'%'))", };

	private Usuario usuario = new Usuario();

	public UsuarioList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
