package br.com.joao.todolist.providers;

public class HttpJsonResponseMessage {
    private int status;
    private String message;

    public HttpJsonResponseMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
