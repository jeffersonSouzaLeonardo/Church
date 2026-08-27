package com.br.church.auth.infra.inbound.rest.dto;

public class AuthResponseDTO {

    private Long id;
    private String token;
    private boolean administration;

    public AuthResponseDTO(Long id, String token, boolean administration) {
        this.id = id;
        this.token = token;
        this.administration = administration;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public boolean isAdministration() { return administration; }
    public void setAdministration(boolean administration) { this.administration = administration; }
}
