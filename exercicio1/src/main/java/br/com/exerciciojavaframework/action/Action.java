package br.com.exerciciojavaframework.action;

public interface Action {   
            
    boolean showButtonNew();
    
    boolean showButtonSave();
    
    boolean showButtonEdit();
    
    boolean showButtonDelete();
    
    boolean showButtonFind();
	
	boolean showButtonReturn();
    
    void controllerButton(boolean showNew, boolean showSave, boolean showEdit, boolean showDelete, boolean showFind, boolean showReturn);
      
	void enableInsert();
}
