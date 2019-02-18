package controller;

import model.BranchesModel;
import entity.*;
import java.util.*;

public class BranchesController {
	
	public List<Branches> getAll() {
		
		BranchesModel model = new BranchesModel();
		return model.getAll();
		
	}
	
	public void saveBranch(Branches branches) {
		BranchesModel model = new BranchesModel();
		model.saveBranch(branches);
		
	}

	
	
}
