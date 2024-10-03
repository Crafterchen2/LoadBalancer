package com.github.crafterchen2.loadbalancer.components;

import javax.swing.*;
import java.awt.*;

//Classes {
public class OldPlaceGrid extends JPanel {
	
	//Fields {
	private final Dimension gridSize = new Dimension(100, 100);
	
	private final int slotSize = 30;
	private final int lineWidth = 5;
	
	private int[][] lineData = new int[gridSize.width][gridSize.height];
	private int[][] slotData = new int[gridSize.width][gridSize.height];
	//} Fields
	
	//Constructor {
	public OldPlaceGrid() {
		for (int x = 0; x < 100; x++) {
			for (int y = 0; y < 100; y++) {
				slotData[x][y] = x + y;
				lineData[x][y] = 1000 + x + y;
			}
		}
		Point rp;
		int rx, ry = 0;
		for (int i = 0; i < 10; i++) {
			rx = (int) (Math.random() * 4500);
			ry = (int) (Math.random() * 4500);
			rp = new Point(rx, ry);
			try {
				gridClicked(rp);
			} catch (Exception e) {
				System.out.println("Fehler");
			}
		}
	}
	//} Constructor
	
	//Methods {
	public void gridClicked(Point componentXY) {
		Point cellXY = new Point(componentXY.x / (slotSize + lineWidth), componentXY.y / (slotSize + lineWidth));
		if (cellXY.x >= gridSize.width || cellXY.y >= gridSize.height) throw new IllegalArgumentException("Mouse coordinates are outside of grid limits.");
		if (isSlotHit(componentXY)) {
			System.out.println(getSlotData(cellXY));
		} else {
			System.out.println(getLineData(cellXY));
		}
	}
	
	private boolean isSlotHit(Point componentXY) {
		return new Rectangle(30, 30).contains(componentXY.x % (slotSize + lineWidth), componentXY.y % (slotSize + lineWidth));
	}
	
	private int getSlotData(Point gridXY) {
		return slotData[gridXY.x][gridXY.y];
	}
	
	private int getLineData(Point gridXY) {
		return lineData[gridXY.x][gridXY.y];
	}
	//} Methods
	
}
//} Classes
