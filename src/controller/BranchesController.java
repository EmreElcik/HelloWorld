package controller;

import model.BranchesModel;
import sun.security.util.Length;
import entity.*;
import java.util.*;

public class BranchesController {
	
	
	public Branches getBranchesByBranchId(Integer pbranchId) {

		BranchesModel model = new BranchesModel();
		return model.getBranchesByBranchId(pbranchId);
		
	}
	public void deleteBranchesByBranchId(Integer pbranchId) {
		BranchesModel model = new BranchesModel();
		model.deleteBranchesByBranchId(pbranchId);		
	}
	public List<Branches> getAll() {
		
		BranchesModel model = new BranchesModel();
		return model.getAll();
		
	}
	
	public void saveBranch(Branches branches) throws Exception{

		BranchesModel model = new BranchesModel();
		
		Branches branchExist = new Branches();
		
		branchExist = model.getBranchesByBranchId(branches.getBranchId());
		
		if (branchExist == null || branchExist.getBranchId() == 0 ) {
		
			if ( String.valueOf(branches.getBranchId()).length() <= 10 && branches.getBranchName().length() <= 50 ) {
				model.saveBranch(branches);					
			}else { 
				throw new Exception("BranchId Max 10 - BranchName Max 50 karakter olabilir! Lütfen düzeltiniz.");
			}

		} else { 
			throw new Exception("Var Olan Branch Id tekrar girilemez!");
			
		}
		
	}

	public void updateBranch(Branches branches) throws Exception{
		BranchesModel model = new BranchesModel();

		if ( String.valueOf(branches.getBranchId()).length() <= 10 && branches.getBranchName().length() <= 50 ) {
			model.saveBranch(branches);					
		}else { 
			throw new Exception("BranchId Max 10 - BranchName Max 50 karakter olabilir! Lütfen düzeltiniz.");
		}
		
		
		model.updateBranch(branches);
	}
	
	
}
