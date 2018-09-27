package com.service;

import java.util.List;

import com.beans.Operation;

public interface OperationService {

	public List<Operation> getListOperationsPourMateriel(int idMat);

	public void supprimerOperationsPourMateriel(int idMat);

	public int getPeriodForNextOperation(int idMat);

	public void ajouterOperation(Operation op);

}
