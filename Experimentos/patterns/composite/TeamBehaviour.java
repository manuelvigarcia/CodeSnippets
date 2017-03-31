/**
 * TeamBehaviour.java 26/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.patterns.composite;

import java.util.List;


/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 26/05/2016
 *
 */
public interface TeamBehaviour {
    int size();
    int cost();
    List<TeamBehaviour> listMembers();
    String printHierarchy(int indentLevel, char indent, char point);
}
