package com.kmno4.presentation.myComboBox;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

public class IComboBox extends JComboBox{
	 
	 public IComboBox(){
	  super();
	  init();
	 }
	 public IComboBox(ComboBoxModel model){
	  super(model);
	  init();
	 }
	 public IComboBox(Object[] items){
	  super(items);
	  init();
	 }
	 public IComboBox(Vector<?> items){
	  super(items);
	  init();
	 }
	 private void init(){
	  setOpaque(false);
	  setUI(new IComboBoxUI());
	  setRenderer(new IComboBoxRenderer());
	  setBackground(XUtil.defaultComboBoxColor);
	 }
	 public Dimension getPreferredSize(){
	  return super.getPreferredSize();
	 }
	}
