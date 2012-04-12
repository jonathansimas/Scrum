package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("sprintList")
public class SprintList extends EntityQuery<Sprint> {

	private static final String EJBQL = "select sprint from Sprint sprint";

	private static final String[] RESTRICTIONS = { "lower(sprint.nome) like lower(concat(#{sprintList.sprint.nome},'%'))", };

	private Sprint sprint = new Sprint();

	public SprintList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Sprint getSprint() {
		return sprint;
	}
}
