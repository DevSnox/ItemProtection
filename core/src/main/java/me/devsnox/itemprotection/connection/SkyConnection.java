package me.devsnox.itemprotection.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Copyright by DevSnox
 * E-Mail: me.devsnox@gmail.com
 * Skype: DevSnox
 */
public class SkyConnection {
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    private SyncMySQL syncMySQL;

    private Connection connection;


    public SkyConnection(String host, int port, String database, String username, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        connect();
        this.syncMySQL = new SyncMySQL(connection);
    }

    public SkyConnection(ConnectionConfig connectionConfig) {
        this.host = connectionConfig.getHost();
        this.port = connectionConfig.getPort();
        this.database = connectionConfig.getDatabase();
        this.username = connectionConfig.getUsername();
        this.password = connectionConfig.getPassword();
        connect();
        this.syncMySQL = new SyncMySQL(connection);
    }

    public void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?autoReconnect=true", this.username, this.password);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isConnected() {
        return this.connection != null;
    }

    public SyncMySQL sync() {
        try {
            if (!this.connection.isValid(3)) {
                disconnect();
                connect();
            }
        } catch (SQLException e) {
            disconnect();
            connect();
        }
        return syncMySQL;
    }

    public Connection getConnection() {
        return connection;
    }
}
