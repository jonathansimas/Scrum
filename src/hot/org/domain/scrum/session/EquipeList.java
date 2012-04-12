package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("equipeList")
public class EquipeList extends EntityQuery<Equipe> {

	private static final String EJBQL = "select equipe from Equipe equipe";

	private static final String[] RESTRICTIONS = { "lower(equipe.nome) like lower(concat(#{equipeList.equipe.nome},'%'))", };

	private Equipe equipe = new Equipe();

	public EquipeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Equipe getEquipe() {
		return equipe;
	}
}
