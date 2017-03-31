/**
 * Employee.java 26/05/2016
 *
 * Copyright 2016 INDITEX.
 * Departamento de Sistemas
 */
package train.patterns.composite;

import java.util.ArrayList;
import java.util.List;


/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 26/05/2016
 *
 */
public class Employee implements TeamBehaviour {
    private final String name;
    private final String dept;
    private final int rate;
    private final List<TeamBehaviour> theTeam = new ArrayList<TeamBehaviour>();
    // constructor
    public Employee(final String name,final String dept, final int rate) {
        this.name = name;
        this.dept = dept;
        this.rate = rate;
    }

    public void add(final TeamBehaviour e) {
        this.theTeam.add(e);
    }

    public void remove(final TeamBehaviour e) {
        this.theTeam.remove(e);
    }

    @Override
    public List<TeamBehaviour> listMembers(){
        final ArrayList<TeamBehaviour> result = new ArrayList<TeamBehaviour>(this.theTeam);
        result.add(this);
        return result;
    }

    @Override
    public String toString(){
        return ("[" + this.name + ", " + this.dept + "(" + this.rate + ")]\n");
    }

    @Override
    public int size() {
        return this.theTeam.size() + 1;
    }

    @Override
    public int cost() {
        int result = this.rate;
        for (final TeamBehaviour ateam : this.theTeam) {
            result += ateam.cost();
        }
        return result;
    }

    @Override
    public String printHierarchy(final int indentLevel, final char indent, final char point) {
        final StringBuilder line = new StringBuilder();
        for (int i = 0; i<indentLevel; i++) {
            line.append(indent);
        }
        line.append(point);
        line.append(toString());
        for (final TeamBehaviour subTeam: this.theTeam) {
            line.append(subTeam.printHierarchy(indentLevel + 1, indent, point));
        }
        return line.toString();
    }
}
