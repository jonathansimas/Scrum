package org.domain.scrum.session;

import org.domain.scrum.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("projetoList")
public class ProjetoList extends EntityQuery<Projeto> {

	private static final String EJBQL = "select projeto from Projeto projeto";

	private static final String[] RESTRICTIONS = {
			"lower(projeto.nome) like lower(concat(#{projetoList.projeto.nome},'%'))",
			"lower(projeto.descricao) like lower(concat(#{projetoList.projeto.descricao},'%'))", };

	private Projeto projeto = new Projeto();

	public ProjetoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Projeto getProjeto() {
		return projeto;
	}
}
