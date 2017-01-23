package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	TicTacToeModel model = new TicTacToeModel();
	@Test
	public void testInitialBoardIsEmpty() {
		assertTrue(model.isEmpty());
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		model.setMarker(0,2);
		assertTrue(model.getMarker(0,2) == 'X');
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		model.setMarker(2,0);
		assertTrue(model.getMarker(2,0) == 'X');
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		char oldMark = model.getMarker(0,0);
		model.setMarker(0,0);
		assertTrue(oldMark == model.getMarker(2,0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		assertTrue(model.findWinner() == 'E');
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

		assertTrue(model.findWinner() != 'E');
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		model.initGame();
		for (int h=0;h<3;h++)
			for (int w=0;w<3;w++)
			{
				model.setMarker(h,w);
			}
		assertTrue(model.findWinner() == 'E');
	}	
}
