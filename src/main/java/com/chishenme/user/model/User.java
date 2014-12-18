package com.chishenme.user.model;

import java.sql.Timestamp;

/**
 * User: nathanchen Date: 18/12/2014 Time: 5:01 PM Description:
 */
public class User
{
    private long id;
    private String name;
    private String password;
    private Timestamp created;

    public long getId ()
    {
        return id;
    }

    public void setId (long id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public Timestamp getCreated ()
    {
        return created;
    }

    public void setCreated (Timestamp created)
    {
        this.created = created;
    }
}
