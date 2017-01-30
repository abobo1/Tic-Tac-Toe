package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacToeTest {
	//@before
	public void setup()
	{
		TicTacToeModel model = new TicTacToeModel();
		
	} 
	TicTacToeModel model = new TicTacToeModel();

	@Test
	public void testInitialBoardIsEmpty() {
		assertEquals('E', model.isEmpty());
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.setMarker(0,2);
		assertEquals(model.getMarker(0,2),'X');
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.setMarker(2,0);
		assertEquals(model.getMarker(2,0),'X');
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		model.setMarker(0,0);
		model.setMarker(0,0);
		assertEquals(model.getMarker(0,0),'X');
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		model.setMarker(2,2);
		assertEquals(model.findWinner(), 'E');
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		model.initGame();
		model.setMarker(0,0);
		model.setMarker(1,0);

		model.setMarker(0,1);
		model.setMarker(1,1);

		model.setMarker(0,2);
		model.setMarker(2,0);

		assertEquals(model.findWinner(),'X');
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.initGame();
		model.setMarker(0,0);
		model.setMarker(1,0);

		model.setMarker(2,0);
		model.setMarker(1,1);

		model.setMarker(0,1);
		model.setMarker(2,1);
		model.setMarker(1,2);

		model.setMarker(0,2);
		model.setMarker(2,2);

		
		assertEquals(model.findWinner(), 'T');
	}	
}