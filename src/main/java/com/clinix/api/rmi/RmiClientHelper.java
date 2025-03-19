package com.clinix.api.rmi;

import java.rmi.Naming;
import java.rmi.Remote;

public class RmiClientHelper {
    private static final int MAX_RETRIES = 5;
    private static final int RETRY_DELAY_MS = 5000;

    public static <T extends Remote> T connect(String url, Class<T> clazz) {
        int attempt = 0;
        while (attempt < MAX_RETRIES) {
            try {
                System.out.println("🔄 Tentando conectar a " + url + " (tentativa " + (attempt + 1) + ")...");
                T service = (T) Naming.lookup(url);
                System.out.println("✅ Conectado a " + url);
                return service;
            } catch (Exception e) {
                System.err.println("❌ Falha ao conectar a " + url + ": " + e.getMessage());
                attempt++;
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ignored) {}
            }
        }
        System.err.println("🚨 Falha ao conectar a " + url + " após " + MAX_RETRIES + " tentativas.");
        return null;
    }
}
