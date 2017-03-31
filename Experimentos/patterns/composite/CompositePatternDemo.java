/**
 * CompositePatternDemo.java 26/05/2016
 */
package es.training.experimentos.patterns;

/**
 *	
 *	@author <a href="mailto:manuelvgr">Manuel V. Garcia Rodriguez</a> 26/05/2016
 *
 */
public class CompositePatternDemo {
    public static void main(final String[] args) {

        final Employee CEO = new Employee("John","CEO", 30000);

        final Employee headSales = new Employee("Robert","Head Sales", 20000);

        final Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        final Employee clerk1 = new Employee("Laura","Marketing", 10000);
        final Employee clerk2 = new Employee("Bob","Marketing", 10000);

        final Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        final Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        //print all employees of the organization
        System.out.println(CEO.printHierarchy(0, ' ', '├'));
    }
}

