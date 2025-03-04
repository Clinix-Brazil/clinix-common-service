package com.clinix.api.interfaces;

import com.clinix.api.dto.MedicoRmiDTO;
import com.clinix.api.dto.PacienteRmiDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsuarioService extends Remote {
    MedicoRmiDTO getMedicoPorId(Long id) throws RemoteException;
    PacienteRmiDTO getPacientePorId(Long id) throws RemoteException;
}

