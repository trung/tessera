package com.quorum.tessera.api;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlMimeType;

/**
 * Model representation of a JSON body on incoming HTTP requests
 *
 * <p>Used when a new transaction is to be created where this node is the sender
 */
public class SendSignedRequest {

    @Schema(description = "hash of pre-stored payload", type = "string", format = "base64")
    @XmlMimeType("base64Binary")
    @Size(min = 1)
    @NotNull
    private byte[] hash;

    @ArraySchema(
            arraySchema = @Schema(description = "public keys identifying the recipients of the payload"),
            schema = @Schema(format = "base64"))
    private String[] to;

    @Schema(
            description =
                    "the privacy mode of the transaction\n* 0 = standard private\n* 1 = party protection\n* 3 = private-state validation",
            allowableValues = {"0", "1", "3"})
    private int privacyFlag;

    @ArraySchema(
            arraySchema =
                    @Schema(
                            description =
                                    "encoded payload hashes identifying all affected private contracts after tx simulation"),
            schema = @Schema(format = "base64"))
    private String[] affectedContractTransactions;

    @Schema(
            description = "execution hash; merkle root of all affected contracts after tx simulation",
            format = "base64")
    private String execHash;

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(final String... to) {
        this.to = to;
    }

    public int getPrivacyFlag() {
        return privacyFlag;
    }

    public void setPrivacyFlag(int privacyFlag) {
        this.privacyFlag = privacyFlag;
    }

    public String[] getAffectedContractTransactions() {
        return affectedContractTransactions;
    }

    public void setAffectedContractTransactions(String... affectedContractTransactions) {
        this.affectedContractTransactions = affectedContractTransactions;
    }

    public String getExecHash() {
        return execHash;
    }

    public void setExecHash(String execHash) {
        this.execHash = execHash;
    }
}
