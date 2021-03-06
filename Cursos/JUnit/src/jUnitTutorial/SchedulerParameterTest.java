package jUnitTutorial;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import resourceSched.MessageWrapper;
import resourceSched.RsrcSched;

@RunWith(Parameterized.class)
public class SchedulerParameterTest{
	private int expectedIdx;
	private int nofMsgs = 0;
	private int completed;
	private int fail = -1;
	
	@Before
	public void initialize() {
		/*Initialization*/
		LOG.setLevel(globalLogLevel);
	}


    		  ,{1,2,3,4,1,1,1,1,2,2,2,3,3,3}, {1,2,3,8,4,5,6,7,9,10,11} /*suspected case from paper exercise*/
    		  ,{1,1,1,1,1,1,1,1,1,1,1,1,1},   {1,2,3,4,5,6,7,8,9,10,11,12} /*Single groupID, single resource*/
    		  ,{3,1,1,1,1,1,1,1,1,1,1,1,1},   {1,2,3,4,5,6,7,8,9,10,11,12} /*Single GroupID, Multiple resources */
    		  ,{3,1,2,3,1,1,1,1,1,1}, {1,4,5,6,7,8,9,2,3} /*All messages from first GroupID are processed first*/
    		  ,{3,1,2,3,4,5,6,7,8,1}, {1,9,2,3,4,5,6,7,8} /*All messages from first GroupID are processed first*/ 
    		  ,{3,1,9,9,9,1,1,1,1,1}, {1,5,6,7,8,9,2,3,4} /*GroupID does not have anything to do with schedule*/
    		  ,{5,9,8,7,6,5,4,3,2,1}, {1,2,3,4,5,6,7,8,9} /*GroupID does not have anything to do with schedule*/
    		  ,{20,Integer.MAX_VALUE,Integer.MAX_VALUE-1,Integer.MAX_VALUE-2,Integer.MAX_VALUE-3,Integer.MAX_VALUE,
    		  /*case continues*/Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}, {1,5,6,7,8,9,2,3,4}
      });
   }

	@Test
	public void testEachCase() {
		RsrcSched rs;
//		GatewayMockUpParameterized gw;
//		gw = new GatewayMockUpParameterized();
//		gw.setCounter(this);
		GatewayMockUp gw;
		gw = new GatewayMockUp();
		rs = new RsrcSched(dataSet[1], gw);
		assertNotNull(rs);
		MessageWrapper.setScheduler(rs);
		
		expectedIdx = 0; /*results didn't start arriving yet*/
		for (int i = 1; i < (dataSet.length - 1); i++){
			rs.sendAndQueueMsg(new MessageWrapper(dataSet[i], getMsgIdx()));
		}
		completed = 0;
		/*Wait while the gateway processes all data*/
		try {
			while (0 == completed) this.wait();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		if (-1 != fail) {
			fail("Arived out of order: message ");
		}
	}

	@Ignore
//	@Test
	public void testAlwaysPass(){
		assertTrue(true);
	}
	private int getMsgIdx(){
		nofMsgs ++;
		return (nofMsgs);
	}

	public int getNofMsgs(){
		return (nofMsgs);
	}
	
	public void failCurrentTstAt(int idx){
		fail = idx;
	}

//	synchronized public void thisArrived(Message msg) {
//		int msgIdx = ((MessageWrapper)msg).getBody();
//		if (expected[expectedIdx]!= msgIdx){
//			failCurrentTstAt(msgIdx);
//			LOG.fine("Out of sync: " + msgIdx + "(" + ((MessageWrapper)msg).toString() + ")");
//		}
//		if (dataSet.length <= msgIdx) {//we're done
//			completed = 1;
//			this.notify(); /*all arrived, keep going*/
//		}
//	}
	
}