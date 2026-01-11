package org.example.playerInfra.Rules;

public enum Outcome {
    PLAYER_WIN("O Player GANHOU! Sua frota venceu a guerra!"),
    MACHINE_WIN("A Maquina GANHOU! Sua frota foi derrotada.");

    public final String menssage;

    Outcome(String menssage) {
        this.menssage = menssage;
    }

}
