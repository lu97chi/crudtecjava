package CRUDweb.helpers;

public class Helpers {
    
    public static String insertStatement(String table, String[] fields, String[] values) {
        String query = "INSERT INTO " + table + " (";
        for (int i = 0; i < fields.length; i+=1) {
            query += fields[i];
            if (i + 1 != fields.length) {
                query += " ,";
            } else {
                query += " )";
            }
        }
        query += " VALUES( ";
        for (int i = 0; i < values.length; i+=1) {
            query += "'" + values[i] + "'";
            if (i + 1 != values.length) {
                query += " ,";
            } else {
                query += " )";
            }
        }
        return query;
    }

    public static String getAllStatement(String table) {
        return "SELECT * FROM " + table;
    }

    public static String deleteByRfc(String table, String rfc, String columdId) {
        return "DELETE FROM " + table + " WHERE " + columdId + " = " + "'" + rfc + "'";
    }

    public static String getByRfc(String table, String rfc, String columdId) {
        return "SELECT * FROM " + table + " WHERE " + columdId + " = " + "'" + rfc + "'";
    } 

    public static String updateByRfc(String table, String[] fields, String[] values, String rfc, String columdId) {
        String query = "UPDATE " + table + " SET ";
        for (int i = 0; i < fields.length; i+=1) {
            String currentFieldValue = fields[i] + " = " + "'" + values[i] + "'";
            query += currentFieldValue;
            if (i + 1 != fields.length) {
                query += " ,";
            }
        }
        query += " WHERE " + columdId + " = " + "'" + rfc + "'";
        return query;
    }
}
