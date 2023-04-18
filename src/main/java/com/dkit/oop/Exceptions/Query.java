package com.dkit.oop.Exceptions;

public class Query {
    private String sql;
    private String parameters;

    public Query(String sql, String parameters) {
        this.sql = sql;
        this.parameters = parameters;
    }
    // getters and setters
    public String getSql() {
        return sql;
    }
    public void setSql(String sql) {
        this.sql = sql;
    }
    public String getParameters() {
        return parameters;
    }
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
    @Override
    public String toString() {
        return "Query{" + "sql=" + sql + ", parameters=" + parameters + '}';
    }
}
