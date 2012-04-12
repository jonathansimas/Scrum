package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("usuarioHome")
public class UsuarioHome extends EntityHome<Usuario> {

	@In(create = true)
	EquipeHome equipeHome;

	public void setUsuarioIdUsuario(Integer id) {
		setId(id);
	}

	public Integer getUsuarioIdUsuario() {
		return (Integer) getId();
	}

	@Override
	protected Usuario createInstance() {
		Usuario usuario = new Usuario();
		return usuario;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Equipe equipe = equipeHome.getDefinedInstance();
		if (equipe != null) {
			getInstance().setEquipe(equipe);
		}
	}

	public boolean isWired() {
		if (getInstance().getEquipe() == null)
			return false;
		return true;
	}

	public Usuario getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tarefa> getTarefas() {
		return getInstance() == null ? null : new ArrayList<Tarefa>(
				getInstance().getTarefas());
	}

	public List<Tarefa> getTarefas_1() {
		return getInstance() == null ? null : new ArrayList<Tarefa>(
				getInstance().getTarefas_1());
	}

}
