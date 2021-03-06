package com.quorum.tessera.api;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Model representation of a JSON body on outgoing HTTP requests
 *
 * <p>A response to a {@link SendRequest} after the transaction has been distributed and saved
 */
public class SendResponse {

    @Schema(description = "encrypted payload hash", format = "base64")
    private String key;

    @Schema(description = "participant public keys managed by the enclave of this Tessera node", format = "base64")
    private String[] managedParties;

    public SendResponse(final String key, final String[] managedParties) {
        this.key = key;
        this.managedParties = managedParties;
    }

    public SendResponse() {}

    public String getKey() {
        return this.key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public String[] getManagedParties() {
        return managedParties;
    }

    public void setManagedParties(final String[] managedParties) {
        this.managedParties = managedParties;
    }
}
