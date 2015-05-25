package by.qd64.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SettingManager {

    @Value("${appUrl}")
    private String appUrl;

    @Value("${fileFolderUrl}")
    private String fileFolderUrl;

    @Value("${sender}")
    private String sender;

    @Value("${login}")
    private String mailLogin;

    @Value("${password}")
    private String mailPassword;

    @Value("${server}")
    private String mailServer;

    @Value("${port}")
    private String mailPort;

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public String getFileFolderUrl() {
        return fileFolderUrl;
    }

    public void setFileFolderUrl(String fileFolderUrl) {
        this.fileFolderUrl = fileFolderUrl;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMailLogin() {
        return mailLogin;
    }

    public void setMailLogin(String mailLogin) {
        this.mailLogin = mailLogin;
    }

    public String getMailPassword() {
        return mailPassword;
    }

    public void setMailPassword(String mailPassword) {
        this.mailPassword = mailPassword;
    }

    public String getMailServer() {
        return mailServer;
    }

    public void setMailServer(String mailServer) {
        this.mailServer = mailServer;
    }

    public String getMailPort() {
        return mailPort;
    }

    public void setMailPort(String mailPort) {
        this.mailPort = mailPort;
    }
}
