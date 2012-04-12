package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tarefaHome")
public class TarefaHome extends EntityHome<Tarefa> {

	@In(create = true)
	UsuarioHome usuarioHome;
	@In(create = true)
	SprintHome sprintHome;
	@In(create = true)
	ProjetoHome projetoHome;

	public void setTarefaIdTarefa(Integer id) {
		setId(id);
	}

	public Integer getTarefaIdTarefa() {
		return (Integer) getId();
	}

	@Override
	protected Tarefa createInstance() {
		Tarefa tarefa = new Tarefa();
		return tarefa;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Usuario usuario = usuarioHome.getDefinedInstance();
		if (usuario != null) {
			getInstance().setUsuario(usuario);
		}
		Sprint sprint = sprintHome.getDefinedInstance();
		if (sprint != null) {
			getInstance().setSprint(sprint);
		}
		Projeto projeto = projetoHome.getDefinedInstance();
		if (projeto != null) {
			getInstance().setProjeto(projeto);
		}
	}

	public boolean isWired() {
		if (getInstance().getUsuario() == null)
			return false;
		if (getInstance().getSprint() == null)
			return false;
		if (getInstance().getProjeto() == null)
			return false;
		return true;
	}

	public Tarefa getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
