/**
 * EmptyTeam.java 26/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.patterns.composite;

import java.util.Collections;
import java.util.List;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 26/05/2016
 *
 */
public class EmptyTeam extends Employee {

    public EmptyTeam() {
        super("", "", 0);
    }

    @Override
    public List<TeamBehaviour> listMembers() {
        return Collections.emptyList();
    }

    @Override
    public String printHierarchy(final int indentLevel, final char indent, final char point) {
        return ("");
    }
}
