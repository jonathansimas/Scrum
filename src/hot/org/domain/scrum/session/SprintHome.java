package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("sprintHome")
public class SprintHome extends EntityHome<Sprint> {

	@In(create = true)
	EquipeHome equipeHome;

	public void setSprintIdSprint(Integer id) {
		setId(id);
	}

	public Integer getSprintIdSprint() {
		return (Integer) getId();
	}

	@Override
	protected Sprint createInstance() {
		Sprint sprint = new Sprint();
		return sprint;
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

	public Sprint getDefinedInstance() {
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
