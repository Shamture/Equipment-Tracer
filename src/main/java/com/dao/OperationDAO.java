package com.dao;

import java.util.List;

import com.beans.Operation;

public interface OperationDAO {

	public List<Operation> getListOperationsPourMateriel(int idMat);

	public void supprimerOperationsPourMateriel(int idMat);

	public int getPeriodForNextOperation(int idMat);

	public void ajouterOperation(Operation op);

}
