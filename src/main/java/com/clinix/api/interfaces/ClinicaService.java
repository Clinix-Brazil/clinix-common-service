package com.clinix.api.interfaces;

import com.clinix.api.dto.ClinicaRmiDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClinicaService extends Remote {
    ClinicaRmiDTO getClinicaPorId(Long id) throws RemoteException;
}
