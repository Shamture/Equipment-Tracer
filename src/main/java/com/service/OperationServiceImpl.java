package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beans.Operation;
import com.dao.OperationDAO;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	private OperationDAO operationDAO;

	public List<Operation> getListOperationsPourMateriel(int idMat) {
		return operationDAO.getListOperationsPourMateriel(idMat);
	}

	public void supprimerOperationsPourMateriel(int idMat) {
		operationDAO.supprimerOperationsPourMateriel(idMat);

	}

	public int getPeriodForNextOperation(int idMat) {
		return operationDAO.getPeriodForNextOperation(idMat);
	}

	public void ajouterOperation(Operation op) {
		operationDAO.ajouterOperation(op);

	}

}
