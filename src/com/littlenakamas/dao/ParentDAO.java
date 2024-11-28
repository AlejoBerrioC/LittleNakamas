package com.littlenakamas.dao;

import com.littlenakamas.util.DbConnection;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;
import java.util.*;

public class ParentDAO {
    DbConnection conn = new DbConnection();
    PreparedStatement pst;
    ResultSet rs;
}
