package com.clinix.api;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiRegistryServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("✅ RMI Registry iniciado na porta 1099.");
            while (true) {
                Thread.sleep(60000);
            }
        } catch (Exception e) {
            System.err.println("🚨 Falha ao iniciar o RMI Registry: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
