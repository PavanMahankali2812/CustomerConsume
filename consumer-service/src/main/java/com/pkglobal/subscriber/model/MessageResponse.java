package com.pkglobal.subscriber.model;

import java.util.Objects;

/**
 * MessageResponse
 */

public class MessageResponse {
    private String status = null;

    private String message = null;

    public MessageResponse status(String status) {
        this.status = status;
        return this;
    }

    /**
     * status
     * 
     * @return status
     **/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MessageResponse data(String data) {
        this.message = data;
        return this;
    }

    /**
     * User's message
     * 
     * @return data
     **/

    public String getData() {
        return message;
    }

    public void setData(String data) {
        this.message = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageResponse messageResponse = (MessageResponse) o;
        return Objects.equals(this.status, messageResponse.status)
                && Objects.equals(this.message, messageResponse.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MessageResponse {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first
     * line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

