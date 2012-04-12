package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("equipeHome")
public class EquipeHome extends EntityHome<Equipe> {

	public void setEquipeIdEquipe(Integer id) {
		setId(id);
	}

	public Integer getEquipeIdEquipe() {
		return (Integer) getId();
	}

	@Override
	protected Equipe createInstance() {
		Equipe equipe = new Equipe();
		return equipe;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Equipe getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Usuario> getUsuarios() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getUsuarios());
	}

	public List<Sprint> getSprints() {
		return getInstance() == null ? null : new ArrayList<Sprint>(
				getInstance().getSprints());
	}

	public List<Sprint> getSprints_1() {
		return getInstance() == null ? null : new ArrayList<Sprint>(
				getInstance().getSprints_1());
	}

	public List<Projeto> getProjetos() {
		return getInstance() == null ? null : new ArrayList<Projeto>(
				getInstance().getProjetos());
	}

	public List<Projeto> getProjetos_1() {
		return getInstance() == null ? null : new ArrayList<Projeto>(
				getInstance().getProjetos_1());
	}

	public List<Usuario> getUsuarios_1() {
		return getInstance() == null ? null : new ArrayList<Usuario>(
				getInstance().getUsuarios_1());
	}

}
