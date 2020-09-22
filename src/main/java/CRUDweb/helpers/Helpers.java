package CRUDweb.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static Boolean validateRfc(String input) {
        String rfcRegex = "^([A-ZÑ]|\\&)?[A-ZÑ]{3}[0-9]{2}(0[1-9]|1[0-2])([12][0-9]|0[1-9]|3[01])[A-Z0-9]{3}$";
        Boolean isValid = validate(rfcRegex, input);
        return isValid;
    }

    public static Boolean validateName(String input) {
        String nameRegex = "^[\\p{L} .'-]+$";
        Boolean isValid = validate(nameRegex, input);
        return isValid;
    }

    public static boolean validate(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(input);
        Boolean matches = match.matches();
        return matches;
    }
}
