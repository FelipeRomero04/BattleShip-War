package org.example.playerInfra.Rules;

public enum Outcome {
    PLAYER_WIN("O Player GANHOU! Sua frota venceu a guerra!"),
    MACHINE_WIN("A Maquina GANHOU! Sua frota foi derrotada.");

    private String menssage;

    Outcome(String message) {
        this.menssage = message;
    }
}
