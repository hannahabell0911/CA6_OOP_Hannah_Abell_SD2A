package com.dkit.oop.Exceptions;

import java.sql.SQLException;

public class DaoException extends SQLException
{
    public DaoException()
    {
    }

    public DaoException(String reason)
    {
        super(reason);
    }
}