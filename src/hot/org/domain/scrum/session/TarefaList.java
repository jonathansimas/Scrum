package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tarefaList")
public class TarefaList extends EntityQuery<Tarefa> {

	private static final String EJBQL = "select tarefa from Tarefa tarefa";

	private static final String[] RESTRICTIONS = { "lower(tarefa.texto) like lower(concat(#{tarefaList.tarefa.texto},'%'))", };

	private Tarefa tarefa = new Tarefa();

	public TarefaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tarefa getTarefa() {
		return tarefa;
	}
}
