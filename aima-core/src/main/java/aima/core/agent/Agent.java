//current approach used

package aima.core.agent;

/**
 * Artificial Intelligence A Modern Approach (3rd Edition): Figure 2.1, page 35.<br>
 * 
 * Figure 2.1 Agents interact with environments through sensors and actuators.
 * 
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 */
public interface Agent extends EnvironmentObject {
	/**
	 * Call the Agent's program, which maps any given percept sequences to an
	 * action.
	 * 
	 * @param percept
	 *            The current percept of a sequence perceived by the Agent.
	 * @return the Action to be taken in response to the currently perceived
	 *         percept.
	 */
	Action execute(Percept percept);

	/**
	 * Life-cycle indicator as to the liveness of an Agent.
	 * 
	 * @return true if the Agent is to be considered alive, false otherwise.
	 */
	boolean isAlive();

	/**
	 * Set the current liveness of the Agent.
	 * 
	 * @param alive
	 *            set to true if the Agent is to be considered alive, false
	 *            otherwise.
	 */
	void setAlive(boolean alive);
}

//my proposed approach

/* I don't know but think this would be the best approad 
*it is ok for me to be defaulted for this, provided my 
*approach or method was wrong.*/

/*This proposal is based on an example pseudo-code which I implemented that talks about an artificial
*breaking system. Which will serve as an artificial driver of a car once implemented*/

public class SimpleReflexAgent {
	private int Action;
	
	public void setPercept(int percept){
		Action = percept;
	}
	
	public int getPercept(){
		return Action;
	}
	
	public void continueWith(){
		int u = getPercept();
		/*now the system has to understand that if it perceives '1' then the break light is on and
		* the driver has to apply breaks, if the system perceives '0' or 'NULL' or '>1' then the
		* driver has to continue with his/her motion*/
		
		if(u == 1){
			System.out.println("The breaks is applied ");
		}
		else {
			/*this segment of the statement simple means
			* if(getPercept() <1 || getPercept() == NULL || getPercept() > 1)
			* and of course you do know that u = getPercept()
			* so where you do see getPercept() it means u and where you do see
			* u it mean getPercept()*/
			
			System.out.println("Keep on with the action");
			
		}
	}
}

//This segment creates an instance of the SimpleReflexAgent class

import java.util.Scanner;
public class UseMethod {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		SimpleReflexAgent a = new SimpleReflexAgent();
		System.out.println("Get What the system Perceives: ");
		int b = input.nextInt();
		a.setPercept(b);
		a.continueWith();
	}
	
}

/*Second Proposal
*The second proposal is simply a modification of the first one which authomatically response once
*the system perceives denger*/

import java.util.Random;
public class TableDrivenAgent {
	
	public static void main(String[] args) {
		
		Random a = new Random();
		int percept;
		String Action;
		System.out.println("Percept\tAction");
		for (int counter=0; counter<10; counter++ ){
			
			percept = counter;
			percept = a.nextInt(2);
			
			/*Percept = 1 means there is danger on ahead of the car
			* while percept = any other number means there road is
			* clear for the driver it can be used for other scenarios
			* as well but with 1 meaning true and others meaning false*/
			
			if (percept == 1){
				Action = " There is denger on the way so, you can slow down";
			}else{
				Action = " You can maintain your speed";
			}
			
			System.out.println(percept +" \t " + Action);
		}
	}
}

